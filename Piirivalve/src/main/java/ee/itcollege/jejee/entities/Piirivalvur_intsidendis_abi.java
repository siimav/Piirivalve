package ee.itcollege.jejee.entities;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;



public class Piirivalvur_intsidendis_abi {

	private Piirivalvur_intsidendis piirivalvur_intsidendis;
	private Long piiriloik_ID;
	private Piirivalvur piirivalvur;
	private Piiriloik piiriloik;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date alates;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date kuni;
	private int kogus;
	private ArrayList<Piirivalvur_intsidendis> pints_arr = new ArrayList<Piirivalvur_intsidendis>();
	
	
	public int getKogus() {
		return kogus;
	}
	public void setKogus(int kogus) {
		this.kogus = kogus;
	}
	public ArrayList<Piirivalvur_intsidendis> getPints_arr() {
		return pints_arr;
	}
	public void setPints_arr(ArrayList<Piirivalvur_intsidendis> pints_arr) {
		this.pints_arr = pints_arr;
	}
	public Long getPiiriloik_ID() {
		return piiriloik_ID;
	}
	public void setPiiriloik_ID(Long piiriloik_ID) {
		this.piiriloik_ID = piiriloik_ID;
	}
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
