package com.max.project.context;

import com.max.project.context.config.AdminConfiguration;
import com.max.project.util.AdminPropertiesReaderUtil;
import com.max.project.util.DatabasePropertiesReaderUtil;
import com.max.project.util.EmailPropertiesReaderUtil;
import com.max.project.util.HibernateUtil;


public class AppContext {
    public enum Type {
        PRODUCTION,
        TESTING;
    }

    private static AppContext instance;
    private Type type;

    public static AppContext getInstance() {
        if (instance == null) {
            instance = new AppContext();
        }
        return instance;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        instance.type = type;
    }

    public void init() {
        AdminPropertiesReaderUtil.loadProperties();
        DatabasePropertiesReaderUtil.loadProperties();
        EmailPropertiesReaderUtil.loadProperties();
        AdminConfiguration.getInstance();
        HibernateUtil.getSessionFactory();
//        System.out.println(AdminConfiguration.getInstance().getAdmin().toString());
    }
}
