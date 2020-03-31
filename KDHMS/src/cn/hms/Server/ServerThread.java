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
	// ����������
	InputStream is = null;
	// ���������
	OutputStream os = null;
	Object m;

	// �����޲ι��췽��
	public ServerThread() {

	}

	// �����вι��췽��
	public ServerThread(Socket sc) {
		try {
			// ��ǰ�ͻ���socket��ֵ
			this.sc = sc;
			// ����������
			is = sc.getInputStream();
			// ���������
			os = sc.getOutputStream();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
    
	public void run() {
		System.out.println("�̣߳�" + Thread.currentThread().getName() + "������");

		// ������
	     read();

		// д����
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
	 * ���ͻ��˴��������
	 */
	public void read() {
//		System.out.println("����");
		try {
			ObjectInputStream ois = new ObjectInputStream(is);
			m=ois.readObject();
           if(m instanceof  Employess) {
                  emp =(Employess)m;
//                  System.out.println("������");
                  
                  while(true) {
                	  System.out.print("Ա��");
        	   if ("��¼�ɹ�".equals( emp.getAction())) {
				System.out.println(Thread.currentThread().getName() + "���ڵ�¼..");
				break;
			} else if ("��¼ʧ��,����¼ʧ��".equals(emp.getAction())) {
				System.out.println(Thread.currentThread().getName()
						+ "���Ե�¼,����¼ʧ��");
				break;
				//write(emp);
			}
        	   break; }
           }
           if(m instanceof Administrator) {
        	   adm=(Administrator)m;
        	  
        	   while(true) {
        		   System.out.print("����Ա");
        	   if("��¼�ɹ�".equals(adm.getAction())) {
        		   System.out.println(Thread.currentThread().getName()+"���ڵ�¼...");
        		   break;
        	   }else if("���Ե�¼,����¼ʧ��".equals(adm.getAction())) {
        		   System.out.println(Thread.currentThread().getName()+"���Ե�¼,����¼ʧ��");
        		   break;
        	   }
        	   break;
        	   }
           }
//           System.out.println("�˳�");
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}



	/**
	 * �������ݵ��ͻ���
	 */
	public void write(Object obj) {
		try {
			System.out.println(Thread.currentThread().getName() + "������ͻ��˷�������");
			ObjectOutputStream oos = new ObjectOutputStream(os);
			oos.writeObject(obj);
            oos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
