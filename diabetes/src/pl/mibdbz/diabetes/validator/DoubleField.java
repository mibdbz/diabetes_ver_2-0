package pl.mibdbz.diabetes.validator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;


@Constraint(validatedBy = DoubleFieldConstraintValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface DoubleField {
	
	public double value() default 0.0;
	
	public String message() default "Wymagana liczba od 0 do 1000";
	
	public Class<?>[] groups() default{};
	
	public Class<? extends Payload>[] payload() default{};

}
