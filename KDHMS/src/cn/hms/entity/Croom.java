package cn.hms.entity;

/**
 * ���ڽ���,��ѯ���з���
 * 
 * @author ��·
 *
 */
public class Croom {
	// ����ID
	private String Crooid;
	// ����������
	private String Crooname;
	// ����۸�
	private Float Croomoney;
	// ����״̬
	private String Croostate;
	// ���䱸ע
	private String Crootext;

	public Croom() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Float getCroomoney() {
		return Croomoney;
	}

	public void setCroomoney(Float croomoney) {
		Croomoney = croomoney;
	}

	public Croom(String crooid, String crooname, Float croomoney, String croostate, String crootext) {
		super();
		Crooid = crooid;
		Crooname = crooname;
		Croomoney = croomoney;
		Croostate = croostate;
		Crootext = crootext;
	}

	public String getCrooid() {
		return Crooid;
	}

	public void setCrooid(String crooid) {
		Crooid = crooid;
	}

	public String getCrooname() {
		return Crooname;
	}

	public void setCrooname(String crooname) {
		Crooname = crooname;
	}

	public String getCroostate() {
		return Croostate;
	}

	public void setCroostate(String croostate) {
		Croostate = croostate;
	}

	public String getCrootext() {
		return Crootext;
	}

	public void setCrootext(String crootext) {
		Crootext = crootext;
	}

	@Override
	public String toString() {
		return "Croom [�����=" + Crooid + ", ������=" + Crooname + ", ����۸�=" + Croomoney + ", ����״̬="
				+ Croostate + ", ���䱸ע=" + Crootext + "]" + "\n";
	}

}
