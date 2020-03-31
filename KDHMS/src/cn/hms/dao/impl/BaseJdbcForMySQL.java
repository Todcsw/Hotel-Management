package cn.hms.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * �������ݿ⹤����
 * 
 * @author ��·
 *
 */
public class BaseJdbcForMySQL {
	// MySQL������
	private static final String DRIVERCLASS = "com.mysql.jdbc.Driver";
	// �����ַ���
	private static final String URL = "jdbc:mysql://localhost:3306/hms?useunicode=true&characterEncoding=UTF-8";

	// mysql�û���
	private static final String UNAME = "root";

	// mysql ����
	private static final String UPWD = "485226";

	/**
	 * �������ݿ�����
	 * 
	 * @return
	 * @throws Exception
	 */
	public Connection getConnection() throws Exception {
		Connection conn = null;
		try {
			// 1,����������
			Class.forName(DRIVERCLASS);
			// 2,��ȡ����
			conn = DriverManager.getConnection(URL, UNAME, UPWD);
		} catch (Exception ex) {
			throw ex;
		}
		return conn;
	}
    /**
     * �ر����ݿ�����
     * @param rs
     * @param ps
     * @param conn
     * @throws Exception
     */
	public void closeConnection(ResultSet rs, PreparedStatement ps, Connection conn) throws Exception {
		try {
			if (rs != null) {
				rs.close();
			}
			if (ps != null) {
				ps.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (Exception ex) {
			throw ex;
		}
	}
}
