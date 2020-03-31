package cn.hms.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Administratorregister extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JPasswordField passwordField;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Administratorregister frame = new Administratorregister();
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
	public Administratorregister() {
		JTextArea textArea = new JTextArea();

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 368, 384);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("\u7BA1\u7406\u5458ID:");
		lblNewLabel.setBounds(24, 25, 72, 18);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("\u7BA1\u7406\u5458\u7528\u6237\u540D\uFF1A");
		lblNewLabel_1.setBounds(24, 66, 118, 18);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("\u7BA1\u7406\u5458\u5BC6\u7801\uFF1A");
		lblNewLabel_2.setBounds(24, 107, 102, 18);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("\u7BA1\u7406\u5458\u72B6\u6001\uFF1A");
		lblNewLabel_3.setBounds(24, 147, 90, 18);
		contentPane.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("\u7BA1\u7406\u5458\u5BC6\u7801\u95EE\u9898:");
		lblNewLabel_4.setBounds(24, 192, 118, 18);
		contentPane.add(lblNewLabel_4);

		textField = new JTextField();
		textField.setBounds(156, 22, 152, 24);
		contentPane.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setBounds(156, 63, 152, 24);
		contentPane.add(textField_1);
		textField_1.setColumns(10);

		passwordField = new JPasswordField();
		passwordField.setBounds(156, 104, 152, 24);
		contentPane.add(passwordField);

		textField_2 = new JTextField();
		textField_2.setBounds(156, 144, 152, 24);
		contentPane.add(textField_2);
		textField_2.setColumns(10);

		textField_3 = new JTextField();
		textField_3.setBounds(156, 189, 152, 24);
		contentPane.add(textField_3);
		textField_3.setColumns(10);

		JButton btnNewButton = new JButton("\u786E\u8BA4\u6CE8\u518C");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// π‹¿Ì‘±◊¢≤·

			}
		});
		btnNewButton.setBounds(35, 240, 113, 27);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("\u53D6\u6D88\u6CE8\u518C");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_1.setBounds(185, 240, 113, 27);
		contentPane.add(btnNewButton_1);

		textArea.setBounds(92, 280, 168, 44);
		contentPane.add(textArea);
		setLocationRelativeTo(null);
	}

}
