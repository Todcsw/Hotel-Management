package cn.hms.dao.impl;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Base64;
import java.util.Date;

import cn.hms.dao.EmployessDAO;
import cn.hms.entity.CheckOut;
import cn.hms.entity.Customer;
import cn.hms.entity.Order1;
import cn.hms.entity.Room;

public class EmployessDAOImpl extends BaseJdbcForMySQL implements EmployessDAO {
	public static void main(String[] args) {
		EmployessDAOImpl ed = new EmployessDAOImpl();
//		//int d=ed.cxfj("1");
//		System.out.println(d);
//		Room roo=new Room("4","1",1);
//		d=ed.ggfj(roo, "1");
//		System.out.println(d);
//		Order1 ord=new Order1("1","1","2","1",200f,new Date());
////		d=ed.cjdd(ord);
////		System.out.println("����"+d);
//		//d=ed.cxdd("1");
//		System.out.println("��ѯ"+d);
//		d=ed.ggdd(ord, "1");
//		System.out.println("����"+d);
	}
   
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
	/**
	 * ��¼ 1 ��ʾ��¼�ɹ� 0��ʾ��¼ʧ��
	 * 
	 * @param emp_name (Ա����¼�û���)
	 * @param emp_pwd  (Ա����¼����)
	 * @return
	 */
	@Override
	public int dl(String emp_name, String emp_pwd) {

		int r = 0;
		Connection conn = null;
		try {
			conn = super.getConnection();
			String sql = "select * from employess where Emp_name=? and Emp_pwd=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setObject(1, emp_name);
			ps.setObject(2, emp_pwd);
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
	 * ��ӹ˿� 1��ʾ��ӳɹ� 0��ʾ���ʧ��
	 * 
	 * @return
	 */
	@Override
	public int tjgk(Customer cus) {
		int r = 0;
		try {
			Connection conn = super.getConnection();
			String sql = "insert into customer(Cus_id,Cus_name,Cus_sex,Cus_identify,Cus_tel) values(?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setObject(1, cus.getCus_id());
			ps.setObject(2, cus.getCus_name());
			ps.setObject(3, cus.getCus_sex());
			ps.setObject(4, cus.getCus_identify());
			ps.setObject(5, cus.getCus_tel());
			r = ps.executeUpdate();
			super.closeConnection(null, ps, conn);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return r;
	}

	/**
	 * ��ѯ�˿� 1��ʾ��ѯ�ɹ� 0��ʾ��ѯʧ��
	 * 
	 * @return
	 */
	public static int d=0;
	@Override
	public Customer cxgk(String cus_name) {
		Customer Cus = new Customer();
		;
		try {
			d=0;
			Connection conn = super.getConnection();
			String sql = "select * from customer where Cus_name=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setObject(1, cus_name);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {

				Cus.setCus_id(rs.getString("Cus_id"));
				Cus.setCus_name(rs.getString("Cus_name"));
				Cus.setCus_sex(rs.getString("Cus_sex"));
				Cus.setCus_identify(rs.getString("Cus_identify"));
				Cus.setCus_tel(rs.getString("Cus_tel"));
                d=1;
			}
			super.closeConnection(rs, ps, conn);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Cus;
	}

	/**
	 * ���Ĺ˿���Ϣ 1��ʾ���ĳɹ� 0��ʾ����ʧ��
	 * 
	 * @return
	 */
	@Override
	public int gggk(Customer cus, String name) {

		int r = 0;
		try {
			Connection conn = super.getConnection();
			String sql = "update customer set Cus_id=?,Cus_name=?,Cus_sex=?,Cus_identify=?,Cus_tel=? where Cus_name=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setObject(1, cus.getCus_id());
			ps.setObject(2, cus.getCus_name());
			ps.setObject(3, cus.getCus_sex());
			ps.setObject(4, cus.getCus_identify());
			ps.setObject(5, cus.getCus_tel());
			ps.setObject(6, name);
			r = ps.executeUpdate();
			super.closeConnection(null, ps, conn);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return r;
	}

	/**
	 * ��ѯ������ס��Ϣ 1��ʾ��ѯ�ɹ� 0��ʾ��ѯʧ��
	 * 
	 * @return
	 */

	@Override
	public Room cxfj(String Roo_id) {
		d=0;
		Room roo = new Room();

		try {
			Connection conn = super.getConnection();
			String sql = "select * from room where Roo_id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setObject(1, Roo_id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {

				roo.setRoo_id(rs.getString("Roo_id"));
				roo.setRok_id(rs.getString("Rok_id"));
				roo.setRoo_state(rs.getInt("Roo_state"));
                  d=1;
			}
			super.closeConnection(rs, ps, conn);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return roo;
	}

	/**
	 * ���ķ�����ס��Ϣ 1��ʾ���ĳɹ� 0��ʾ����ʧ�� 1��ʾ�ѱ����� 0��ʾδ������
	 * 
	 * @return
	 */
	@Override
	public int ggfj(Room roo, String Roo_id) {
		int r = 0;
		try {
			Connection conn = super.getConnection();
			String sql = "update room set Rok_id=?,Roo_state=? where Roo_id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setObject(1, roo.getRok_id());
			ps.setObject(2, roo.getRoo_state());
			ps.setObject(3, Roo_id);
			r = ps.executeUpdate();
			System.out.println(r);
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
	 * ��ѯ���� 1��ʾ��ѯ�ɹ� 0��ʾ��ѯʧ��
	 * 
	 * @return
	 */
	@Override
	public Order1 cxdd(String ord_id) {
		Order1 ord = new Order1();

		try {
			Connection conn = super.getConnection();
			String sql = "select * from Order1 where Ord_id=? ";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setObject(1, ord_id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {

				ord.setOrd_id(rs.getString("Ord_id"));
				ord.setEmp_id(rs.getString("Emp_id"));
				ord.setCus_id(rs.getString("Cus_id"));
				ord.setRoo_id(rs.getString("Roo_id"));
				ord.setOrd_deposit(rs.getFloat("Ord_deposit"));
				ord.setOrd_date(rs.getDate("Ord_date"));

			}
			super.closeConnection(rs, ps, conn);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ord;
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
	 * �����˷����� 1��ʾ����ɹ� 0��ʾ����ʧ��
	 * 
	 * @return
	 */
	@Override
	public int cjtf(CheckOut che) {
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

}
