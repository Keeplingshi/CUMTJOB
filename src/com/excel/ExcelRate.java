package com.excel;

import com.sql.SqlModel;

public class ExcelRate {

	private String college_dm;
	private String major_dm;
	private int promotion_num;//升学总人数
	private int work_num;//就业总人数
	private int abroad_num;//出国总人数
	private int not_employed_num;//未就业总人数
	
	
	
	public ExcelRate() {
		super();
	}
	public ExcelRate(String college_dm, String major_dm, int promotion_num,
			int work_num, int abroad_num, int not_employed_num) {
		super();
		this.college_dm = college_dm;
		this.major_dm = major_dm;
		this.promotion_num = promotion_num;
		this.work_num = work_num;
		this.abroad_num = abroad_num;
		this.not_employed_num = not_employed_num;
	}
	public String getCollege_dm() {
		return college_dm;
	}
	public void setCollege_dm(String college_dm) {
		this.college_dm = college_dm;
	}
	public String getMajor_dm() {
		return major_dm;
	}
	public void setMajor_dm(String major_dm) {
		this.major_dm = major_dm;
	}
	public int getPromotion_num() {
		return promotion_num;
	}
	public void setPromotion_num(int promotion_num) {
		this.promotion_num = promotion_num;
	}
	public int getWork_num() {
		return work_num;
	}
	public void setWork_num(int work_num) {
		this.work_num = work_num;
	}
	public int getAbroad_num() {
		return abroad_num;
	}
	public void setAbroad_num(int abroad_num) {
		this.abroad_num = abroad_num;
	}
	public int getNot_employed_num() {
		return not_employed_num;
	}
	public void setNot_employed_num(int not_employed_num) {
		this.not_employed_num = not_employed_num;
	}
	
	public boolean save()
	{
		String sql="update t_rate set promotion_num="+promotion_num+",work_num="+work_num+",abroad_num="+abroad_num+",not_employed_num="+not_employed_num+" where college_dm='"+college_dm+"' and major_dm='"+major_dm+"'";
		return SqlModel.Update(sql);
	}

}
