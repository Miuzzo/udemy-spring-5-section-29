package com.luv2code.springdemo.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan("com.luv2code.springdemo")
public class ProxyAOP {
	
	/*
	 * Annotation Proxy aop version: alternative in xml
	 * 1 - open hibernate.cfg.xml and add:
	 *		1.1 xmlns:aop="http://www.springframework.org/schema/aop"
	 *		1.2 xsi:schemaLocation="...
	 *				http://www.springframework.org/schema/aop 
	 *				http://www.springframework.org/schema/aop/spring-aop.xsd
	 *								..."
	 *		1.3 <aop:aspectj-autoproxy />
	 * */

}
