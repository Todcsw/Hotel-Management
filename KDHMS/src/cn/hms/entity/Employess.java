package cn.hms.entity;

import java.io.Serializable;

/**
 * 员工实体类
 * 
 * @author 行路
 *
 */
public class Employess implements Serializable {
	private static final long serialVersionUID = 1L;
	// 员工id
	private String Emp_id;
	// 员工用户名
	private String Emp_name;
	// 员工密码
	private String Emp_pwd;
	//员工加密密码
	private String Emp_jmpwd;
	// 员工性别
	private String Emp_sex;
	// 员工身份证号
	private String Emp_identify;
	// 员工薪水
	private float Emp_salary;
	// 员工删除状态 默认1为存在 0 为已删除
	private int Emp_delremark;
	// 员工密保问题
	private String Emp_problem;
	// 员工备注
	private String Emp_text;
	
	private String  Action;

	public Employess() {

	}

	public Employess(String emp_id, String emp_name, String emp_pwd, String emp_sex, String emp_identify,
			Float emp_salary, int emp_delremark, String emp_problem) {
		super();
		Emp_id = emp_id;
		Emp_name = emp_name;
		Emp_pwd = emp_pwd;
		Emp_sex = emp_sex;
		Emp_identify = emp_identify;
		Emp_salary = emp_salary;
		Emp_delremark = emp_delremark;
		Emp_problem = emp_problem;
	}

	public String getEmp_id() {
		return Emp_id;
	}

	public void setEmp_id(String emp_id) {
		Emp_id = emp_id;
	}

	public String getEmp_name() {
		return Emp_name;
	}

	public void setEmp_name(String emp_name) {
		Emp_name = emp_name;
	}

	public String getEmp_pwd() {
		return Emp_pwd;
	}

	public void setEmp_pwd(String emp_pwd) {
		Emp_pwd = emp_pwd;
	}

	public String getEmp_sex() {
		return Emp_sex;
	}

	public void setEmp_sex(String emp_sex) {
		Emp_sex = emp_sex;
	}

	public String getEmp_identify() {
		return Emp_identify;
	}

	public void setEmp_identify(String emp_identify) {
		Emp_identify = emp_identify;
	}

	public Float getEmp_salary() {
		return Emp_salary;
	}

	public void setEmp_salary(Float emp_salary) {
		Emp_salary = emp_salary;
	}

	public int getEmp_delremark() {
		return Emp_delremark;
	}

	public void setEmp_delremark(int emp_delremark) {
		Emp_delremark = emp_delremark;
	}

	public String getEmp_text() {
		return Emp_text;
	}

	public void setEmp_text(String emp_text) {
		Emp_text = emp_text;
	}

	public String getEmp_problem() {
		return Emp_problem;
	}

	public void setEmp_problem(String emp_problem) {
		Emp_problem = emp_problem;
	}
	public String getAction() {
		return Action;
	}

	public void setAction(String action) {
		Action = action;
	}
	@Override
	public String toString() {
		return "Employess [员工ID=" + Emp_id + ", 员工姓名\n=" + Emp_name + ", 员工密码=" + Emp_pwd + ", 员工加密密码="
				+ Emp_jmpwd + "\n, 员工性别=" + Emp_sex + ", 员工身份证号=" + Emp_identify + "\n, 员工薪水=" + Emp_salary
				+ ", 员工删除标志=" + Emp_delremark + "\n, 密保答案=" + Emp_problem + ", 员工备注=" + Emp_text + "]";
	}
	



	
}
