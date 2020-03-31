package cn.hms.entity;

import java.util.Date;

/**
 * �˷���¼ʵ����
 * 
 * @author ��·
 *
 */
public class CheckOut {
	//�˷�����ID
	private String Che_id;
	// �˷�����Ա��
	private String Emp_id;
	// �˷��˿�
	private String Cus_id;
	// �˷������
	private String Roo_id;
	// �˷�ʱ��
	private Date Cho_date;
	// ��ע
	private String Cho_text;

	public CheckOut() {

	}

	public CheckOut(String che_id,String emp_id, String cus_id, String roo_id, Date cho_date) {
		super();
		Che_id= che_id;
		Emp_id = emp_id;
		Cus_id = cus_id;
		Roo_id = roo_id;
		Cho_date = cho_date;
	}

	public String getEmp_id() {
		return Emp_id;
	}

	public void setEmp_id(String emp_id) {
		Emp_id = emp_id;
	}

	public String getCus_id() {
		return Cus_id;
	}

	public void setCus_id(String cus_id) {
		Cus_id = cus_id;
	}

	public String getRoo_id() {
		return Roo_id;
	}

	public void setRoo_id(String roo_id) {
		Roo_id = roo_id;
	}

	public Date getCho_date() {
		return Cho_date;
	}

	public void setCho_date(Date cho_date) {
		Cho_date = cho_date;
	}

	public String getCho_text() {
		return Cho_text;
	}

	public void setCho_text(String cho_text) {
		Cho_text = cho_text;
	}

	public String getChe_id() {
		return Che_id;
	}

	public void setChe_id(String che_id) {
		Che_id = che_id;
	}

	@Override
	public String toString() {
		return "CheckOut [�˷�������=" + Che_id + ", Ա��ID=" + Emp_id + "\n, �˿�ID=" + Cus_id + ", �����=" + Roo_id
				+ "\n, �˷�����=" + Cho_date + ", �˷���ע=" + Cho_text + "]";
	}

}
