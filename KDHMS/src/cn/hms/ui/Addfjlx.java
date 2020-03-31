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
import cn.hms.entity.Roomkind;

public class Addfjlx extends JFrame {
	private String rzname;
	private String ygrzname;
	private String result = MyFrame1.gl;
	private JPanel contentPane;
	private JTextField textField1;
	private JTextField textField2;
	private JTextField textField3;
	private JTextField textField4;
	private JTextField textField5;
	private JTextField textField6;
	JTextArea textArea = new JTextArea();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Addfjlx frame = new Addfjlx();

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
	public Addfjlx() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 340, 442);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("\u623F\u95F4\u7C7B\u578BID:");
		lblNewLabel.setBounds(25, 38, 126, 18);
		contentPane.add(lblNewLabel);

		JLabel label = new JLabel("\u623F\u95F4\u7C7B\u578B\u540D:");
		label.setBounds(25, 83, 97, 18);
		contentPane.add(label);

		JLabel label_1 = new JLabel("\u623F\u95F4\u4EF7\u683C:");
		label_1.setBounds(25, 127, 72, 18);
		contentPane.add(label_1);

		JLabel label_2 = new JLabel("\u623F\u95F4\u603B\u6570:");
		label_2.setBounds(25, 170, 72, 18);
		contentPane.add(label_2);

		JLabel label_3 = new JLabel("\u623F\u95F4\u5269\u4F59:");
		label_3.setBounds(25, 216, 72, 18);
		contentPane.add(label_3);

		JLabel label_4 = new JLabel("\u623F\u95F4\u5220\u9664\u6807\u5FD7:");
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
		long dd = System.currentTimeMillis();
		textField1.setText(dd + "");
		JButton btnNewButton = new JButton("\u786E\u8BA4\u589E\u52A0");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Roomkind rok = new Roomkind();
				rok.setRok_id(dd+"");
				rok.setRok_name(textField2.getText());
				rok.setRok_money(Float.parseFloat(textField3.getText()));
				rok.setRok_total(Integer.parseInt(textField4.getText()));
				rok.setRok_surplus(Integer.parseInt(textField5.getText()));
				if (textField6.getText().equals("使用中")) {
					rok.setRok_delremark(1);
				} else {
					rok.setRok_delremark(0);
				}
				int d = new AdministratorDAOImpl().zjfj(rok);
				if (d == 1) {
					textArea.setText("添加成功");
					result = "时间成功增加房间类型,房间类型号为:" + textField1.getText();
					tjrz(result);
				} else {
					textArea.setText("添加失败,房间类型ID名重复或者必填项未填");
					result = "时间增加房间类型失败,房间类型号为:" + textField1.getText();
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
