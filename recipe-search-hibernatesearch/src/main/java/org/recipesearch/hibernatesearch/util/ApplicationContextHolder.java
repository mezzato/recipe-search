package org.recipesearch.hibernatesearch.util;

import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

public class ApplicationContextHolder {

    private static GenericApplicationContext context;
    

    static {
        context = new GenericApplicationContext();
        new XmlBeanDefinitionReader(context).loadBeanDefinitions(
                new String[]{
                    "classpath:org/lambico/spring/dao/hibernate/genericDao.xml",
                    "classpath:org/lambico/spring/dao/hibernate/applicationContextBase.xml",
                    "classpath:database.xml",
                    "classpath:applicationContext.xml"
                });
        context.refresh();
    }

    public static ApplicationContext getApplicationContext() {
        return context;
    }

    public static void autowireBeanProperties(Object o) {
        context.getBeanFactory().autowireBeanProperties(o,
                AutowireCapableBeanFactory.AUTOWIRE_BY_TYPE, true);
    }
}
