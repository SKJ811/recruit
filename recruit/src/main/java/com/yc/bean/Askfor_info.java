package com.yc.bean;

import java.io.Serializable;

public class Askfor_info implements Serializable {

	private static final long serialVersionUID = 1L;
	
	
	private Integer id;
	private Integer status;
	private Student_baseinfo Student_baseinfo;
	private Merchant_wantedjob merchant_wantedjob;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Merchant_wantedjob getMerchant_wantedjob() {
		return merchant_wantedjob;
	}
	public void setMerchant_wantedjob(Merchant_wantedjob merchant_wantedjob) {
		this.merchant_wantedjob = merchant_wantedjob;
	}
	public Student_baseinfo getStudent_baseinfo() {
		return Student_baseinfo;
	}
	public void setStudent_baseinfo(Student_baseinfo student_baseinfo) {
		Student_baseinfo = student_baseinfo;
	}
	@Override
	public String toString() {
		return "Askfor_info [id=" + id + ", status=" + status
				+ ", merchant_wantedjob=" + merchant_wantedjob
				+ ", Student_baseinfo=" + Student_baseinfo + "]";
	}
	
}
