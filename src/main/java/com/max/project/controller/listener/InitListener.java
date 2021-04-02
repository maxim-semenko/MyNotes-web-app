package com.max.project.controller.listener;

import com.max.project.context.AppContext;
import com.max.project.util.HibernateUtil;
import lombok.extern.log4j.Log4j2;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
@Log4j2
public class InitListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        log.info("Context initialized");
        AppContext.getInstance().setType(AppContext.Type.PRODUCTION);
        AppContext.getInstance().init();
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        log.info("Context destroyed");
        HibernateUtil.getSessionFactory().close();
    }
}
