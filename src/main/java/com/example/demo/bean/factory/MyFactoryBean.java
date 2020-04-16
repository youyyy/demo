package com.example.demo.bean.factory;
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

import org.springframework.beans.factory.FactoryBean;


/**
 * @program: demo
 * @description: description
 * @author: youyi
 * @create: 2020-04-08 16:51
 **/
public class MyFactoryBean implements FactoryBean<MyBean> {


    @Override
    public MyBean getObject() throws Exception {
        return null;
    }

    @Override
    public Class<?> getObjectType() {
        return MyBean.class;
    }
    @Override
    public boolean isSingleton(){
        return false;
    }


}
