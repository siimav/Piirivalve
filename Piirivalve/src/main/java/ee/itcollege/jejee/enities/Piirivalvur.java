package ee.itcollege.jejee.enities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.tostring.RooToString;

/**
 * Entity implementation class for Entity: Piirivalvur
 *
 */
@Entity
@RooEntity
@RooToString
public class Piirivalvur implements Serializable {

	@GeneratedValue(strategy = GenerationType.AUTO)   
	@Id
	private Integer piirivalvur_ID;
	private String isikukood;
	private String eesnimed;
	private String perekonnanimi;
	private String sugu;
	private String soduri_kood;
	private String avaja;
	private Date avatud;
	private String sulgeja;
	private Date suletud;
	private String muutja;
	private Date muudetud;
	private String kommentaar;
	private static final long serialVersionUID = 1L;

	public Piirivalvur() {
		super();
	}   
	public Integer getPiirivalvur_ID() {
		return this.piirivalvur_ID;
	}

	public void setPiirivalvur_ID(Integer piirivalvur_ID) {
		this.piirivalvur_ID = piirivalvur_ID;
	}   
	public String getIsikukood() {
		return this.isikukood;
	}

	public void setIsikukood(String isikukood) {
		this.isikukood = isikukood;
	}   
	public String getEesnimed() {
		return this.eesnimed;
	}

	public void setEesnimed(String eesnimed) {
		this.eesnimed = eesnimed;
	}   
	public String getPerekonnanimi() {
		return this.perekonnanimi;
	}

	public void setPerekonnanimi(String perekonnanimi) {
		this.perekonnanimi = perekonnanimi;
	}   
	public String getSugu() {
		return this.sugu;
	}

	public void setSugu(String sugu) {
		this.sugu = sugu;
	}   
	public String getSoduri_kood() {
		return this.soduri_kood;
	}

	public void setSoduri_kood(String soduri_kood) {
		this.soduri_kood = soduri_kood;
	}   
	public String getAvaja() {
		return this.avaja;
	}

	public void setAvaja(String avaja) {
		this.avaja = avaja;
	}   
	public Date getAvatud() {
		return this.avatud;
	}

	public void setAvatud(Date avatud) {
		this.avatud = avatud;
	}   
	public String getSulgeja() {
		return this.sulgeja;
	}

	public void setSulgeja(String sulgeja) {
		this.sulgeja = sulgeja;
	}   
	public Date getSuletud() {
		return this.suletud;
	}

	public void setSuletud(Date suletud) {
		this.suletud = suletud;
	}   
	public String getMuutja() {
		return this.muutja;
	}

	public void setMuutja(String muutja) {
		this.muutja = muutja;
	}   
	public Date getMuudetud() {
		return this.muudetud;
	}

	public void setMuudetud(Date muudetud) {
		this.muudetud = muudetud;
	}   
	public String getKommentaar() {
		return this.kommentaar;
	}

	public void setKommentaar(String kommentaar) {
		this.kommentaar = kommentaar;
	}
   
}
