package ee.itcollege.jejee.web;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;

import ee.itcollege.jejee.entities.Piirivalvur_intsidendis;


@Component("IntsidendidPiiriloigulDetailValidator")
public class IntsidendidPiiriloigulDetailValidation {

	public boolean supports(Class<?> klass) {
		return Piirivalvur_intsidendis.class.isAssignableFrom(klass);
	}

	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "kirjeldus",
				"error_kirjeldus",
				" Sisesta kirjeldus!");

	}

}