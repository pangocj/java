package xyz.itwill04.bean;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;
 
//Spring 프레임워크에서는 BeanFactory 객체 또는 ApplicationContext 객체로 스프링 컨테이너
//(Spring Container) 기능 제공
// => 스프링 컨테이너는 환경설정파일(Spring Bean Configuration File - XML)로 클래스를 제공받아 
//Spring Bean(객체) 관리
@SuppressWarnings("deprecation")
public class CreateBeanApp {
	public static void main(String[] args) {
		System.out.println("1.BeanFactory 객체를 생성하여 스프링 컨테이너로 사용하는 방법");
		System.out.println("=============== Spring Container 초기화 전 ===============");
		//BeanFactory 인터페이스를 상속받은 자식클래스로 객체 생성 - BeanFactory 객체 
		// => BeanFactory 객체를 생성할 때 Spring Bean Configuration File을 제공받아 스프링 
		//컨테이너 생성 - 스프링 컨테이너 초기화 작업 
		// => 매개변수에는 Spring Bean Configuration File의 경로를 제공받아 Resource 객체로 생성하여 전달
		// => BeanFactory 객체는 Spring Bean Configuration File에 등록된 클래스로 미리 객체를
		//생성하지 않고 Spring Bean 요청시  생성하여 제공
		BeanFactory factory=new XmlBeanFactory
				(new FileSystemResource("src/main/resources/04-1_beanCreate.xml"));
		System.out.println("=============== Spring Container 초기화 후 ===============");
		//BeanFactory.getBean(String beanName) : 매개변수로 Spring Bean를 구분하기 위한 식별자
		//(beanName)을 전달받아 스프링 컨테이너로부터 Spring Bean(객체)를 생성하여 반환하는 메소드
		// => Object 타입의 객체를 반환하므로 반드시 명시적 객체 형변환 사용
		// => 매개변수로 전달받은 식별자(beanName)의 Spring Bean이 없는 경우 NoSuchBeanDefinitionException 발생
		CreateBean bean1=(CreateBean)factory.getBean("createBean");
		bean1.display();
		System.out.println("==========================================================");
		System.out.println("2.ApplicationContext 객체를 생성하여 스프링 컨테이너로 사용하는 방법");
		System.out.println("=============== Spring Container 초기화 전 ===============");
		//ApplicationContext 인터페이스를 상속받은 자식클래스로 객체 생성 - ApplicationContext 객체
		// => ApplicationContext 객체를 생성할 때 Spring Bean Configuration File을 제공받아 
		//스프링 컨테이너 생성 - 스프링 컨테이너 초기화 작업 
		// => 클래스가 참조 가능한 폴더(ClassPath)에 저장된 Spring Bean Configuration File을 제공받아 사용
		// => ApplicationContext 객체는 Spring Bean Configuration File에 등록된 클래스로 미리 
		//객체를 생성하여 Spring Bean 요청시 미리 생성된 객체를 제공		
		ApplicationContext context=new ClassPathXmlApplicationContext("04-1_beanCreate.xml");
		System.out.println("=============== Spring Container 초기화 후 ===============");
		//DL(Dependency Lookup) : 스프링 컨테이너가 관리하는 객체(Spring Bean)를 검색하여 제공하는 기능 
		//ApplicationContext.getBean(String beanName) : 매개변수로 Spring Bean를 구분하기 위한 
		//식별자(beanName)을 전달받아 스프링 컨테이너로부터 Spring Bean(객체)를 반환하는 메소드
		// => Object 타입의 객체를 반환하므로 반드시 명시적 객체 형변환 사용
		// => 매개변수로 전달받은 식별자(beanName)의 Spring Bean이 없는 경우 NoSuchBeanDefinitionException 발생
		CreateBean bean2=(CreateBean)context.getBean("createBean");
		bean2.display();
		
		//ClassPathXmlApplicationContext.close() : ApplicationContext 객체를 제거하는 메소드
		// => 스프링 컨테이너가 소멸되기 전에 스프링 컨테이너에 의해 관리되는 모든 객체(Spring Bean)를 자동 소멸
		((ClassPathXmlApplicationContext)context).close();
		System.out.println("==========================================================");
	} 
}
