package com.yc.web.listeners;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;



// ServletContextListener   -> 监听容器的启动
public class InitListener implements ServletContextListener {
	private ApplicationContext ac;
	public InitListener() {
	}

	public void contextDestroyed(ServletContextEvent arg0) {
	}

	public void contextInitialized(ServletContextEvent sce) {
		ServletContext application=sce.getServletContext();
		ac=WebApplicationContextUtils.getWebApplicationContext(application);
	
	}

}
