# ssm-BookAppointment<br>
优雅整合SSM框架：SpringMVC + Spring + MyBatis（用户登陆式图书预约系统）<br>
小伙伴们开车了！<br>
 话不多说先让我们看看此项目运行起来的效果，方便大家有个直观了解，好在事先估计要用到那些技术，方便大家有针对性的学习。<br>
看图！<br>
这是图书管理系统的首页，不用登陆即可查看、搜索系统有已有图书。<br>
![image](https://github.com/nize1989/pic/blob/master/raw/1.png)
搜索想要预定的书：<br>
![image](https://github.com/nize1989/pic/blob/master/raw/2.png)
点击详情，进入预定页面，如果没有登陆的话会弹出登陆层，提示输入学号密码，如果用户已经在之前查看某本书的详细时已经登陆，则不会要求再登陆，这里的用户名密码与数据库验证成功后保存在cookie中，且生命周期默认与session相同，即关闭路径窗口后就失效。<br>
![image](https://github.com/nize1989/pic/blob/master/raw/3.png)
这是什么都不输入和输入格式不对时，点击submit的提示：<br>
![image](https://github.com/nize1989/pic/blob/master/raw/4.png)
![image](https://github.com/nize1989/pic/blob/master/raw/5.png)
![image](https://github.com/nize1989/pic/blob/master/raw/6.png)
登陆后进入预约界面，点击预约后的界面：<br>
![image](https://github.com/nize1989/pic/blob/master/raw/7.png)
如果已经对当前书预约过，点击预约会提示重复预约，如果没有库存，点击预约会提示没有库存。<br>
![image](https://github.com/nize1989/pic/blob/master/raw/8.png)
预约后点击：查看我的已预约书籍，会显示之前所有预约的信息：<br>
![image](https://github.com/nize1989/pic/blob/master/raw/9.png)
## 1、利用maven创建文件路径：<br>
利用命令行工具输入：mvn archetype:generate -DgroupId=cn.nize  -DarchetypeArtifactId=
maven-archetype-webapp  -DarchetypeCatalog=internal<br>
## 2、创建项目包： <br>
![image](https://github.com/nize1989/pic/blob/master/raw/11.png)
## 3、再然后就是在pom.xml里面注入依赖，maven会自动在网站上下载。关于maven大家可以看看慕课网上的教学视频。 
pom.xml
```java
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
  xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/maven-v4_0_0.xsd">
  <modelVersion>4.0.0</modelVersion>
  <groupId>cn.nize</groupId>
  <artifactId>ssm-BookAppointment</artifactId>
  <version>1.0-SNAPSHOT</version>
  <name>ssm-BookAppointment Maven Webapp</name>
  <url>http://maven.apache.org</url>
  
	<dependencies>
		<!-- 单元测试 -->
		<dependency>
			<groupId>junit</groupId>
			<artifactId>junit</artifactId>
			<version>4.11</version>
		</dependency>

		<!-- 1.日志 -->
		<!-- 实现slf4j接口并整合 -->
		<dependency>
			<groupId>ch.qos.logback</groupId>
			<artifactId>logback-classic</artifactId>
			<version>1.1.1</version>
		</dependency>

		<!-- 2.数据库 -->
		<dependency>
			<groupId>mysql</groupId>
			<artifactId>mysql-connector-java</artifactId>
			<version>5.1.35</version>
			<!--  <scope>runtime</scope> -->
		</dependency>
		<dependency>
			<groupId>c3p0</groupId>
			<artifactId>c3p0</artifactId>
			<version>0.9.1.2</version>
		</dependency>

		<!-- DAO: MyBatis -->
		<dependency>
			<groupId>org.mybatis</groupId>
			<artifactId>mybatis</artifactId>
			<version>3.3.0</version>
		</dependency>
		<dependency>
			<groupId>org.mybatis</groupId>
			<artifactId>mybatis-spring</artifactId>
			<version>1.2.3</version>
		</dependency>

		<!-- 3.Servlet web -->
		<dependency>
			<groupId>taglibs</groupId>
			<artifactId>standard</artifactId>
			<version>1.1.2</version>
		</dependency>
		<dependency>
			<groupId>jstl</groupId>
			<artifactId>jstl</artifactId>
			<version>1.2</version>
		</dependency>
		<dependency>
    		<groupId>com.fasterxml.jackson.core</groupId>
    		<artifactId>jackson-databind</artifactId>
    		<version>2.5.0</version>
		</dependency>
		<dependency>
    		<groupId>com.fasterxml.jackson.core</groupId>
    		<artifactId>jackson-core</artifactId>
    		<version>2.5.0</version>
		</dependency>
		<dependency>
    		<groupId>com.fasterxml.jackson.core</groupId>
    		<artifactId>jackson-annotations</artifactId>
    		<version>2.5.0</version>
		</dependency>
	<!-- 	<dependency>
			<groupId>com.fasterxml.jackson.core</groupId>
			<artifactId>jackson-databind</artifactId>
			<version>2.5.4</version>
		</dependency> -->
		<dependency>
			<groupId>javax.servlet</groupId>
			<artifactId>javax.servlet-api</artifactId>
			<version>3.1.0</version>
		</dependency>

		<!-- 4.Spring -->
		<!-- 1)Spring核心 -->
		<dependency>
			<groupId>org.springframework</groupId>
			<artifactId>spring-core</artifactId>
			<version>4.1.7.RELEASE</version>
		</dependency>
		<dependency>
			<groupId>org.springframework</groupId>
			<artifactId>spring-beans</artifactId>
			<version>4.1.7.RELEASE</version>
		</dependency>
		<dependency>
			<groupId>org.springframework</groupId>
			<artifactId>spring-context</artifactId>
			<version>4.1.7.RELEASE</version>
		</dependency>
		<!-- 2)Spring DAO层 -->
		<dependency>
			<groupId>org.springframework</groupId>
			<artifactId>spring-jdbc</artifactId>
			<version>4.1.7.RELEASE</version>
		</dependency>
		<dependency>
			<groupId>org.springframework</groupId>
			<artifactId>spring-tx</artifactId>
			<version>4.1.7.RELEASE</version>
		</dependency>
		<!-- 3)Spring web -->
		<dependency>
			<groupId>org.springframework</groupId>
			<artifactId>spring-web</artifactId>
			<version>4.1.7.RELEASE</version>
		</dependency>
		<dependency>
			<groupId>org.springframework</groupId>
			<artifactId>spring-webmvc</artifactId>
			<version>4.1.7.RELEASE</version>
		</dependency>
		<!-- 4)Spring test -->
		<dependency>
			<groupId>org.springframework</groupId>
			<artifactId>spring-test</artifactId>
			<version>4.1.7.RELEASE</version>
		</dependency>

		<!-- redis客户端:Jedis -->
		<dependency>
			<groupId>redis.clients</groupId>
			<artifactId>jedis</artifactId>
			<version>2.7.3</version>
		</dependency>
		<dependency>
			<groupId>com.dyuproject.protostuff</groupId>
			<artifactId>protostuff-core</artifactId>
			<version>1.0.8</version>
		</dependency>
		<dependency>
			<groupId>com.dyuproject.protostuff</groupId>
			<artifactId>protostuff-runtime</artifactId>
			<version>1.0.8</version>
		</dependency>

		<!-- Map工具类 -->
		<dependency>
			<groupId>commons-collections</groupId>
			<artifactId>commons-collections</artifactId>
			<version>3.2</version>
		</dependency>
	</dependencies>
 
  <build>
    <finalName>ssm-BookAppointment</finalName>
  </build>
</project>
```
## 4、做好之前的准备工作后，逻辑理顺，现在就要开始编码啦，首先我们创建数据库！<br> 
根据我们的实际情况，在数据库中创建表：<br>
schema.sql
```java
-- 创建图书表
CREATE TABLE `book` ( 
  `book_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '图书ID',
  `name` varchar(100) NOT NULL COMMENT '图书名称',
  `introd` varchar(1000) NOT NULL COMMENT '简介',
  `number` int(11) NOT NULL COMMENT '馆藏数量',
  PRIMARY KEY (`book_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8 COMMENT='图书表';

-- 初始化图书数据
INSERT INTO `book` (`book_id`, `name`, `introd`,`number`)
VALUES
	(1000, 'Java程序设计', 'Java程序设计是一门balbal',10),
	(1001, '数据结构','数据结构是计算机存储、组织数据的方式。数据结构是指相互之间存在一种或多种特定关系的数据元素的集合。', 10),
	(1002, '设计模式','设计模式（Design Pattern）是一套被反复使用、多数人知晓的、经过分类的、代码设计经验的总结。',10),
	(1003, '编译原理','编译原理是计算机专业的一门重要专业课，旨在介绍编译程序构造的一般原理和基本方法。',10),
	(1004,'大学语文','基于长期的教学实践和学科思考，我们编写了这本《大学语文》教材balbal',10),
	(1005,'计算方法','计算方法又称“数值分析”。是为各种数学问题的数值解答研究提供最有效的算法。',10),
	(1006,'高等数学','广义地说，初等数学之外的数学都是高等数学，也有将中学较深入的代数、几何以及简单的集合论初步balbal',10);

-- 创建预约图书表
CREATE TABLE `appointment` (
  `book_id` bigint(20) NOT NULL COMMENT '图书ID',
  `student_id` bigint(20) NOT NULL COMMENT '学号',
  `appoint_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '预约时间' ,
  PRIMARY KEY (`book_id`, `student_id`),
  INDEX `idx_appoint_time` (`appoint_time`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='预约图书表';
-- 创建学生数据表
CREATE TABLE `student`(
	`student_id` bigint(20) NOT NULL COMMENT '学生ID',
	`password`  bigint(20) NOT NULL COMMENT '密码',
	PRIMARY KEY(`student_id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='学生统计表';	
-- 初始化学生数据
INSERT INTO `student`(`student_id`,`password`) 
VALUES
	(3211200801,346543),
	(3211200802,754323),
	(3211200803,674554),
	(3211200804,542344),
	(3211200805,298383),
	(3211200806,873973),
	(3211200807,193737),
	(3211200808,873092);
	
```
## 5 根据数据库对象创建实体类。<br>
第一个开始填充的类当然是entiy包，他是承接我们从数据库里去除数据的类，或者把该类存入数据库，在这里我们创建两个类，一个是Book包（从数据库取出书后放入该包），一个是Appointment（存放从数据库取出的预约书籍信息）。<br>
Book.java
```java
package com.imooc.appoint.entiy;

public class Book {
	
	private long bookId;//图书ID
	private String name;//图书名称
	private int number;//馆藏数量 
	private String introd;
	public Book() {  //为什么要有个无参构造器
	}
	public Book(long bookId, String name, int number) { 
		this.bookId = bookId;
		this.name = name;
		this.number = number;
	}
	public long getBookId() {
		return bookId;
	}
	public void setBookId(long bookId) {
		this.bookId = bookId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getIntrod() {
		return introd;
	}
	public void setIntrod(String introd) {
		this.introd = introd;
	}

	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", name=" + name + ", number=" + number + ", introd=" + introd + "]";
	}
}
```
Appointment.java
```java
package com.imooc.appoint.entiy;

import java.util.Date; 

public class Appointment {
	private long bookId;
	private long studentId;
	private Date appointTime;
	// 多对一的复合属性
	private Book book;// 图书实体
	public Appointment(){
	}
	public Appointment(long bookId, long studentId, Date appointTime) { 
		this.bookId = bookId;
		this.studentId = studentId;
		this.appointTime = appointTime;
	}
	public long getBookId() {
		return bookId;
	}
	public void setBookId(long bookId) {
		this.bookId = bookId;
	}
	public long getStudentId() {
		return studentId;
	}
	public void setStudentId(long studentId) {
		this.studentId = studentId;
	}
	public Date getAppointTime() {
		return appointTime;
	}
	public void setAppointTime(Date appointTime) {
		this.appointTime = appointTime;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	@Override
	public String toString() {
		return "Appointment [bookId=" + bookId + ", studentId=" + studentId + ", appointTime=" + appointTime + ", book="
				+ book + "]";
	}
}
```
因为我们还打算做一个学生ID、密码验证，所以也得有学生类.<br>
Student.java
```java
package com.imooc.appoint.entiy;

public class Student {  
	private Long studentId;
	private Long password;
	
	public Student(){
		
	}
	public Student(Long studentId,Long password){
		this.studentId=studentId;
		this.password=password;
	}
	public Long getStudentId() {
		return studentId;
	}
	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}
	public Long getPassword() {
		return password;
	}
	public void setPassword(Long password) {
		this.password = password;
	}
	
	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", password=" + password + "]";
	}
}

```
## 6创建DAO中的类<br>
DAO包中的类主要功能是实现与数据库交互，所以我们需要大的逻辑是：1、学生类与数据库交互；2、预约是与数据库交互；3、查询书时与时与数据库交互。这里大致分为几类，等具体写接口时再去细写。还有就是注意，DAO只是与数据库交互，不能写交互组成的逻辑，这个放在service里面。我们应该站在用户的角度设计DAO接口，至于具体怎么用，后面再写。<br>
BookDao.java
```java
package com.imooc.appoint.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.imooc.appoint.entiy.Book;

public interface BookDao {
	/*
	 * 根据id查询书
	 * 
	 */
	Book queryById(long id);
	List<Book> querySome(String name);
	List<Book> queryAll(@Param("offset") int offset,@Param("limit") int limit);
	
	/*减少管存数量
	 * 用返回值可判断当前库存是否还有书
	 */
	 int reduceNumber(long bookId);
}


```
AppointmentDao.java
```java
package com.imooc.appoint.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.imooc.appoint.entiy.Appointment; 

public interface AppointmentDao {
	//通过图书ID和学生ID预约书籍，并插入
	int insertAppointment(@Param("bookId") long bookId, @Param("studentId") long studentId);
	 
	//通过一个学生ID查询已经预约了哪些书。
	List<Appointment> quaryAndReturn(long studentId);
 
}

```
StudentDao.java
```java
package com.imooc.appoint.dao;

import org.apache.ibatis.annotations.Param;

import com.imooc.appoint.entiy.Student;

public interface StudentDao {
	/**
	 * 向数据库验证输入的密码是否正确
	 */
	Student quaryStudent(@Param("studentId") long studentId, @Param("password") long password);
}

```
## 7我们暂时先不管以上接口实现，先为DAO配置入框架，实现spring与mybatis的整合。<br>
 因为spring的配置太多，我们这里分三层，分别是dao service web。我们这里先写spring-dao.xml，其他的等我们实现相应包后再去配置。
 配置时，主要注意一下几个方面：<br>
1、读入数据库连接相关参数（可选）<br>
2、配置数据连接池<br>
3、配置连接属性，可以不读配置项文件直接在这里写死<br>
4、配置c3p0，只配了几个常用的<br>
5、配置SqlSessionFactory对象（mybatis）<br>
6、扫描dao层接口，动态实现dao接口，也就是说不需要daoImpl，sql和参数都写在xml文件上<br>
spring-dao.xml
```java
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:context="http://www.springframework.org/schema/context"
	xsi:schemaLocation="http://www.springframework.org/schema/beans
	http://www.springframework.org/schema/beans/spring-beans.xsd
	http://www.springframework.org/schema/context
	http://www.springframework.org/schema/context/spring-context.xsd">
			<!-- 配置整合mybatis过程 -->
	<!-- 1.配置数据库相关参数   properties的属性：${url} -->
	<context:property-placeholder location="classpath:jdbc.properties" />

	<!-- 2.数据库连接池 -->
	<bean id="dataSource" class="com.mchange.v2.c3p0.ComboPooledDataSource">
		<!-- 配置连接池属性 -->
		<property name="driverClass" value="${jdbc.driver}" />
		<property name="jdbcUrl" value="${jdbc.url}" />
		<property name="user" value="${jdbc.username}" />
		<property name="password" value="${jdbc.password}" />

		<!-- c3p0连接池的私有属性 -->
		<property name="maxPoolSize" value="30" />
		<property name="minPoolSize" value="10" />
		<!-- 关闭连接后不自动commit -->
		<property name="autoCommitOnClose" value="false" />
		<!-- 获取连接超时时间 -->
		<property name="checkoutTimeout" value="10000" />
		<!-- 当获取连接失败重试次数 -->
		<property name="acquireRetryAttempts" value="2" />
	</bean>
		<!-- 3.配置SqlSessionFactory对象 -->
	<bean id="sqlSessionFactory" class="org.mybatis.spring.SqlSessionFactoryBean">
		<!-- 注入数据库连接池 -->
		<property name="dataSource" ref="dataSource" />
		<!-- 配置MyBaties全局配置文件:mybatis-config.xml -->
		<property name="configLocation" value="classpath:mybatis-config.xml" />
		<!-- 扫描entity包 使用别名 -->
		<property name="typeAliasesPackage" value="com.imooc.appoint.entity" /> 
		<!-- 扫描sql配置文件:mapper需要的xml文件 -->
		<property name="mapperLocations" value="classpath:mapper/*.xml" />
	</bean>

	<!-- 4.配置扫描Dao接口包，动态实现Dao接口，注入到spring容器中 -->
	<bean class="org.mybatis.spring.mapper.MapperScannerConfigurer">
		<!-- 注入sqlSessionFactory -->
		<property name="sqlSessionFactoryBeanName" value="sqlSessionFactory" />
		<!-- 给出需要扫描Dao接口包 -->
		<property name="basePackage" value="com.imooc.appoint.dao" /> 
	</bean>
	
</beans>
```
### 配置jdbc.properties文件<br>
```java
jdbc.driver=com.mysql.jdbc.Driver
jdbc.url=jdbc:mysql://127.0.0.1:3306/ssmbookappoint?useUnicode=true&characterEncoding=utf8
jdbc.username= 
jdbc.password= 
```
第一次上传忘记去掉用户名密码了，好险！大家用的时候填上自己的用户名、密码。<br>
### 配置mybatis。<br>
所以需要配置mybatis核心文件，在recources文件夹里新建mybatis-config.xml文件。<br>

1、使用自增主键<br>
2、使用列别名<br>
3、开启驼峰命名转换 create_time -> createTime<br>
mybatis-config.xml
```java
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE configuration
  PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
  "http://mybatis.org/dtd/mybatis-3-config.dtd">
<configuration>
	<!-- 配置全局属性 -->
	<settings>
		<!-- 使用jdbc的getGeneratedKeys获取数据库自增主键值 -->
		<setting name="useGeneratedKeys" value="true" />

		<!-- 使用列别名替换列名 默认:true -->
		<setting name="useColumnLabel" value="true" />

		<!-- 开启驼峰命名转换:Table{create_time} -> Entity{createTime} -->
		<setting name="mapUnderscoreToCamelCase" value="true" />
	</settings>
</configuration>
```

## 8配置实现接口的xml<br>
我们要开始写DAO接口的实现类，因为我们配置扫描sql配置文件路径是:mapper下的xml，所有我们应该在resourse下新建mapper文件夹，在这里存放实现DAO接口的各种xml<br>
BookDao.xml
```java
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper
    PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
    "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="com.imooc.appoint.dao.BookDao">
	<select id="queryById" parameterType="long" resultType="com.imooc.appoint.entiy.Book" >
		<!-- 具体的sql -->
		SELECT
			book_id,
			name,
			introd,
			number
		FROM
			book
		WHERE
			book_id = #{bookId}
	</select>

	<select id="querySome" parameterType="com.imooc.appoint.entiy.Book" resultType="com.imooc.appoint.entiy.Book">
		SELECT book_id,name,introd,number FROM book
		<where>
			<!-- <if test="name !=null and !&quot;&quot;.equals(name.trim())">  -->
				and name like '%' #{name} '%'
			<!--  </if>   -->
		</where> 
	</select> 
		
	<select id="queryAll" resultType="com.imooc.appoint.entiy.Book">
		SELECT
			book_id,
			name,
			introd,
			number
		FROM
			book
		ORDER BY
			book_id
		LIMIT #{offset}, #{limit}
	</select>
	
	<update id="reduceNumber">
		UPDATE book
		SET number = number - 1
		WHERE
			book_id = #{bookId}
		AND number > 0
	</update>

</mapper>
```
AppointmentDao.xml
```java
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper
    PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
    "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
	<mapper namespace="com.imooc.appoint.dao.AppointmentDao">
    <insert id="insertAppointment">
		<!-- ignore 主键冲突，报错 -->
		INSERT ignore INTO appointment (book_id, student_id)
		VALUES (#{bookId}, #{studentId})
	</insert>
<!--     <delete id="deleteOne" >
    	DELETE FROM appointment WHERE book_id=#{bookId} AND student_id=#{studentId} 
    </delete>  用不到这个功能-->
    <!-- //查询某个学生的所有预约记录 -->
    <select id="quaryAndReturn"  resultType="com.imooc.appoint.entiy.Appointment">
		<!-- 如何告诉MyBatis把结果映射到Appointment同时映射book属性 -->
		<!-- 可以自由控制SQL -->
		SELECT
			a.book_id,<!--mybatis会认为是book_id,又因为开启了驼峰命名法 所以最终是bookId -->
			a.student_id,
			a.appoint_time,
			b.book_id "book.book_id",<!--b.book_id as "book.book_id" 告诉mybatis b.book_id是Appointment中book属性的值-->
			b.`name` "book.name",
			b.introd "book.introd",
			b.number "book.number"
		FROM
			appointment a
		INNER JOIN book b ON a.book_id = b.book_id
		WHERE 
		 	a.student_id = #{studentId}
	</select>
<!-- 	//查询所有被预约了的书
	<select id="queryAll" >
		SELECT 
			a.book_id, 
			a.student_id,
			a.appoint_time, 
			b.book_id "book.book_id", 
			b.`name` "book.name",
			b.introd "book.introd"
			b.number "book.number"
		FROM 
			appointment a
		INNER JOIN book b ON a.book_id = b.book_id	
		ORDER BY
			a.book_id
		LIMIT #{offset}, #{limit}
	</select> 暂时用不到这个功能，管理员界面待开发-->
	
</mapper>
```
StudentDao.java
```java
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper
    PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
    "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="com.imooc.appoint.dao.StudentDao">
	<select id="quaryStudent" resultType="com.imooc.appoint.entiy.Student">
		SELECT 
			student_id,
			password
		FROM
			student
		WHERE
			student_id=#{studentId}
		AND password=#{password}		
	</select>

</mapper>
```
到此为止，我们dao层的开发就算结束了，大家可以写个测试类，测试一下。（我没写，哈哈），要实现预约功能还得有更多详细的逻辑组织，这个功能将他放在service中，他把DAO中与数据库交互的功能组织成可以用的详细逻辑。提供给上层web调用。<br>
## 8 service层<br>
### 首先写service接口类<br>
BookService.java
```java
package com.imooc.appoint.service;

import java.util.List;

import com.imooc.appoint.dto.AppointExecution;
import com.imooc.appoint.entiy.Appointment;
import com.imooc.appoint.entiy.Book;
import com.imooc.appoint.entiy.Student; 

public interface BookService {
	/**
	 * 查询一本图书
	 * 
	 * @param bookId
	 * @return
	 */
	Book getById(long bookId);  
	/**
	 * 查询所有图书
	 * 
	 * @return
	 */
	List<Book> getList();
	/**
	 * 登陆时查询数据库是否有该学生记录。
	 */
	Student validateStu(Long studentId,Long password);
	/**按照图书名称查询
	 * 按条件搜索图书
	 * 
	 */ 
	List<Book> getSomeList(String name);
	/*
	 * 查看某学生预约的所有图书
	 * 
	 */
	List<Appointment> getAppointByStu(long studentId);
	/**
	 * 预约图书
	 * 
	 * @param bookId
	 * @param studentId
	 * @return
	 */
	AppointExecution appoint(long bookId, long studentId);//返回预约成功的实体类
}
```
大家可以看到，这个借口类中基本和DAO中的没啥区别，有区别的是某些类他是在dao上更进一步，需要多个dao类一起组织，或者在加入其它逻辑才能实现<br>
为了实现BookService的借口，我们得写BookServiceImpl类。但是想让我们想想，为了写BookServiceImpl，我们需要什么，上面我们已经写出预约成功的实体类是AppointExecution，所以当然我们得写出该类，因为该类交互service和web，对这类有点像entiy包我们管叫bto包（bto包和其他包一起存放在appoint下）。对于AppointExecution来说，作用就是预约成功后给web层提供返回的信息。（就是返回预约成功、预约失败、无库存、之类的信息）<br>
```java
package com.imooc.appoint.dto;
import com.imooc.appoint.enums.AppointStateEnum;

public class AppointExecution {

	// 图书ID
	private long bookId;

	// 预约结果状态
	private int state;

	// 状态标识
	private String stateInfo;  

	public AppointExecution() {
	}

	// 预约失败的构造器
	public AppointExecution(long bookId, AppointStateEnum stateEnum) {
		this.bookId = bookId;
		this.state = stateEnum.getState();
		this.stateInfo = stateEnum.getStateInfo();
	}

	//set get 方法！
	public long getBookId() {
		return bookId;
	}

	public void setBookId(long bookId) {
		this.bookId = bookId;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public String getStateInfo() {
		return stateInfo;
	}

	public void setStateInfo(String stateInfo) {
		this.stateInfo = stateInfo;
	}
	
	@Override
	public String toString() {
		return "AppointExecution [bookId=" + bookId + ", state=" + state + ", stateInfo=" + stateInfo+"]";
	} 
}
```
除此之外，我们在预约图书时可能出现异常，例如重复预约、无库存、和其他异常，我们需要事先设计好异常类，来接收这类异常，方便处理，而不是直接报错。因此在appoint包下新建excption包，报下新建三个类：AppoinException.java;NoNumberException.java;RepeatAppoint.java<br>
AppoinException.java
```java
package com.imooc.appoint.exception;
//预约义务异常
public class AppointException extends RuntimeException{
	public AppointException(String message) {
		super(message);
	}

	public AppointException(String message, Throwable cause) {
		super(message, cause);
	}
}

```
NoNumberException.java
```java
package com.imooc.appoint.exception;

//库存不足异常
public class NoNumberException extends RuntimeException{
	public NoNumberException(String message) {
		super(message);
	}

	public NoNumberException(String message, Throwable cause) {
		super(message, cause);
	}

}

```
RepeatAppoint.java
```java
package com.imooc.appoint.exception;
//重复预约异常
public class RepeatAppointException extends RuntimeException{
	public RepeatAppointException(String message) {
		super(message);
	}

	public RepeatAppointException(String message, Throwable cause) {
		super(message, cause);
	}
}
```
现在可以写接口的实现类啦：BookServiceImpl.java<br>
```java
package com.imooc.appoint.service.Impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.imooc.appoint.dao.AppointmentDao;
import com.imooc.appoint.dao.BookDao;
import com.imooc.appoint.dao.StudentDao;
import com.imooc.appoint.dto.AppointExecution;
import com.imooc.appoint.entiy.Appointment;
import com.imooc.appoint.entiy.Book;
import com.imooc.appoint.entiy.Student;
import com.imooc.appoint.enums.AppointStateEnum;
import com.imooc.appoint.exception.AppointException;
import com.imooc.appoint.exception.NoNumberException;
import com.imooc.appoint.exception.RepeatAppointException;
import com.imooc.appoint.service.BookService;
 
@Service
public class BookServiceImpl implements BookService{
	private Logger logger=LoggerFactory.getLogger(this.getClass());
	@Autowired
	private BookDao bookDao;
	@Autowired
	private AppointmentDao appointmentDao;
	@Autowired
	private StudentDao studentDao; 
	@Override
	public Book getById(long bookId) { 
		return bookDao.queryById(bookId);
	}  
	@Override
	public List<Book> getList() { 
		return bookDao.queryAll(0, 1000);
	} 
	@Override
	public Student validateStu(Long studentId,Long password){
		return studentDao.quaryStudent(studentId, password);
	}
	@Override
	public List<Book> getSomeList(String name) {
		 
		return bookDao.querySome(name);
	} 
	@Override
	public List<Appointment> getAppointByStu(long studentId) {//DOTO
		return appointmentDao.quaryAndReturn(studentId);
		 
	}
	@Override
	@Transactional
	public AppointExecution appoint(long bookId, long studentId) {//在Dao的基础上组织逻辑，形成与web成交互用的方法
		try{													  //返回成功预约的类型。		
			int update=bookDao.reduceNumber(bookId);//减库存
			if(update<=0){//已经无库存！
				throw new NoNumberException("no number");
			}else{
				//执行预约操作
				int insert=appointmentDao.insertAppointment(bookId, studentId);
				if(insert<=0){//重复预约
					throw new RepeatAppointException("repeat appoint");
				}else{//预约成功
					return new AppointExecution(bookId,AppointStateEnum.SUCCESS);
				}
				
			}
		} catch (NoNumberException e1) {
			throw e1;
		} catch (RepeatAppointException e2) {
			throw e2;
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			// 所有编译期异常转换为运行期异常
			throw new AppointException("appoint inner error:" + e.getMessage());
		}
	} 
}

```
### 又到了我们写service层配置的时候！<br>
该xml依然位于resourse下的spring包下<br>
spring-service.xml
```java
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" 
	xmlns:context="http://www.springframework.org/schema/context"
	xmlns:tx="http://www.springframework.org/schema/tx"
	xsi:schemaLocation="http://www.springframework.org/schema/beans
	http://www.springframework.org/schema/beans/spring-beans.xsd
	http://www.springframework.org/schema/context
	http://www.springframework.org/schema/context/spring-context.xsd
	http://www.springframework.org/schema/tx
	http://www.springframework.org/schema/tx/spring-tx.xsd">
	<!-- 扫描service包下所有使用注解的类型 -->
	<context:component-scan base-package="com.imooc.appoint.service"></context:component-scan>
	<!-- 配置事务管理器 -->
	<bean id="transactionManager"
		class="org.springframework.jdbc.datasource.DataSourceTransactionManager">
		<!-- 注入数据库连接池 -->
		<property name="dataSource" ref="dataSource" />
	</bean>
		<!-- 配置基于注解的声明式事务 -->
	<tx:annotation-driven transaction-manager="transactionManager" />
</beans>	
```
## 9web层<br>
现在我们一起看看web层该如何组织。<br>
在写具体的代码之前，先配置web层，在这里主要实现的作用是：<br>
1、开启SpringMVC注解模式，可以使用@RequestMapping，@PathVariable，@ResponseBody等<br>
2、对静态资源处理，如js，css，jpg等<br>
3、配置jsp 显示ViewResolver，例如在controller中某个方法返回一个string类型的"login"，实际上会返回"/WEB-INF/login.jsp"<br>
4、扫描web层 @Controller <br>
详细见xml中每一步的注释<br>
spring-web.xml<br>
```java
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xmlns:context="http://www.springframework.org/schema/context"
	xmlns:mvc="http://www.springframework.org/schema/mvc" 
	xsi:schemaLocation="http://www.springframework.org/schema/beans
	http://www.springframework.org/schema/beans/spring-beans.xsd
	http://www.springframework.org/schema/context
	http://www.springframework.org/schema/context/spring-context.xsd
	http://www.springframework.org/schema/mvc
	http://www.springframework.org/schema/mvc/spring-mvc-3.0.xsd">
		<!-- 配置SpringMVC -->
	<!-- 1.开启SpringMVC注解模式 -->
	<!-- 简化配置： 
		(1)自动注册DefaultAnootationHandlerMapping,AnotationMethodHandlerAdapter 
		(2)提供一些列：数据绑定，数字和日期的format @NumberFormat, @DateTimeFormat, xml,json默认读写支持 
	-->
	<mvc:annotation-driven />
	<!-- 2.静态资源默认servlet配置
		(1)加入对静态资源的处理：js,gif,png
		(2)允许使用"/"做整体映射
	 -->
	 <mvc:default-servlet-handler/>
	 <!-- 3.配置jsp 显示ViewResolver -->
	 <bean class="org.springframework.web.servlet.view.InternalResourceViewResolver">
	 	<property name="viewClass" value="org.springframework.web.servlet.view.JstlView" />
	 	<property name="prefix" value="/WEB-INF/jsp/" />
	 	<property name="suffix" value=".jsp" />
	 </bean>
	 
	 <!-- 4.扫描web相关的bean -->
	 <context:component-scan base-package="com.imooc.appoint.web" />
</beans>
```
当然我们必须修改web.xml文件，它在webapp的WEB-INF下，这个文件配置servlet，并初始化，指定扫描spring相关的配置，最后我们将所有的url都拦截下来。
web.xml<br>
```java
<web-app xmlns="http://xmlns.jcp.org/xml/ns/javaee" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/javaee
                      http://xmlns.jcp.org/xml/ns/javaee/web-app_3_1.xsd"
	version="3.1" metadata-complete="true">
   	<servlet>
   		<servlet-name>BookAppointment-dispatcher</servlet-name>
   		<servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
   		<init-param>
   			<param-name>contextConfigLocation</param-name>
   			<param-value>classpath:spring/spring-*.xml</param-value>
   		</init-param>
   	</servlet>
  	<servlet-mapping>
  		<servlet-name>BookAppointment-dispatcher</servlet-name>
  		<url-pattern>/</url-pattern>
  	</servlet-mapping>
  
</web-app>

``` 
因为在运行时，我们经常会查看日志什么的，所以我们把这个配置进去<br>
logback.xml
```java
<?xml version="1.0" encoding="UTF-8"?><!-- 我们在项目中经常会使用到日志，所以这里还有配置日志xml -->
<configuration debug="true">
	<appender name="STDOUT" class="ch.qos.logback.core.ConsoleAppender">
		<!-- encoders are by default assigned the type ch.qos.logback.classic.encoder.PatternLayoutEncoder -->
		<encoder>
			<pattern>%d{HH:mm:ss.SSS} [%thread] %-5level %logger{36} - %msg%n</pattern>
		</encoder>
	</appender>

	<root level="debug">
		<appender-ref ref="STDOUT" />
	</root>
</configuration>
```
最后我们开始组织我们web的逻辑，也就是具体的controller层代码的编写。<br>
这一层中与我们的前段联系的较为紧密，大家可以边写边看效果，再调试。
```java
package com.imooc.appoint.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.imooc.appoint.dto.AppointExecution;
import com.imooc.appoint.dto.Result;
import com.imooc.appoint.entiy.Appointment;
import com.imooc.appoint.entiy.Book;
import com.imooc.appoint.entiy.Student;
import com.imooc.appoint.enums.AppointStateEnum;
import com.imooc.appoint.service.BookService;
import com.imooc.appoint.exception.RepeatAppointException;
import com.imooc.appoint.exception.NoNumberException;
 

@Controller
@RequestMapping("/books")
public class BookController {
	private Logger logger=LoggerFactory.getLogger(this.getClass());
	@Autowired
	private BookService bookService;
	//获取图书列表
	@RequestMapping(value="/list",method = RequestMethod.GET)
	private String List(Model model){
		List<Book> list = bookService.getList();
		model.addAttribute("list", list);
		
		return "list";
	}
	//搜索是否有某图书
	@RequestMapping(value="/search",method = RequestMethod.POST)
	private void  search(HttpServletRequest req,HttpServletResponse resp) 
								throws ServletException, IOException{
		//接收页面的值
		String name=req.getParameter("name");
		name=name.trim();
		//向页面传值
		req.setAttribute("name", name);
		req.setAttribute("list", bookService.getSomeList(name)); 
		req.getRequestDispatcher("/WEB-INF/jsp/list.jsp").forward(req, resp); 
	}
	//查看某图书的详细情况
	@RequestMapping(value = "/{bookId}/detail", method = RequestMethod.GET)
	private String detail(@PathVariable("bookId") Long bookId, Model model){
		if(bookId==null){
			return "redict:/book/list";
		}
		Book book=bookService.getById(bookId);
		if(book==null){
			return "forward:/book/list"; 
		}
		model.addAttribute("book",book);
		System.out.println(book);
		return "detail";
	}
	//验证输入的用户名、密码是否正确
	@RequestMapping(value="/verify", method = RequestMethod.POST, produces = {
		"application/json; charset=utf-8" })
	@ResponseBody
	private Map validate(Long studentId,Long password){   //(HttpServletRequest req,HttpServletResponse resp){
		Map resultMap=new HashMap(); 
		Student student =null;  
		System.out.println("验证函数"); 
		student =bookService.validateStu(studentId,password);
		
		System.out.println("输入的学号、密码："+studentId+":"+password);
		System.out.println("查询到的："+student.getStudentId()+":"+student.getPassword());
		
		if(student!=null){
			System.out.println("SUCCESS");
			resultMap.put("result", "SUCCESS");
			return resultMap;
		}else{ 
			resultMap.put("result", "FAILED");
			return resultMap;
		}
		
	}
	//执行预约的逻辑
	@RequestMapping(value = "/{bookId}/appoint", method = RequestMethod.POST, produces = {
	"application/json; charset=utf-8" })
	@ResponseBody
	private Result<AppointExecution> execute(@PathVariable("bookId") Long bookId,@RequestParam("studentId") Long studentId){
		Result<AppointExecution> result;
		AppointExecution execution=null;
		
		try{//手动try catch,在调用appoint方法时可能报错
			execution=bookService.appoint(bookId, studentId);
			result=new Result<AppointExecution>(true,execution); 
				return result; 
				
		} catch(NoNumberException e1) {
			execution=new AppointExecution(bookId,AppointStateEnum.NO_NUMBER);
			result=new Result<AppointExecution>(true,execution);
				return result;
		}catch(RepeatAppointException e2){
			execution=new AppointExecution(bookId,AppointStateEnum.REPEAT_APPOINT);
			result=new Result<AppointExecution>(true,execution);
				return result;
		}catch (Exception e){
			execution=new AppointExecution(bookId,AppointStateEnum.INNER_ERROR); 
			result=new Result<AppointExecution>(true,execution);
				return result;
		} 
	}
	@RequestMapping(value ="/appoint")
	private String appointBooks(@RequestParam("studentId") long studentId,Model model){
		
		List<Appointment> appointList=new ArrayList<Appointment>();
		appointList=bookService.getAppointByStu(studentId);
		model.addAttribute("appointList", appointList);
		 
		return "appointBookList";
	}
	
}

```
为了把执行预约逻辑是否返回的不同信息封装起来，我们创建一个Result<T>类，它是类型T的集合。<br>
Result.java
```java
package com.imooc.appoint.dto; 
/**
 * 封装json对象，所有返回结果都使用它
 */
public class Result<T> { 
	private boolean success;// 是否成功标志

	private T data;// 成功时返回的数据

	private String error;// 错误信息

	public Result() {
	}

	// 成功时的构造器
	public Result(boolean success, T data) {
		this.success = success;
		this.data = data;
	}

	// 错误时的构造器
	public Result(boolean success, String error) {
		this.success = success;
		this.error = error;
	}

	 
	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

}	
```
为了给web显示预约后的反馈信息，我们建立一个常量数据字典类存放这些要反馈给客户的信息<br>
AppointStateEnum.java
```java
package com.imooc.appoint.enums;
 
//使用枚举表述常量数据字典,我们先定义几个预约图书操作返回码的数据字典，也就是我们要返回给客户端的信息。
public enum AppointStateEnum {
	SUCCESS(1, "预约成功"), NO_NUMBER(0, "库存不足"), REPEAT_APPOINT(-1, "重复预约"), INNER_ERROR(-2, "系统异常");

	private int state;

	private String stateInfo;

	private AppointStateEnum(int state, String stateInfo) {
		this.state = state;
		this.stateInfo = stateInfo;
	}

	public int getState() {
		return state;
	}

	public String getStateInfo() {
		return stateInfo;
	}

	public static AppointStateEnum stateOf(int index) {
		for (AppointStateEnum state : values()) {
			if (state.getState() == index) {
				return state;
			}
		}
		return null;
	}
}
```
到此为止，我们后端写的差不多了，下面是前段页面的开发，其实前段和controller中的方法开发是相互嵌套的，在写方法的同时，写js或者jsp文件。这样逻辑才能连贯。再此用bootstrap这种轻量一站式框架开发前段，能死前端技术不怎么好的童鞋也能开发出还看得过去的页面。<br>
话不多少，我们上代码：<br>
list.jsp
```java
<%@page contentType="text/html; charset=UTF-8" language="java" %>
<%@include file="common/tag.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <title>图书列表</title>
    <%@include file="common/head.jsp" %>
</head>
<body>
<div class="container">
    <div class="panel panel-default">
        <div class="panel-heading text-center">
            <h2>图书列表</h2>
        </div>
        <form name="firstForm" action="<%= request.getContextPath()%>/books/search" method="post">
        	<div class="panel-heading ">
        	    <table class="table table-bookName">
        	       <thead>
        	       		<tr> 
        					<th width="90" align="lift">图书名称：</th>
        					<th width="150" align="lift">
        						<input type="text" name="name" class="allInput" value="${name}" placeholder="输入检索书名^o^" />
        					</th>
        					<th> 
        						<input type="submit" id="tabSub" value="检索" /> 
        					</th> 
        				</tr> 
        	       </thead> 
        	    </table> 
         	</div>
        </form>
       
        
        <div class="panel-body">
            <table class="table table-hover">
                <thead>
                <tr>
                    <th>图书ID</th>
                    <th>图书名称</th>
                    <th>馆藏数量</th> 
                    <th>详细</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${list}" var="sk">
                    <tr>
                        <td>${sk.bookId}</td>
                        <td>${sk.name}</td>
                        <td>${sk.number}</td>
                        <td><a class="btn btn-info" href="/books/${sk.bookId}/detail " target="_blank">详细</a></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table> 
        </div>

        
    </div>
</div> 
<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="http://apps.bdimg.com/libs/jquery/2.0.0/jquery.min.js"></script>

<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="http://apps.bdimg.com/libs/bootstrap/3.3.0/js/bootstrap.min.js"></script>
</body>
</html> 
```
detail.jsp
```java
<%@page contentType="text/html; charset=UTF-8" language="java" %>
<%@include file="common/tag.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <title>预约详情页</title>
    <%@include file="common/head.jsp" %>
</head>
<body>
<div class="container">
    <div class="panel panel-default">
        <div class="panel-heading text-center">
     	   	<h2>图书详情</h2>
        </div>
        <div class="panel-body">
            <table class="table table-hover">
                <thead>
                <tr>
                    <th>图书ID</th>
                    <th>图书名称</th> 
                    <th>图书简介</th>
                    <th>剩余数量</th>
                    <th>预约数量</th>
                </tr>
                </thead>
                <tbody>
                	<tr>
                		<td>${book.bookId}</td>
                		<td>${book.name}</td>
                		<td>${book.introd}</td> 
                		<td>${book.number }</td>
                		<td>1</td>
                	</tr>  
                </tbody>
             </table> 
           </div>  
           <div class="panel-body text-center">
            	<h2 class="text-danger">  
            		<!--用来展示预约控件-->
            		<span class="glyphicon" id="appoint-box"></span> <!--在js里面调用这个id还可以动态显示一些其他东西，例如动态时间等（需要插件）-->
            		 
            		<span class="glyphicon"><a class="btn btn-primary btn-lg" href="/books/appoint?studentId=${cookie['studentId'].value}" target="_blank">查看我的已预约书籍</a></span>
            	</h2>           <!--如何获取该页面弹出层输入的学生ID， 传给上面的url-->
        	</div>
    </div>	 	
            		  
</div>
   <!--  登录弹出层 输入电话   -->
<div id="varifyModal" class="modal fade"> 
    <div class="modal-dialog"> 
        <div class="modal-content">
            <div class="modal-header">
                <h3 class="modal-title text-center">
                    <span class="glyphicon glyphicon-studentId"> </span>请输入学号和密码:
                </h3>
            </div>

            <div class="modal-body">
                <div class="row">
                    <div class="col-xs-8 col-xs-offset-2">
                        <input type="text" name="studentId" id="studentIdKey"
                               placeholder="填写学号^o^" class="form-control">
                    </div>
                    <div class="col-xs-8 col-xs-offset-2">
                        <input type="password" name="password" id="passwordKey"
                               placeholder="输入密码^o^" class="form-control">
                    </div>
                </div>
            </div>

            <div class="modal-footer">
               		<!--  验证信息 -->
                <span id="studentMessage" class="glyphicon"> </span>
                <button type="button" id="studentBtn" class="btn btn-success">
                    <span class="glyphicon glyphicon-student"></span>
                    Submit
                </button>
            </div>
        </div>
    </div> 
</div>  

</body>
<%--jQery文件,务必在bootstrap.min.js之前引入--%>
<script src="http://apps.bdimg.com/libs/jquery/2.0.0/jquery.min.js"></script>
<script src="http://apps.bdimg.com/libs/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<%--使用CDN 获取公共js http://www.bootcdn.cn/--%>
<%--jQuery Cookie操作插件--%>
<script src="http://cdn.bootcss.com/jquery-cookie/1.4.1/jquery.cookie.min.js"></script>
<%--jQuery countDown倒计时插件--%>
<script src="http://cdn.bootcss.com/jquery.countdown/2.1.0/jquery.countdown.min.js"></script>

<script src="/resources/script/bookappointment.js" type="text/javascript"></script>

<script type="text/javascript">
    $(function () {
        //使用EL表达式传入参数
        bookappointment.detail.init({
            bookId:${book.bookId}  
             
        });
    })
</script>
</html> 
```
bookappointment.js
```javascript
var bookappointment={
	//封装相关ajax的url
	URL:{
		appoint:function(bookId,studentId){
			return '/books/'+bookId+'/appoint?studentId='+studentId;
		},
		verify:function(){
			return '/books'+'/verify';
		}
	},
		
	//验证学号和密码
	validateStudent:function(studentId,password){
		console.log("studentId"+studentId);
		if(!studentId||!password){
			return "nothing";
		}else if(studentId.length!=10 ||isNaN(studentId)||password.length!=6 ||isNaN(password)){
			return "typerror";
		}else {
			if(bookappointment.verifyWithDatabase(studentId, password)){
				console.log("验证成功！");
				return "success";
			}else{
				console.log("验证失败！");
				return "mismatch";
			}
		}  
	},
	//将学号和用户名与数据库匹配
	verifyWithDatabase:function(studentId,password){
		var result=false;
		var params={};
		params.studentId=studentId;
		params.password=password;
		console.log("params.password:"+params.password);
		var verifyUrl=bookappointment.URL.verify();
		$.ajax({
			type:'post',
			url:verifyUrl,
			data:params,
			datatype:'josn', 
			async:false,                       //同步调用，保证先执行result=true,后再执行return result;
			success:function(data){
				if(data.result=='SUCCESS'){
					window.location.reload();
					//弹出登录成功！
					alert("登陆成功！");
					result=true;
				}else{
					result=false;
				}
			}
		});
		console.log("我是验证结果："+result);
		return result;
			
	},
		
	//预定图书逻辑
	detail:{
		//预定也初始化
		init:function(params){
			var bookId=params['bookId']; 
			console.log("我是js文件！");
				
			var studentId=$.cookie('studentId');
			var password=$.cookie('password');
			if(!studentId||!password){
				//设置弹出层属性
				var  IdAndPasswordModal=$('#varifyModal');
				IdAndPasswordModal.modal({
					show: true,//显示弹出层
	               			backdrop: 'static',//禁止位置关闭
	               		 	keyboard: false//关闭键盘事件
				});
				$('#studentBtn').click(function (){
					studentId=$('#studentIdKey').val();
						console.log("studentId:"+studentId);
					password=$('#passwordKey').val();
						console.log("password:"+password);
					//调用validateStudent函数验证用户id和密码。
					var temp=bookappointment.validateStudent(studentId,password);
						console.log(temp);
					if(temp=="nothing"){
						$('#studentMessage').hide().html('<label class="label label-danger">学号或密码为空!</label>').show(300);
					}else if(temp=="typerror"){
						$('#studentMessage').hide().html('<label class="label label-danger">格式不正确!</label>').show(300);
					}else if(temp=="mismatch"){
						console.log("已经调用验证函数！");
						$('#studentMessage').hide().html('<label class="label label-danger">学号密码不匹配!</label>').show(300);
					}else if(temp=="success"){
						//学号与密码匹配正确，将学号密码保存在cookie中。不设置cookie过期时间，这样即为session模式，关闭浏览器就不保存密码了。
						$.cookie('studentId', studentId, {  path: '/books'}); 
						$.cookie('password', password, {  path: '/books'}); 
							// 跳转到预约逻辑 
						var appointbox=$('#appoint-box');
						bookappointment.appointment(bookId,studentId,appointbox);
					}
				}); 
			}else{
				var appointbox=$('#appoint-box');
				bookappointment.appointment(bookId,studentId,appointbox);
			} 
		}	
	},
	appointment:function(bookId,studentId, node){
		console.log("我执行预约的方法!" );
		node.html('<button class="btn btn-primary btn-lg" id="appointmentBtn">预约</button>');
			  
		var appointmentUrl = bookappointment.URL.appoint(bookId,studentId);
		console.log("appointmentUrl:"+appointmentUrl);
		//绑定一次点击事件
		$('#appointmentBtn').one('click', function () {
			//执行预约请求
			//1、先禁用请求
			$(this).addClass('disabled');
			//2、发送预约请求执行预约
			$.post(appointmentUrl,{},function(result){   //Ajax强大之处，向Controller方法提出请求和返回结果在一处!
				if(result && result['success']){         //同时还可以连续取对象的子对象！
					var appointResult=result['data'];
						console.log("appointResult"+appointResult);
					var state=appointResult['state'];
						console.log("state"+state);
					var stateInfo=appointResult['stateInfo'];
						console.log("stateInfo"+stateInfo);
					//显示预约结果    把结果显示给页面，完成了jsp的工作 
					node.html('<span class="label label-success">'+stateInfo+'</span>');
				}       //因为公用一个node所以，用来显示“stateInfo”时就不会显示上面的“预约”
				console.log('result'+result);
			});
		 });
			
			
	}
}
```
appointBookList.jsp
```java
<%@page contentType="text/html; charset=UTF-8" language="java" %>
<%@include file="common/tag.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <title>预约图书列表</title>
    <%@include file="common/head.jsp" %>
</head>
<body>
<div class="container">
    <div class="panel panel-default">
        <div class="panel-heading text-center">
            <h2>您已预约图书列表</h2>
        </div>
		<div class="panel-body">
            <table class="table table-hover">
                <thead>
                <tr> 
                    <th>预定学号</th>
                    <th>预约时间</th>
                    <th>图书ID</th> 
                    <th>图书名称</th>
                    <th>图书简介</th>
                    <th>预约数量</th>  
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${appointList}" var="sk">
                    <tr>
                    	<td>${sk.studentId}</td> 
                        <td>${sk.appointTime}</td>
                        <td>${sk.bookId}</td>
                        <td>${sk.book.getName()}</td>
                        <td>${sk.book.getIntrod()}</td> 
                        <td>1</td> 
                    </tr>
                </c:forEach>
                </tbody>
            </table> 
        </div> 
    </div>
</div> 
<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="http://apps.bdimg.com/libs/jquery/2.0.0/jquery.min.js"></script>

<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="http://apps.bdimg.com/libs/bootstrap/3.3.0/js/bootstrap.min.js"></script>
</body>
</html>
```
到此为止，所有的开发就已经结束，已经把所有源代码上传至github，需要的可以去下载，喜欢就给个star吧，这篇东西写了整整一个上午也不容易啊。<br>爱你们，么么哒！




