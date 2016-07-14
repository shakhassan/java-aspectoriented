package my.winapp.sample.aop;

import org.springframework.aop.ThrowsAdvice;

public class DoAfterThrowingExceptionMethod implements ThrowsAdvice {
	public void afterThrowing(IllegalArgumentException e) throws Throwable {
		System.out.println("****SPRING AOP**** DoAfterThrowingExceptionMethod : Executing when method throws exception!");
	}
}
