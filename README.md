Course: Spring 5: Learn Spring 5 Core, AOP, Spring MVC, Spring Security, Spring REST, Spring Boot 2, Thymeleaf, JPA & Hibernate - Chad Darby
===================================

Mysql dump under path:src/main/resources/sql
------------

What to change: [********]
------------
1: hibernate.cfg.xml
```xml
<br>
     <bean id="dataSource" class="com.mchange.v2.c3p0.ComboPooledDataSource" destroy-method="close"> 
        <property name="driverClass" value="com.mysql.cj.jdbc.Driver"/>
        <property name="jdbcUrl" value="jdbc:mysql://localhost:3306/web_customer_tracker?useSSL=false&amp;serverTimezone=UTC"/>
        <property name="user" value="********"/>
        <property name="password" value="********"/>
        <property name="initialPoolSize" value="5"/>
		<property name="minPoolSize" value="5" />
		<property name="maxPoolSize" value="20" />
		<property name="maxIdleTime" value="30000" /> 
    </bean>
```

How to install: 
------------
- Check if Eclipse contains Egit (https://www.eclipse.org/egit/)
- Clone my .git repo (https://dzone.com/articles/tutorial-git-with-eclipse --> Read section: "Git Perspective and Repository Setup in Eclipse" and "Import from Git" )
- Right key mouse on project -> Maven -> Update Projects...
	- Check "Force update of Snapshots/Releases"
	- Click OK
- Right key mouse on project -> Run As -> Run on Server

SW version:
------------
- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
- Eclipse: Version: 2019-06 (4.12.0)
- OS: Windows 10 64 bit
