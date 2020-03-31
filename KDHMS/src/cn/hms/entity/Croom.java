package cn.hms.entity;

/**
 * 用于接收,查询所有房间
 * 
 * @author 行路
 *
 */
public class Croom {
	// 房间ID
	private String Crooid;
	// 房间类型名
	private String Crooname;
	// 房间价格
	private Float Croomoney;
	// 房间状态
	private String Croostate;
	// 房间备注
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
		return "Croom [房间号=" + Crooid + ", 房间名=" + Crooname + ", 房间价格=" + Croomoney + ", 房间状态="
				+ Croostate + ", 房间备注=" + Crootext + "]" + "\n";
	}

}
