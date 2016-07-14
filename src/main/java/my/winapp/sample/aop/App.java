/*
  https://examples.javacodegeeks.com/enterprise-java/spring/aop/spring-aop-example/
 
  BEFORE Advice executes before a method execution, but does not have the ability to prevent 
  execution flow proceeding to the method execution (unless it throws an exception).
  
  AFTER returning advice is the Advice to be executed after a method execution 
  completes normally:  * for example, if a method returns without throwing an exception. 
  
  AFTER throwing Advice is the Advice to be executed if a method exits by throwing an exception.
  
  AROUND advice is the Advice that surrounds a join point such as a method invocation. 
  This is the most powerful kind of advice. Around advice can perform custom behavior before and 
  after the method invocation. It is also responsible for choosing whether to proceed to the 
  join point or to shortcut the advised method execution by returning its own return value or 
  throwing an exception.
  
  POINTCUT indicates which method should be intercepted whereas the Advisor groups the 
  Advice and the Pointcut into a single unit, and passes it to a proxy factory object. 2 types : 
  1- match a method by its name 
  2- match a method using a regular expression pattern
*/

package my.winapp.sample.aop;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	
	public static void main(String[] args) {
		
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		SimpleService simpleService = (SimpleService) context.getBean("simpleServiceProxy");
		simpleService.printNameId();
		System.out.println("--------------");
		try{
			simpleService.checkName();
		} catch(Exception e){
			System.out.println("SimpleService: Method checkName() exception thrown..");
		}
		System.out.println("--------------");
		simpleService.sayHello("Javacodegeeks");
		context.close();
}

}
