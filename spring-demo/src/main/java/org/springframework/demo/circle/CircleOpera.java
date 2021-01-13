package org.springframework.demo.circle;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

public class CircleOpera {

	protected final Log logger = LogFactory.getLog(getClass());

	public static void main(String[] args) {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(TestConfig.class);
		System.out.println("单例模式 循环依赖可以解决");
		//单例模式 循环依赖可以解决
		A.CircleA circleA = applicationContext.getBean(A.CircleA.class);

		System.out.println("原型模式无法解决");
		//原型模式无法解决
		try {
			B.CircleA bCircleA = applicationContext.getBean(B.CircleA.class);
		}catch (Exception e){
			e.printStackTrace();
		}

		//单例模式，构造器注入
		System.out.println("单例模式，构造器注入,无法解决");
		C.CircleA cCircleA = applicationContext.getBean(C.CircleA.class);
	}
}
@Configuration
@ComponentScan("org.springframework.demo")
class TestConfig{


}
class A {
	@Component
	static class CircleA {
		@Autowired
		CircleB circleB;
	}

	@Component
	static class CircleB {
		@Autowired
		CircleC circleC;

	}

	@Component
	static class CircleC {

		@Autowired
		CircleA circleA;
	}
}


class B {
	@Component
	@Scope("prototype")
	static class CircleA {
		@Autowired
		CircleB circleB;
	}

	@Component
	@Scope("prototype")
	static class CircleB {
		@Autowired
		CircleC circleC;

	}

	@Component
	@Scope("prototype")
	static class CircleC {

		@Autowired
		CircleA circleA;
	}
}


class C{
	@Component
	static class CircleA {

		CircleB circleB;

		@Autowired
		public CircleA(CircleB circleB) {
			this.circleB = circleB;
		}
	}

	@Component
	static class CircleB {

		CircleC circleC;

		@Autowired
		public CircleB(CircleC circleC) {
			this.circleC = circleC;
		}
	}

	@Component
	static class CircleC {

		CircleA circleA;

		@Autowired
		public CircleC(CircleA circleA) {
			this.circleA = circleA;
		}
	}
}

