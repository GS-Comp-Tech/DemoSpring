package com.gscomptech.DemoSpring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.gscomptech.DemoSpring", "com.gscomptech.OtherPackage"})
public class DemoSpringApplication {

	public static void main(String[] args) {
		ApplicationContext appContext = SpringApplication.run(DemoSpringApplication.class, args);
		String[] beans = appContext.getBeanDefinitionNames();
		for (String bean: beans) {
			System.out.println(bean);
		}
	}
}
