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
    ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nimetus",
            "NotEmpty.intsident.nimetus",
            " Sisesta väärtus NIMETUSELE!");
    ValidationUtils.rejectIfEmptyOrWhitespace(errors, "toimumise_algus",
            "NotEmpty.intsident.toimumise_algus",
            " Sisesta väärtus ALGUSELE!");
    ValidationUtils.rejectIfEmptyOrWhitespace(errors, "toimumise_lopp",
            "NotEmpty.intsident.toimumise_lopp",
            " Sisesta väärtus LÕPULE!");
    ValidationUtils.rejectIfEmptyOrWhitespace(errors, "kirjeldus",
            "NotEmpty.intsident.kirjeldus",
            " Sisesta väärtus KIRJELDUSELE!");
    
    String gps_lat = intsident.getGPS_latituud();
    String gps_long = intsident.getGPS_longituud();
    boolean ok_lat = false;
    boolean ok_long = false;
    for (char c : gps_lat.toCharArray()) {
		if(c=='.')
			ok_lat=true;
	}
    if(!ok_lat){
    	errors.rejectValue("GPS_latituud",
              "lengthOfNimetus.intsident.GPS_latituud",
              "GPS_latituudi väärtus vale!");
    }
    
    for (char c : gps_long.toCharArray()) {
		if(c=='.')
			ok_long=true;
	}
    if(!ok_long){
    	errors.rejectValue("GPS_longituud",
              "lengthOfNimetus.intsident.GPS_longituud",
              "GPS_longituudi väärtus vale!");
    }
    
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
