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
        "error_kood",
        " Sisesta väärtus KOODILE!");
    ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nimetus",
            "error_nimetus",
            " Sisesta väärtus NIMETUSELE!");
    ValidationUtils.rejectIfEmptyOrWhitespace(errors, "toimumise_algus",
            "error_algus",
            " Sisesta väärtus ALGUSELE!");
    ValidationUtils.rejectIfEmptyOrWhitespace(errors, "toimumise_lopp",
            "error_lopp",
            " Sisesta väärtus LÕPULE!");
    ValidationUtils.rejectIfEmptyOrWhitespace(errors, "kirjeldus",
            "error_kirjeldus",
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
              "error_gps_lat",
              "GPS_latituudi väärtus vale!");
    }
    
    for (char c : gps_long.toCharArray()) {
		if(c=='.')
			ok_long=true;
	}
    if(!ok_long){
    	errors.rejectValue("GPS_longituud",
              "error_gps_long",
              "GPS_longituudi väärtus vale!");
    }
    
  }
}
