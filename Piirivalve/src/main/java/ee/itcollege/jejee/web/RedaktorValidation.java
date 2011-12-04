package ee.itcollege.jejee.web;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;

import ee.itcollege.jejee.entities.Isik_intsidendis;
import ee.itcollege.jejee.entities.Objekt_intsidendis;
import ee.itcollege.jejee.entities.Piirivalvur_intsidendis;


@Component("redaktorValidator")
public class RedaktorValidation {
	
	public boolean supports(Class<?> klass) {
		return Piirivalvur_intsidendis.class.isAssignableFrom(klass) || 
			   Isik_intsidendis.class.isAssignableFrom(klass) ||
			   Objekt_intsidendis.class.isAssignableFrom(klass);
	}

	public void validate(Object target, String [] cbs, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "kirjeldus",
				"error_kirjeldus",
				"Sisesta kirjeldus!");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "alates",
				"error_alates",
				"Sisesta väärtus ALGUSELE!");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "kuni",
				"error_kuni",
				"Sisesta väärtus LÕPULE!");
	}
	
}