package cn.hms.dao;


import cn.hms.entity.CheckOut;
import cn.hms.entity.Customer;
import cn.hms.entity.Order1;
import cn.hms.entity.Room;

public interface EmployessDAO {
	/**
	 * ��¼ 1 ��ʾ��¼�ɹ� 0��ʾ��¼ʧ��
	 * 
	 * @param emp_name (Ա����¼�û���)
	 * @param emp_pwd  (Ա����¼����)
	 * @return
	 */

	public int dl(String emp_name, String emp_pwd);

	/**
	 * ��ӹ˿�
	 * 
	 * @return
	 */
	public int tjgk(Customer cus);

	/**
	 * ��ѯ�˿�
	 * 
	 * @return
	 */
	public Customer cxgk(String  cus_id);

	/**
	 * ���Ĺ˿���Ϣ
	 * 
	 * @return
	 */
	public int gggk(Customer cus,String name);


	/**
	 * ��ѯ������ס��Ϣ
	 * 
	 * @return
	 */
	public Room cxfj(String Rok_id);

	/**
	 * ���ķ�����ס��Ϣ
	 * 
	 * @return
	 */
	public int ggfj(Room roo,String Roo_id);

	/**
	 * ��������
	 * 
	 * @return
	 */
	public int cjdd(Order1 ord);

	/**
	 * ��ѯ����
	 * 
	 * @return
	 */
	public Order1  cxdd(String ord_id);

	/**
	 * ���Ķ�����Ϣ
	 * 
	 * @return
	 */
	public int  ggdd(Order1 ord,String ord_id);
	/**
	 * �����˷�����
	 * 
	 * @return
	 */

	public int cjtf(CheckOut che);
	

}
