package cn.hms.entity;

/**
 * 房间实体类
 * 
 * @author 行路
 *
 */
public class Room {
	// 房间号
	private String Roo_id;
	// 房间类型号
	private String Rok_id;
	// 房间状态 默认1为入住 0为空房间
	private int Roo_state;
	// 房间备注
	private String Roo_text;

	public Room() {

	}

	public Room(String roo_id, String rok_id, int roo_state) {
		super();
		Roo_id = roo_id;
		Rok_id = rok_id;
		Roo_state = roo_state;
	}

	public String getRoo_id() {
		return Roo_id;
	}

	public void setRoo_id(String roo_id) {
		Roo_id = roo_id;
	}

	public String getRok_id() {
		return Rok_id;
	}

	public void setRok_id(String rok_id) {
		Rok_id = rok_id;
	}

	public int getRoo_state() {
		return Roo_state;
	}

	public void setRoo_state(int roo_state) {
		Roo_state = roo_state;
	}

	public String getRoo_text() {
		return Roo_text;
	}

	public void setRoo_text(String roo_text) {
		Roo_text = roo_text;
	}

	@Override
	public String toString() {
		return "Room [房间号=" + Roo_id + ", 房间类型ID=" + Rok_id + "\n, 房间入住状态=" + Roo_state + ", 房间备注=" + Roo_text
				+ "]";
	}
      
}
