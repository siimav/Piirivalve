package ee.itcollege.jejee.web;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;

import ee.itcollege.jejee.entities.Intsident;
import ee.itcollege.jejee.entities.Piirivalvur_intsidendis;


@Component("redaktorValidator")
public class RedaktorValidation {
	
	public boolean supports(Class<?> klass) {
		return Piirivalvur_intsidendis.class.isAssignableFrom(klass);
	}

	public void validate(Object target, Errors errors) {
//		Piirivalvur_intsidendis pi = (Piirivalvur_intsidendis) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "kirjeldus",
				null,
				" Sisesta kirjeldus!");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "alates",
				null,
				" Sisesta väärtus ALGUSELE!");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "kuni",
				null,
				" Sisesta väärtus LÕPULE!");

	}
}