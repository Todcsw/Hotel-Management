package cn.hms.ui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import cn.hms.dao.impl.EmployessDAOImpl;
import cn.hms.entity.Order1;

public class Updateddxx extends JFrame {
	private Order1 ord;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private String ygrzname = MyFrame1.yg;
	private String rzname;
	private String result;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Updateddxx frame = new Updateddxx();
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
	public Updateddxx() {
		JTextArea textArea = new JTextArea();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 353, 536);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblid = new JLabel("\u8BA2\u5355ID:");
		lblid.setBounds(57, 28, 72, 18);
		contentPane.add(lblid);

		textField = new JTextField();
		textField.setBounds(153, 25, 132, 24);
		contentPane.add(textField);
		textField.setColumns(10);

		JButton btnNewButton = new JButton("\u786E\u8BA4\u66F4\u6539\u8BE5\u8BA2\u5355");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 确认更改该订单
				String ord_id = textField.getText();
				ord = new EmployessDAOImpl().cxdd(ord_id);
				textField_1.setText(ord.getEmp_id());
				textField_2.setText(ord.getCus_id());
				textField_3.setText(ord.getRoo_id());
				textField_4.setText(ord.getOrd_deposit() + "");
				textField_5.setText(ord.getOrd_date() + "");
				textField_6.setText(ord.getOrd_text());
			}
		});
		btnNewButton.setBounds(92, 59, 145, 27);
		contentPane.add(btnNewButton);

		JLabel lblNewLabel = new JLabel("\u64CD\u4F5C\u5458ID:");
		lblNewLabel.setBounds(57, 111, 72, 18);
		contentPane.add(lblNewLabel);

		textField_1 = new JTextField();
		textField_1.setBounds(153, 108, 132, 24);
		contentPane.add(textField_1);
		textField_1.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("\u987E\u5BA2ID:");
		lblNewLabel_1.setBounds(57, 164, 72, 18);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("\u623F\u95F4\u53F7ID:");
		lblNewLabel_2.setBounds(57, 207, 72, 18);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("\u62BC\u91D1:");
		lblNewLabel_3.setBounds(57, 255, 72, 18);
		contentPane.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("\u8BA2\u5355\u4EA7\u751F\u65F6\u95F4:");
		lblNewLabel_4.setBounds(57, 304, 98, 18);
		contentPane.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("\u5907\u6CE8:");
		lblNewLabel_5.setBounds(57, 347, 72, 18);
		contentPane.add(lblNewLabel_5);

		textField_2 = new JTextField();
		textField_2.setBounds(153, 161, 132, 24);
		contentPane.add(textField_2);
		textField_2.setColumns(10);

		textField_3 = new JTextField();
		textField_3.setBounds(153, 204, 132, 24);
		contentPane.add(textField_3);
		textField_3.setColumns(10);

		textField_4 = new JTextField();
		textField_4.setBounds(153, 252, 132, 24);
		contentPane.add(textField_4);
		textField_4.setColumns(10);

		textField_5 = new JTextField();
		textField_5.setBounds(153, 301, 132, 24);
		contentPane.add(textField_5);
		textField_5.setColumns(10);

		textField_6 = new JTextField();
		textField_6.setBounds(153, 344, 132, 24);
		contentPane.add(textField_6);
		textField_6.setColumns(10);

		JButton btnNewButton_1 = new JButton("\u786E\u8BA4\u66F4\u6539:");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 确认更改
				ord.setOrd_id(textField.getText());
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
				ord.setOrd_text(textField.getText());
				int d = new EmployessDAOImpl().ggdd(ord, ord.getOrd_id());
				if (d == 1) {
					textArea.setText("更改成功");
					result = "时间时间成功更改订单,订单号为:" + textField.getText();
					ygtjrz(result);
				} else {
					textArea.setText("时间时间更改订单失败,订单号为:" + textField.getText());
				}
			}
		});
		btnNewButton_1.setBounds(65, 392, 113, 27);
		contentPane.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("\u53D6\u6D88\u66F4\u6539:");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_2.setBounds(188, 392, 113, 27);
		contentPane.add(btnNewButton_2);

		textArea.setBounds(92, 432, 173, 44);
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
