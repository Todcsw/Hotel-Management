package cn.hms.entity;

/**
 * 用于查询接收的 查看所有操作员
 * 
 * @author 行路
 *
 */
public class Cemployess {
	//员工ID
	private String Cid;
	//员工姓名
	private String Cname;
	//员工密码
	private String Cpwd;
	//员工性别
	private String Csex;
	//员工身份证号
	private String Cidentify;
	//员工工资
	private Float Csalary;

	public Cemployess() {
		super();
		// TODO Auto-generated constructor stub
	}
   
	public Cemployess(String cid, String cname, String cpwd, String csex, String cidentify, Float csalary) {
		super();
		Cid = cid;
		Cname = cname;
		Cpwd = cpwd;
		Csex = csex;
		Cidentify = cidentify;
		Csalary = csalary;
	}

	public String getCid() {
		return Cid;
	}

	public void setCid(String cid) {
		Cid = cid;
	}

	public String getCname() {
		return Cname;
	}

	public void setCname(String cname) {
		Cname = cname;
	}

	public String getCpwd() {
		return Cpwd;
	}

	public void setCpwd(String cpwd) {
		Cpwd = cpwd;
	}

	public String getCsex() {
		return Csex;
	}

	public void setCsex(String csex) {
		Csex = csex;
	}

	public String getCidentify() {
		return Cidentify;
	}

	public void setCidentify(String cidentify) {
		Cidentify = cidentify;
	}

	public Float getCsalary() {
		return Csalary;
	}

	public void setCsalary(Float csalary) {
		Csalary = csalary;
	}

	@Override
	public String toString() {
		return  Cid+"|\t"+Cname+"|\t"+Cpwd+"|\t"+Csex+"|\t"+Cidentify+"|\t\t"+Csalary+"\n";
	}
	
}
