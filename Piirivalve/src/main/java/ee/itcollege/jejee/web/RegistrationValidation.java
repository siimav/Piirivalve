package ee.itcollege.jejee.web;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;

import ee.itcollege.jejee.entities.Intsident;


@Component("registrationValidator")
public class RegistrationValidation {
  public boolean supports(Class<?> klass) {
    return Intsident.class.isAssignableFrom(klass);
  }

  public void validate(Object target, Errors errors) {
	  Intsident intsident = (Intsident) target;
    ValidationUtils.rejectIfEmptyOrWhitespace(errors, "kood",
        "NotEmpty.intsident.kood",
        " Sisesta väärtus KOODILE!");
//    String nimetus = intsident.getNimetus();
//    if ((nimetus.length()) > 10) {
//      errors.rejectValue("nimetus",
//          "lengthOfNimetus.intsident.nimetus",
//          "Nimetus must not more than 10 characters.");
//    }
//    if (!(intsident.getPassword()).equals(registration
//        .getConfirmPassword())) {
//      errors.rejectValue("password",
//          "matchingPassword.registration.password",
//          "Password and Confirm Password Not match.");
//    }
  }
}
