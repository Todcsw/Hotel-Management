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

public class Updategkxx extends JFrame {
	private Customer cus;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
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
					Updategkxx frame = new Updategkxx();
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
	public Updategkxx() {

		JTextArea textArea = new JTextArea();

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 353, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblid = new JLabel("\u987E\u5BA2\u59D3\u540D:");
		lblid.setBounds(50, 30, 72, 18);
		contentPane.add(lblid);

		JButton btnNewButton_1 = new JButton("\u786E\u5B9A\u66F4\u6539\u6B64\u987E\u5BA2\u4FE1\u606F");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 确定更改此顾客
				String cus_name = textField.getText();
				cus = new EmployessDAOImpl().cxgk(cus_name);
				textField_1.setText(cus.getCus_id());
				textField_2.setText(cus.getCus_sex());
				textField_3.setText(cus.getCus_identify());
				textField_4.setText(cus.getCus_tel());
				textField_5.setText(cus.getCus_text());

			}
		});
		btnNewButton_1.setBounds(79, 61, 177, 27);
		contentPane.add(btnNewButton_1);

		JLabel lblid_1 = new JLabel("\u987E\u5BA2ID:");
		lblid_1.setBounds(50, 101, 72, 18);
		contentPane.add(lblid_1);

		JLabel lblNewLabel = new JLabel("\u987E\u5BA2\u6027\u522B:");
		lblNewLabel.setBounds(50, 152, 72, 18);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("\u987E\u5BA2\u8EAB\u4EFD\u8BC1:");
		lblNewLabel_1.setBounds(50, 206, 98, 18);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("\u987E\u5BA2\u7535\u8BDD:");
		lblNewLabel_2.setBounds(50, 255, 72, 18);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("\u987E\u5BA2\u5907\u6CE8:");
		lblNewLabel_3.setBounds(50, 307, 72, 18);
		contentPane.add(lblNewLabel_3);

		textField = new JTextField();
		textField.setBounds(136, 27, 153, 24);
		contentPane.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setBounds(136, 101, 153, 24);
		contentPane.add(textField_1);
		textField_1.setColumns(10);

		textField_2 = new JTextField();
		textField_2.setBounds(136, 149, 153, 24);
		contentPane.add(textField_2);
		textField_2.setColumns(10);

		textField_3 = new JTextField();
		textField_3.setBounds(136, 203, 153, 24);
		contentPane.add(textField_3);
		textField_3.setColumns(10);

		textField_4 = new JTextField();
		textField_4.setBounds(136, 252, 153, 24);
		contentPane.add(textField_4);
		textField_4.setColumns(10);

		textField_5 = new JTextField();
		textField_5.setBounds(136, 304, 153, 24);
		contentPane.add(textField_5);
		textField_5.setColumns(10);

		JButton btnNewButton = new JButton("\u786E\u5B9A\u66F4\u6539:");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// 确定更改
				cus.setCus_id(textField_1.getText());
				cus.setCus_name(textField.getText());
				cus.setCus_sex(textField_2.getText());
				cus.setCus_identify(textField_3.getText());
				cus.setCus_tel(textField_4.getText());
				cus.setCus_text(textField_5.getText());
				int d = new EmployessDAOImpl().gggk(cus, cus.getCus_name());
				if (d == 1) {
					textArea.setText("更改成功");
					result = "时间成功更改顾客信息,顾客号为:" + textField.getText();
					ygtjrz(result);
				} else {
					textArea.setText("信息填写有误");
					result = "时间更改顾客信息失败,顾客号为:" + textField.getText();
					ygtjrz(result);
				}
			}
		});
		btnNewButton.setBounds(58, 352, 101, 27);
		contentPane.add(btnNewButton);

		JButton btnNewButton_2 = new JButton("\u53D6\u6D88\u66F4\u6539:");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_2.setBounds(174, 352, 101, 27);
		contentPane.add(btnNewButton_2);

		textArea.setBounds(68, 392, 207, 48);
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
