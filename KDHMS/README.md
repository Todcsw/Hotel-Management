# Hotel-Management

(酒店管理系统)
大一下做的课程设计(酒店管理系统) java实现 桌面应用,(mysql数据库)适合大一学生学习,主要技术(日志,网络编程,多线程,IO,密码加密)

登录功能:具有找回密码和数据库密码加密功能；
注册功能:有注册用户是否存在的判断；
界面要求:页面美观、布局合理，可操作性强；
登录、注册功能外，系统的功能点不少于6个，均要有较强的容错能力；

软件：Eclipse或IDEA、MySQL

cn.hms.Client   //该包下存在MainUI.java 启动客户端项目 

cn.hms.dao      //增删改查的接口
 
cn.hms.dao.impl //增删改查的接口实现,数据库的信息在里面修改

cn.hms.entity   //实体类,存在一些不规范的实体类

cn.hms.Server   //服务端,只用于监听谁登录系统 。

cn.hms.gui      //图形化界面,采用插件生成,里面含有java逻辑判断代码,调用了impl实现的方法,有写日志的操作,加密。
三个主界面分别是 MyFrame1,MyFrame2,MyFrame3分别为主登录页面,管理员登录后页面,员工登录后页面。这个包下还存在大量的小窗口用来一些添加删除,命名为英文加中文首字母比较难懂,有耐心的可以慢慢试出来,有的里面写有注释。

运行:建议先启动cn.hms.Server(服务端下的)Servers.java主方法,再启动(cn.hms.Client)客户端下的MainUI.java主方法。
数据库连接在cn.hms.dao.impl BaseJdbcForMySQL.java 文件中,
	// 连接字符串
	private static final String URL = "jdbc:mysql://localhost:3306/hms?useunicode=true&characterEncoding=UTF-8";
	// mysql用户名
	private static final String UNAME = "root";
	// mysql 密码
	private static final String UPWD = "485226";
  这三处修改成自己的即可
  项目日志存放在:lib文件夹下

该项目适合学习,不要直接当课程设计。(一切以学习为主,可能里面内容存在纰漏)
有问题联系QQ:405786560
