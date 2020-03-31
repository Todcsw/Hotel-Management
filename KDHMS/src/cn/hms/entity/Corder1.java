package cn.hms.entity;

import java.util.Date;

/**
 * 用于接收 查看所有订单
 * 
 * @author 行路
 *
 */
public class Corder1 {
	// 订单编号
	private String Cordid;
	// 客户编号
	private String Cordcusid;
	// 入住时间
	private Date indate;
	// 离开时间
	private Date outdate;
	// 房间状态
	private String Cordroomstate;

	public Corder1() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Corder1(String cordid, String cordcusid, Date indate, Date outdate, String cordroomstate) {
		super();
		Cordid = cordid;
		Cordcusid = cordcusid;
		this.indate = indate;
		this.outdate = outdate;
		Cordroomstate = cordroomstate;
	}

	public String getCordid() {
		return Cordid;
	}

	public void setCordid(String cordid) {
		Cordid = cordid;
	}

	public String getCordcusid() {
		return Cordcusid;
	}

	public void setCordcusid(String cordcusid) {
		Cordcusid = cordcusid;
	}

	public Date getIndate() {
		return indate;
	}

	public void setIndate(Date indate) {
		this.indate = indate;
	}

	public Date getOutdate() {
		return outdate;
	}

	public void setOutdate(Date outdate) {
		this.outdate = outdate;
	}

	public String getCordroomstate() {
		return Cordroomstate;
	}

	public void setCordroomstate(String cordroomstate) {
		Cordroomstate = cordroomstate;
	}

	@Override
	public String toString() {
		return "Corder1 [订单id=" + Cordid + ", 顾客id=" + Cordcusid + ", 住店日期=" + indate + ", 离店日期=" + outdate
				+ ", 房间状态=" + Cordroomstate + "]"+"\n";
	}

}
