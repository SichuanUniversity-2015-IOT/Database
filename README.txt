src:
	com.wp.poi  课程信息导出成excel文件
	Course.monitor   处理课程业务（删改查）
	user.monitor   处理用户（包括学生和老师）业务
	Dao  	对数据库操作的封装。
		connectionFactory-连接数据库操作
		CourseDao-对课程的数据库操作的接口
		CourseDaoImp-对接口的具体实现
		UserDao和UserDaoImp同理
	dbconfig.properties  数据库信息配置

WebRoot:
	assets  不用管它，前端页面的配置
	project：
		courseManage:前端课程代码文件夹
		userManage：前端用户代码文件夹
	WEB-INF:
		lib:自己导入的jar库
		web.xml：servlet配置文件


目前已知问题：
1. 在查询操作中，未处理查询不到数据时的情况。
2. 没有添加用户和课程的操作。
3. 课程的教师名和学院名均用的教师ID和学院ID表示，没有进行数据表的连接
4. 课程统计没有按照学院来统计，仅仅存在课程总数
5. 没有实现导出教师用户和学生用户称excel表的形式。
6. 打印页面没有打印完整信息。
7. 删改后返回页面没有是否成功提示，仅存在返回按钮。