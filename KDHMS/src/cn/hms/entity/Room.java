package cn.hms.entity;

/**
 * ����ʵ����
 * 
 * @author ��·
 *
 */
public class Room {
	// �����
	private String Roo_id;
	// �������ͺ�
	private String Rok_id;
	// ����״̬ Ĭ��1Ϊ��ס 0Ϊ�շ���
	private int Roo_state;
	// ���䱸ע
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
		return "Room [�����=" + Roo_id + ", ��������ID=" + Rok_id + "\n, ������ס״̬=" + Roo_state + ", ���䱸ע=" + Roo_text
				+ "]";
	}
      
}
