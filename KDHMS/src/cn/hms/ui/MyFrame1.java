package cn.hms.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Calendar;
import java.util.Date;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cn.hms.dao.impl.AdministratorDAOImpl;
import cn.hms.dao.impl.EmployessDAOImpl;
import cn.hms.entity.Administrator;
import cn.hms.entity.Employess;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;

public class MyFrame1 extends JFrame {
//	public  Employess emp=null; 
	public static String yg = null;
	public static String gl = null;
	private JPanel contentPane;
	private JTextField name;
	private JPasswordField password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyFrame1 frame = new MyFrame1();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MyFrame1() {
		setResizable(false);
		setTitle("\u79D1\u5927\u5BBE\u9986\u7BA1\u7406\u7CFB\u7EDF");
		password = new JPasswordField();

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1057, 609);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		// 内容也是同样进行绝对定位
		contentPane.setLayout(null);

		JPanel panel = new JPanel() {// 设置背景
			BufferedImage image;

			protected void paintComponent(Graphics g) {
				Image bg;
				try {
					image = ImageIO.read(new File("Image/timg.jpg"));
					g.drawImage(image, 0, 0, null);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		};
		panel.setBackground(new Color(192, 192, 192));
		panel.setBounds(0, 0, 1051, 574);
		contentPane.add(panel);
		// 对组件进行绝对定位
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("\u79D1 \u5927 \u5BBE \u9986 \u7BA1 \u7406 \u7CFB \u7EDF");
		lblNewLabel.setForeground(new Color(0, 191, 255));
		lblNewLabel.setBackground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("楷体", Font.BOLD, 35));
		lblNewLabel.setBounds(364, 71, 536, 52);
		panel.add(lblNewLabel);

		name = new JTextField();
		name.setBounds(395, 190, 446, 24);
		panel.add(name);
		name.setColumns(10);

		JButton btnNewButton_2 = new JButton("\u5458\u5DE5\u767B\u5F55");
		btnNewButton_2.setIcon(new ImageIcon(MyFrame1.class.getResource("/Image/drxx92.png")));
		btnNewButton_2.setForeground(new Color(0, 191, 255));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 员工登录
				// 获得员工用户名
                
				String emp_name = name.getText();
				yg = emp_name;
				// 获得员工登录密码
				String emp_password = new String(password.getPassword());
				// System.out.println(password);

				// 创建实现类对象
				EmployessDAOImpl e1 = new EmployessDAOImpl();
				// 验证登录，1为登录成功，0 为登录失败
				int i = e1.dl(emp_name, emp_password);
				Employess emp = new Employess();
				if (i == 1) {
					JOptionPane.showMessageDialog(null, "登录成功");

					emp.setAction("登录成功");

					Date d1 = new Date();
					try {
						String txtname = "lib/IO流记录系统的操作日志/员工操作日志/" + emp_name + "员工操作日志" + ".txt";
						File file = new File(txtname);
						if (!file.exists()) {
							file.createNewFile();
						}
						FileOutputStream out = new FileOutputStream(file, true);
						String str = emp_name + "在" + d1 + "时间登录";
						out.write(str.getBytes());
						out.write("\n".getBytes());
						out.close();
					} catch (IOException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}

					dispose();
					MyFrame3 f1 = new MyFrame3();
					f1.setVisible(true);
				} else if (i == 0) {
					JOptionPane.showMessageDialog(null, "用户名或密码错误");
					emp.setAction("尝试登录,但登录失败");
					// dispose();
				}
				try {
					Socket sb = new Socket("localhost", 9999);
					OutputStream os = sb.getOutputStream();
					ObjectOutputStream oos = new ObjectOutputStream(os);
					oos.writeObject(emp);
					sb.shutdownOutput();
					// 停止向服务端发送数据

					// 接收服务端返回的结果
					InputStream is = sb.getInputStream();
					ObjectInputStream ois = new ObjectInputStream(is);
					try {
						emp = (Employess) ois.readObject();
					} catch (ClassNotFoundException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					os.close();
				} catch (UnknownHostException e3) {
					// TODO Auto-generated catch block
					e3.printStackTrace();
					System.out.println("与服务器连接出错，请稍后重试.");
				} catch (IOException e3) {
					// TODO Auto-generated catch block
					e3.printStackTrace();
					System.out.println("与服务器连接出错，请稍后重试.");
				}
			}
		});
		btnNewButton_2.setFont(new Font("楷体", Font.PLAIN, 17));
		btnNewButton_2.setBounds(342, 370, 141, 27);
		panel.add(btnNewButton_2);

		JButton btnNewButton_3 = new JButton("\u5458\u5DE5\u6CE8\u518C");
		btnNewButton_3.setIcon(new ImageIcon(MyFrame1.class.getResource("/Image/zhuceliucheng.png")));
		btnNewButton_3.setForeground(new Color(0, 191, 255));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 员工注册
				Employessregister emp = new Employessregister();
				emp.setVisible(true);
			}
		});
		btnNewButton_3.setFont(new Font("楷体", Font.PLAIN, 17));
		btnNewButton_3.setBounds(608, 370, 137, 27);
		panel.add(btnNewButton_3);

		JButton btnNewButton_4 = new JButton("\u7BA1\u7406\u5458\u767B\u5F55");
		btnNewButton_4.setIcon(new ImageIcon(MyFrame1.class.getResource("/Image/drxx92.png")));
		btnNewButton_4.setForeground(new Color(0, 191, 255));
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 管理员登录
				// 获得管理员用户名
				String adm_name = name.getText();
				gl = adm_name;
				// 获得管理员登录密码
				String adm_password = new String(password.getPassword());
				System.out.println(password);

				// 创建实现类对象
				AdministratorDAOImpl e1 = new AdministratorDAOImpl();
				// 验证登录，1为登录成功，0 为登录失败
				int i = e1.dl(adm_name, adm_password);
				Administrator adm = new Administrator();
				if (i == 1) {
					adm.setAction("登录成功");
					JOptionPane.showMessageDialog(null, "登录成功");

					Date d1 = new Date();
					try {
						String txtname = "lib/IO流记录系统的操作日志/管理员操作日志/" + adm_name + "管理员操作日志" + ".txt";
						File file = new File(txtname);
						if (!file.exists()) {
							file.createNewFile();
						}
						FileOutputStream out = new FileOutputStream(file, true);
						String str = adm_name + "在" + d1 + "时间登录";
						out.write(str.getBytes());
						out.write("\n".getBytes());
						out.close();
					} catch (IOException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					dispose();
					MyFrame2 f1 = new MyFrame2();
					f1.setVisible(true);
				} else if (i == 0) {
					JOptionPane.showMessageDialog(null, "用户名或密码错误");
					adm.setAction("尝试登录,但登录失败");
					// dispose();
				}
				try {
					Socket sb = new Socket("localhost", 9999);
					OutputStream os = sb.getOutputStream();
					ObjectOutputStream oos = new ObjectOutputStream(os);
					oos.writeObject(adm);
					sb.shutdownOutput();
					// 停止向服务端发送数据

					// 接收服务端返回的结果
					InputStream is = sb.getInputStream();
					ObjectInputStream ois = new ObjectInputStream(is);
					try {
						adm = (Administrator) ois.readObject();
					} catch (ClassNotFoundException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					os.close();
				} catch (UnknownHostException e3) {
					// TODO Auto-generated catch block
					e3.printStackTrace();
					System.out.println("与服务器连接出错，请稍后重试.");
				} catch (IOException e3) {
					// TODO Auto-generated catch block
					e3.printStackTrace();
					System.out.println("与服务器连接出错，请稍后重试.");
				}
			}
		});
		btnNewButton_4.setFont(new Font("楷体", Font.PLAIN, 17));
		btnNewButton_4.setBounds(329, 432, 158, 27);
		panel.add(btnNewButton_4);

		JButton btnNewButton_5 = new JButton("\u7BA1\u7406\u5458\u6CE8\u518C");
		btnNewButton_5.setIcon(new ImageIcon(MyFrame1.class.getResource("/Image/zhuceliucheng.png")));
		btnNewButton_5.setForeground(new Color(0, 191, 255));
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 管理员注册
				Administratorregister ad = new Administratorregister();
				ad.setVisible(true);
			}
		});
		btnNewButton_5.setFont(new Font("楷体", Font.PLAIN, 17));
		btnNewButton_5.setBounds(604, 432, 158, 27);
		panel.add(btnNewButton_5);

		JButton btnNewButton_6 = new JButton("\u5458\u5DE5\u627E\u56DE\u5BC6\u7801");
		btnNewButton_6.setIcon(new ImageIcon(MyFrame1.class.getResource("/Image/renwu_1.png")));
		btnNewButton_6.setForeground(new Color(0, 191, 255));
		btnNewButton_6.setFont(new Font("楷体", Font.PLAIN, 15));
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 员工找回密码
				// 员工找回密码
				Employessfind em = new Employessfind();
				// 员工用户名
				// String emp_name=new String(password.getPassword());
				em.setVisible(true);
			}
		});
		btnNewButton_6.setBounds(856, 472, 158, 27);
		panel.add(btnNewButton_6);

		JButton btnNewButton_7 = new JButton("\u7BA1\u7406\u5458\u627E\u56DE\u5BC6\u7801");
		btnNewButton_7.setIcon(new ImageIcon(MyFrame1.class.getResource("/Image/renwu.png")));
		btnNewButton_7.setForeground(new Color(0, 191, 255));
		btnNewButton_7.setFont(new Font("楷体", Font.PLAIN, 15));
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 管理员找回密码
				// 管理员找回密码
				Administratorfind ad = new Administratorfind();

				ad.setVisible(true);
			}
		});
		btnNewButton_7.setBounds(847, 502, 178, 27);
		panel.add(btnNewButton_7);

		JLabel lblNewLabel_1 = new JLabel("\u7528 \u6237 \u540D :");
		lblNewLabel_1.setIcon(new ImageIcon(MyFrame1.class.getResource("/Image/guke.png")));
		lblNewLabel_1.setForeground(new Color(0, 191, 255));
		lblNewLabel_1.setFont(new Font("楷体", Font.PLAIN, 22));
		lblNewLabel_1.setBounds(252, 190, 151, 21);
		panel.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("\u5BC6  \u7801   :");
		lblNewLabel_2.setIcon(new ImageIcon(MyFrame1.class.getResource("/Image/mima.png")));
		lblNewLabel_2.setForeground(new Color(0, 191, 255));
		lblNewLabel_2.setFont(new Font("楷体", Font.PLAIN, 22));
		lblNewLabel_2.setBounds(252, 264, 151, 27);
		panel.add(lblNewLabel_2);

		password.setBounds(395, 268, 446, 24);
		panel.add(password);
		setLocationRelativeTo(null);
	}
}
