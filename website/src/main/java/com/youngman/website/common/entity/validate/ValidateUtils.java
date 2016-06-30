package com.youngman.website.common.entity.validate;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

/**
 * 领域模型验证.
 */
public class ValidateUtils {
	private static ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
	
	/**
	 * 
	 * 使用JSR303为基础,对所有领域模型验证进行支持.
	 * 将返回的信息进行简单封装. 多个错误信息采用&符号进行分割.
	 */
	public static Map<String, String> validate(Object domain) {
		Map<String, String> errors = new HashMap<String, String>();
		
		if (domain == null) {
			return errors;
		}
		
		Validator validator = factory.getValidator();
		Set<ConstraintViolation<Object>> constraintViolations = validator.validate(domain);
		for (ConstraintViolation<?> constraintViolation : constraintViolations) {
			String key = constraintViolation.getPropertyPath().toString();
			String value = constraintViolation.getMessage();
			if (errors.containsKey(key)) {
				String last = errors.get(key);
				errors.put(key, value + "&" + last);
			} else {
				errors.put(key, value);
			}
        }
		
		return errors;
	}
}
