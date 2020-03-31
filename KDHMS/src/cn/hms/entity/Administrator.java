package cn.hms.entity;

import java.io.Serializable;

/**
 * 管理员实体类
 * 
 * @author 行路
 *
 */
public class Administrator implements Serializable{
	private static final long serialVersionUID = 1L;
	// 管理员编号
	private String Adm_id;
	// 管理员用户名
	private String Adm_name;
	// 管理员密码
	private String Adm_pwd;
	//管理员加密密码
	private String Adm_jmpwd;
	// 管理员删除状态 默认1为存在 0 为已删除
	private int Adm_delremark;
	// 管理员备注
	private String Adm_text;
	// 管理员密保问题
	private String Adm_problem;
	//关于服务器的行为
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
