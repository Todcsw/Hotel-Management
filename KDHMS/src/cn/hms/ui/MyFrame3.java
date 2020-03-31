package cn.hms.ui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import cn.hms.dao.impl.AdministratorDAOImpl;
import cn.hms.entity.Croom;

public class MyFrame3 extends JFrame {

	private JPanel contentPane;
	public String ygrzname = MyFrame1.yg;
	private String result;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyFrame3 frame = new MyFrame3();
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
	public MyFrame3() {
		setResizable(false);
		setTitle("\u5458\u5DE5\u754C\u9762");
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setFont(new Font("����", Font.PLAIN, 15));
		Date d1 = new Date();
		textArea_1.setText("  ��ӭ" + MyFrame1.yg + "����Ա" + "       ������������ף���������,���彡��" + "-" + d1);
		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("����", Font.PLAIN, 13));
		// Ĭ��չʾ����
		String str = "\n                                       �Ƶ����е�Ա����Ҫ������������ʶ\n \n ��������Ҫ��һ�㣬��Ϊ�Ƶ��Ƿ�����ҵ�������ṩ�������������ͼ�ֵ��������ȷ���͸��Ѿ�Ӧ�õõ���������ֵ������Ӧ����\n�����ǾƵ����ʳ��ĸ���ǾƵ�����֮Դ���Ƶ�������������ر��ͣ�վ�ڱ��͵������ϣ���������룬���������裬Ϊ�����ṩһ�� .\n�ķ���"
				+ "\r\n"
				+ "  ������ķ���Ҫ������������񣬾����п��������Ƶ꣬Ա��Ҫ��Ҫ�����ڱ��ͣ������ǵȴ��ͻ���Ҫ�������ṩ���������к�\n��Ĳ��ġ��ҷ����ں��ݺܶ�Ƶ궼����������һ�㣬�ṩ�Ķ��Ǳ�����������Ա��������ʶ����λ�ľ�����֣������ǾƵ����\n��������һ��,��������ͺܺõ�ӡ�󣬸��ˡ�������顱�ĸо���\nҪ��������������\n  ��Ҷ�֪���������Ҫ�ԣ�����ô�����÷����أ�����ΪҪ�������¼��㣺\r"
				+ "\r\n"
				+ "   1��������������������Ҫ���Ƿ���ϸ������λ��ϸ�ھ����ɰܣ����������ĸߵ�ȡ����ϸ�ڹ����ĳ̶ȣ�ֻ�н������ϸ������λ��\n���˲��ܸо�������Ĵ��ڣ���Ϊ�Ƶ��ṩ�ķ�����嶼����ͬ�ģ�ֻ��ϸ΢֮��������ʾ�������ˮƽ��ֻ�н�һ���˲�ע���С��\n���ã����ܽ��Լ��ľƵ��������Ƶ����𿪣������Ͳ�һ��ĸо�����������һ�£����������ס��һ�ҾƵ꣬һ�����������סʱ��\nǰ̨�ܹ���ס��ͻ������ֺͿͻ���ϲ�ò���������Ͱ��źã��Ǹ�����ʲô���ĸо���\r"
				+ "\r\n"
				+ "   2�����뽨������ı�׼��̡��ƶ�������ʱ������ȷ������Ļ��ڳ�������Ӷ�����>��ס��>�˷���>������������>��ס����Ҫȷ��ÿ��\n����ͳһ�Ķ��������ԡ�ʱ�䡢�þߣ���Ҫ�����������¼�����ʱҪ��Ļ��ⷽʽ�������ȡ���Щ��Ҫ�ù����ƶȵ���ʽ���ֳ�������\n��������ͳһ������������Ӷ�ʹ֮�ﵽ����������׼���������λ�淶���ͷ��������򻯡�ϵ�л���Ҫ��Ա�����������ã�"
				+ "\n   3���Ƶ�ķ����ǲ����벿��֮�以��Э����ͬ��ɵġ�Ա��Ҫ��ǿЭ��������Ҫ�����ʱ�������������Լ����ڵ��¶��ѿ�����\n����ȥ��ͬ��֮��Ӧ�������أ��Ѻ��ദ������������໥��ϣ��Ž�Э����"
				+ "\n   4�����ؾƵ�����ƶȺ͵�͵��ʹ�Ƶ꾭Ӫ����������ת��ȷ�����ʷ���ġ�"
				+ "\n   5��������һ�С���һ�С�רһ�С����ȣ�Ҫ����ڸ�λ��ѧϰ���о�����˿͵��ص㣬�ܽ������ɣ���ѧϰ����Ա���ľ��飬��\n�߷���ˮƽ����Σ�Ҫ�����ҵ��ʱ��ѧϰ������ѧϰ���۷ḻ�Լ������ҵ��ˮƽ��Ϊ�Լ�����߲�η�չ���»�����"
				+ "\n   6���Ծ�ά���Ƶ�������֪����ǧ�գ�����һʱ��Ҫ֪���Ƶ�����Ʒ\"I0-1=0\"�ĵ���Ҫͨ���Լ���һ��һ�У�һ��һ����ȥ��\n���ʹ����Ƶ���������󣬲�˵�����κζԾƵ겻���Ļ����£���������ά���Ƶ�������Ϊ���ͷ���Ļ���׼��";
		textArea.setText(str);

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1057, 609);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel() {// ���ñ���
			BufferedImage image;

			protected void paintComponent(Graphics g) {
				Image bg;
				try {
					image = ImageIO.read(new File("Image/timg1.jpg"));
					g.drawImage(image, 0, 0, null);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		};
		panel.setBounds(0, 0, 1051, 574);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("\u79D1\u5927\u9152\u5E97\u7BA1\u7406\u7CFB\u7EDF");
		lblNewLabel.setIcon(new ImageIcon(MyFrame3.class.getResource("/Image/1.png")));
		lblNewLabel.setForeground(new Color(0, 191, 255));
		lblNewLabel.setFont(new Font("����", Font.PLAIN, 15));
		lblNewLabel.setBounds(0, 0, 144, 24);
		panel.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("\u5BA2\u6237\u7BA1\u7406");
		lblNewLabel_1.setForeground(new Color(0, 191, 255));
		lblNewLabel_1.setIcon(new ImageIcon(MyFrame3.class.getResource("/Image/gukefenbu.png")));
		lblNewLabel_1.setFont(new Font("����", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(0, 59, 89, 20);
		panel.add(lblNewLabel_1);

		JLabel lblNewLabel_3 = new JLabel("\u623F\u95F4\u4FE1\u606F");
		lblNewLabel_3.setForeground(new Color(0, 191, 255));
		lblNewLabel_3.setIcon(new ImageIcon(MyFrame3.class.getResource("/Image/ico_jiudianguanli_fangjianyuyue.png")));
		lblNewLabel_3.setFont(new Font("����", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(0, 319, 89, 24);
		panel.add(lblNewLabel_3);

		JButton btnNewButton_1 = new JButton("\u6DFB\u52A0\u987E\u5BA2\u4FE1\u606F");
		btnNewButton_1.setIcon(new ImageIcon(MyFrame3.class.getResource("/Image/guke.png")));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// ��ӹ˿���Ϣ
				Addgk ad = new Addgk();
				ad.setVisible(true);
			}
		});
		btnNewButton_1.setFont(new Font("����", Font.PLAIN, 15));
		btnNewButton_1.setBounds(0, 92, 158, 27);
		panel.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("\u67E5\u8BE2\u987E\u5BA2\u4FE1\u606F");
		btnNewButton_2.setIcon(new ImageIcon(MyFrame3.class.getResource("/Image/yuangongfengcai.png")));
		btnNewButton_2.setFont(new Font("����", Font.PLAIN, 15));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// ��ѯ�˿���Ϣ
				Selectgk se = new Selectgk();
				se.setVisible(true);
			}
		});
		btnNewButton_2.setBounds(0, 173, 158, 27);
		panel.add(btnNewButton_2);

		JButton btnNewButton_3 = new JButton("\u66F4\u6539\u987E\u5BA2\u4FE1\u606F");
		btnNewButton_3.setIcon(new ImageIcon(MyFrame3.class.getResource("/Image/yuangongguanli.png")));
		btnNewButton_3.setFont(new Font("����", Font.PLAIN, 15));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// ���Ĺ˿���Ϣ
				Updategkxx up = new Updategkxx();
				up.setVisible(true);
			}
		});
		btnNewButton_3.setBounds(0, 260, 158, 27);
		panel.add(btnNewButton_3);

		JButton btnNewButton_7 = new JButton("\u67E5\u8BE2\u623F\u95F4\u4FE1\u606F");
		btnNewButton_7.setIcon(new ImageIcon(
				MyFrame3.class.getResource("/Image/ico_shujuchaxunyutongji_jiudianfangjianruzhutongji.png")));
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// ��ѯ������Ϣ
				Selectfjxx se = new Selectfjxx();
				se.setVisible(true);
			}
		});
		btnNewButton_7.setFont(new Font("����", Font.PLAIN, 15));
		btnNewButton_7.setBounds(0, 356, 158, 27);
		panel.add(btnNewButton_7);

		JButton btnNewButton_8 = new JButton("\u66F4\u6539\u623F\u95F4\u4FE1\u606F");
		btnNewButton_8.setIcon(new ImageIcon(MyFrame3.class.getResource("/Image/ico_xitongshezhi_fangjianguanli.png")));
		btnNewButton_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// ���ķ�����Ϣ
				Updatefjxx up = new Updatefjxx();
				up.setVisible(true);
			}
		});
		btnNewButton_8.setFont(new Font("����", Font.PLAIN, 15));
		btnNewButton_8.setBounds(0, 429, 158, 27);
		panel.add(btnNewButton_8);

		JButton btnNewButton_9 = new JButton("\u67E5\u8BE2\u6240\u6709\u623F\u95F4");
		btnNewButton_9.setIcon(
				new ImageIcon(MyFrame3.class.getResource("/Image/ico_shujuchaxunyutongji_fangjianweixiuchaxun.png")));
		btnNewButton_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// ��ѯ���з���
				AdministratorDAOImpl ad = new AdministratorDAOImpl();
				textArea.setText("\n���巿��|\t �����|\t����������|\t����۸�|\t������ס״̬|\t\t���䱸ע\n");
				List<Croom> list = new ArrayList<Croom>();
				list = ad.cxsyfj();
				for (Croom ce : list) {
					textArea.append(ce.toString());
				}
				result = "ʱ���ѯ���з���";
				ygtjrz(result);
			}
		});
		btnNewButton_9.setFont(new Font("����", Font.PLAIN, 15));
		btnNewButton_9.setBounds(0, 510, 158, 27);
		panel.add(btnNewButton_9);

		JLabel lblNewLabel_4 = new JLabel("\u8BA2\u5355\u4FE1\u606F");
		lblNewLabel_4.setForeground(new Color(0, 191, 255));
		lblNewLabel_4.setFont(new Font("����", Font.PLAIN, 15));
		lblNewLabel_4.setBounds(158, 3, 72, 18);
		panel.add(lblNewLabel_4);

		JButton btnNewButton_11 = new JButton("\u66F4\u6539\u8BA2\u5355\u4FE1\u606F");
		btnNewButton_11.setIcon(new ImageIcon(MyFrame3.class.getResource("/Image/dingdanguanli_1.png")));
		btnNewButton_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// ���Ķ�����Ϣ
				Updateddxx up = new Updateddxx();
				up.setVisible(true);
			}
		});
		btnNewButton_11.setFont(new Font("����", Font.PLAIN, 14));
		btnNewButton_11.setBounds(217, -1, 159, 27);
		panel.add(btnNewButton_11);

		JButton btnNewButton_12 = new JButton("\u67E5\u8BE2\u9000\u623F\u8BA2\u5355");
		btnNewButton_12.setIcon(new ImageIcon(MyFrame3.class.getResource("/Image/dingdanlan.png")));
		btnNewButton_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// ��ѯ�˷�����
				Selecttf se = new Selecttf();
				se.setVisible(true);
			}
		});
		btnNewButton_12.setFont(new Font("����", Font.PLAIN, 14));
		btnNewButton_12.setBounds(390, -1, 151, 27);
		panel.add(btnNewButton_12);

		JButton btnNewButton_13 = new JButton("\u589E\u52A0\u9000\u623F\u8BA2\u5355");
		btnNewButton_13.setIcon(new ImageIcon(MyFrame3.class.getResource("/Image/dingdanguanli_1.png")));
		btnNewButton_13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// �����˷�����
				Addtf ad = new Addtf();
				ad.setVisible(true);
			}
		});
		btnNewButton_13.setFont(new Font("����", Font.PLAIN, 14));
		btnNewButton_13.setBounds(555, -1, 150, 27);
		panel.add(btnNewButton_13);

		JButton btnNewButton_14 = new JButton("\u67E5\u8BE2\u8BA2\u5355\u4FE1\u606F");
		btnNewButton_14.setIcon(new ImageIcon(MyFrame3.class.getResource("/Image/dingdanxinxi.png")));
		btnNewButton_14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// ��ѯ������Ϣ
				Selectdd se = new Selectdd();
				se.setVisible(true);
			}
		});
		btnNewButton_14.setFont(new Font("����", Font.PLAIN, 14));
		btnNewButton_14.setBounds(719, -1, 153, 27);
		panel.add(btnNewButton_14);

		JButton btnNewButton_15 = new JButton("\u589E\u52A0\u8BA2\u5355\u4FE1\u606F");
		btnNewButton_15.setIcon(new ImageIcon(MyFrame3.class.getResource("/Image/dingdanguanli.png")));
		btnNewButton_15.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// ���Ӷ�����Ϣ
				Adddd ad = new Adddd();
				ad.setVisible(true);
			}
		});
		btnNewButton_15.setFont(new Font("����", Font.PLAIN, 14));
		btnNewButton_15.setBounds(886, -1, 153, 27);
		panel.add(btnNewButton_15);

		textArea.setBounds(158, 89, 773, 473);
		panel.add(textArea);

		JButton btnNewButton_16 = new JButton("\u8FD4\u56DE\u767B\u5F55\u83DC\u5355");
		btnNewButton_16.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// ���ص�¼�˵�
				MyFrame1 my = new MyFrame1();
				my.setVisible(true);
				dispose();
				result = "ʱ�䷵�ص�¼�˵�";
				ygtjrz(result);
			}
		});
		btnNewButton_16.setFont(new Font("����", Font.PLAIN, 11));
		btnNewButton_16.setBounds(937, 495, 102, 27);
		panel.add(btnNewButton_16);

		JButton btnNewButton_17 = new JButton("\u9000\u51FA");
		btnNewButton_17.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				result = "ʱ���˳�";
				ygtjrz(result);
				dispose();

			}
		});
		btnNewButton_17.setFont(new Font("����", Font.PLAIN, 15));
		btnNewButton_17.setBounds(937, 535, 102, 27);
		panel.add(btnNewButton_17);

		textArea_1.setBounds(181, 59, 723, 20);
		panel.add(textArea_1);

		JButton btnNewButton = new JButton("\u5458\u5DE5\u987B\u77E5");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String str1 = "\n                                       �Ƶ����е�Ա����Ҫ������������ʶ\n \n ��������Ҫ��һ�㣬��Ϊ�Ƶ��Ƿ�����ҵ�������ṩ�������������ͼ�ֵ��������ȷ���͸��Ѿ�Ӧ�õõ���������ֵ������Ӧ����\n�����ǾƵ����ʳ��ĸ���ǾƵ�����֮Դ���Ƶ�������������ر��ͣ�վ�ڱ��͵������ϣ���������룬���������裬Ϊ�����ṩһ�� .\n�ķ���"
						+ "\r\n"
						+ "  ������ķ���Ҫ������������񣬾����п��������Ƶ꣬Ա��Ҫ��Ҫ�����ڱ��ͣ������ǵȴ��ͻ���Ҫ�������ṩ���������к�\n��Ĳ��ġ��ҷ����ں��ݺܶ�Ƶ궼����������һ�㣬�ṩ�Ķ��Ǳ�����������Ա��������ʶ����λ�ľ�����֣������ǾƵ����\n��������һ��,��������ͺܺõ�ӡ�󣬸��ˡ�������顱�ĸо���\nҪ��������������\n  ��Ҷ�֪���������Ҫ�ԣ�����ô�����÷����أ�����ΪҪ�������¼��㣺\r"
						+ "\r\n"
						+ "   1��������������������Ҫ���Ƿ���ϸ������λ��ϸ�ھ����ɰܣ����������ĸߵ�ȡ����ϸ�ڹ����ĳ̶ȣ�ֻ�н������ϸ������λ��\n���˲��ܸо�������Ĵ��ڣ���Ϊ�Ƶ��ṩ�ķ�����嶼����ͬ�ģ�ֻ��ϸ΢֮��������ʾ�������ˮƽ��ֻ�н�һ���˲�ע���С��\n���ã����ܽ��Լ��ľƵ��������Ƶ����𿪣������Ͳ�һ��ĸо�����������һ�£����������ס��һ�ҾƵ꣬һ�����������סʱ��\nǰ̨�ܹ���ס��ͻ������ֺͿͻ���ϲ�ò���������Ͱ��źã��Ǹ�����ʲô���ĸо���\r"
						+ "\r\n"
						+ "   2�����뽨������ı�׼��̡��ƶ�������ʱ������ȷ������Ļ��ڳ�������Ӷ�����>��ס��>�˷���>������������>��ס����Ҫȷ��ÿ��\n����ͳһ�Ķ��������ԡ�ʱ�䡢�þߣ���Ҫ�����������¼�����ʱҪ��Ļ��ⷽʽ�������ȡ���Щ��Ҫ�ù����ƶȵ���ʽ���ֳ�������\n��������ͳһ������������Ӷ�ʹ֮�ﵽ����������׼���������λ�淶���ͷ��������򻯡�ϵ�л���Ҫ��Ա�����������ã�"
						+ "\n   3���Ƶ�ķ����ǲ����벿��֮�以��Э����ͬ��ɵġ�Ա��Ҫ��ǿЭ��������Ҫ�����ʱ�������������Լ����ڵ��¶��ѿ�����\n����ȥ��ͬ��֮��Ӧ�������أ��Ѻ��ദ������������໥��ϣ��Ž�Э����"
						+ "\n   4�����ؾƵ�����ƶȺ͵�͵��ʹ�Ƶ꾭Ӫ����������ת��ȷ�����ʷ���ġ�"
						+ "\n   5��������һ�С���һ�С�רһ�С����ȣ�Ҫ����ڸ�λ��ѧϰ���о�����˿͵��ص㣬�ܽ������ɣ���ѧϰ����Ա���ľ��飬��\n�߷���ˮƽ����Σ�Ҫ�����ҵ��ʱ��ѧϰ������ѧϰ���۷ḻ�Լ������ҵ��ˮƽ��Ϊ�Լ�����߲�η�չ���»�����"
						+ "\n   6���Ծ�ά���Ƶ�������֪����ǧ�գ�����һʱ��Ҫ֪���Ƶ�����Ʒ\"I0-1=0\"�ĵ���Ҫͨ���Լ���һ��һ�У�һ��һ����ȥ��\n���ʹ����Ƶ���������󣬲�˵�����κζԾƵ겻���Ļ����£���������ά���Ƶ�������Ϊ���ͷ���Ļ���׼��";
				textArea.setText(str1);
			}
		});
		btnNewButton.setFont(new Font("����", Font.PLAIN, 15));
		btnNewButton.setBounds(945, 276, 94, 27);
		panel.add(btnNewButton);
		setLocationRelativeTo(null);
	}

	public void ygtjrz(String result) {
		try {
			Date d1 = new Date();

			String txtname = "lib/IO����¼ϵͳ�Ĳ�����־/Ա��������־/" + ygrzname + "Ա��������־" + ".txt";
			File file = new File(txtname);
			if (!file.exists()) {
				file.createNewFile();
			}
			FileOutputStream out = new FileOutputStream(file, true);
			String str = ygrzname + "��" + d1 + result;
			out.write(str.getBytes());
			out.write("\n".getBytes());
			out.close();
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
	}
}
