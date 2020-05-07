package com.example.demo.util.jdbc;
/*
          .--,       .--,
         ( (  \.---./  ) )
          '.__/o   o\__.'
             {=  ^  =}
              >  -  <
             /       \
            //       \\
           //|   .   |\\
           "'\       /'"_.-~^`'-.
              \  _  /--'         `
            ___)( )(___
           (((__) (__)))
   高山仰止,景行行止.虽不能至,心向往之。
*/


import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.ParameterMapping;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.defaults.DefaultSqlSession.StrictMap;
import org.springframework.stereotype.Component;

import java.sql.Statement;
import java.util.*;
import java.util.stream.Collectors;


/**
 * @program: demo
 * @description: description
 * @author: youyi
 * @create: 2020-05-07 14:48
 **/

@Intercepts(value = {
        @Signature(args = {Statement.class, ResultHandler.class}, method = "query", type = StatementHandler.class),
        @Signature(args = {Statement.class}, method = "update", type = StatementHandler.class),
        @Signature(args = {Statement.class}, method = "batch", type = StatementHandler.class)})
@Component
@Slf4j
public class SqlCostInterceptor implements Interceptor {

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        long startTime = System.currentTimeMillis();

        Object target = invocation.getTarget();
        StatementHandler statementHandler = (StatementHandler) target;
        Object result = null;
        try {
            result = invocation.proceed();
        } finally {
            BoundSql boundSql = statementHandler.getBoundSql();
            // 格式化Sql语句，去除换行符，替换参数
            String sql = formatSql(boundSql.getSql(), boundSql);

            log.info("SQL：\n" + sql + "\n执行耗时[" + (System.currentTimeMillis() - startTime) / 1000f + "秒]");
//            System.out.println("SQL：\n" + sql + "\n执行耗时[" + (System.currentTimeMillis() - startTime) / 1000f + "秒]");
        }

        return result;
    }

    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    @Override
    public void setProperties(Properties properties) {

    }

    private String formatSql(String sql, BoundSql boundSql) {
        Object parameterObject = boundSql.getParameterObject();
        List<ParameterMapping> parameterMappingList = boundSql.getParameterMappings();

        // 输入判断是否为空
        if (StringUtils.isEmpty(sql)) {
            return "";
        }

        String[] strs = sql.split("\n");
        StringBuffer stringBuffer = new StringBuffer();

        for ( String s: strs ) {
            // 去掉注释的语句
            if ( !s.contains("--") ) {
                stringBuffer.append(s).append("\n");
            }
        }

        // 美化sql
        sql = beautifySql(stringBuffer.toString());

        // 不传参数的场景，直接把Sql美化一下返回出去
        if (parameterObject == null || parameterMappingList == null || parameterMappingList.size() == 0) {
            return sql;
        }

        // 定义一个没有替换过占位符的sql，用于出异常时返回
        String sqlWithoutReplacePlaceholder = sql;
        try {
            if (parameterMappingList != null) {
                Class<?> parameterObjectClass = parameterObject.getClass();

                if (isMap(parameterObjectClass)) {
                    // 如果参数是Map则直接强转，通过map.get(key)方法获取真正的属性值
                    // 这里主要是为了处理<insert>、<delete>、<update>、<select>时传入parameterType为map的场景
                    Map<?, ?> paramMap = (Map<?, ?>) parameterObject;
                    sql = handleMapParameter(sql, paramMap, parameterMappingList, boundSql);
                } else if (isStrictMap(parameterObjectClass)) {
                    StrictMap<Collection<?>> strictMap = null;
                    try {
                        strictMap = (StrictMap<Collection<?>>) parameterObject;
                    } catch (Exception e) {
                    }

                    if ( strictMap == null ) {
                        List list = (List) ((HashMap) parameterObject).values().stream().collect(Collectors.toList());
                        Object o = list.get(0);
                        if ( o instanceof Collection) {
                            sql = handleListParameter(sql, (Collection<?>) list.get(0));
                        } else if ( o instanceof Number ) {
                            Number number = (Number) list.get(0);
                            sql = handleListParameter(sql, Arrays.asList(number));
                        }

                    } else {
                        if (isList(strictMap.get("list").getClass())) {
                            sql = handleListParameter(sql, strictMap.get("list"));
                        }
                    }

                } else {
                    // 通用场景，比如传的是一个自定义的对象或者八种基本数据类型之一或者String
                    sql = handleCommonParameter(sql, parameterMappingList, parameterObjectClass, parameterObject, boundSql);
                }
            }
        } catch (Exception e) {
            // 占位符替换过程中出现异常，则返回没有替换过占位符但是格式美化过的sql，这样至少保证sql语句比BoundSql中的sql更好看
            return sqlWithoutReplacePlaceholder;
        }

        // 格式化
        sql = BasicFormatterUtil.format(sql) + ";";

        return sql;
    }

    /**
     * 处理通用场景
     *
     * @throws SecurityException
     * @throws NoSuchFieldException
     * @throws IllegalAccessException
     * @throws IllegalArgumentException
     */
    private String handleCommonParameter(String sql, List<ParameterMapping> parameterMappingList,
                                         Class<?> parameterObjectClass, Object parameterObject, BoundSql boundSql) throws Exception {
        for (ParameterMapping parameterMapping : parameterMappingList) {
            String propertyValue = null;
            // 基本数据类型或者基本数据类型的包装类，直接toString即可获取其真正的参数值，其余直接取paramterMapping中的property属性即可
            if (isPrimitiveOrPrimitiveWrapper(parameterObjectClass)) {
                propertyValue = parameterObject.toString();
            } else {
                String propertyName = parameterMapping.getProperty();
                Object o = boundSql.getAdditionalParameter(propertyName);
                propertyValue = ParamUtil.objectToString(o, false);

                if ( propertyValue == null ) {
                    try {
                        Object value = BeanMapper.getFieldValue(parameterObject, BeanMapper.getDeclaredField(parameterObjectClass, propertyName));
                        propertyValue = ParamUtil.objectToString(BeanMapper.getFieldValue(parameterObject, BeanMapper.getDeclaredField(parameterObjectClass, propertyName)), false);
                    } catch (Exception e) {
                    }
                } else {
                    if (parameterMapping.getJavaType().isAssignableFrom(String.class)) {
                        propertyValue = "\"" + propertyValue + "\"";
                    }
                }
            }

            if ( propertyValue == null ) {
                // 不做null字符串的处理.
                // 这里添加逻辑, 如果这个值为null, 那就替换这个值为null
                sql = sql.replaceFirst("\\?", "null");
                continue;
            }

            sql = sql.replaceFirst("\\?", propertyValue);
        }

        return sql;
    }

    /**
     * 处理Map场景
     */
    private String handleMapParameter(String sql, Map<?, ?> paramMap, List<ParameterMapping> parameterMappingList, BoundSql boundSql) {
        for (ParameterMapping parameterMapping : parameterMappingList) {
            Object propertyName = parameterMapping.getProperty();
            Object propertyValue = paramMap.get(propertyName);
            if (propertyValue != null) {
                if (propertyValue.getClass().isAssignableFrom(String.class)) {
                    propertyValue = "\'" + propertyValue + "\'";
                }

            } else {

                String name = String.valueOf(propertyName);
                Object o = boundSql.getAdditionalParameter(name);
                propertyValue = ParamUtil.objectToString(o, false);

                if ( propertyValue == null ) {
                    try {
                        Object value = BeanMapper.getFieldValue(boundSql.getParameterObject(), BeanMapper.getDeclaredField(boundSql.getParameterObject().getClass(), name));
                        propertyValue = ParamUtil.objectToString(BeanMapper.getFieldValue(boundSql.getParameterObject(), BeanMapper.getDeclaredField(boundSql.getParameterObject().getClass(), name)), false);
                    } catch (Exception e) {
                    }
                } else {
                    if (parameterMapping.getJavaType().isAssignableFrom(String.class)) {
                        propertyValue = "\'" + propertyValue + "\'";
                    }
                }
            }

            if ( propertyValue == null ) {
                if (parameterMapping.getJavaType().isAssignableFrom(String.class)) {
                    propertyValue = "\'" + propertyValue + "\'";
                } else {
                    continue;
                }
            }

            sql = sql.replaceFirst("\\?", propertyValue.toString());

        }
        return sql;
    }

    /**
     * @param sql
     * @param col
     * @Description: 处理List场景
     */
    private String handleListParameter(String sql, Collection<?> col) {
        if (col != null && col.size() != 0) {
            for (Object obj : col) {
                String value = null;
                Class<?> objClass = obj.getClass();

                // 只处理基本数据类型、基本数据类型的包装类、String这三种
                // 如果是复合类型也是可以的，不过复杂点且这种场景较少，写代码的时候要判断一下要拿到的是复合类型中的哪个属性
                if (isPrimitiveOrPrimitiveWrapper(objClass)) {
                    value = obj.toString();
                } else if (objClass.isAssignableFrom(String.class)) {
                    value = "\"" + obj.toString() + "\"";
                }

                sql = sql.replaceFirst("\\?", value);
            }
        }

        return sql;
    }

    private String beautifySql(String sql) {
        sql = sql.replaceAll("[\\s\n ]+", " ");
        return sql;
    }

    /**
     * 是否基本数据类型或者基本数据类型的包装类
     */
    private boolean isPrimitiveOrPrimitiveWrapper(Class<?> parameterObjectClass) {
        return parameterObjectClass.isPrimitive() || (parameterObjectClass.isAssignableFrom(Byte.class)
                || parameterObjectClass.isAssignableFrom(Short.class)
                || parameterObjectClass.isAssignableFrom(Integer.class)
                || parameterObjectClass.isAssignableFrom(Long.class)
                || parameterObjectClass.isAssignableFrom(Double.class)
                || parameterObjectClass.isAssignableFrom(Float.class)
                || parameterObjectClass.isAssignableFrom(Character.class)
                || parameterObjectClass.isAssignableFrom(Boolean.class));
    }

    /**
     * 是否DefaultSqlSession的内部类StrictMap
     */
    private boolean isStrictMap(Class<?> parameterObjectClass) {
        return parameterObjectClass.isAssignableFrom(StrictMap.class);
    }

    /**
     * 是否List的实现类
     */
    private boolean isList(Class<?> clazz) {
        Class<?>[] interfaceClasses = clazz.getInterfaces();
        for (Class<?> interfaceClass : interfaceClasses) {
            if (interfaceClass.isAssignableFrom(List.class)) {
                return true;
            }
        }

        return false;
    }

    /**
     * 是否Map的实现类
     */
    private boolean isMap(Class<?> parameterObjectClass) {
        Class<?>[] interfaceClasses = parameterObjectClass.getInterfaces();
        for (Class<?> interfaceClass : interfaceClasses) {
            if (interfaceClass.isAssignableFrom(Map.class)) {
                return true;
            }
        }

        return false;
    }

}
