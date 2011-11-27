package ee.itcollege.jejee.entities;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;



public class Piirivalvur_intsidendis_abi {

	private Piirivalvur_intsidendis piirivalvur_intsidendis;
	private Piirivalvur piirivalvur;
	private Piiriloik piiriloik;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date alates;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date kuni;
	
	public Piirivalvur_intsidendis getPiirivalvur_intsidendis() {
		return piirivalvur_intsidendis;
	}
	public void setPiirivalvur_intsidendis(
			Piirivalvur_intsidendis piirivalvur_intsidendis) {
		this.piirivalvur_intsidendis = piirivalvur_intsidendis;
	}
	public Piirivalvur getPiirivalvur() {
		return piirivalvur;
	}
	public void setPiirivalvur(Piirivalvur piirivalvur) {
		this.piirivalvur = piirivalvur;
	}
	public Piiriloik getPiiriloik() {
		return piiriloik;
	}
	public void setPiiriloik(Piiriloik piiriloik) {
		this.piiriloik = piiriloik;
	}
	public Date getAlates() {
		return alates;
	}
	public void setAlates(Date algus) {
		this.alates = algus;
	}
	public Date getKuni() {
		return kuni;
	}
	public void setKuni(Date kuni) {
		this.kuni = kuni;
	}
	
	
}
