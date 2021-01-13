package org.springframework.demo;


public class XmlBeanFatoryTest {
	public static void main(String[] args) {
//		BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("application.xml"));
//		MyTestBean myBean = (MyTestBean) beanFactory.getBean("myBean");
//		System.out.println(myBean.getTestStr());


	}
}
class MyTestBean{
	private String testStr = "testStr";

	public String getTestStr() {
		return testStr;
	}

	public void setTestStr(String testStr) {
		this.testStr = testStr;
	}
}