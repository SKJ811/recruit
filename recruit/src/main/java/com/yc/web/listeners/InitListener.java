package com.yc.web.listeners;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.yc.bean.Job;
import com.yc.biz.impl.JobBizImpl;

@Component
public class InitListener implements ServletContextListener {
	private ApplicationContext ac;


	public void contextDestroyed(ServletContextEvent arg0) {
	}

	public void contextInitialized(ServletContextEvent sce) {
		ServletContext application=sce.getServletContext();
		ac=WebApplicationContextUtils.getWebApplicationContext(application);
		JobBizImpl  jobBizImpl=(JobBizImpl) ac.getBean("jobBizImpl");
		//查出所有的行业 
		Job   job=new Job();
		List<Job>   industryList=jobBizImpl.getJob(job);
		application.setAttribute("industryList", industryList); 
		System.out.println(industryList);
	}

}
