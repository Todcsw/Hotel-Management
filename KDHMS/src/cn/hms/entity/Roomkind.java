package cn.hms.entity;

/**
 * ��������ʵ����
 * 
 * @author ��·
 *
 */
public class Roomkind {
	// һ�ַ�������,һ����������ID
	private String Rok_id;
	// ����������
	private String Rok_name;
	// һ�췿��۸�
	private float Rok_money;
	// ���෿������
	private int Rok_total;
	// ���෿��ʣ��
	private int Rok_surplus;
	//�������ͼ�����IDɾ����־
	private int Rok_delremark;
	// ��ע
	private String Rok_text;

	public Roomkind() {

	}

	public Roomkind(String rok_id, String rok_name, float rok_money, int rok_total, int rok_surplus,int rok_delremark) {
		super();
		Rok_id = rok_id;
		Rok_name = rok_name;
		Rok_money = rok_money;
		Rok_total = rok_total;
		Rok_surplus = rok_surplus;
		Rok_delremark=rok_delremark;
	}

	public int getRok_delremark() {
		return Rok_delremark;
	}

	public void setRok_delremark(int rok_delremark) {
		Rok_delremark = rok_delremark;
	}

	public String getRok_id() {
		return Rok_id;
	}

	public void setRok_id(String rok_id) {
		Rok_id = rok_id;
	}

	public String getRok_name() {
		return Rok_name;
	}

	public void setRok_name(String rok_name) {
		Rok_name = rok_name;
	}

	public float getRok_money() {
		return Rok_money;
	}

	public void setRok_money(float rok_money) {
		Rok_money = rok_money;
	}

	public int getRok_total() {
		return Rok_total;
	}

	public void setRok_total(int rok_total) {
		Rok_total = rok_total;
	}

	public int getRok_surplus() {
		return Rok_surplus;
	}

	public void setRok_surplus(int rok_surplus) {
		Rok_surplus = rok_surplus;
	}

	public String getRok_text() {
		return Rok_text;
	}

	public void setRok_text(String rok_text) {
		Rok_text = rok_text;
	}

	@Override
	public String toString() {
		return "Roomkind [�������ͺ�=" + Rok_id + ", ����������=" + Rok_name + "\n"+", ����۸�=" + Rok_money + ", ��������="
				+ Rok_total + ", ����ʣ��=" + Rok_surplus+"\n" + ",�����־=" + Rok_delremark + ",���䱸ע="
				+ Rok_text + "]";
	}

}
