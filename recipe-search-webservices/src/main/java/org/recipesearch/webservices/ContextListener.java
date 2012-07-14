package org.recipesearch.webservices;

import java.util.Map;
import java.util.List;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.Logger;
import org.lambico.spring.dao.DaoUtils;
import org.parancoe.util.BaseConf;
import org.parancoe.util.MemoryAppender;
import org.parancoe.web.plugin.PluginHelper;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.XmlWebApplicationContext;

public class ContextListener implements ServletContextListener {
    private static final Logger log = Logger.getLogger(ContextListener.class);
    private ServletContext servletContext;
    private XmlWebApplicationContext applicationContext;

    public void contextInitialized(ServletContextEvent evt) {
        try {
            this.servletContext = evt.getServletContext();

            MemoryAppender.clean();

            log.info("loading custom Spring WebApplicationContext");
            loadApplicationContext();
            PluginHelper helper = new PluginHelper(applicationContext);
            helper.initApplicationContextPlugins(); // deve essere DOPO loadApplicationContext()
            helper.invokePluginContextInitialized(evt);
            log.info("### Starting up Parancoe in " + BaseConf.getEnv() + " mode.");        
        } catch (Exception e) {
            log.error("Error in base ContextListener.contextInitialized", e);
        }
    }


    /**
     * load the ApplicationContext mixing the base parancoe
     * files and the application specific configuration
     */
    private void loadApplicationContext() {
        List<String> config = new ArrayList<String>();
        // generici
        /*
       
        
        config.add("classpath:org/parancoe/core/applicationContextBase.xml");
        */
        config.add("classpath:org/lambico/spring/dao/hibernate/genericDao.xml");
        config.add("classpath:org/lambico/spring/dao/hibernate/applicationContextBase.xml");
        
        config.add("WEB-INF/database.xml");
        // load all plugin configurations at once
        config.add("classpath*:applicationContext-plugin.xml");
        config.add("WEB-INF/applicationContext.xml");
        XmlWebApplicationContext ctx = new XmlWebApplicationContext();
        ctx.setServletContext(servletContext);
        ctx.setConfigLocations(config.toArray(new String[config.size()]));
        ctx.refresh();

        servletContext.setAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE, ctx);
        applicationContext = ctx;

        populateDaoMap(ctx);
    }

    public void contextDestroyed(ServletContextEvent evt) {
        new PluginHelper(applicationContext).invokePluginContextDestroyed(evt);
        log.info("### Shutting down Parancoe in " + BaseConf.getEnv() + " mode.");
    }

    /**
     * Populate the "daoMap" bean with the DAOs defined in the context.
     */
    private void populateDaoMap(XmlWebApplicationContext ctx) {
        Map daoMap = (Map) ctx.getBean("daoMap");
        Map daos = DaoUtils.getDaos(ctx);
        daoMap.putAll(daos);
    }

}
