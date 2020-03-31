package cn.hms.dao;


import java.util.List;

import cn.hms.entity.Administrator;
import cn.hms.entity.Ccustomer;
import cn.hms.entity.Cemployess;
import cn.hms.entity.CheckOut;
import cn.hms.entity.Corder1;
import cn.hms.entity.Croom;
import cn.hms.entity.Employess;
import cn.hms.entity.Order1;
import cn.hms.entity.Roomkind;

public interface AdministratorDAO {
	/**
	 * ��¼ 1 ��ʾ��¼�ɹ� 0��ʾ��¼ʧ��
	 * 
	 * @param adm_name (����Ա����)
	 * @param adm_pwd  (����Ա����)
	 * @return
	 */
	public int dl(String adm_name, String adm_pwd) throws Exception;

	/**
	 * ���Ա����Ϣ
	 * 
	 * @return
	 */
	public int tjyg(Employess emp)throws Exception;

	/**
	 * ����Ա����Ϣ
	 * 
	 * @return
	 */
	public Employess ggyg( Employess emp,String Emp_id)throws Exception;

	/**
	 * ��ѯԱ����Ϣ
	 * 
	 * @return
	 */
	
	
	public Employess cxyg(String Emp_id)throws Exception;
	/**
	 * �һ�Ա������������
	 * @param Emp_name
	 * @return
	 */
	public  Employess zhyg(String Emp_name)throws Exception;
	/**
	 * �һع�����������
	 * @param Emp_name
	 * @return
	 */
	public Administrator zhgl(String Adm_name)throws Exception;

	/**
	 * ɾ��Ա��
	 * 
	 * @return
	 */
	public int scyg(String Emp_id)throws Exception;

	/**
	 * ��ѯԱ��������־
	 * 
	 * @return
	 */
	public int cxygcz()throws Exception;

	/**
	 * ��ѯ����������Ϣ
	 * 
	 * @return
	 */
	public Roomkind cxfj(String Rok_id)throws Exception;

	/**
	 * ���ķ�����Ϣ
	 * 
	 * @return
	 */
	public int ggfj(Roomkind rok,String rok_id)throws Exception;

	/**
	 * ɾ������
	 * 
	 * @return
	 */
	public int scfj(String rok_id)throws Exception;

	/**
	 * ���ӷ���
	 * 
	 * @return
	 */
	public int zjfj(Roomkind rok)throws Exception;

	/**
	 * ��ѯ����
	 * 
	 * @return
	 */
	public Order1 cxdd(String ord_id)throws Exception;

	/**
	 * ɾ������
	 * 
	 * @return
	 */
	public int scdd()throws Exception;

	/**
	 * ���Ķ�����Ϣ
	 * 1��ʾ���ĳɹ�  0��ʾ����ʧ��
	 * @return
	 */

	public int ggdd(Order1 ord,String ord_id)throws Exception;

	/**
	 * ɾ���˿� 1��ʾɾ���ɹ� 0��ʾɾ��ʧ��
	 * 
	 * @return
	 */
	public int scgk(String name)throws Exception;

	/**
	 * ��������
	 * 1��ʾ�����ɹ�  0��ʾ����ʧ��
	 * @return
	 */
	public int cjdd(Order1 ord)throws Exception;

	/**
	 * �˷�����
	 * 
	 * @return
	 */

	public int tfbl(CheckOut che)throws Exception;
	/**
	 * �鿴�˷�����
	 * @return
	 */
	/**
	 */
	public CheckOut cktf(String che_id)throws Exception;
	/**
	 * ��ѯ����Ա��
	 * @return
	 */
	public List<Cemployess> cxsyyg() throws Exception;
	/**
	 * ��ѯ���з���
	 * @return
	 */
	public List<Croom> cxsyfj()throws Exception;
	/**
	 * ��ѯ���й˿���Ϣ����ס������Ϣ
	 */
	public List<Ccustomer> cxsygk()throws Exception ;
	/**
	 * ��ѯ���ж���
	 */
	public List<Corder1> cxsydd()throws Exception;
}
