package cn.hms.entity;

/**
 * �˿�ʵ����
 * 
 * @author ��·
 *
 */
public class Customer {

	// �˿�ID
	private String Cus_id;
	// �˿�����
	private String Cus_name;
	// �˿��Ա�
	private String Cus_sex;
	// �˿�ʡ��֤
	private String Cus_identify;
	// �˿͵绰
	private String Cus_tel;
	// �˿ͱ�ע
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
		return "Customer [�˿�ID=" + Cus_id + ", �˿�����=" + Cus_name + ", �˿�\n�Ա�=" + Cus_sex + ", �˿����֤��="
				+ Cus_identify + "\n, �˿͵绰=" + Cus_tel + ", �˿ͱ�ע=" + Cus_text + "]";
	}

}
