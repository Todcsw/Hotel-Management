package cn.hms.entity;

import java.io.Serializable;

/**
 * Ա��ʵ����
 * 
 * @author ��·
 *
 */
public class Employess implements Serializable {
	private static final long serialVersionUID = 1L;
	// Ա��id
	private String Emp_id;
	// Ա���û���
	private String Emp_name;
	// Ա������
	private String Emp_pwd;
	//Ա����������
	private String Emp_jmpwd;
	// Ա���Ա�
	private String Emp_sex;
	// Ա�����֤��
	private String Emp_identify;
	// Ա��нˮ
	private float Emp_salary;
	// Ա��ɾ��״̬ Ĭ��1Ϊ���� 0 Ϊ��ɾ��
	private int Emp_delremark;
	// Ա���ܱ�����
	private String Emp_problem;
	// Ա����ע
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
		return "Employess [Ա��ID=" + Emp_id + ", Ա������\n=" + Emp_name + ", Ա������=" + Emp_pwd + ", Ա����������="
				+ Emp_jmpwd + "\n, Ա���Ա�=" + Emp_sex + ", Ա�����֤��=" + Emp_identify + "\n, Ա��нˮ=" + Emp_salary
				+ ", Ա��ɾ����־=" + Emp_delremark + "\n, �ܱ���=" + Emp_problem + ", Ա����ע=" + Emp_text + "]";
	}
	



	
}
