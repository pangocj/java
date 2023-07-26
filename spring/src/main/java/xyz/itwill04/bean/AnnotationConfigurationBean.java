package xyz.itwill04.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration : 스프링 컨테이너에 의해 관리될 객체(Spring Bean)을 생성하여 반환하는 메소드가
//선언된 클래스를 설정하기 위한 어노테이션
// => 클래스를 Spring Bean Configuration File과 유사한 기능을 제공하는 어노테이션
@Configuration
public class AnnotationConfigurationBean {
	//@Bean : 클래스로 객체를 생성하여 반환하는 메소드에 설정하는 어노테이션
	// => @Bean 어노테이션을 사용한 메소드가 반환한 객체는 스프링 컨테이너에 의해 관리 - Spring Bean
	// => Spring Bean Configuration File의 bean 엘리먼트와 유사한 기능을 제공하는 어노테이션
	// => 메소드의 이름이 Spring Bean의 식별자(beanName)으로 사용
	// => @Bean 어노테이션의 name 속성을 이용하여 식별자(beanName) 변경 가능
	@Bean
	public AnnotationBean annotationBean() {
		return new AnnotationBean();
	}
	
	/*
	@Bean
	public ComponentAnnotationBean componentAnnotationBean() {
		return new ComponentAnnotationBean();
	}
	*/
}
