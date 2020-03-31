package cn.hms.entity;

import java.io.Serializable;

/**
 * ����Աʵ����
 * 
 * @author ��·
 *
 */
public class Administrator implements Serializable{
	private static final long serialVersionUID = 1L;
	// ����Ա���
	private String Adm_id;
	// ����Ա�û���
	private String Adm_name;
	// ����Ա����
	private String Adm_pwd;
	//����Ա��������
	private String Adm_jmpwd;
	// ����Աɾ��״̬ Ĭ��1Ϊ���� 0 Ϊ��ɾ��
	private int Adm_delremark;
	// ����Ա��ע
	private String Adm_text;
	// ����Ա�ܱ�����
	private String Adm_problem;
	//���ڷ���������Ϊ
	private String  Action;

	public String getAction() {
		return Action;
	}

	public void setAction(String action) {
		Action = action;
	}

	public Administrator() {
		super();
	}
    
	public String getAdm_jmpwd() {
		return Adm_jmpwd;
	}

	public void setAdm_jmpwd(String adm_jmpwd) {
		Adm_jmpwd = adm_jmpwd;
	}

	public Administrator(String adm_id, String adm_name, String adm_pwd, int adm_delremark,String adm_problem,String adm_jmpwd) {
		super();
		Adm_id = adm_id;
		Adm_name = adm_name;
		Adm_pwd = adm_pwd;
		Adm_delremark = adm_delremark;
		Adm_problem = adm_problem;
		 Adm_jmpwd=adm_jmpwd;
	}

	public String getAdm_id() {
		return Adm_id;
	}

	public void setAdm_id(String adm_id) {
		Adm_id = adm_id;
	}

	public String getAdm_name() {
		return Adm_name;
	}

	public void setAdm_name(String adm_name) {
		Adm_name = adm_name;
	}

	public String getAdm_pwd() {
		return Adm_pwd;
	}

	public void setAdm_pwd(String adm_pwd) {
		Adm_pwd = adm_pwd;
	}

	public int getAdm_delremark() {
		return Adm_delremark;
	}

	public void setAdm_delremark(int adm_delremark) {
		Adm_delremark = adm_delremark;
	}

	public String getAdm_text() {
		return Adm_text;
	}

	public void setAdm_text(String adm_text) {
		Adm_text = adm_text;
	}
	public String getAdm_problem() {
		return Adm_problem;
	}

	public void setAdm_problem(String adm_problem) {
		Adm_problem = adm_problem;
	}
}
