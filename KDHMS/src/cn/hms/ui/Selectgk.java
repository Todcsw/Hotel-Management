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

public class Selectgk extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
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
					Selectgk frame = new Selectgk();
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
	public Selectgk() {
		JTextArea textArea = new JTextArea();

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 339, 245);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("\u987E\u5BA2\u59D3\u540D:");
		lblNewLabel.setBounds(25, 38, 126, 18);
		contentPane.add(lblNewLabel);

		textField = new JTextField();
		textField.setBounds(130, 35, 141, 24);
		contentPane.add(textField);
		textField.setColumns(10);

		JButton btnNewButton = new JButton("\u786E\u8BA4\u67E5\u8BE2");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 查询房间类型
				String Cus_name = textField.getText();
				Customer cus = new Customer();
				cus = new EmployessDAOImpl().cxgk(Cus_name);
				if (EmployessDAOImpl.d == 1) {
					textArea.setText(cus.toString());
					result = "时间成功查询房间类型,房间名为为:" + textField.getText();
					ygtjrz(result);
				} else {
					textArea.setText("顾客不存在");
					result = "时间查询房间类型失败,房间名为:" + textField.getText();
					ygtjrz(result);
				}
			}
		});
		btnNewButton.setBounds(14, 85, 113, 27);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("\u53D6\u6D88\u67E5\u8BE2");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_1.setBounds(195, 85, 113, 27);
		contentPane.add(btnNewButton_1);

		textArea.setBounds(25, 125, 256, 60);
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
