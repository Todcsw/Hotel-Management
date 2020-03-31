package cn.hms.entity;
/**
 * 用于接收，查看所有顾客信息
 */
import java.util.Date;

public class Ccustomer {
	// 客人编号
	private String Ccusid;
	// 房间编号
	private String Ccusroomid;
	// 入住人姓名
	private String Ccusname;
	// 入住人性别
	private String Ccussex;
	// 入住人证件号码
	private String Ccusidentify;
	// 入住人电话
	private String Ccusnumber;
	// 押金
	private Float Ccusdeposit;
	// 入住时间
	private Date indate;
	// 到点时间
	private Date outdate;
	// 房间价格
	private Float Ccusmoney;
	// 操作员工姓名
	private String name;
	public Ccustomer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Ccustomer(String ccusid, String ccusroomid, String ccusname, String ccussex, String ccusidentify,
			String ccusnumber, Float ccusdeposit, Date indate, Date outdate, Float ccusmoney, String name) {
		super();
		Ccusid = ccusid;
		Ccusroomid = ccusroomid;
		Ccusname = ccusname;
		Ccussex = ccussex;
		Ccusidentify = ccusidentify;
		Ccusnumber = ccusnumber;
		Ccusdeposit = ccusdeposit;
		this.indate = indate;
		this.outdate = outdate;
		Ccusmoney = ccusmoney;
		this.name = name;
	}
	public String getCcusid() {
		return Ccusid;
	}
	public void setCcusid(String ccusid) {
		Ccusid = ccusid;
	}
	public String getCcusroomid() {
		return Ccusroomid;
	}
	public void setCcusroomid(String ccusroomid) {
		Ccusroomid = ccusroomid;
	}
	public String getCcusname() {
		return Ccusname;
	}
	public void setCcusname(String ccusname) {
		Ccusname = ccusname;
	}
	public String getCcussex() {
		return Ccussex;
	}
	public void setCcussex(String ccussex) {
		Ccussex = ccussex;
	}
	public String getCcusidentify() {
		return Ccusidentify;
	}
	public void setCcusidentify(String ccusidentify) {
		Ccusidentify = ccusidentify;
	}
	public String getCcusnumber() {
		return Ccusnumber;
	}
	public void setCcusnumber(String ccusnumber) {
		Ccusnumber = ccusnumber;
	}
	public Float getCcusdeposit() {
		return Ccusdeposit;
	}
	public void setCcusdeposit(Float ccusdeposit) {
		Ccusdeposit = ccusdeposit;
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
	public Float getCcusmoney() {
		return Ccusmoney;
	}
	public void setCcusmoney(Float ccusmoney) {
		Ccusmoney = ccusmoney;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return  ""+Ccusid +""+"| "+ Ccusroomid +"|" + Ccusname + "|"
				+ Ccussex + "|   " + Ccusidentify +"|"  + Ccusnumber + ""
				+ Ccusdeposit +"|  "  + indate +"|  " + outdate + "|  " + Ccusmoney + "|  "
				+ name+"|\n";
	}
	
}
