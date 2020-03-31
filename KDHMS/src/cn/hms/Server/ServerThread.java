package cn.hms.Server;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

import cn.hms.entity.Administrator;
import cn.hms.entity.Employess;


public class ServerThread extends Thread{
	Socket sc = null;
    private Employess emp;
    private Administrator adm;
	// 定义输入流
	InputStream is = null;
	// 定义输出流
	OutputStream os = null;
	Object m;

	// 定义无参构造方法
	public ServerThread() {

	}

	// 定义有参构造方法
	public ServerThread(Socket sc) {
		try {
			// 当前客户端socket赋值
			this.sc = sc;
			// 创建输入流
			is = sc.getInputStream();
			// 创建输出流
			os = sc.getOutputStream();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
    
	public void run() {
		System.out.println("线程：" + Thread.currentThread().getName() + "已连接");

		// 读数据
	     read();

		// 写数据
		 write(m);

		try {
			is.close();
			os.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * 读客户端传入的数据
	 */
	public void read() {
//		System.out.println("进入");
		try {
			ObjectInputStream ois = new ObjectInputStream(is);
			m=ois.readObject();
           if(m instanceof  Employess) {
                  emp =(Employess)m;
//                  System.out.println("哈哈哈");
                  
                  while(true) {
                	  System.out.print("员工");
        	   if ("登录成功".equals( emp.getAction())) {
				System.out.println(Thread.currentThread().getName() + "正在登录..");
				break;
			} else if ("登录失败,但登录失败".equals(emp.getAction())) {
				System.out.println(Thread.currentThread().getName()
						+ "尝试登录,但登录失败");
				break;
				//write(emp);
			}
        	   break; }
           }
           if(m instanceof Administrator) {
        	   adm=(Administrator)m;
        	  
        	   while(true) {
        		   System.out.print("管理员");
        	   if("登录成功".equals(adm.getAction())) {
        		   System.out.println(Thread.currentThread().getName()+"正在登录...");
        		   break;
        	   }else if("尝试登录,但登录失败".equals(adm.getAction())) {
        		   System.out.println(Thread.currentThread().getName()+"尝试登录,但登录失败");
        		   break;
        	   }
        	   break;
        	   }
           }
//           System.out.println("退出");
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}



	/**
	 * 返回数据到客户端
	 */
	public void write(Object obj) {
		try {
			System.out.println(Thread.currentThread().getName() + "正在向客户端返回数据");
			ObjectOutputStream oos = new ObjectOutputStream(os);
			oos.writeObject(obj);
            oos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
