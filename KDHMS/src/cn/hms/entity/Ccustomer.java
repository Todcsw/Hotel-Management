package cn.hms.entity;
/**
 * ���ڽ��գ��鿴���й˿���Ϣ
 */
import java.util.Date;

public class Ccustomer {
	// ���˱��
	private String Ccusid;
	// ������
	private String Ccusroomid;
	// ��ס������
	private String Ccusname;
	// ��ס���Ա�
	private String Ccussex;
	// ��ס��֤������
	private String Ccusidentify;
	// ��ס�˵绰
	private String Ccusnumber;
	// Ѻ��
	private Float Ccusdeposit;
	// ��סʱ��
	private Date indate;
	// ����ʱ��
	private Date outdate;
	// ����۸�
	private Float Ccusmoney;
	// ����Ա������
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
