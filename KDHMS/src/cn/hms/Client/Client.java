package cn.hms.Client;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

public class Client {

	public static void main(String[] args) {

		try {
			Socket sc = new Socket("localhost", 9999);

			OutputStream os = sc.getOutputStream();
			os.write("你好".getBytes());
			

			sc.shutdownOutput();// 停止向服务端发送数据
			InputStream is = sc.getInputStream();

			BufferedReader br = new BufferedReader(new InputStreamReader(is));

			System.out.println(br.readLine());

			
			br.close();
			is.close();
			os.close();
			sc.close();

		} catch (Exception e) {

			e.printStackTrace();
		}

	}
}
