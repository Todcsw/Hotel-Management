package cn.hms.entity;

import java.util.Date;

/**
 * ���ڽ��� �鿴���ж���
 * 
 * @author ��·
 *
 */
public class Corder1 {
	// �������
	private String Cordid;
	// �ͻ����
	private String Cordcusid;
	// ��סʱ��
	private Date indate;
	// �뿪ʱ��
	private Date outdate;
	// ����״̬
	private String Cordroomstate;

	public Corder1() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Corder1(String cordid, String cordcusid, Date indate, Date outdate, String cordroomstate) {
		super();
		Cordid = cordid;
		Cordcusid = cordcusid;
		this.indate = indate;
		this.outdate = outdate;
		Cordroomstate = cordroomstate;
	}

	public String getCordid() {
		return Cordid;
	}

	public void setCordid(String cordid) {
		Cordid = cordid;
	}

	public String getCordcusid() {
		return Cordcusid;
	}

	public void setCordcusid(String cordcusid) {
		Cordcusid = cordcusid;
	}

	public Date getIndate() {
		return indate;
	}

	public void setIndate(Date indate) {
		this.indate = indate;
	}

	public Date getOutdate() {
		return outdate;
	}

	public void setOutdate(Date outdate) {
		this.outdate = outdate;
	}

	public String getCordroomstate() {
		return Cordroomstate;
	}

	public void setCordroomstate(String cordroomstate) {
		Cordroomstate = cordroomstate;
	}

	@Override
	public String toString() {
		return "Corder1 [����id=" + Cordid + ", �˿�id=" + Cordcusid + ", ס������=" + indate + ", �������=" + outdate
				+ ", ����״̬=" + Cordroomstate + "]"+"\n";
	}

}
