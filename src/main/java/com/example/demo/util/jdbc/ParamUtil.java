package com.example.demo.util.jdbc;

import org.apache.commons.lang3.StringUtils;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.text.DecimalFormat;
import java.util.*;

/**
 * @Description: [一句话描述该类的作用]
 * @Author:
 * @CreateDate: 16/10/11 16:53
 * @Version: [v1.0]
 */
public class ParamUtil {

    public static final String UNDERLINE_FLAG = "_";
    public static final String COMMA_FLAG = ",";

    private static DecimalFormat df = new DecimalFormat("#.00");

    /**
     * 如果字符串为空返回
     *
     * @param str
     * @return
     */
    public static boolean isStringEmpty(String str) {
        return (str == null || "".equals(str));
    }

    public static boolean isListEmpty(List list) {
        return (null == list || list.size() == 0);
    }

    public static boolean isNullList(List list) {
        if (!isListEmpty(list)) {
            for (Object o : list) {
                if (o != null) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isCollectionEmpty(Collection list) {
        return (null == list || list.size() == 0);
    }

    public static boolean isArrayEmpty(Object[] list) {
        return (null == list || list.length == 0);
    }

    public static boolean isLongEmpty(Long item) {
        return (null == item || item == 0);
    }

    public static boolean isIntegerEmpty(Integer item) {
        return (null == item || item == 0);
    }

    public static boolean isDoubleEmpty(Double item) {
        return (null == item || item == 0.0);
    }

    public static boolean isBigDecimalEmpty(BigDecimal item) {
        return (null == item || item.equals(BigDecimal.ZERO));
    }

    /**
     * 校验map不能为空（基本类型）
     */
    public static String checkMapByKey(String[] keyList, Map<String, Object> map) throws Exception {
        for (String key : keyList) {
            if (!map.containsKey(key)) {
                return key + "参数不能为空";
            }
            Object value = map.get(key);
            if (null == value) {
                return key + "参数值不能为null";
            }
        }
        return "";
    }

    /**
     * 四舍五入保留n位小数
     *
     * @param value value
     * @param scale n位小数
     * @return return
     */
    public static Double formatNum(Double value, int scale) {
        if (null == value) {
            return 0.0;
        }
        BigDecimal bd = new BigDecimal(value);
        return bd.setScale(scale, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    /**
     * 把list转换成相应的map结构
     * <p>
     *
     * @param list list
     * @param key  key
     * @param <T>  </T>
     * @return return
     */
    public static <T> Map<Long, T> changeListToLongKeyMap(List<T> list, String key) {
        Map<Long, T> result = new LinkedHashMap<>();
        if (null == list || list.size() == 0) {
            return result;
        }
        try {
            Field field = getDeclaredField(list.get(0), key);
            field.setAccessible(true);
            for (T item : list) {
                Long id = (Long) field.get(item);
                result.put(id, item);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 把list转换成相应的map结构
     * <p>
     *
     * @param list list
     * @param key  key
     * @param <T>  </T>
     * @return return
     */
    public static <T> Map<String, T> changeListToStringKeyMap(List<T> list, String key) {
        Map<String, T> result = new LinkedHashMap<>();
        if (null == list || list.size() == 0) {
            return result;
        }
        try {
            Field field = getDeclaredField(list.get(0), key);
            field.setAccessible(true);
            for (T item : list) {
                String id = (String) field.get(item);
                result.put(id, item);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 循环向上转型, 获取对象的 DeclaredField
     *
     * @param object    : 子类对象
     * @param fieldName : 父类中的属性名
     * @return 父类中的属性对象
     */
    public static Field getDeclaredField(Object object, String fieldName) {
        Field field = null;
        Class<?> clazz = object.getClass();
        for (; clazz != Object.class; clazz = clazz.getSuperclass()) {
            try {
                field = clazz.getDeclaredField(fieldName);
                return field;
            } catch (Exception e) {
                //这里甚么都不要做！并且这里的异常必须这样写，不能抛出去。
                //如果这里的异常打印或者往外抛，则就不会执行clazz = clazz.getSuperclass(),最后就不会进入到父类中了
            }
        }
        return null;
    }

    /**
     * 循环向上转型, 获取对象的 DeclaredField
     *
     * @param clazz     : 子类类型
     * @param fieldName : 父类中的属性名
     * @return 父类中的属性对象
     */
    public static Field getDeclaredField(Class<?> clazz, String fieldName) {
        Field field = null;
        for (; clazz != Object.class; clazz = clazz.getSuperclass()) {
            try {
                field = clazz.getDeclaredField(fieldName);
                return field;
            } catch (Exception e) {
                //这里甚么都不要做！并且这里的异常必须这样写，不能抛出去。
                //如果这里的异常打印或者往外抛，则就不会执行clazz = clazz.getSuperclass(),最后就不会进入到父类中了
            }
        }
        return null;
    }

    /**
     * 提取相关的变量
     *
     * @param list list
     * @param key  key
     * @param <T>  </T>
     * @return return
     */
    public static <T> List<Long> changeListToLongList(List<T> list, String key) {
        if (null == list || list.size() == 0) {
            return new ArrayList<Long>();
        }
        List<Long> result = new ArrayList<>();
        try {
            Field field = getDeclaredField(list.get(0), key);
            field.setAccessible(true);
            for (T item : list) {
                Long id = (Long) field.get(item);
                if (!result.contains(id)) {
                    result.add(id);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 从map中提取相关变量
     *
     * @param list list
     * @param key  key
     * @return return
     */
    public static <K, V> List<Long> changeMapListToLongList(List<Map<K, V>> list, String key) {
        List<Long> result = new ArrayList<>();
        try {
            for (Map m : list) {
                if (m.containsKey(key)) {
                    Long item = Long.parseLong("" + m.get(key));
                    if (!result.contains(item)) {
                        result.add(item);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 根据条件过滤list,保留只满足条件的list
     *
     * @param list      list
     * @param key       key
     * @param conditons conditions
     * @param clazz     clazz
     * @param <T>       <T>
     * @return return
     */
    public static <T, V> List<T> filterList(List<T> list, String key, Class<V> type, List<V> conditons, Class<T> clazz) {
        if (null == list || list.size() == 0) {
            return new ArrayList<T>();
        }
        try {
            Field field = getDeclaredField(list.get(0), key);
            field.setAccessible(true);
            Iterator<T> itr = list.iterator();
            while (itr.hasNext()) {
                T item = itr.next();
                V id = (V) field.get(item);
                if (!conditons.contains(id)) {
                    itr.remove();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * 判断字符串是否是整数
     */
    public static boolean isInteger(String value) {
        try {
            Integer.parseInt(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     * 判断字符串是否是整数
     */
    public static boolean isLong(String value) {
        try {
            Long.parseLong(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     * 将固定格式的字符串转换成list
     *
     * @param source    source
     * @param separator separator
     * @return return
     */
    public static List<Long> splitStringToLongList(String source, String separator) {
        List<Long> result = new ArrayList<>();
        if (StringUtils.isEmpty(source) || StringUtils.isEmpty(separator)) {
            return result;
        }
        String sourceArr[] = source.split(separator);
        for (int i = 0; i < sourceArr.length; i++) {
            String item = sourceArr[i];
            if (StringUtils.isNumeric(item)) {
                result.add(Long.parseLong(item));
            }
        }
        return result;
    }

    public static <T> String splitListToStr(List<T> datas, String separator) {
        if (ParamUtil.isListEmpty(datas)) {
            return "";
        }
        if (StringUtils.isEmpty(separator)) {
            separator = ParamUtil.COMMA_FLAG;
        }
        StringBuilder sb = new StringBuilder();
        int i = 0;
        for (T data : datas) {
            sb.append(data.toString());
            if (i < datas.size() - 1) {
                sb.append(separator);
            }
            i++;
        }
        return sb.toString();
    }

    /**
     * 将大集合按照数量拆分成小集合
     *
     * @param totalList  被拆分集合
     * @param splitCount 拆分总集合
     * @return return
     */
    public static <T> List<List<T>> listSplit(List<T> totalList, int splitCount) {
        List<List<T>> result = new ArrayList<List<T>>();
        int end = totalList.size() - 1;
        int start = 0;
        while ((start + splitCount - 1) < end) {
            result.add(totalList.subList(start, start + splitCount));
            start += splitCount;
        }
        result.add(totalList.subList(start, end + 1));
        return result;
    }


    /**
     * 字符串拼接
     *
     * @param source    source
     * @param delimeter 分隔符
     * @param addInfo   addInfo
     * @return return
     */
    public static String addInfo(String source, String delimeter, String addInfo) {
        StringBuffer buffer = new StringBuffer();
        if (StringUtils.isEmpty(source)) {
            buffer.append(addInfo);
        } else {
            buffer.append(source).append(delimeter).append(addInfo);
        }
        return buffer.toString();
    }

    public static String objectToString(Object o, boolean isDefalutEmpty) {
        if (null == o && isDefalutEmpty) {
            return "";
        } else if (null == o) {
            return null;
        }
        return o.toString();
    }

    public static Long objectToLong(Object o, boolean isDefalutZero) {
        if (null == o && isDefalutZero) {
            return 0L;
        } else if (null == o) {
            return null;
        }
        return Long.parseLong(o.toString());
    }

    public static Integer objectToInteger(Object o, boolean isDefalutZero) {
        if (null == o && isDefalutZero) {
            return 0;
        } else if (null == o) {
            return null;
        }
        return Integer.parseInt(o.toString());
    }

    public static Double objectToDouble(Object o, boolean isDefalutZero) {
        if (null == o && isDefalutZero) {
            return 0d;
        } else if (null == o) {
            return null;
        }
        return Double.parseDouble(o.toString());
    }

    public static Boolean objectToBoolean(Object o, boolean isDefalutFalse) {
        if (null == o && isDefalutFalse) {
            return false;
        } else if (null == o) {
            return null;
        }
        return Boolean.parseBoolean(o.toString());
    }

    public static Float objectToFloat(Object o, boolean isDefalutZero) {
        if (null == o && isDefalutZero) {
            return 0F;
        } else if (null == o) {
            return null;
        }
        return Float.parseFloat(o.toString());
    }

    public static List<String> longListToStringList(List<Long> longList) {
        if (null == longList) {
            return null;
        }
        List<String> strList = new ArrayList<>();
        for (Long eachLong : longList) {
            strList.add(String.valueOf(eachLong));
        }
        return strList;
    }

    /**
     * 移除map中的value空值
     *
     * @param map
     * @return
     */
    public static void removeNullValue(Map map) {
        Set set = map.keySet();
        for (Iterator iterator = set.iterator(); iterator.hasNext(); ) {
            Object obj = (Object) iterator.next();
            Object value = (Object) map.get(obj);
            remove(value, iterator);
        }
    }

    /**
     * 内部调用
     *
     * @param obj
     * @param iterator
     */
    private static void remove(Object obj, Iterator iterator) {
        if (obj instanceof String) {
            String str = (String) obj;
            if (isStringEmpty(str)) {  //过滤掉为null和""的值 主函数输出结果map：{2=BB, 1=AA, 5=CC, 8=  }
                //if("".equals(str.trim())){  //过滤掉为null、""和" "的值 主函数输出结果map：{2=BB, 1=AA, 5=CC}
                iterator.remove();
            }
        } else if (obj instanceof Collection) {
            Collection col = (Collection) obj;
            if (col == null || col.isEmpty()) {
                iterator.remove();
            }
        } else if (obj instanceof Map) {
            Map temp = (Map) obj;
            if (temp == null || temp.isEmpty()) {
                iterator.remove();
            }
        } else if (obj instanceof Object[]) {
            Object[] array = (Object[]) obj;
            if (array == null || array.length <= 0) {
                iterator.remove();
            }
        } else {
            if (obj == null) {
                iterator.remove();
            }
        }
    }

    /**
     * 四舍五入保留n位小数
     *
     * @param value
     * @param scale
     * @return
     */
    public static BigDecimal formatMoneyConvert(Long value, BigDecimal roundingMode, int scale) {
        if (null == value) {
            return new BigDecimal(0.00);
        }
        if (null == roundingMode || roundingMode.equals(BigDecimal.ZERO)) {
            return new BigDecimal(value);
        }
        BigDecimal bd = new BigDecimal(value);
        return bd.divide(roundingMode, scale, BigDecimal.ROUND_HALF_UP);
    }

    public static String roundUpToTowDigit(BigDecimal value) {
        return df.format(value);
    }

    public static String joinStr(Long... args) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < args.length; i++) {
            if (i == (args.length - 1)) {
                sb.append(args[i]);
            } else {
                sb.append(args[i]).append("_");
            }
        }
        return sb.toString();
    }

    /**
     * 把list转换成相应的map结构
     *
     * @param list  list
     * @param key   key
     * @param clazz clazz
     * @param <T>   </T>
     * @return return
     */
    public static <T> Map<Long, T> listToMap(List<T> list, String key, Class<T> clazz) {
        Map<Long, T> result = new LinkedHashMap<>();
        if (null == list || list.size() == 0) {
            return result;
        }
        try {
            Field field = clazz.getDeclaredField(key);
            field.setAccessible(true);
            for (T item : list) {
                Long id = (Long) field.get(item);
                result.put(id, item);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public static String joinStr(String... args) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < args.length; i++) {
            if (i == (args.length - 1)) {
                sb.append(args[i]);
            } else {
                sb.append(args[i]).append(" ");
            }
        }
        return sb.toString();
    }

    /**
     * 提取相关的变量
     * 该方法不支持继承体系中的属性提取，已废弃
     * 详情参考 extractKeyIncludeSuperClass（）
     *
     * @param list  list
     * @param key   key
     * @param clazz class
     * @param <T>   </T>
     * @return return
     */
    @Deprecated
    public static <T> List<Long> extractKey(List<T> list, String key, Class<T> clazz) {
        List<Long> result = new ArrayList<>();
        try {
            Field field = clazz.getDeclaredField(key);
            field.setAccessible(true);
            for (T item : list) {
                Long id = (Long) field.get(item);
                if (!result.contains(id)) {
                    result.add(id);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 提取相关属性，该方法支持继承体系中的属性提取
     *
     * @param list  list
     * @param key   key
     * @param clazz clazz
     * @param <T>   <T>
     * @return
     */
    public static <T> List<Long> extractKeyIncludeSuperClass(List<T> list, String key, Class<T> clazz) {
        List<Long> result = new ArrayList<>();
        try {
            Field field = getDeclaredField(list.get(0), key);
            field.setAccessible(true);
            for (T item : list) {
                Long id = (Long) field.get(item);
                if (!result.contains(id)) {
                    result.add(id);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 生成组合可以
     *
     * @param items
     * @return
     */
    public static String makeCompKey(Object... items) {
        if (null == items || items.length < 0) {
            return "";
        }
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < items.length; i++) {
            buffer.append(items[i]);
            if (i != items.length - 1) {
                buffer.append("_");
            }
        }
        return buffer.toString();
    }

    /**
     * @Author: wangyuanyuan
     * @Description: 判断字都穿是否为全英文
     * @Params:
     * @Return:
     */
    public static boolean isEnglish(String str) {
        boolean isEng = false;
        if (null != str) {
            isEng = str.matches("^[a-zA-Z]*");
        }
        return isEng;
    }

    /**
     * Bean --> Map 1: 利用Introspector和PropertyDescriptor 将Bean --> Map
     *
     * @param obj
     * @return
     */
    public static Map<String, Object> transBean2Map(Object obj) {
        if (obj == null) {
            return null;
        }
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass());
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
            for (PropertyDescriptor property : propertyDescriptors) {
                String key = property.getName();
                // 过滤class属性
                if (!key.equals("class")) {
                    // 得到property对应的getter方法
                    Method getter = property.getReadMethod();
                    Object value = getter.invoke(obj);
                    map.put(key, value);
                }
            }
        } catch (Exception e) {
            System.out.println("transBean2Map Error " + e);
        }
        return map;
    }

    public static Object mapToObject(Map<String, Object> map, Class<?> beanClass) throws Exception {
        if (map == null)
            return null;
        Object obj = beanClass.newInstance();
        org.apache.commons.beanutils.BeanUtils.populate(obj, map);
        return obj;
    }

    public static Map<String, String> obj2Map(Object obj) {
        Map<String, String> map = new HashMap<String, String>();
        // System.out.println(obj.getClass());
        // 获取f对象对应类中的所有属性域
        Field[] fields = obj.getClass().getDeclaredFields();
        for (int i = 0, len = fields.length; i < len; i++) {
            String varName = fields[i].getName();
            varName = varName.toLowerCase();//将key置为小写，默认为对象的属性
            try {
                // 获取原来的访问控制权限
                boolean accessFlag = fields[i].isAccessible();
                // 修改访问控制权限
                fields[i].setAccessible(true);
                // 获取在对象f中属性fields[i]对应的对象中的变量
                Object o = fields[i].get(obj);
                if (o != null)
                    map.put(varName, o.toString());
                // System.out.println("传入的对象中包含一个如下的变量：" + varName + " = " + o);
                // 恢复访问控制权限
                fields[i].setAccessible(accessFlag);
            } catch (IllegalArgumentException ex) {
                ex.printStackTrace();
            } catch (IllegalAccessException ex) {
                ex.printStackTrace();
            }
        }
        return map;
    }

    public static String getMD5(String str) {
        try {
            // 生成一个MD5加密计算摘要
            MessageDigest md = MessageDigest.getInstance("MD5");
            // 计算md5函数
            md.update(str.getBytes());
            // digest()最后确定返回md5 hash值，返回值为8为字符串。因为md5 hash值是16位的hex值，实际上就是8位的字符
            // BigInteger函数则将8位的字符串转换成16位hex值，用字符串来表示；得到字符串形式的hash值
            String md5 = new BigInteger(1, md.digest()).toString(16);
            //BigInteger会把0省略掉，需补全至32位
            return fillMD5(md5);
        } catch (Exception e) {
            throw new RuntimeException("MD5加密错误:" + e.getMessage(), e);
        }
    }

    public static String fillMD5(String md5) {
        return md5.length() == 32 ? md5 : fillMD5("0" + md5);
    }

    /**
     *  *[简述]: List 泛型 排序
     *  * @param list 源数据 排序集合
     *  * @param field 排序的数据字段名称
     *  * @param sort 升序 还是 降序，默认升序
     *  * @param <T> 泛型T
     *  * @return List
     */
    public static <T> List<T> sort(List<T> list, final String field, final String sort) {
        Collections.sort(list, new Comparator<T>() {
            @Override
            public int compare(T o1, T o2) {
                int ret = 0;
                try {
                    Method method1 = o1.getClass().getDeclaredMethod(getMethodName(field), null);
                    Method method2 = o2.getClass().getDeclaredMethod(getMethodName(field), null);
                    Field field1 = o1.getClass().getDeclaredField(field);
                    field1.setAccessible(true);
                    Class<?> type = field1.getType();
                    if (type == int.class) {
                        ret = ((Integer) field1.getInt(o1)).compareTo((Integer) field1.getInt(o2));
                    } else if (type == double.class) {
                        ret = ((Double) field1.getDouble(o1)).compareTo((Double) field1.getDouble(o2));
                    } else if (type == long.class) {
                        ret = ((Long) field1.getLong(o1)).compareTo((Long) field1.getLong(o2));
                    } else if (type == float.class) {
                        ret = ((Float) field1.getFloat(o1)).compareTo((Float) field1.getFloat(o2));
                    } else if (type == Date.class) {
                        ret = ((Date) field1.get(o1)).compareTo((Date) field1.get(o2));
                    } else if (isDouble(String.valueOf(field1.get(o1))) && isDouble(String.valueOf(field1.get(o2)))) {
                        ret = (new Double(method1.invoke(o1).toString())).compareTo(new Double(method2.invoke(o2).toString()));
                    } else {
                        ret = String.valueOf(field1.get(o1)).compareTo(String.valueOf(field1.get(o2)));
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (NoSuchFieldException e) {
                    e.printStackTrace();
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
                if (null != sort && "desc".equalsIgnoreCase(sort)) {
                    return -ret;
                } else {
                    return ret;
                }
            }
        });
        return list;
    }

    private static String getMethodName(String str) {
        StringBuffer name = new StringBuffer();
        name = name.append("get").append(firstLetterToCapture(str));
        return name.toString();
    }


    private static String firstLetterToCapture(String name) {
        char[] arr = name.toCharArray();
        arr[0] -= 32;
        return String.valueOf(arr);
    }

    private static boolean isDouble(String str) {
        boolean flag = false;
        if (isInteger(str) || isFloat(str)) {
            flag = true;
        }
        return flag;
    }

    public static String captureName(String name) {
        if (name.isEmpty() || "".equals(name)) {
            throw new RuntimeException("首字母大写异常 " + name);
        }
        char[] cs = name.toCharArray();
        cs[0] -= 32;
        String str = "get" + String.valueOf(cs);
        return str;
    }

    private static boolean isFloat(String str) {
        return str.matches("[\\d]+\\.[\\d]+");
    }

    public static BigDecimal changeToBigDecimalWithZero(String value) {
        if (StringUtils.isEmpty(value)) {
            return BigDecimal.ZERO;
        }
        BigDecimal bigDecimal = new BigDecimal(value);
        return bigDecimal;
    }

    public static BigDecimal sub(BigDecimal v1, int resScale, boolean negativeResultToZero, BigDecimal... v2List) {
        BigDecimal b1 = v1;
        for (BigDecimal b2 : v2List) {
            b1 = b1.subtract(b2);
        }
        b1 = b1.setScale(resScale, BigDecimal.ROUND_HALF_UP);
        if (b1.compareTo(BigDecimal.ZERO) < 0 && negativeResultToZero) {
            b1 = BigDecimal.ZERO;
        }
        return b1;
    }

    public static BigDecimal add(BigDecimal v1, int resScale, BigDecimal... v2List) {
        BigDecimal b1 = v1;
        for (BigDecimal b2 : v2List) {
            b1 = b1.add(b2);
        }
        b1 = b1.setScale(resScale, BigDecimal.ROUND_HALF_UP);
        return b1;
    }

    public static BigDecimal multiply(BigDecimal v1, int resScale, BigDecimal... v2List) {
        BigDecimal b1 = v1;
        for (BigDecimal b2 : v2List) {
            b1 = b1.multiply(b2);
        }
        b1 = b1.setScale(resScale, BigDecimal.ROUND_HALF_UP);
        return b1;
    }

    public static BigDecimal formatNullWithZero(BigDecimal v1, boolean isFormatNullWithZero) {
        if (null == v1 && isFormatNullWithZero) {
            return BigDecimal.ZERO;
        }
        return v1;
    }

    public static void main(String args[]) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(3);
        list.add(8);
        list.add(9);
        list.add(11);
        list.add(12);
        list.add(13);
        list.add(17);
        list.add(18);
        System.out.println(listSplit(list, 2));
    }
}
