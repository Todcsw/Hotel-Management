package cn.hms.entity;

import java.util.Date;

/**
 * ����ʵ����
 * 
 * @author ��·
 *
 */
public class Order1 {
	// ������ID
	private String Ord_id;
	// ����Ա��ID
	private String Emp_id;
	// �˿�ID
	private String Cus_id;
	// �����ID
	private String Roo_id;
	// Ѻ��
	private Float Ord_deposit;
	// ��������ʱ��(��סʱ��)
	private Date Ord_date;
	// ��ע
	private String Ord_text;

	public Order1() {

	}

	public Order1(String ord_id, String emp_id, String cus_id, String roo_id, Float ord_deposit, Date ord_date) {
		super();
		Ord_id = ord_id;
		Emp_id = emp_id;
		Cus_id = cus_id;
		Roo_id = roo_id;
		Ord_deposit = ord_deposit;
		Ord_date = ord_date;
	}

	public String getOrd_id() {
		return Ord_id;
	}

	public void setOrd_id(String ord_id) {
		Ord_id = ord_id;
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

	public Float getOrd_deposit() {
		return Ord_deposit;
	}

	public void setOrd_deposit(Float ord_deposit) {
		Ord_deposit = ord_deposit;
	}

	public Date getOrd_date() {
		return Ord_date;
	}

	public void setOrd_date(Date ord_date) {
		Ord_date = ord_date;
	}

	public String getOrd_text() {
		return Ord_text;
	}

	public void setOrd_text(String ord_text) {
		Ord_text = ord_text;
	}

	@Override
	public String toString() {
		return "Order1 [������=" + Ord_id + ", Ա����=" + Emp_id + ", �˿�=" + Cus_id + "\n,   �����=" + Roo_id
				+ ",    Ѻ��=" + Ord_deposit + "\n, ��������=" + Ord_date + ", ������ע=" + Ord_text + "]";
	}

}
