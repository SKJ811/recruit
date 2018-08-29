package com.yc.web.listeners;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.Logger;
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
    	Logger logger=Logger.getLogger(InitListener.class);

		ServletContext application = sce.getServletContext();
		ac = WebApplicationContextUtils.getWebApplicationContext(application);
		JobBizImpl jobBizImpl = (JobBizImpl) ac.getBean("jobBizImpl");
		// 查出所有的行业
		List<Job> industryList;
		try {
			industryList = jobBizImpl.getAllJob();
			application.setAttribute("industryList", industryList);
			logger.info(industryList);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("系统初始化错误，详细信息如下：",e);
			logger.error("系统退出，请检查再次部署。。。。。");
			System.exit(0);
		}

	}

}
