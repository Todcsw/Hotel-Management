package cn.hms.entity;

/**
 * 房间类型实体类
 * 
 * @author 行路
 *
 */
public class Roomkind {
	// 一种房间类型,一个房间类型ID
	private String Rok_id;
	// 房间类型名
	private String Rok_name;
	// 一天房间价格
	private float Rok_money;
	// 该类房间总数
	private int Rok_total;
	// 该类房间剩余
	private int Rok_surplus;
	//房间类型及房间ID删除标志
	private int Rok_delremark;
	// 备注
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
		return "Roomkind [房间类型号=" + Rok_id + ", 房间类型名=" + Rok_name + "\n"+", 房间价格=" + Rok_money + ", 房间总量="
				+ Rok_total + ", 房间剩余=" + Rok_surplus+"\n" + ",房间标志=" + Rok_delremark + ",房间备注="
				+ Rok_text + "]";
	}

}
