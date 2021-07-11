package com.spring.mvc;

import java.lang.annotation.ElementType;  
import java.lang.annotation.Retention;  
import java.lang.annotation.RetentionPolicy;  
import java.lang.annotation.Target;  
  
import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
  
@Constraint(validatedBy = InputConstraintValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD, ElementType.TYPE } )
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation {
	public String message() default "Input must contain # character";  

}  



class InputConstraintValidator implements ConstraintValidator<MyAnnotation, String> {

	 public boolean isValid(String s, ConstraintValidatorContext cvc) {
		 System.out.println("InputConstraintValidator:isValid(): "+ s);
		 return s.contains("#");
	 }
}
