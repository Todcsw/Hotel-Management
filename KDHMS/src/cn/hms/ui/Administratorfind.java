package cn.hms.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cn.hms.dao.impl.AdministratorDAOImpl;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

public class Administratorfind extends JFrame {

	private JPanel contentPane;
	private JTextField name;
	private JPasswordField pwdproblem;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Administratorfind frame = new Administratorfind();
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
	public Administratorfind() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 401, 398);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("\u7BA1\u7406\u5458\u7528\u6237\u540D\uFF1A");
		lblNewLabel.setBounds(49, 55, 113, 18);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("管理员密保答案:");
		lblNewLabel_1.setBounds(49, 104, 113, 18);
		contentPane.add(lblNewLabel_1);

		name = new JTextField();
		name.setBounds(176, 52, 147, 24);
		contentPane.add(name);
		name.setColumns(10);

		pwdproblem = new JPasswordField();
		pwdproblem.setBounds(176, 101, 147, 24);
		contentPane.add(pwdproblem);

		JTextArea dlpassword = new JTextArea();
		dlpassword.setBounds(62, 250, 270, 88);
		contentPane.add(dlpassword);

		JButton btnNewButton = new JButton("\u786E\u8BA4\u627E\u56DE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 管理找会密码
				// 找回密码
				String adm_name = name.getText();
				String adm_pwdproblem = new String(pwdproblem.getPassword());
				AdministratorDAOImpl zh = new AdministratorDAOImpl();
				zh.zhgl(adm_name);
				if(AdministratorDAOImpl.d1==0) {
					dlpassword.setText("找回失败,用户名填写错误");
				}
				else {
				if (adm_name.equals(zh.zhgl(adm_name).getAdm_name())
						&& adm_pwdproblem.equals(zh.zhgl(adm_name).getAdm_problem())) {
					dlpassword.setText("找会成功  你的密码为:" + zh.zhgl(adm_name).getAdm_pwd());
					Date d1 = new Date();
					try {
						String txtname = "lib/IO流记录系统的操作日志/管理员操作日志/" + adm_name + "管理员操作日志" + ".txt";
						File file = new File(txtname);
						if (!file.exists()) {
							file.createNewFile();
						}
						FileOutputStream out = new FileOutputStream(file, true);
						String str = adm_name + "在" + d1 + "时间找回密码";
						out.write(str.getBytes());
						out.write("\n".getBytes());
						out.close();
					} catch (IOException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}

				} else {
					Date d1 = new Date();
					try {
						String txtname = "lib/IO流记录系统的操作日志/管理员操作日志/" + adm_name + "管理员操作日志" + ".txt";
						File file = new File(txtname);
						if (!file.exists()) {
							file.createNewFile();
						}
						FileOutputStream out = new FileOutputStream(file, true);
						String str = adm_name + "在" + d1 + "时间找回密码，但找回失败";

						out.write(str.getBytes());
						out.write("\n".getBytes());
						out.close();
					} catch (IOException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					dlpassword.setText("找回失败,用户名或密保答案   回答错误");
				}
			}}
		});
		btnNewButton.setBounds(62, 161, 113, 27);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("\u53D6\u6D88\u627E\u56DE");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_1.setBounds(202, 161, 113, 27);
		contentPane.add(btnNewButton_1);

		JLabel lblNewLabel_2 = new JLabel("\u539F\u767B\u5F55\u5BC6\u7801");
		lblNewLabel_2.setBounds(139, 217, 120, 18);
		contentPane.add(lblNewLabel_2);

		setLocationRelativeTo(null);
	}
}
