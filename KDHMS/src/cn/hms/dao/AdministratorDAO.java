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
	 * 登录 1 表示登录成功 0表示登录失败
	 * 
	 * @param adm_name (管理员姓名)
	 * @param adm_pwd  (管理员密码)
	 * @return
	 */
	public int dl(String adm_name, String adm_pwd) throws Exception;

	/**
	 * 添加员工信息
	 * 
	 * @return
	 */
	public int tjyg(Employess emp)throws Exception;

	/**
	 * 更改员工信息
	 * 
	 * @return
	 */
	public Employess ggyg( Employess emp,String Emp_id)throws Exception;

	/**
	 * 查询员工信息
	 * 
	 * @return
	 */
	
	
	public Employess cxyg(String Emp_id)throws Exception;
	/**
	 * 找回员工，根据姓名
	 * @param Emp_name
	 * @return
	 */
	public  Employess zhyg(String Emp_name)throws Exception;
	/**
	 * 找回管理，根据姓名
	 * @param Emp_name
	 * @return
	 */
	public Administrator zhgl(String Adm_name)throws Exception;

	/**
	 * 删除员工
	 * 
	 * @return
	 */
	public int scyg(String Emp_id)throws Exception;

	/**
	 * 查询员工操作日志
	 * 
	 * @return
	 */
	public int cxygcz()throws Exception;

	/**
	 * 查询房间类型信息
	 * 
	 * @return
	 */
	public Roomkind cxfj(String Rok_id)throws Exception;

	/**
	 * 更改房间信息
	 * 
	 * @return
	 */
	public int ggfj(Roomkind rok,String rok_id)throws Exception;

	/**
	 * 删除房间
	 * 
	 * @return
	 */
	public int scfj(String rok_id)throws Exception;

	/**
	 * 增加房间
	 * 
	 * @return
	 */
	public int zjfj(Roomkind rok)throws Exception;

	/**
	 * 查询订单
	 * 
	 * @return
	 */
	public Order1 cxdd(String ord_id)throws Exception;

	/**
	 * 删除订单
	 * 
	 * @return
	 */
	public int scdd()throws Exception;

	/**
	 * 更改订单信息
	 * 1表示更改成功  0表示更改失败
	 * @return
	 */

	public int ggdd(Order1 ord,String ord_id)throws Exception;

	/**
	 * 删除顾客 1表示删除成功 0表示删除失败
	 * 
	 * @return
	 */
	public int scgk(String name)throws Exception;

	/**
	 * 创建订单
	 * 1表示创建成功  0表示创建失败
	 * @return
	 */
	public int cjdd(Order1 ord)throws Exception;

	/**
	 * 退房办理
	 * 
	 * @return
	 */

	public int tfbl(CheckOut che)throws Exception;
	/**
	 * 查看退房订单
	 * @return
	 */
	/**
	 */
	public CheckOut cktf(String che_id)throws Exception;
	/**
	 * 查询所有员工
	 * @return
	 */
	public List<Cemployess> cxsyyg() throws Exception;
	/**
	 * 查询所有房间
	 * @return
	 */
	public List<Croom> cxsyfj()throws Exception;
	/**
	 * 查询所有顾客信息及入住订单信息
	 */
	public List<Ccustomer> cxsygk()throws Exception ;
	/**
	 * 查询所有订单
	 */
	public List<Corder1> cxsydd()throws Exception;
}
