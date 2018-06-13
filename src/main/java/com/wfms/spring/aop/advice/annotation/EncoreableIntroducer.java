package com.wfms.spring.aop.advice.annotation;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;

@Aspect
public class EncoreableIntroducer {
	
	@DeclareParents(value="com.wfms.spring.aop.advice.annotation.Performance+",
								defaultImpl=DefaultEncoreable.class)
	public static Encoreable encoreable;
}