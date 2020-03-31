package cn.hms.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cn.hms.dao.impl.AdministratorDAOImpl;
import cn.hms.entity.Employess;

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

public class Employessfind extends JFrame {

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
					Employessfind frame = new Employessfind();
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
	public Employessfind() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 401, 398);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("\u5458\u5DE5\u7528\u6237\u540D:");
		lblNewLabel.setBounds(49, 55, 101, 18);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("\u5BC6\u4FDD\u95EE\u9898\u7B54\u6848:");
		lblNewLabel_1.setBounds(49, 104, 101, 18);
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
				// �һ�����
				String emp_name = name.getText();
				String emp_pwdproblem = new String(pwdproblem.getPassword());
				AdministratorDAOImpl zh = new AdministratorDAOImpl();
				zh.cxyg(emp_name);
				if (zh.d == 0) {
					dlpassword.setText("�Ҳ�����Ա��");
				} else {
					if (emp_name.equals(zh.zhyg(emp_name).getEmp_name())
							&& emp_pwdproblem.equals(zh.zhyg(emp_name).getEmp_problem())) {
						dlpassword.setText("�һ�ɹ�  �������Ϊ:" + zh.zhyg(emp_name).getEmp_pwd());
						Date d1 = new Date();
						try {
							String txtname = "lib/IO����¼ϵͳ�Ĳ�����־/Ա��������־/" + emp_name + "Ա��������־" + ".txt";
							File file = new File(txtname);
							if (!file.exists()) {
								file.createNewFile();
							}
							FileOutputStream out = new FileOutputStream(file, true);
							String str = emp_name + "��" + d1 + "ʱ���һ�����";

							out.write(str.getBytes());
							out.write("\n".getBytes());
							out.close();
						} catch (IOException e2) {
							// TODO Auto-generated catch block
							e2.printStackTrace();
						}

					} else {

						dlpassword.setText("�һ�ʧ��,�û������ܱ���   �ش����");
						Date d1 = new Date();
						try {
							String txtname = "lib/IO����¼ϵͳ�Ĳ�����־/Ա��������־/" + emp_name + "Ա��������־" + ".txt";
							File file = new File(txtname);
							if (!file.exists()) {
								file.createNewFile();
							}
							FileOutputStream out = new FileOutputStream(file, true);
							String str = emp_name + "��" + d1 + "ʱ���һ�����,���һ�ʧ��";
							out.write(str.getBytes());
							out.write("\n".getBytes());
							out.close();
						} catch (IOException e2) {
							// TODO Auto-generated catch block
							e2.printStackTrace();
						}
					}
				}

			}
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
