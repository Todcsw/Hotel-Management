package cn.hms.entity;

import java.util.Date;

/**
 * 订单实体类
 * 
 * @author 行路
 *
 */
public class Order1 {
	// 订单号ID
	private String Ord_id;
	// 操作员工ID
	private String Emp_id;
	// 顾客ID
	private String Cus_id;
	// 房间号ID
	private String Roo_id;
	// 押金
	private Float Ord_deposit;
	// 订单产生时间(入住时间)
	private Date Ord_date;
	// 备注
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
		return "Order1 [订单号=" + Ord_id + ", 员工号=" + Emp_id + ", 顾客=" + Cus_id + "\n,   房间号=" + Roo_id
				+ ",    押金=" + Ord_deposit + "\n, 订单日期=" + Ord_date + ", 订单备注=" + Ord_text + "]";
	}

}
