package com.yc.test;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.yc.bean.Job;
import com.yc.biz.JobBiz;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JobTests {
	@Resource(name="jobBizImpl")
	private JobBiz jobBiz;
	@Test //查找
	public void getJob() {
		List<Job> list=new ArrayList<Job>();
		Job job=new Job();
		job.setKeycode("行业");
		list =jobBiz.getJob(job);
		System.out.println(list);
	}

}
