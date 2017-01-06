数据库用户名：root 密码：root

配置文件：在/Exam-12747-20160106-1/src/main/resources文件中，dbconfig.properties为
数据库文件，applicationContext.xml为Spring配置文件，sqlMapConfig.xml为mybatis配置文件,还有mapper映射文件，与mapper文件下中的
对象名称一一对应

方案一、使用jetty启动项目，contextPath为空，访问时不用输入项目名称访问。
	1、启动项目先进入login.html欢迎页(即登录页面)，访问路径为http://localhost:8080/login.html
	
	2、进入登录页面后，输入您的用户名，如果用户名与数据库中的first_name完全匹配（比如MARY），则登录成功，
	跳转到film列表页面，您可以进入film列表了，否则登录失败，会提示您重新登陆
	
	3、进入film列表页面，您可以对film列表进行增删改查操作，列表页面进行了分页操作，您可以选择首页、尾页、下一页、上一页，或者
	在文本框输入页数（不能超过最大页数），点击回车跳转到您想要的页面）
	
	（注：(1)ajax加载数据可能较慢，所以数据显示会有延迟、（2）新增的数据在最后一页）
	
方案二、使用Tomcat启动项目，contextPath为项目名，即Exam-12747-20160106-1，你访问时的访问地址为
http://localhost:8080/Exam-12747-20170106-1/login.html
