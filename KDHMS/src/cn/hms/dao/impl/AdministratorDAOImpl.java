package cn.hms.dao.impl;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import cn.hms.dao.AdministratorDAO;
import cn.hms.entity.Administrator;
import cn.hms.entity.Ccustomer;
import cn.hms.entity.Cemployess;
import cn.hms.entity.CheckOut;
import cn.hms.entity.Corder1;
import cn.hms.entity.Croom;
import cn.hms.entity.Employess;
import cn.hms.entity.Order1;
import cn.hms.entity.Roomkind;

public class AdministratorDAOImpl extends BaseJdbcForMySQL implements AdministratorDAO {
	static public int d = 0;
	/**
	 * md5�����㷨
	 */
	private static String md5(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("md5");
            
            //����������� ������
            byte[] bytes = md.digest(password.getBytes());
            
            String str = Base64.getEncoder().encodeToString(bytes);
            
            return str;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }
	/**
	 * ��֤����
	 * @param password
	 * @return
	 */
	public static boolean login(String savePassWord,String password) {
        if(savePassWord.equals(md5(password))) {
            return true;
        }else {
            return false;
        }
    }
     public static void main(String[] args) {
    	 
    	
	}
	/**
	 * ��¼ 1 ��ʾ��¼�ɹ� 0��ʾ��¼ʧ��
	 * 
	 * @param adm_name (����Ա����)
	 * @param adm_pwd  (����Ա����)
	 * @return
	 */

	@Override
	public int dl(String adm_name, String adm_pwd) {
		int r = 0;
		Connection conn = null;
		try {
			conn = super.getConnection();
			String sql = "select * from administrator where Adm_name=? and Adm_jmpwd=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			adm_pwd=md5(adm_pwd);
			ps.setObject(1, adm_name);
			ps.setObject(2, adm_pwd);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				r = 1;
			}
			super.closeConnection(rs, ps, conn);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return r;
	}

	/**
	 * 1 ��ʾ��ӳɹ� 0��ʾ���ʧ�� ���Ա����Ϣ
	 * 
	 * @return
	 */
	@Override
	public int tjyg(Employess emp)  {

		int r = 0;
		try {
			// ��������
			Connection conn = super.getConnection();
			// ��дSQL���
			String sql = "insert into employess(Emp_id,Emp_name,Emp_pwd,Emp_jmpwd,Emp_sex,Emp_identify,Emp_salary, Emp_delremark,Emp_problem) values(?,?,?,?,?,?,?,?,?)";
			// ����preparedStatement
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setObject(1, emp.getEmp_id());
			ps.setObject(2, emp.getEmp_name());
			ps.setObject(3, emp.getEmp_pwd());
			ps.setObject(4, md5(emp.getEmp_pwd()));
			ps.setObject(5, emp.getEmp_sex());
			ps.setObject(6, emp.getEmp_identify());
			ps.setObject(7, emp.getEmp_salary());
			ps.setObject(8, emp.getEmp_delremark());
			ps.setObject(9, emp.getEmp_problem());
			// ִ�б���
			r = ps.executeUpdate();
			// �ر�����
			super.closeConnection(null, ps, conn);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return r;
	}

	/**
	 * 1 ���ĳɹ� 0��ʾ����ʧ�� ����Ա����Ϣ
	 * 
	 * @return
	 */
	
	@Override
	public Employess ggyg( Employess emp,String Emp_id) {
		
		 d = 0;
		// ��������
		try {
			Connection conn = super.getConnection();
			// ��дSQL���
			String sql = "update Employess set emp_id=?,emp_name=?,emp_pwd=?, emp_sex=?,emp_identify=?, emp_salary=?, emp_delremark=?,emp_problem=? where emp_id=?";
			// ����preparedStatement
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setObject(1, emp.getEmp_id());
			ps.setObject(2, emp.getEmp_name());
			ps.setObject(3, emp.getEmp_pwd());
			ps.setObject(4, emp.getEmp_sex());
			ps.setObject(5, emp.getEmp_identify());
			ps.setObject(6, emp.getEmp_salary());
			ps.setObject(7, emp.getEmp_delremark());
			ps.setObject(8, emp.getEmp_problem());
			ps.setObject(9, Emp_id);
			// ִ�б���
			 ps.executeUpdate();
			 d=1;
			//System.out.println(d);
			// �ر�����
			super.closeConnection(null, ps, conn);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return emp;
	}

	/**
	 * 1��ʾ�ɹ� 0��ʾʧ�� ��ѯԱ����Ϣ
	 * 
	 * @return
	 */
	
	@Override
	public Employess cxyg(String Emp_name) {
		Employess emp=null;
		//int r = 0;
		try {
			Connection conn = super.getConnection();
			String sql = "select * from employess where Emp_delremark=1 and Emp_name=? ";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setObject(1, Emp_name);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				emp = new Employess();
				emp.setEmp_id(rs.getString("emp_id"));
				emp.setEmp_name(rs.getString("emp_name"));
				emp.setEmp_pwd(rs.getString("emp_pwd"));
				emp.setEmp_sex(rs.getString("emp_sex"));
				emp.setEmp_identify(rs.getString("emp_identify"));
				emp.setEmp_salary(rs.getFloat("emp_salary"));
				emp.setEmp_delremark(rs.getInt("emp_delremark"));
				emp.setEmp_problem(rs.getString("emp_problem"));
				d = 1;
			}
			super.closeConnection(rs, ps, conn);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return emp;
	}
	/**
	 * 1��ʾ�ɹ� 0��ʾʧ�� �һ�Ա����Ϣ
	 * 
	 * @return
	 */
	@Override
	public Employess zhyg(String Emp_name) {
		Employess emp=null;
		int r = 0;
		try {
			Connection conn = super.getConnection();
			String sql = "select * from employess where Emp_delremark=1 and Emp_name=? ";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setObject(1, Emp_name);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				emp = new Employess();
				emp.setEmp_id(rs.getString("emp_id"));
				emp.setEmp_name(rs.getString("emp_name"));
				emp.setEmp_pwd(rs.getString("emp_pwd"));
				emp.setEmp_sex(rs.getString("emp_sex"));
				emp.setEmp_identify(rs.getString("emp_identify"));
				emp.setEmp_salary(rs.getFloat("emp_salary"));
				emp.setEmp_delremark(rs.getInt("emp_delremark"));
				emp.setEmp_problem(rs.getString("emp_problem"));
				r=1;
			}
			super.closeConnection(rs, ps, conn);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return emp;
	}
	/**
	 * 1��ʾ�ɹ� 0��ʾʧ�� �һع�����Ϣ
	 * 
	 * @return
	 */
	static public int d1=0; 
	@Override
	public Administrator  zhgl(String Adm_name)  {
		Administrator adm=null;
		int r = 0;
		try {
			Connection conn = super.getConnection();
			String sql = "select * from administrator where Adm_delremark=1 and Adm_name=? ";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setObject(1, Adm_name);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				adm = new Administrator();
				adm.setAdm_id(rs.getString("Adm_id"));
				adm.setAdm_name(rs.getString("Adm_name"));
				adm.setAdm_pwd(rs.getString("Adm_pwd"));
				adm.setAdm_delremark(rs.getInt("Adm_delremark"));
				adm.setAdm_problem(rs.getString("Adm_problem"));
				d1=1;
			}
			super.closeConnection(rs, ps, conn);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return adm;
	}
	/**
	 * ɾ��Ա�� 1��ʾɾ���ɹ� 0��ʾɾ��ʧ�� Emp_delremark ���Ϊ1 ʱ ��ְ 0ʱΪ��ְ
	 * 
	 * @return
	 */
	@Override
	public int scyg(String Emp_id) {
		int r = 0;
		try {
			Connection conn = super.getConnection();
			String sql = "update employess set Emp_delremark=0 where Emp_id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setObject(1, Emp_id);
			r = ps.executeUpdate();
			super.closeConnection(null, ps, conn);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return r;
	}

	/**
	 * ��ѯԱ��������־
	 * 
	 * @return
	 */
	@Override
	public int cxygcz() {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * ��ѯ����������Ϣ 1��ʾ��ѯ�ɹ� 0��ʾ��ѯʧ��
	 * 
	 * @return
	 */
	@Override
	public Roomkind cxfj(String Rok_id) {
		d = 0;
		Roomkind rok = new Roomkind();
		try {
			Connection conn = super.getConnection();
			String sql = "select * from Roomkind where Rok_delremark=1 and Rok_id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setObject(1, Rok_id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				rok.setRok_id(rs.getString("Rok_id"));
				rok.setRok_name(rs.getString("Rok_name"));
				rok.setRok_money(rs.getFloat("Rok_money"));
				rok.setRok_total(rs.getInt("Rok_total"));
				rok.setRok_surplus(rs.getInt("Rok_surplus"));
				rok.setRok_delremark(rs.getInt("Rok_delremark"));
				d = 1;
			}
			super.closeConnection(rs, ps, conn);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return rok;
	}

	/**
	 * ���ķ���������Ϣ 1��ʾ���ĳɹ� 0��ʾ����ʧ��
	 * 
	 * @return
	 */
	@Override
	public int ggfj( Roomkind rok,String rok_id) {
		//Roomkind rok=null;
		int r = 0;
		try {
			Connection conn = super.getConnection();
			String sql = "update roomkind set Rok_id=?,Rok_name=?,Rok_money=?,Rok_total=?,Rok_surplus=?,Rok_delremark=? where Rok_id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setObject(1, rok.getRok_id());
			ps.setObject(2, rok.getRok_name());
			ps.setObject(3, rok.getRok_money());
			ps.setObject(4, rok.getRok_total());
			ps.setObject(5, rok.getRok_surplus());
			ps.setObject(6, rok.getRok_delremark());
			ps.setObject(7, rok_id);
			r = ps.executeUpdate();
			super.closeConnection(null, ps, conn);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return r;
	}

	/**
	 * ɾ������������Ϣ 1��ʾɾ���ɹ� 0��ʾɾ��ʧ��
	 * 
	 * @return
	 */
	@Override
	public int scfj(String rok_id) {
		int r = 0;
		try {
			Connection conn = super.getConnection();
			String sql = "update roomkind set Rok_delremark=0  where rok_id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setObject(1, rok_id);
			r = ps.executeUpdate();
			super.closeConnection(null, ps, conn);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return r;
	}

	/**
	 * ���ӷ���������Ϣ 1��ʾ���ӳɹ� 0��ʾ����ʧ��
	 * 
	 * @return
	 */
	@Override
	public int zjfj(Roomkind rok) {
		
		int r = 0;
		try {
			Connection conn = super.getConnection();
			String sql = "insert into Roomkind(Rok_id,Rok_name,Rok_money,Rok_total,Rok_surplus,Rok_delremark) values (?,?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setObject(1, rok.getRok_id());
			ps.setObject(2, rok.getRok_name());
			ps.setObject(3, rok.getRok_money());
			ps.setObject(4, rok.getRok_total());
			ps.setObject(5, rok.getRok_surplus());
			ps.setObject(6, rok.getRok_delremark());
			r = ps.executeUpdate();
			super.closeConnection(null, ps, conn);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return r;
	}

	/**
	 * ��ѯ���� 1��ʾ��ѯ�ɹ� 0��ʾ��ѯʧ��
	 * 
	 * @return
	 */
	@Override
	public Order1 cxdd(String ord_id) {
		Order1 ord=null;
		d = 0;
		try {
			Connection conn = super.getConnection();
			String sql = "select * from Order1 where Ord_id=? ";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setObject(1, ord_id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ord = new Order1();
				ord.setOrd_id(rs.getString("Ord_id"));
				ord.setEmp_id(rs.getString("Emp_id"));
				ord.setCus_id(rs.getString("Cus_id"));
				ord.setRoo_id(rs.getString("Roo_id"));
				ord.setOrd_deposit(rs.getFloat("Ord_deposit"));
				ord.setOrd_date(rs.getDate("Ord_date"));
				d = 1;
			}
			super.closeConnection(rs, ps, conn);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ord;
	}

	/**
	 * ɾ������ 1��ʾɾ���ɹ� 0��ʾɾ��ʧ�� ������Ҫ�б�־ 1��ʾ���� 0��ʾ�ѱ�ɾ�� ��ʵ��
	 * 
	 * @return
	 */
	@Override
	public int scdd() {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * ���Ķ�����Ϣ 1��ʾ���ĳɹ� 0��ʾ����ʧ��
	 * 
	 * @return
	 */
	@Override
	public int ggdd(Order1 ord, String ord_id) {
		int r = 0;
		try {
			Connection conn = super.getConnection();
			String sql = "update Order1 set Ord_id=?,Emp_id=?,Cus_id=?,Roo_id=?,Ord_deposit=?,Ord_date=? where Ord_id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setObject(1, ord.getOrd_id());
			ps.setObject(2, ord.getEmp_id());
			ps.setObject(3, ord.getCus_id());
			ps.setObject(4, ord.getRoo_id());
			ps.setObject(5, ord.getOrd_deposit());
			ps.setObject(6, ord.getOrd_date());
			ps.setObject(7, ord_id);
			r = ps.executeUpdate();
			super.closeConnection(null, ps, conn);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return r;
	}

	/**
	 * �������� 1��ʾ�����ɹ� 0��ʾ����ʧ��
	 * 
	 * @return
	 */
	@Override
	public int cjdd(Order1 ord) {
		int r = 0;
		try {
		//	long d=System.currentTimeMillis();
			Connection conn = super.getConnection();
			String sql = "insert into order1(Ord_id,Emp_id,Cus_id,Roo_id,Ord_deposit,Ord_date) values(?,?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setObject(1, ord.getOrd_id());
			ps.setObject(2, ord.getEmp_id());
			ps.setObject(3, ord.getCus_id());
			ps.setObject(4, ord.getRoo_id());
			ps.setObject(5, ord.getOrd_deposit());
			ps.setObject(6, ord.getOrd_date());
			r = ps.executeUpdate();
			super.closeConnection(null, ps, conn);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return r;
	}

	/**
	 * ɾ���˿� 1��ʾɾ���ɹ� 0��ʾɾ��ʧ�� //��ʵ��
	 * 
	 * @return
	 */
	@Override
	public int scgk(String name) {
		int r = 0;
		return 0;
	}

	/**
	 * �����˷�����
	 * 
	 * @return
	 */
	@Override
	public int tfbl(CheckOut che) {
		int r = 0;
		try {
			Connection conn = super.getConnection();
			String sql = "insert into checkout(Che_id,Emp_id,Cus_id,Roo_id,Cho_date)  values(?,?,?,?,?) ";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setObject(1, che.getChe_id());
			ps.setObject(2, che.getEmp_id());
			ps.setObject(3, che.getCus_id());
			ps.setObject(4, che.getRoo_id());
			ps.setObject(5, che.getCho_date());
			r = ps.executeUpdate();
			super.closeConnection(null, ps, conn);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return r;
	}

	/**
	 * �鿴�˷�����
	 * 
	 * @return
	 */
	public CheckOut cktf(String che_id) {
		CheckOut che = new CheckOut();
		d=0;
		try {
			Connection conn = super.getConnection();
			String sql = "select * from CheckOut where che_id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setObject(1, che_id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				che.setChe_id(rs.getString("Che_id"));
				che.setEmp_id(rs.getString("Emp_id"));
				che.setCus_id(rs.getString("Cus_id"));
				che.setRoo_id(rs.getString("Roo_id"));
				che.setCho_date(rs.getDate("Cho_date"));
				d=1;
			}
			super.closeConnection(rs, ps, conn);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return che;
	}

	/**
	 * ��ѯ���в���Ա
	 */
	@Override
	public List<Cemployess> cxsyyg() {
		// TODO Auto-generated method stub
		List<Cemployess> list = new ArrayList<Cemployess>();
		try {

			Cemployess cemp;
			Connection conn = super.getConnection();
			String sql = "select * from employess where Emp_delremark=1";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				cemp = new Cemployess();
				cemp.setCid(rs.getString("Emp_id"));
				cemp.setCname(rs.getString("Emp_name"));
				cemp.setCpwd(rs.getString("Emp_pwd"));
				cemp.setCsex(rs.getString("Emp_sex"));
				cemp.setCidentify(rs.getString("Emp_identify"));
				cemp.setCsalary(rs.getFloat("Emp_salary"));
				list.add(cemp);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * ��ѯ���з���
	 * 
	 * @return
	 */
	public List<Croom> cxsyfj() {
		List<Croom> list = new ArrayList<Croom>();
		try {
			Croom croo;
			PreparedStatement ps1 = null;
			ResultSet rs1 = null;
			Connection conn = super.getConnection();
			String sql = "select * from room";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				croo = new Croom();
				croo.setCrooid(rs.getString("Roo_id"));

				String sql1 = "select Rok_name,Rok_money from roomkind where Rok_id=?";
				ps1 = conn.prepareStatement(sql1);
				ps1.setObject(1, rs.getString("Rok_id"));
				rs1 = ps1.executeQuery();
				while (rs1.next()) {
					croo.setCrooname(rs1.getString("Rok_name"));
					croo.setCroomoney(rs1.getFloat("Rok_money"));
				}
				int i = rs.getInt("Roo_state");
				switch (i) {
				case 1:
					croo.setCroostate("����ס");
					break;
				case 0:
					croo.setCroostate("δס��");
					break;
				default:
					break;
				}
				croo.setCrootext(rs.getString("Roo_text"));
				list.add(croo);
			}
			super.closeConnection(rs1, ps1, null);
			super.closeConnection(rs, ps, conn);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * ��ѯ���й˿���Ϣ����ס������Ϣ
	 */
	public List<Ccustomer> cxsygk() {
		List<Ccustomer> list = new ArrayList<Ccustomer>();
		try {
			Ccustomer Ccus;
			PreparedStatement ps1 = null;
			PreparedStatement ps2 = null;
			PreparedStatement ps3 = null;
			ResultSet rs1 = null;
			ResultSet rs2 = null;
			ResultSet rs3 = null;
			Connection conn = super.getConnection();
			String sql = "select * from customer";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Ccus = new Ccustomer();
				// ��ÿ��˱��
				Ccus.setCcusid(rs.getString("Cus_id"));
				String sql1 = "select Emp_id,Roo_id,Ord_deposit,Ord_date,Ord_outdate from order1 where Cus_id=?";
				ps1 = conn.prepareStatement(sql1);
				ps1.setObject(1, rs.getString("Cus_id"));
				rs1 = ps1.executeQuery();
				while (rs1.next()) {
					// ��ò���Ա����
					String sql2 = "select Emp_name from employess where Emp_id=?";
					ps2 = conn.prepareStatement(sql2);
					ps2.setObject(1, rs1.getString("Emp_id"));

					rs2 = ps2.executeQuery();
					rs2.next();
					Ccus.setName(rs2.getString("Emp_name"));
					// ��÷�����
					Ccus.setCcusroomid(rs1.getString("Roo_id"));
					// ���Ѻ��
					Ccus.setCcusdeposit(rs1.getFloat("Ord_deposit"));
					// �����סʱ��
					Ccus.setIndate(rs1.getDate("Ord_date"));
					// ��õ���ʱ��
					Ccus.setOutdate(rs1.getDate("Ord_outdate"));
					// ��÷���۸�
					String sql3 = "select Rok_money from roomkind where Rok_id in (select Rok_id from room where Roo_id=?)";
					ps3 = conn.prepareStatement(sql3);
					ps3.setObject(1, rs1.getString("Roo_id"));

					rs3 = ps3.executeQuery();
					rs3.next();
					Ccus.setCcusmoney(rs3.getFloat("Rok_money"));
				}
				// �����ס������
				Ccus.setCcusname(rs.getString("Cus_name"));
				// �����ס���Ա�
				Ccus.setCcussex(rs.getString("Cus_sex"));
				// �����ס��֤������
				Ccus.setCcusidentify(rs.getString("Cus_identify"));
				// �����ס�˵绰
				Ccus.setCcusnumber(rs.getString("Cus_tel"));
				list.add(Ccus);

			}
			super.closeConnection(rs3, ps3, null);
			super.closeConnection(rs2, ps2, null);
			super.closeConnection(rs1, ps1, null);
			super.closeConnection(rs, ps, conn);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * ��ѯ���ж���
	 */
	public List<Corder1> cxsydd() {
		List<Corder1> list = new ArrayList<Corder1>();
		Corder1 cord;
		try {
			PreparedStatement ps1 = null;
			ResultSet rs1 = null;
			Connection conn = super.getConnection();
			String sql = "select * from order1";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				cord = new Corder1();
				cord.setCordid(rs.getString("Ord_id"));
				cord.setCordcusid(rs.getString("Cus_id"));
				cord.setIndate(rs.getDate("Ord_date"));
				cord.setOutdate(rs.getDate("Ord_outdate"));
				String sql1 = "select Roo_state from room where Roo_id in (select Roo_id from order1 where Roo_id=?)";
				ps1 = conn.prepareStatement(sql1);
				ps1.setObject(1, rs.getString("Roo_id"));
				rs1 = ps1.executeQuery();
				rs1.next();
				int i = rs1.getInt("Roo_state");
				switch (i) {
				case 1:
					cord.setCordroomstate("����ʹ��");
					break;
				case 0:
					cord.setCordroomstate("δʹ��");
					break;
				default:
					break;
				}
				list.add(cord);
			}
			super.closeConnection(rs1, ps1, null);
			super.closeConnection(rs, ps, conn);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
}
