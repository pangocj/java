package xyz.itwill05.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CollectionBeanApp {
	public static void main(String[] args) {
		System.out.println("=============== Spring Container 초기화 전 ===============");
		ApplicationContext context=new ClassPathXmlApplicationContext("05-2_collection.xml");
		System.out.println("=============== Spring Container 초기화 후 ===============");
		CollectionBean bean=context.getBean("collectionBean", CollectionBean.class);
		
		//CollectionBean 객체의 필드값(Collection 객체)을 반환받아 출력
		// => Collection 객체의 toString() 메소드 호출 - Collection 객체에 저장된 모든 요소값 출력
		System.out.println("nameSet = "+bean.getNameSet());
		System.out.println("nameList = "+bean.getNameList());
		System.out.println("controllerSet = "+bean.getControllerSet());
		System.out.println("controllerList = "+bean.getControllerList());
		System.out.println("controllerMap = "+bean.getControllerMap());
		System.out.println("controllerProperties = "+bean.getControllerProperties());
		System.out.println("==========================================================");
		((ClassPathXmlApplicationContext)context).close();		
	}
}
