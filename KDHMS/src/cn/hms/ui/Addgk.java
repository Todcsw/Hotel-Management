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

import cn.hms.dao.impl.EmployessDAOImpl;
import cn.hms.entity.Customer;

public class Addgk extends JFrame {
	private String ygrzname = MyFrame1.yg;
	private String rzname;
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
					Addgk frame = new Addgk();
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
	public Addgk() {
		JTextArea textArea = new JTextArea();

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 340, 442);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("\u987E\u5BA2ID:");
		lblNewLabel.setBounds(25, 38, 126, 18);
		contentPane.add(lblNewLabel);

		JLabel lblid = new JLabel("\u987E\u5BA2\u59D3\u540D:");
		lblid.setBounds(25, 83, 97, 18);
		contentPane.add(lblid);

		JLabel lblid_1 = new JLabel("\u987E\u5BA2\u6027\u522B\uFF1A");
		lblid_1.setBounds(25, 127, 97, 18);
		contentPane.add(lblid_1);

		JLabel lblid_2 = new JLabel("\u987E\u5BA2\u8EAB\u4EFD\u8BC1\u53F7:");
		lblid_2.setBounds(25, 170, 102, 18);
		contentPane.add(lblid_2);

		JLabel label_3 = new JLabel("\u987E\u5BA2\u7535\u8BDD:");
		label_3.setBounds(25, 216, 72, 18);
		contentPane.add(label_3);

		JLabel label_4 = new JLabel("\u987E\u5BA2\u5907\u6CE8:");
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
				Customer cus = new Customer();
				cus.setCus_id(dd+"");
				cus.setCus_name(textField_1.getText());
				cus.setCus_sex(textField_2.getText());
				cus.setCus_identify(textField_3.getText());
				cus.setCus_tel(textField_4.getText());
				cus.setCus_text(textField_5.getText());

				int d = new EmployessDAOImpl().tjgk(cus);
				if (d == 1) {
					textArea.setText("增加顾客成功");
					result = "时间成功增加顾客,顾客号为:" + textField.getText();
					ygtjrz(result);

				} else {
					textArea.setText("顾客ID已存在或者信息输入错误");
					result = "时间增加顾客失败,顾客号为:" + textField.getText();
					ygtjrz(result);
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

	public void ygtjrz(String result) {
		try {
			Date d1 = new Date();

			String txtname = "lib/IO流记录系统的操作日志/员工操作日志/" + ygrzname + "员工操作日志" + ".txt";
			File file = new File(txtname);
			if (!file.exists()) {
				file.createNewFile();
			}
			FileOutputStream out = new FileOutputStream(file, true);
			String str = ygrzname + "在" + d1 + result;
			out.write(str.getBytes());
			out.write("\n".getBytes());
			out.close();
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
	}
}
