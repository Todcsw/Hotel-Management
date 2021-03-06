package cn.hms.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cn.hms.dao.impl.AdministratorDAOImpl;
import cn.hms.entity.Order1;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;

public class Adddd extends JFrame {
	private String rzname = MyFrame1.gl;
	private String ygrzname;
	private String result;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Adddd frame = new Adddd();
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
	public Adddd() {
		JTextArea textArea = new JTextArea();

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 340, 442);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("\u8BA2\u5355ID:");
		lblNewLabel.setBounds(25, 38, 126, 18);
		contentPane.add(lblNewLabel);

		JLabel lblid = new JLabel("\u5458\u5DE5ID:");
		lblid.setBounds(25, 83, 97, 18);
		contentPane.add(lblid);

		JLabel lblid_1 = new JLabel("\u987E\u5BA2ID\uFF1A");
		lblid_1.setBounds(25, 127, 72, 18);
		contentPane.add(lblid_1);

		JLabel lblid_2 = new JLabel("\u623F\u95F4\u53F7ID:");
		lblid_2.setBounds(25, 170, 72, 18);
		contentPane.add(lblid_2);

		JLabel label_3 = new JLabel("\u62BC\u91D1:");
		label_3.setBounds(25, 216, 72, 18);
		contentPane.add(label_3);

		JLabel label_4 = new JLabel("\u5165\u4F4F\u65F6\u95F4:");
		label_4.setBounds(25, 258, 126, 18);
		contentPane.add(label_4);

		textField = new JTextField();
		textField.setBounds(130, 35, 141, 24);
		contentPane.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setBounds(130, 80, 141, 24);
		contentPane.add(textField_1);
		textField_1.setColumns(10);

		textField_2 = new JTextField();
		textField_2.setBounds(130, 124, 141, 24);
		contentPane.add(textField_2);
		textField_2.setColumns(10);

		textField_3 = new JTextField();
		textField_3.setBounds(130, 167, 141, 24);
		contentPane.add(textField_3);
		textField_3.setColumns(10);

		textField_4 = new JTextField();
		textField_4.setBounds(130, 213, 141, 24);
		contentPane.add(textField_4);
		textField_4.setColumns(10);

		textField_5 = new JTextField();
		textField_5.setBounds(130, 255, 141, 24);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		long dd = System.currentTimeMillis();
		textField.setText(dd + "");
		JButton btnNewButton = new JButton("\u786E\u8BA4\u589E\u52A0");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 增加订单信息
				Order1 ord = new Order1();

				ord.setOrd_id(dd + "");

				ord.setEmp_id(textField_1.getText());
				ord.setCus_id(textField_2.getText());
				ord.setRoo_id(textField_3.getText());
				ord.setOrd_deposit(Float.valueOf(textField_4.getText()));
				try {
					ord.setOrd_date(new SimpleDateFormat("yyyy-MM-dd").parse(textField_5.getText()));
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				int d;

				d = new AdministratorDAOImpl().cjdd(ord);
				if (d == 1) {
					textArea.setText("增加订单成功");
					result = "时间增加订单成功,订单号为:" + textField.getText();
					tjrz(result);

				} else {
					textArea.setText("订单ID已存在或者信息输入错误");
					result = "时间增加订单失败,失败订单号为:" + textField.getText();
					tjrz(result);
				}

			}

		});
		btnNewButton.setBounds(14, 306, 113, 27);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("\u53D6\u6D88\u589E\u52A0");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_1.setBounds(181, 306, 113, 27);
		contentPane.add(btnNewButton_1);

		textArea.setBounds(52, 346, 205, 37);
		contentPane.add(textArea);
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
