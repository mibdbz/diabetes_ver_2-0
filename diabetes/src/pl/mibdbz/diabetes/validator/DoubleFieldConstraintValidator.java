package pl.mibdbz.diabetes.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class DoubleFieldConstraintValidator implements ConstraintValidator<DoubleField, String>{


	@Override
	public boolean isValid(String theCode, ConstraintValidatorContext theContext) {

		
		if(theCode != null) {
			
			double defaultValue = Double.parseDouble(theCode);
			
			if(defaultValue < 0) {
				return false;
				
			} else if(defaultValue > 1000) {
				return false;
				
			} 
			
		}
		
		return true;
		
	}

}
