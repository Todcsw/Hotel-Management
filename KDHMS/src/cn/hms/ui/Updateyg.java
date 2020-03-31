package cn.hms.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cn.hms.dao.impl.AdministratorDAOImpl;
import cn.hms.entity.Employess;
import cn.hms.entity.Roomkind;

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

public class Updateyg extends JFrame {
	private String rzname = MyFrame1.gl;
	private String ygrzname;
	private String result;
	static Employess emp;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Updateyg frame = new Updateyg();
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
	public Updateyg() {

		JTextArea textArea = new JTextArea();

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 343, 547);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("\u5458\u5DE5\u59D3\u540D:");
		lblNewLabel.setBounds(25, 38, 126, 18);
		contentPane.add(lblNewLabel);

		JLabel label = new JLabel("\u5458\u5DE5\u7528\u6237\u540D:");
		label.setBounds(25, 125, 97, 18);
		contentPane.add(label);

		JLabel label_1 = new JLabel("\u5458\u5DE5\u5BC6\u7801:");
		label_1.setBounds(25, 167, 72, 18);
		contentPane.add(label_1);

		JLabel label_2 = new JLabel("\u5458\u5DE5\u6027\u522B:");
		label_2.setBounds(25, 212, 72, 18);
		contentPane.add(label_2);

		JLabel label_3 = new JLabel("\u5458\u5DE5\u8EAB\u4EFD\u8BC1\u53F7:");
		label_3.setBounds(25, 258, 102, 18);
		contentPane.add(label_3);

		JLabel label_4 = new JLabel("\u5458\u5DE5\u85AA\u6C34:");
		label_4.setBounds(25, 295, 126, 18);
		contentPane.add(label_4);

		textField = new JTextField();
		textField.setBounds(130, 35, 141, 24);
		contentPane.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setBounds(130, 122, 141, 24);
		contentPane.add(textField_1);
		textField_1.setColumns(10);

		textField_2 = new JTextField();
		textField_2.setBounds(130, 167, 141, 24);
		contentPane.add(textField_2);
		textField_2.setColumns(10);

		textField_3 = new JTextField();
		textField_3.setBounds(130, 212, 141, 24);
		contentPane.add(textField_3);
		textField_3.setColumns(10);

		textField_4 = new JTextField();
		textField_4.setBounds(130, 255, 141, 24);
		contentPane.add(textField_4);
		textField_4.setColumns(10);

		textField_5 = new JTextField();
		textField_5.setBounds(130, 292, 141, 24);
		contentPane.add(textField_5);
		textField_5.setColumns(10);

		JButton btnNewButton = new JButton("\u786E\u8BA4\u66F4\u6539");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 更改员工
				emp.setEmp_id(textField.getText());
				emp.setEmp_name(textField_1.getText());
				emp.setEmp_pwd(textField_2.getText());
				emp.setEmp_sex(textField_3.getText());
				emp.setEmp_identify(textField_4.getText());
				emp.setEmp_salary(Float.valueOf(textField_5.getText()));
				emp.setEmp_delremark(Integer.valueOf(textField_6.getText()));
				emp.setEmp_problem(textField_7.getText());
				emp = new AdministratorDAOImpl().ggyg(emp, emp.getEmp_id());
				if (AdministratorDAOImpl.d == 1) {
					textArea.setText("更改成功");
					result = "时间成功更改员工,员工号为:" + textField.getText();
					tjrz(result);
				} else {
					textArea.setText("更改失败,信息填写有误");
					result = "时间更改员工失败,员工号为:" + textField.getText();
					tjrz(result);
				}

			}
		});
		btnNewButton.setBounds(14, 409, 113, 27);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("\u53D6\u6D88\u66F4\u6539");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_1.setBounds(183, 409, 113, 27);
		contentPane.add(btnNewButton_1);

		textArea.setBounds(55, 450, 205, 37);
		contentPane.add(textArea);

		JLabel lblNewLabel_1 = new JLabel("\u5458\u5DE5\u5728\u804C\u72B6\u6001:");
		lblNewLabel_1.setBounds(25, 334, 104, 18);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("\u5458\u5DE5\u5BC6\u4FDD\u7B54\u6848:");
		lblNewLabel_2.setBounds(25, 371, 113, 18);
		contentPane.add(lblNewLabel_2);

		textField_6 = new JTextField();
		textField_6.setBounds(130, 331, 141, 24);
		contentPane.add(textField_6);
		textField_6.setColumns(10);

		textField_7 = new JTextField();
		textField_7.setBounds(130, 368, 141, 24);
		contentPane.add(textField_7);
		textField_7.setColumns(10);

		JButton btnNewButton_2 = new JButton("\u786E\u8BA4\u66F4\u6539\u8BE5\u5458\u5DE5");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 确认更改该员工
				String Emp_id = textField.getText();

				AdministratorDAOImpl ad = new AdministratorDAOImpl();
				emp = ad.cxyg(Emp_id);
				textField.setText(emp.getEmp_id());
				textField_1.setText(emp.getEmp_name());
				textField_2.setText(emp.getEmp_pwd());
				textField_3.setText("" + emp.getEmp_sex());
				textField_4.setText("" + emp.getEmp_identify());
				textField_5.setText("" + emp.getEmp_salary());
				textField_6.setText("" + emp.getEmp_delremark());
				textField_7.setText("" + emp.getEmp_problem());

			}
		});
		btnNewButton_2.setBounds(90, 69, 141, 37);
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
