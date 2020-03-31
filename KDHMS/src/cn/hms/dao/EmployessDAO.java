package cn.hms.dao;


import cn.hms.entity.CheckOut;
import cn.hms.entity.Customer;
import cn.hms.entity.Order1;
import cn.hms.entity.Room;

public interface EmployessDAO {
	/**
	 * 登录 1 表示登录成功 0表示登录失败
	 * 
	 * @param emp_name (员工登录用户名)
	 * @param emp_pwd  (员工登录密码)
	 * @return
	 */

	public int dl(String emp_name, String emp_pwd);

	/**
	 * 添加顾客
	 * 
	 * @return
	 */
	public int tjgk(Customer cus);

	/**
	 * 查询顾客
	 * 
	 * @return
	 */
	public Customer cxgk(String  cus_id);

	/**
	 * 更改顾客信息
	 * 
	 * @return
	 */
	public int gggk(Customer cus,String name);


	/**
	 * 查询房间入住信息
	 * 
	 * @return
	 */
	public Room cxfj(String Rok_id);

	/**
	 * 更改房间入住信息
	 * 
	 * @return
	 */
	public int ggfj(Room roo,String Roo_id);

	/**
	 * 创建订单
	 * 
	 * @return
	 */
	public int cjdd(Order1 ord);

	/**
	 * 查询订单
	 * 
	 * @return
	 */
	public Order1  cxdd(String ord_id);

	/**
	 * 更改订单信息
	 * 
	 * @return
	 */
	public int  ggdd(Order1 ord,String ord_id);
	/**
	 * 创建退房订单
	 * 
	 * @return
	 */

	public int cjtf(CheckOut che);
	

}
