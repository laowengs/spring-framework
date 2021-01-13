package org.springframework.demo.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

public class SpringTest {
	public static void main(String[] args) {
//		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("");
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(TestConfig.class);
		TestProcessor testProcessor = applicationContext.getBean(TestProcessor.class);
		testProcessor.process();
	}
}

@Component
class TestProcessor{

	public void process(){
		System.out.println("process...");
	}
}

@Configuration
@ComponentScan("org.springframework.demo.main")
class TestConfig{


}
