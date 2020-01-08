# udemy-spring-5-section-29
Course: Spring and Hibernate for beginners - Chad Darby<br>
Mysql dump under path:src/main/resources/sql<br>

1- What to change:

1.1 - hibernate.cfg.xml<br>
...<br>
     <bean id="dataSource" 
			class="com.mchange.v2.c3p0.ComboPooledDataSource" destroy-method="close"> 
        <property name="driverClass" value="com.mysql.cj.jdbc.Driver"/>
        <property name="jdbcUrl" value="jdbc:mysql://localhost:3306/web_customer_tracker?useSSL=false&amp;serverTimezone=UTC"/>
        <property name="user" value=<b>"springstudent"<b>/>
        <property name="password" value="springstudent"/>
        <property name="initialPoolSize" value="5"/>
		<property name="minPoolSize" value="5" />
		<property name="maxPoolSize" value="20" />
		<property name="maxIdleTime" value="30000" /> 
    </bean>
...<br>

2 - SW version:<br>
  2.1 - MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)<br>
  2.2 - Eclipse: Version: 2019-06 (4.12.0)<br>
