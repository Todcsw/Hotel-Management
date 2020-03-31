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
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.awt.event.ActionEvent;

public class Selectyg extends JFrame {
	private String rzname = MyFrame1.gl;
	private String ygrzname;
	private String result;
	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Selectyg frame = new Selectyg();
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
	public Selectyg() {
		JTextArea textArea = new JTextArea();

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 339, 245);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("\u5458\u5DE5\u59D3\u540D:");
		lblNewLabel.setBounds(42, 38, 126, 18);
		contentPane.add(lblNewLabel);

		textField = new JTextField();
		textField.setBounds(130, 35, 141, 24);
		contentPane.add(textField);
		textField.setColumns(10);

		JButton btnNewButton = new JButton("\u786E\u8BA4\u67E5\u8BE2");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 查询员工
				Employess emp = new Employess();
				emp = new AdministratorDAOImpl().cxyg(textField.getText());
				if (AdministratorDAOImpl.d == 1) {
					textArea.setText(emp.toString());
					result = "时间成功查询员工,员工姓名为:" + textField.getText();
					tjrz(result);
				} else {
					textArea.setText("员工ID输入错误或该人已被开除");
					result = "时间查询员工失败,员工姓名为:" + textField.getText();
					tjrz(result);
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

		textArea.setBounds(25, 125, 256, 73);
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
