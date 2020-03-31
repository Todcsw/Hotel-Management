package cn.hms.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cn.hms.dao.impl.AdministratorDAOImpl;
import cn.hms.entity.Employess;

import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

public class Employessregister extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JPasswordField passwordField;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Employessregister frame = new Employessregister();
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
	public Employessregister() {
		JTextArea textArea = new JTextArea();

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 452, 475);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("\u5458\u5DE5ID:");
		lblNewLabel.setBounds(33, 28, 72, 18);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("\u5458\u5DE5\u7528\u6237\u540D:");
		lblNewLabel_1.setBounds(33, 59, 87, 18);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("\u5458\u5DE5\u5BC6\u7801:");
		lblNewLabel_2.setBounds(33, 95, 72, 18);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("\u5458\u5DE5\u6027\u522B:");
		lblNewLabel_3.setBounds(33, 126, 72, 18);
		contentPane.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("\u5458\u5DE5\u8EAB\u4EFD\u8BC1\u53F7:");
		lblNewLabel_4.setBounds(33, 157, 110, 18);
		contentPane.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("\u5458\u5DE5\u85AA\u6C34:");
		lblNewLabel_5.setBounds(33, 188, 72, 18);
		contentPane.add(lblNewLabel_5);

		JLabel lblNewLabel_6 = new JLabel("\u5458\u5DE5\u72B6\u6001:");
		lblNewLabel_6.setBounds(33, 219, 72, 18);
		contentPane.add(lblNewLabel_6);

		JLabel lblNewLabel_7 = new JLabel("\u5458\u5DE5\u5BC6\u4FDD\u95EE\u9898:");
		lblNewLabel_7.setBounds(33, 250, 110, 18);
		contentPane.add(lblNewLabel_7);

		JLabel lblNewLabel_8 = new JLabel("\u5458\u5DE5\u5907\u6CE8:");
		lblNewLabel_8.setBounds(33, 283, 72, 18);
		contentPane.add(lblNewLabel_8);

		textField = new JTextField();
		textField.setBounds(163, 25, 172, 24);
		contentPane.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setBounds(163, 56, 172, 24);
		contentPane.add(textField_1);
		textField_1.setColumns(10);

		passwordField = new JPasswordField();
		passwordField.setBounds(163, 92, 172, 24);
		contentPane.add(passwordField);

		textField_2 = new JTextField();
		textField_2.setBounds(163, 123, 172, 24);
		contentPane.add(textField_2);
		textField_2.setColumns(10);

		textField_3 = new JTextField();
		textField_3.setBounds(163, 154, 172, 24);
		contentPane.add(textField_3);
		textField_3.setColumns(10);

		textField_4 = new JTextField();
		textField_4.setBounds(163, 185, 172, 24);
		contentPane.add(textField_4);
		textField_4.setColumns(10);

		textField_5 = new JTextField();
		textField_5.setBounds(163, 216, 172, 24);
		contentPane.add(textField_5);
		textField_5.setColumns(10);

		textField_6 = new JTextField();
		textField_6.setBounds(163, 247, 172, 24);
		contentPane.add(textField_6);
		textField_6.setColumns(10);

		textField_7 = new JTextField();
		textField_7.setBounds(163, 280, 172, 24);
		contentPane.add(textField_7);
		textField_7.setColumns(10);
		long dd = System.currentTimeMillis();
		textField.setText(dd + "");
		JButton btnNewButton = new JButton("\u786E\u8BA4\u6CE8\u518C");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 员工注册
				Employess emp = new Employess();
				emp.setEmp_id(dd+"");
				emp.setEmp_name(textField_1.getText());
				emp.setEmp_pwd(passwordField.getText());
				emp.setEmp_sex(textField_2.getText());
				emp.setEmp_identify(textField_3.getText());
				emp.setEmp_salary(Float.valueOf(textField_4.getText()));
				if ("在职".equals(textField_5.getText())) {
					emp.setEmp_delremark(1);
				} else {
					emp.setEmp_delremark(0);
				}
				emp.setEmp_problem(textField_6.getText());
				emp.setEmp_text(textField_7.getText());
				int d = new AdministratorDAOImpl().tjyg(emp);
				if (d == 1) {
					textArea.setText("注册成功");
				} else {
					textArea.setText("注册失败");
				}
			}
		});
		btnNewButton.setBounds(64, 336, 113, 27);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("\u53D6\u6D88\u6CE8\u518C");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_1.setBounds(285, 336, 113, 27);
		contentPane.add(btnNewButton_1);

		textArea.setBounds(114, 376, 221, 39);
		contentPane.add(textArea);
		setLocationRelativeTo(null);
	}
}
