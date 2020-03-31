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
import cn.hms.entity.Room;

public class Updatefjxx extends JFrame {
	private String ygrzname = MyFrame1.yg;
	private String rzname;
	private String result;
	private Room roo;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Updatefjxx frame = new Updatefjxx();
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
	public Updatefjxx() {
		JTextArea textArea = new JTextArea();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 330, 373);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("\u623F\u95F4ID:");
		lblNewLabel.setBounds(47, 35, 72, 18);
		contentPane.add(lblNewLabel);

		textField = new JTextField();
		textField.setBounds(129, 32, 134, 24);
		contentPane.add(textField);
		textField.setColumns(10);

		JButton btnNewButton = new JButton("\u786E\u8BA4\u66F4\u6539\u8BE5\u623F\u95F4");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 确认更改该房间
				String roo_id = textField.getText();
				roo = new EmployessDAOImpl().cxfj(roo_id);
				textField_1.setText(roo.getRok_id());
				textField_2.setText(roo.getRoo_state() + "");
				textField_3.setText(roo.getRoo_text());

			}
		});
		btnNewButton.setBounds(84, 66, 147, 27);
		contentPane.add(btnNewButton);

		JLabel lblNewLabel_1 = new JLabel("\u623F\u95F4\u7C7B\u578B\u53F7:");
		lblNewLabel_1.setBounds(47, 115, 92, 18);
		contentPane.add(lblNewLabel_1);

		textField_1 = new JTextField();
		textField_1.setBounds(129, 112, 134, 24);
		contentPane.add(textField_1);
		textField_1.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("\u623F\u95F4\u72B6\u6001:");
		lblNewLabel_2.setBounds(47, 168, 72, 18);
		contentPane.add(lblNewLabel_2);

		textField_2 = new JTextField();
		textField_2.setBounds(128, 165, 135, 24);
		contentPane.add(textField_2);
		textField_2.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("\u623F\u95F4\u5907\u6CE8:");
		lblNewLabel_3.setBounds(47, 215, 72, 18);
		contentPane.add(lblNewLabel_3);

		textField_3 = new JTextField();
		textField_3.setBounds(129, 212, 134, 24);
		contentPane.add(textField_3);
		textField_3.setColumns(10);

		JButton btnNewButton_1 = new JButton("\u786E\u8BA4\u66F4\u6539:");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 确认更改
				roo.setRoo_id(textField.getText());
				roo.setRok_id(textField_1.getText());
				if ("已住人".equals(textField_2.getText())) {
					roo.setRoo_state(1);
				} else {
					roo.setRoo_state(0);
				}
				roo.setRoo_text(textField_3.getText());
				int d = new EmployessDAOImpl().ggfj(roo, roo.getRoo_id());
				if (d == 1) {
					textArea.setText("更改成功");

					result = "时间成功更改房间信息,房间号为:" + textField.getText();
					ygtjrz(result);
				} else {
					textArea.setText("更改失败,信息填写有误");

					result = "时间更改房间信息失败,房间号为:" + textField.getText();
					ygtjrz(result);
				}
			}
		});
		btnNewButton_1.setBounds(35, 249, 123, 27);
		contentPane.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("\u53D6\u6D88\u66F4\u6539:");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_2.setBounds(170, 249, 113, 27);
		contentPane.add(btnNewButton_2);

		textArea.setBounds(68, 280, 181, 37);
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
