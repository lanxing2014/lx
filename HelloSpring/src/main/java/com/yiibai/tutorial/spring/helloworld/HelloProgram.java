package com.yiibai.tutorial.spring.helloworld;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloProgram {
	 @SuppressWarnings("resource")
	public static void main(String[] args) {
		 	//可以通过读取beans.xml 文件来创建一个应用程序上下文对象
	        ApplicationContext context =
	                new ClassPathXmlApplicationContext("beans.xml");
	         
	        HelloWorldService service =
	             (HelloWorldService) context.getBean("helloWorldService");
	          
	        HelloWorld hw= service.getHelloWorld();
	         
	        hw.sayHello();
	    }
}
