package com.yc.web.listeners;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.springframework.context.ApplicationContext;

@WebListener
public class InitListener implements ServletContextListener {
	private ApplicationContext ac;
	public InitListener() {
	}

	public void contextDestroyed(ServletContextEvent arg0) {
	}

	public void contextInitialized(ServletContextEvent sce) {
//		ServletContext application=sce.getServletContext();
//		ac=WebApplicationContextUtils.getWebApplicationContext(application);
//		JobBizImpl  jobBizImpl=(JobBizImpl) ac.getBean("JobBizImpl");
//		//查出所有的行业 
//		Job   job=new Job();
//		List<Job>   industryList=jobBizImpl.getJob(job);
//		application.setAttribute("industryList", industryList); 
//		System.out.println(industryList);
		System.out.println("1111111");
	}

}
