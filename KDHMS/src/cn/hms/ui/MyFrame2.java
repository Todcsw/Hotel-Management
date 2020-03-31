package cn.hms.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cn.hms.dao.impl.AdministratorDAOImpl;
import cn.hms.entity.Ccustomer;
import cn.hms.entity.Cemployess;
import cn.hms.entity.Corder1;
import cn.hms.entity.Croom;

import javax.swing.JLabel;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.TextArea;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.SwingConstants;

public class MyFrame2 extends JFrame {

	private JPanel contentPane;
	public String rzname = MyFrame1.gl;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyFrame2 frame = new MyFrame2();
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
	public MyFrame2() {
		setResizable(false);
		setTitle("\u7BA1\u7406\u5458\u754C\u9762");
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setFont(new Font("楷体", Font.PLAIN, 15));
		Date d1 = new Date();
		textArea_1.setText("  欢迎" + MyFrame1.gl + "管理员" + "       ——————祝您工作愉快,身体健康" + "-" + d1);
		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("楷体", Font.PLAIN, 13));
		// 默认展示文字
		String str1 = "\n                                       酒店所有的员工都要建立起服务的意识\n \n 这是最重要的一点，因为酒店是服务行业，是以提供服务来获得利润和价值。必须明确宾客付费就应该得到“物有所值”的相应服务；\n宾客是酒店的衣食父母，是酒店生存之源，酒店必须立足于尊重宾客，站在宾客的立场上，想客人所想，急客人所需，为客人提供一流 .\n的服务。"
				+ "\r\n"
				+ "  而这里的服务要求的是主动服务，就是有客人来到酒店，员工要主要服务于宾客，而不是等待客户来要求服务才提供服务，这是有很\n大的差别的。我发现在贺州很多酒店都不能做到这一点，提供的都是被动服务，这是员工服务意识不到位的具体表现，而我们酒店如果\n能做到这一点,将会给宾客很好的印象，给人“宾至如归”的感觉。\n要提升服务质量。\n  大家都知道服务的重要性，但怎么样做好服务呢？我认为要做好以下几点：\r"
				+ "\r\n"
				+ "   1、服务质量的提升最重要的是服务细节做到位。细节决定成败！服务质量的高低取决于细节工作的程度，只有将服务的细节做到位，\n客人才能感觉到服务的存在，因为酒店提供的服务大体都是相同的，只有细微之处才能显示出管理的水平，只有将一般人不注意的小事\n做好，才能将自己的酒店与其它酒店区别开，给宾客不一般的感觉。可以想像一下，如果宾客入住过一家酒店，一年后再来的入住时候\n前台能够记住这客户的名字和客户的喜好并主动帮宾客安排好，那给宾客什么样的感觉！\r"
				+ "\r\n"
				+ "   2、必须建立服务的标准规程。制定服务规程时，首先确定服务的环节程序，例如从订房—>入住—>退房—>房间卫生清理—>入住，都要确定每个\n环节统一的动作、语言、时间、用具，还要包括对意外事件、临时要求的化解方式、方法等。这些都要用规章制度的形式表现出来。用\n服务规程来统一各项服务工作，从而使之达到服务质量标准化、服务岗位规范化和服务工作程序化、系列化。要求员工做到，做好！"
				+ "\n   3、酒店的服务是部门与部门之间互相协作共同完成的。员工要加强协作，客人要求服务时，不能因不属于自己份内的事而把客人推\n来推去。同事之间应互相尊重，友好相处，互相帮助，相互配合，团结协作。"
				+ "\n   4、遵守酒店规章制度和店纪店规使酒店经营得以正常运转，确保优质服务的。"
				+ "\n   5、做到爱一行、干一行、专一行。首先，要坚持在岗位上学习，研究各类顾客的特点，总结服务规律，并学习其他员工的经验，提\n高服务水平。其次，要坚持在业余时间学习，不断学习理论丰富自己，提高业务水平。为自己向更高层次发展打下基础。"
				+ "\n   6、自觉维护酒店形象，须知树誉千日，毁誉一时，要知道酒店服务产品\"I0-1=0\"的道理。要通过自己的一言一行，一举一动，去树\n立和传播酒店的良好形象，不说不做任何对酒店不利的话和事，把树立和维护酒店形象当作为宾客服务的基本准则。";
		textArea.setText(str1);

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1057, 609);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel() {// 设置背景
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
		lblNewLabel.setForeground(new Color(0, 191, 255));
		lblNewLabel.setIcon(new ImageIcon(MyFrame2.class.getResource("/Image/1.png")));
		lblNewLabel.setFont(new Font("楷体", Font.PLAIN, 15));
		lblNewLabel.setBounds(0, 0, 144, 24);
		panel.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("\u5BA2\u6237\u7BA1\u7406");
		lblNewLabel_1.setIcon(new ImageIcon(
				MyFrame2.class.getResource("/Image/ico_shujuchaxunyutongji_fangjianfujiazhuangtaichaxun.png")));
		lblNewLabel_1.setForeground(new Color(0, 191, 255));
		lblNewLabel_1.setFont(new Font("楷体", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(0, 59, 96, 20);
		panel.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("\u5165\u4F4F\u548C\u5BA2\u623F\u7BA1\u7406");
		lblNewLabel_2.setIcon(new ImageIcon(MyFrame2.class.getResource("/Image/ico_xitongshezhi_fangjianguanli.png")));
		lblNewLabel_2.setForeground(new Color(0, 191, 255));
		lblNewLabel_2.setFont(new Font("楷体", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(0, 132, 144, 24);
		panel.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("\u5458\u5DE5\u7BA1\u7406");
		lblNewLabel_3.setIcon(new ImageIcon(MyFrame2.class.getResource("/Image/yuangongguanli.png")));
		lblNewLabel_3.setForeground(new Color(0, 191, 255));
		lblNewLabel_3.setFont(new Font("楷体", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(0, 357, 96, 24);
		panel.add(lblNewLabel_3);

		JButton btnNewButton = new JButton("\u67E5\u8BE2\u6240\u6709\u987E\u5BA2");
		btnNewButton.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton.setIcon(new ImageIcon(
				MyFrame2.class.getResource("/Image/ico_shujuchaxunyutongji_fangjianfujiazhuangtaichaxun.png")));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 查询所有顾客
				AdministratorDAOImpl ad = new AdministratorDAOImpl();
				textArea.setText(
						"\n客人ID|      房间编号| 姓名|性别| 身份证号|\t电话|\t   押金|  入住时间|   到点时间|   房间价格|    操作员|\n");
				List<Ccustomer> list = new ArrayList<Ccustomer>();
				list = ad.cxsygk();
				for (Ccustomer ce : list) {
					textArea.append(ce.toString());
				}
				try {
					String txtname = "lib/IO流记录系统的操作日志/管理员操作日志/" + rzname + "管理员操作日志" + ".txt";
					File file = new File(txtname);
					if (!file.exists()) {
						file.createNewFile();
					}
					FileOutputStream out = new FileOutputStream(file, true);
					String str = rzname + "在" + d1 + "时间查询所有顾客";
					out.write(str.getBytes());
					out.write("\n".getBytes());
					out.close();
				} catch (IOException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
			}
		});
		btnNewButton.setFont(new Font("楷体", Font.PLAIN, 15));
		btnNewButton.setBounds(0, 95, 157, 27);
		panel.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("\u589E\u52A0\u623F\u95F4\u7C7B\u578B");
		btnNewButton_1.setIcon(
				new ImageIcon(MyFrame2.class.getResource("/Image/ico_shujuchaxunyutongji_fangjianweixiuchaxun.png")));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 增加房间类型
				Addfjlx ad = new Addfjlx();
				ad.setVisible(true);

			}
		});
		btnNewButton_1.setFont(new Font("楷体", Font.PLAIN, 15));
		btnNewButton_1.setBounds(0, 163, 157, 27);
		panel.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("\u5220\u9664\u623F\u95F4\u7C7B\u578B");
		btnNewButton_2.setIcon(new ImageIcon(MyFrame2.class.getResource("/Image/ico_xitongshezhi_fangjianguanli.png")));
		btnNewButton_2.setFont(new Font("楷体", Font.PLAIN, 15));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 删除房间类型
				Delfjlx de = new Delfjlx();
				de.setVisible(true);

			}
		});
		btnNewButton_2.setBounds(0, 203, 157, 27);
		panel.add(btnNewButton_2);

		JButton btnNewButton_3 = new JButton("\u66F4\u6539\u623F\u95F4\u7C7B\u578B");
		btnNewButton_3.setIcon(new ImageIcon(MyFrame2.class.getResource("/Image/ico_xitongshezhi_fangjianguanli.png")));
		btnNewButton_3.setFont(new Font("楷体", Font.PLAIN, 15));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 更改房间类型
				Updatefjlx up = new Updatefjlx();
				up.setVisible(true);

			}
		});
		btnNewButton_3.setBounds(0, 243, 157, 27);
		panel.add(btnNewButton_3);

		JButton btnNewButton_4 = new JButton("\u67E5\u8BE2\u623F\u95F4\u7C7B\u578B");
		btnNewButton_4.setIcon(new ImageIcon(MyFrame2.class.getResource("/Image/ico_jiudianguanli_fangjianyuyue.png")));
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 查询房间类型
				Selectfjlx se = new Selectfjlx();
				se.setVisible(true);

			}
		});
		btnNewButton_4.setFont(new Font("楷体", Font.PLAIN, 15));
		btnNewButton_4.setBounds(0, 283, 157, 27);
		panel.add(btnNewButton_4);

		JButton btnNewButton_5 = new JButton("\u67E5\u8BE2\u6240\u6709\u623F\u95F4");
		btnNewButton_5.setIcon(new ImageIcon(
				MyFrame2.class.getResource("/Image/ico_shujuchaxunyutongji_jiudianfangjianruzhutongji.png")));
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 查询所有房间
				AdministratorDAOImpl ad = new AdministratorDAOImpl();
				textArea.setText("\n房间|\t房间号|\t房间类型名|\t房间价格|\t房间入住状态|\t\t房间备注\n");
				List<Croom> list = new ArrayList<Croom>();
				list = ad.cxsyfj();
				for (Croom ce : list) {
					textArea.append(ce.toString());
				}
				try {
					String txtname = "lib/IO流记录系统的操作日志/管理员操作日志/" + rzname + "管理员操作日志" + ".txt";
					File file = new File(txtname);
					if (!file.exists()) {
						file.createNewFile();
					}
					FileOutputStream out = new FileOutputStream(file, true);
					String str = rzname + "在" + d1 + "时间查询所有房间";
					out.write(str.getBytes());
					out.write("\n".getBytes());
					out.close();
				} catch (IOException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
			}
		});
		btnNewButton_5.setFont(new Font("楷体", Font.PLAIN, 15));
		btnNewButton_5.setBounds(0, 323, 157, 27);
		panel.add(btnNewButton_5);

		JButton btnNewButton_6 = new JButton("\u67E5\u770B\u6240\u6709\u5458\u5DE5");
		btnNewButton_6.setIcon(new ImageIcon(MyFrame2.class.getResource("/Image/yuangongfengcai.png")));
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 查看所有员工
				AdministratorDAOImpl ad = new AdministratorDAOImpl();
				textArea.setText("\n员工ID|员工姓名|员工密码|\t员工性别|\t员工身份证号|\t\t员工薪水\n");
				List<Cemployess> list = new ArrayList<Cemployess>();
				list = ad.cxsyyg();
				for (Cemployess ce : list) {
					textArea.append(ce.toString());
				}
				try {
					String txtname = "lib/IO流记录系统的操作日志/管理员操作日志/" + rzname + "管理员操作日志" + ".txt";
					File file = new File(txtname);
					if (!file.exists()) {
						file.createNewFile();
					}
					FileOutputStream out = new FileOutputStream(file, true);
					String str = rzname + "在" + d1 + "时间查询所有员工";
					out.write(str.getBytes());
					out.write("\n".getBytes());
					out.close();
				} catch (IOException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
			}
		});
		btnNewButton_6.setFont(new Font("楷体", Font.PLAIN, 15));
		btnNewButton_6.setBounds(0, 387, 157, 27);
		panel.add(btnNewButton_6);

		JButton btnNewButton_7 = new JButton("\u6DFB\u52A0\u5458\u5DE5\u4FE1\u606F");
		btnNewButton_7.setIcon(new ImageIcon(MyFrame2.class.getResource("/Image/yuangongzipingliucheng.png")));
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 添加员工信息
				Addyg ad = new Addyg();
				ad.setVisible(true);

			}
		});
		btnNewButton_7.setFont(new Font("楷体", Font.PLAIN, 15));
		btnNewButton_7.setBounds(0, 427, 157, 27);
		panel.add(btnNewButton_7);

		JButton btnNewButton_8 = new JButton("\u5220\u9664\u5458\u5DE5\u4FE1\u606F");
		btnNewButton_8.setIcon(new ImageIcon(MyFrame2.class.getResource("/Image/yuangong.png")));
		btnNewButton_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 删除员工信息
				Delyg de = new Delyg();
				de.setVisible(true);

			}
		});
		btnNewButton_8.setFont(new Font("楷体", Font.PLAIN, 15));
		btnNewButton_8.setBounds(0, 467, 157, 27);
		panel.add(btnNewButton_8);

		JButton btnNewButton_9 = new JButton("\u66F4\u6539\u5458\u5DE5\u4FE1\u606F");
		btnNewButton_9.setIcon(new ImageIcon(MyFrame2.class.getResource("/Image/yuangongguanli.png")));
		btnNewButton_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 更改员工信息
				Updateyg up = new Updateyg();
				up.setVisible(true);

			}
		});
		btnNewButton_9.setFont(new Font("楷体", Font.PLAIN, 15));
		btnNewButton_9.setBounds(0, 502, 157, 27);
		panel.add(btnNewButton_9);

		JButton btnNewButton_10 = new JButton("\u67E5\u8BE2\u5458\u5DE5\u4FE1\u606F");
		btnNewButton_10.setIcon(new ImageIcon(MyFrame2.class.getResource("/Image/yuangongguanli_h.png")));
		btnNewButton_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 查询员工信息
				Selectyg se = new Selectyg();
				se.setVisible(true);

			}
		});
		btnNewButton_10.setFont(new Font("楷体", Font.PLAIN, 15));
		btnNewButton_10.setBounds(0, 535, 157, 27);
		panel.add(btnNewButton_10);

		JLabel lblNewLabel_4 = new JLabel("\u8BA2\u5355\u4FE1\u606F");
		lblNewLabel_4.setForeground(new Color(0, 191, 255));
		lblNewLabel_4.setFont(new Font("楷体", Font.PLAIN, 15));
		lblNewLabel_4.setBounds(158, 3, 72, 18);
		panel.add(lblNewLabel_4);

		JButton btnNewButton_11 = new JButton("\u67E5\u8BE2\u6240\u6709\u8BA2\u5355");
		btnNewButton_11.setIcon(new ImageIcon(MyFrame2.class.getResource("/Image/dingdan.png")));
		btnNewButton_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 查询所有订单
				AdministratorDAOImpl ad = new AdministratorDAOImpl();
				textArea.setText("\n  订单|\t订单ID|\t              顾客ID|\t            下单时间|\t         离店时间|\t     房间状态\n");
				List<Corder1> list = new ArrayList<Corder1>();
				list = ad.cxsydd();
				for (Corder1 ce : list) {
					textArea.append(ce.toString());
				}
				try {
					String txtname = "lib/IO流记录系统的操作日志/管理员操作日志/" + rzname + "管理员操作日志" + ".txt";
					File file = new File(txtname);
					if (!file.exists()) {
						file.createNewFile();
					}
					FileOutputStream out = new FileOutputStream(file, true);
					String str = rzname + "在" + d1 + "时间查询所有订单";
					out.write(str.getBytes());
					out.write("\n".getBytes());
					out.close();
				} catch (IOException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
			}
		});
		btnNewButton_11.setFont(new Font("楷体", Font.PLAIN, 14));
		btnNewButton_11.setBounds(218, -1, 157, 27);
		panel.add(btnNewButton_11);

		JButton btnNewButton_12 = new JButton("\u67E5\u8BE2\u9000\u623F\u8BA2\u5355");
		btnNewButton_12.setIcon(new ImageIcon(MyFrame2.class.getResource("/Image/dingdanxinxi.png")));
		btnNewButton_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 查询退房订单
				Selecttf se = new Selecttf();
				se.setVisible(true);

			}
		});
		btnNewButton_12.setFont(new Font("楷体", Font.PLAIN, 14));
		btnNewButton_12.setBounds(389, -1, 153, 27);
		panel.add(btnNewButton_12);

		JButton btnNewButton_13 = new JButton("\u589E\u52A0\u9000\u623F\u8BA2\u5355");
		btnNewButton_13.setIcon(new ImageIcon(MyFrame2.class.getResource("/Image/dingdanlan.png")));
		btnNewButton_13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 增加退房订单
				Addtf ad = new Addtf();
				ad.setVisible(true);

			}
		});
		btnNewButton_13.setFont(new Font("楷体", Font.PLAIN, 14));
		btnNewButton_13.setBounds(556, -1, 153, 27);
		panel.add(btnNewButton_13);

		JButton btnNewButton_14 = new JButton("\u67E5\u8BE2\u8BA2\u5355\u4FE1\u606F");
		btnNewButton_14.setIcon(new ImageIcon(MyFrame2.class.getResource("/Image/dingdan_1.png")));
		btnNewButton_14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 查询订单信息
				Selectdd se = new Selectdd();
				se.setVisible(true);

			}
		});
		btnNewButton_14.setFont(new Font("楷体", Font.PLAIN, 14));
		btnNewButton_14.setBounds(716, -1, 157, 27);
		panel.add(btnNewButton_14);

		JButton btnNewButton_15 = new JButton("\u589E\u52A0\u8BA2\u5355\u4FE1\u606F");
		btnNewButton_15.setIcon(new ImageIcon(MyFrame2.class.getResource("/Image/dingdanguanli_1.png")));
		btnNewButton_15.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 增加订单信息
				Adddd ad = new Adddd();
				ad.setVisible(true);

			}
		});
		btnNewButton_15.setFont(new Font("楷体", Font.PLAIN, 14));
		btnNewButton_15.setBounds(882, -1, 157, 27);
		panel.add(btnNewButton_15);

		textArea.setBounds(163, 95, 773, 467);
		panel.add(textArea);

		JButton btnNewButton_16 = new JButton("\u8FD4\u56DE\u767B\u5F55\u83DC\u5355");
		btnNewButton_16.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 返回登录菜单
				MyFrame1 my = new MyFrame1();
				my.setVisible(true);
				dispose();
				try {
					String txtname = "lib/IO流记录系统的操作日志/管理员操作日志/" + rzname + "管理员操作日志" + ".txt";
					File file = new File(txtname);
					if (!file.exists()) {
						file.createNewFile();
					}
					FileOutputStream out = new FileOutputStream(file, true);
					String str = rzname + "在" + d1 + "时间返回登录菜单";
					out.write(str.getBytes());
					out.write("\n".getBytes());
					out.close();
				} catch (IOException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
			}
		});
		btnNewButton_16.setFont(new Font("楷体", Font.PLAIN, 11));
		btnNewButton_16.setBounds(937, 495, 102, 27);
		panel.add(btnNewButton_16);

		JButton btnNewButton_17 = new JButton("\u9000\u51FA");
		btnNewButton_17.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 退出
				dispose();
				try {
					String txtname = "lib/IO流记录系统的操作日志/管理员操作日志/" + rzname + "管理员操作日志" + ".txt";
					File file = new File(txtname);
					if (!file.exists()) {
						file.createNewFile();
					}
					FileOutputStream out = new FileOutputStream(file, true);
					String str = rzname + "在" + d1 + "时间退出";
					out.write(str.getBytes());
					out.write("\n".getBytes());
					out.close();
				} catch (IOException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
			}
		});
		btnNewButton_17.setFont(new Font("楷体", Font.PLAIN, 15));
		btnNewButton_17.setBounds(937, 535, 102, 27);
		panel.add(btnNewButton_17);

		textArea_1.setBounds(181, 59, 723, 20);
		panel.add(textArea_1);

		JButton btnNewButton_18 = new JButton("\u7BA1\u7406\u987B\u77E5");
		btnNewButton_18.setFont(new Font("楷体", Font.PLAIN, 15));
		btnNewButton_18.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String str1 = "\n                                       酒店所有的员工都要建立起服务的意识\n \n 这是最重要的一点，因为酒店是服务行业，是以提供服务来获得利润和价值。必须明确宾客付费就应该得到“物有所值”的相应服务；\n宾客是酒店的衣食父母，是酒店生存之源，酒店必须立足于尊重宾客，站在宾客的立场上，想客人所想，急客人所需，为客人提供一流 .\n的服务。"
						+ "\r\n"
						+ "  而这里的服务要求的是主动服务，就是有客人来到酒店，员工要主要服务于宾客，而不是等待客户来要求服务才提供服务，这是有很\n大的差别的。我发现在贺州很多酒店都不能做到这一点，提供的都是被动服务，这是员工服务意识不到位的具体表现，而我们酒店如果\n能做到这一点,将会给宾客很好的印象，给人“宾至如归”的感觉。\n要提升服务质量。\n  大家都知道服务的重要性，但怎么样做好服务呢？我认为要做好以下几点：\r"
						+ "\r\n"
						+ "   1、服务质量的提升最重要的是服务细节做到位。细节决定成败！服务质量的高低取决于细节工作的程度，只有将服务的细节做到位，\n客人才能感觉到服务的存在，因为酒店提供的服务大体都是相同的，只有细微之处才能显示出管理的水平，只有将一般人不注意的小事\n做好，才能将自己的酒店与其它酒店区别开，给宾客不一般的感觉。可以想像一下，如果宾客入住过一家酒店，一年后再来的入住时候\n前台能够记住这客户的名字和客户的喜好并主动帮宾客安排好，那给宾客什么样的感觉！\r"
						+ "\r\n"
						+ "   2、必须建立服务的标准规程。制定服务规程时，首先确定服务的环节程序，例如从订房—>入住—>退房—>房间卫生清理—>入住，都要确定每个\n环节统一的动作、语言、时间、用具，还要包括对意外事件、临时要求的化解方式、方法等。这些都要用规章制度的形式表现出来。用\n服务规程来统一各项服务工作，从而使之达到服务质量标准化、服务岗位规范化和服务工作程序化、系列化。要求员工做到，做好！"
						+ "\n   3、酒店的服务是部门与部门之间互相协作共同完成的。员工要加强协作，客人要求服务时，不能因不属于自己份内的事而把客人推\n来推去。同事之间应互相尊重，友好相处，互相帮助，相互配合，团结协作。"
						+ "\n   4、遵守酒店规章制度和店纪店规使酒店经营得以正常运转，确保优质服务的。"
						+ "\n   5、做到爱一行、干一行、专一行。首先，要坚持在岗位上学习，研究各类顾客的特点，总结服务规律，并学习其他员工的经验，提\n高服务水平。其次，要坚持在业余时间学习，不断学习理论丰富自己，提高业务水平。为自己向更高层次发展打下基础。"
						+ "\n   6、自觉维护酒店形象，须知树誉千日，毁誉一时，要知道酒店服务产品\"I0-1=0\"的道理。要通过自己的一言一行，一举一动，去树\n立和传播酒店的良好形象，不说不做任何对酒店不利的话和事，把树立和维护酒店形象当作为宾客服务的基本准则。";
				textArea.setText(str1);
			}
		});
		btnNewButton_18.setBounds(937, 295, 102, 27);
		panel.add(btnNewButton_18);
		setLocationRelativeTo(null);
	}
}
