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

public class Updatefjlx extends JFrame {
	private String rzname = MyFrame1.gl;
	private String ygrzname;
	private String result;
	static Roomkind rok;
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
					Updatefjlx frame = new Updatefjlx();
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
	public Updatefjlx() {

		JTextArea textArea = new JTextArea();

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 340, 491);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("\u623F\u95F4\u7C7B\u578BID:");
		lblNewLabel.setBounds(25, 38, 126, 18);
		contentPane.add(lblNewLabel);

		JLabel label = new JLabel("\u623F\u95F4\u7C7B\u578B\u540D:");
		label.setBounds(25, 118, 97, 18);
		contentPane.add(label);

		JLabel label_1 = new JLabel("\u623F\u95F4\u4EF7\u683C:");
		label_1.setBounds(25, 162, 72, 18);
		contentPane.add(label_1);

		JLabel label_2 = new JLabel("\u623F\u95F4\u603B\u6570:");
		label_2.setBounds(25, 204, 72, 18);
		contentPane.add(label_2);

		JLabel label_3 = new JLabel("\u623F\u95F4\u5269\u4F59:");
		label_3.setBounds(25, 253, 72, 18);
		contentPane.add(label_3);

		JLabel label_4 = new JLabel("\u623F\u95F4\u5220\u9664\u6807\u5FD7:");
		label_4.setBounds(25, 299, 126, 18);
		contentPane.add(label_4);

		textField = new JTextField();
		textField.setBounds(130, 35, 141, 24);
		contentPane.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setBounds(130, 115, 141, 24);
		contentPane.add(textField_1);
		textField_1.setColumns(10);

		textField_2 = new JTextField();
		textField_2.setBounds(130, 159, 141, 24);
		contentPane.add(textField_2);
		textField_2.setColumns(10);

		textField_3 = new JTextField();
		textField_3.setBounds(130, 201, 141, 24);
		contentPane.add(textField_3);
		textField_3.setColumns(10);

		textField_4 = new JTextField();
		textField_4.setBounds(130, 253, 141, 24);
		contentPane.add(textField_4);
		textField_4.setColumns(10);

		textField_5 = new JTextField();
		textField_5.setBounds(130, 296, 141, 24);
		contentPane.add(textField_5);
		textField_5.setColumns(10);

		JButton btnNewButton = new JButton("\u786E\u8BA4\u66F4\u6539");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 更改房间类型
				rok.setRok_id(textField.getText());
				rok.setRok_name(textField_1.getText());
				rok.setRok_money(Float.valueOf(textField_2.getText()));
				rok.setRok_total(Integer.valueOf(textField_3.getText()));
				rok.setRok_surplus(Integer.valueOf(textField_4.getText()));
				rok.setRok_delremark(Integer.valueOf(textField_5.getText()));
				int d = new AdministratorDAOImpl().ggfj(rok, rok.getRok_id());
				if (d == 1) {
					textArea.setText("更改成功");
					result = "时间成功更改房间类型,房间类型号为:" + textField.getText();
					tjrz(result);
				} else {
					textArea.setText("更改失败,信息填写有误");
					result = "时间更改房间类型失败,房间类型号为:" + textField.getText();
					tjrz(result);
				}

			}
		});
		btnNewButton.setBounds(14, 354, 113, 27);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("\u53D6\u6D88\u66F4\u6539");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_1.setBounds(181, 354, 113, 27);
		contentPane.add(btnNewButton_1);

		textArea.setBounds(49, 394, 205, 37);
		contentPane.add(textArea);

		JButton btnNewButton_2 = new JButton("\u786E\u8BA4\u66F4\u6539\u8BE5\u623F\u578B");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 确认更改该房间类型
				String rok_id = textField.getText();

				AdministratorDAOImpl ad = new AdministratorDAOImpl();
				rok = ad.cxfj(rok_id);
				textField_1.setText(rok.getRok_name());
				textField_2.setText("" + rok.getRok_money());
				textField_3.setText("" + rok.getRok_total());
				textField_4.setText("" + rok.getRok_surplus());
				textField_5.setText("" + rok.getRok_delremark());
			}
		});
		btnNewButton_2.setBounds(90, 69, 141, 36);
		contentPane.add(btnNewButton_2);
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
