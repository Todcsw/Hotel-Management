package cn.hms.Server;

import java.net.ServerSocket;
import java.net.Socket;



public class Servers  {
	public static void main(String[] args) {

		try {
			// 1������8888�˿�
			ServerSocket sb = new ServerSocket(9999);
			System.out.println("������Ѿ�����...���ڼ���9999�˿�");
			while (true) {
				// ���ڵȴ��ͻ��˵Ľ���
				Socket sc = sb.accept();
				// ����пͻ��˽��룬�ʹ���һ���µ��߳�
				ServerThread st = new ServerThread(sc);
				st.start();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
