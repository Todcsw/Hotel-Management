package cn.hms.Server;

import java.net.ServerSocket;
import java.net.Socket;



public class Servers  {
	public static void main(String[] args) {

		try {
			// 1、监听8888端口
			ServerSocket sb = new ServerSocket(9999);
			System.out.println("服务端已经启动...正在监听9999端口");
			while (true) {
				// 正在等待客户端的接入
				Socket sc = sb.accept();
				// 如果有客户端接入，就创建一个新的线程
				ServerThread st = new ServerThread(sc);
				st.start();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
