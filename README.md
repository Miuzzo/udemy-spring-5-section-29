# udemy-spring-5-section-29

Course: Spring 5: Learn Spring 5 Core, AOP, Spring MVC, Spring Security, Spring REST, Spring Boot 2, Thymeleaf, JPA & Hibernate - Chad Darby
===================================

Mysql dump under path:src/main/resources/sql

What to change
------------
1: hibernate.cfg.xml<br>
```xml
<br>
     <bean id="dataSource" class="com.mchange.v2.c3p0.ComboPooledDataSource" destroy-method="close"> 
        <property name="driverClass" value="com.mysql.cj.jdbc.Driver"/>
        <property name="jdbcUrl" value="jdbc:mysql://localhost:3306/web_customer_tracker?useSSL=false&amp;serverTimezone=UTC"/>
        <property name="user" value="springstudent"/>
        <property name="password" value="springstudent"/>
        <property name="initialPoolSize" value="5"/>
		<property name="minPoolSize" value="5" />
		<property name="maxPoolSize" value="20" />
		<property name="maxIdleTime" value="30000" /> 
    </bean>
```

SW version
------------
- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
- Eclipse: Version: 2019-06 (4.12.0)
