package cn.hms.ui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import cn.hms.dao.impl.AdministratorDAOImpl;
import cn.hms.entity.Employess;

public class Addyg extends JFrame {
	private String rzname = MyFrame1.gl;
	private String ygrzname;
	private String result;
	private JPanel contentPane;
	private JTextField textField1;
	private JTextField textField2;
	private JTextField textField3;
	private JTextField textField4;
	private JTextField textField5;
	private JTextField textField6;
	private JTextField textField7;
	private JTextField textField8;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Addyg frame = new Addyg();
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
	public Addyg() {
		JTextArea textArea = new JTextArea();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 343, 517);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("\u5458\u5DE5ID:");
		lblNewLabel.setBounds(25, 38, 126, 18);
		contentPane.add(lblNewLabel);

		JLabel label = new JLabel("\u5458\u5DE5\u7528\u6237\u540D:");
		label.setBounds(25, 83, 97, 18);
		contentPane.add(label);

		JLabel label_1 = new JLabel("\u5458\u5DE5\u5BC6\u7801:");
		label_1.setBounds(25, 127, 72, 18);
		contentPane.add(label_1);

		JLabel label_2 = new JLabel("\u5458\u5DE5\u6027\u522B:");
		label_2.setBounds(25, 170, 72, 18);
		contentPane.add(label_2);

		JLabel label_3 = new JLabel("\u5458\u5DE5\u8EAB\u4EFD\u8BC1\u53F7:");
		label_3.setBounds(25, 216, 102, 18);
		contentPane.add(label_3);

		JLabel label_4 = new JLabel("\u5458\u5DE5\u85AA\u6C34:");
		label_4.setBounds(25, 258, 126, 18);
		contentPane.add(label_4);

		textField1 = new JTextField();
		textField1.setBounds(130, 35, 141, 24);
		contentPane.add(textField1);
		textField1.setColumns(10);

		textField2 = new JTextField();
		textField2.setBounds(130, 80, 141, 24);
		contentPane.add(textField2);
		textField2.setColumns(10);

		textField3 = new JTextField();
		textField3.setBounds(130, 124, 141, 24);
		contentPane.add(textField3);
		textField3.setColumns(10);

		textField4 = new JTextField();
		textField4.setBounds(130, 167, 141, 24);
		contentPane.add(textField4);
		textField4.setColumns(10);

		textField5 = new JTextField();
		textField5.setBounds(130, 213, 141, 24);
		contentPane.add(textField5);
		textField5.setColumns(10);

		textField6 = new JTextField();
		textField6.setBounds(130, 255, 141, 24);
		contentPane.add(textField6);
		textField6.setColumns(10);

		textField7 = new JTextField();
		textField7.setBounds(130, 294, 141, 24);
		contentPane.add(textField7);
		textField7.setColumns(10);

		textField8 = new JTextField();
		textField8.setBounds(130, 334, 141, 24);
		contentPane.add(textField8);
		textField8.setColumns(10);
		long dd = System.currentTimeMillis();
		textField1.setText(dd + "");
		JButton btnNewButton = new JButton("\u786E\u8BA4\u589E\u52A0");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Employess emp = new Employess();
				emp.setEmp_id(dd+"");
				emp.setEmp_name(textField2.getText());
				emp.setEmp_pwd(textField3.getText());
				emp.setEmp_sex(textField4.getText());
				emp.setEmp_identify(textField5.getText());
				emp.setEmp_salary(Float.valueOf(textField6.getText()));
				if ("在职".equals(textField7.getText())) {

					emp.setEmp_delremark(Integer.valueOf(1));

				} else {
					emp.setEmp_delremark(Integer.valueOf(0));
				}
				emp.setEmp_problem(textField8.getText());
				int d = new AdministratorDAOImpl().tjyg(emp);
				if (d == 1) {
					textArea.setText("添加成功");
					result = "时间成功添加员工,员工号为:" + textField1.getText();
					tjrz(result);
				} else {
					textArea.setText("用户已存在或用户信息填写错误");
					result = "时间添加员工失败,员工号为:" + textField1.getText();
					tjrz(result);
				}
				// 增加员工
			}
		});
		btnNewButton.setBounds(14, 380, 113, 27);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("\u53D6\u6D88\u589E\u52A0");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_1.setBounds(183, 380, 113, 27);
		contentPane.add(btnNewButton_1);

		textArea.setBounds(55, 420, 205, 37);
		contentPane.add(textArea);

		JLabel lblNewLabel_1 = new JLabel("\u5458\u5DE5\u5728\u804C\u72B6\u6001:");
		lblNewLabel_1.setBounds(25, 297, 104, 18);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("\u5458\u5DE5\u5BC6\u4FDD\u7B54\u6848:");
		lblNewLabel_2.setBounds(25, 334, 113, 18);
		contentPane.add(lblNewLabel_2);

		setLocationRelativeTo(null);
	}

	public void tjrz(String result) {
		try {
			Date d1 = new Date();

			String txtname = "lib/IO流记录系统的操作日志/管理员操作日志/" + rzname + "管理员操作日志" + ".txt";
			File file = new File(txtname);
			if (!file.exists()) {
				file.createNewFile();
			}
			FileOutputStream out = new FileOutputStream(file, true);
			String str = rzname + "在" + d1 + result;
			out.write(str.getBytes());
			out.write("\n".getBytes());
			out.close();
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
	}
}
