package cn.hms.entity;

/**
 * 顾客实体类
 * 
 * @author 行路
 *
 */
public class Customer {

	// 顾客ID
	private String Cus_id;
	// 顾客姓名
	private String Cus_name;
	// 顾客性别
	private String Cus_sex;
	// 顾客省份证
	private String Cus_identify;
	// 顾客电话
	private String Cus_tel;
	// 顾客备注
	private String Cus_text;

	public Customer() {

	}

	public Customer(String cus_id, String cus_name, String cus_sex, String cus_identify, String cus_tel) {
		super();
		Cus_id = cus_id;
		Cus_name = cus_name;
		Cus_sex = cus_sex;
		Cus_identify = cus_identify;
		Cus_tel = cus_tel;
	}

	public String getCus_id() {
		return Cus_id;
	}

	public void setCus_id(String cus_id) {
		Cus_id = cus_id;
	}

	public String getCus_name() {
		return Cus_name;
	}

	public void setCus_name(String cus_name) {
		Cus_name = cus_name;
	}

	public String getCus_sex() {
		return Cus_sex;
	}

	public void setCus_sex(String cus_sex) {
		Cus_sex = cus_sex;
	}

	public String getCus_identify() {
		return Cus_identify;
	}

	public void setCus_identify(String cus_identify) {
		Cus_identify = cus_identify;
	}

	public String getCus_tel() {
		return Cus_tel;
	}

	public void setCus_tel(String cus_tel) {
		Cus_tel = cus_tel;
	}

	public String getCus_text() {
		return Cus_text;
	}

	public void setCus_text(String cus_text) {
		Cus_text = cus_text;
	}

	@Override
	public String toString() {
		return "Customer [顾客ID=" + Cus_id + ", 顾客姓名=" + Cus_name + ", 顾客\n性别=" + Cus_sex + ", 顾客身份证号="
				+ Cus_identify + "\n, 顾客电话=" + Cus_tel + ", 顾客备注=" + Cus_text + "]";
	}

}
