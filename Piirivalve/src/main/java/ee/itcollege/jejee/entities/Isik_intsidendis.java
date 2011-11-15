package ee.itcollege.jejee.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.tostring.RooToString;
import ee.itcollege.jejee.entities.Intsident;
import javax.persistence.ManyToOne;
import ee.itcollege.jejee.entities.Piiririkkuja;

/**
 * Entity implementation class for Entity: Isik_intsidendis
 *
 */
@Entity
@RooEntity
@RooToString
public class Isik_intsidendis implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@GeneratedValue(strategy = GenerationType.AUTO)   
	@Id
	private Long isik_intsidendis_ID;
	@DateTimeFormat(style = "M-")
	@NotNull
	private Date alates;
	@DateTimeFormat(style = "M-")
	@NotNull
	private Date kuni;
	@NotNull
	private String kirjeldus;
	private ee.itcollege.jejee.entities.Intsident intsident_ID;
	private ee.itcollege.jejee.entities.Piiririkkuja piiririkkuja_ID;
	@NotNull
	private String avaja;
	@DateTimeFormat(style = "M-")
	@NotNull
	private Date avatud;
	private String sulgeja;
	@DateTimeFormat(style = "M-")
	@NotNull
	private Date suletud;
	@NotNull
	private String muutja;
	@DateTimeFormat(style = "M-")
	@NotNull
	private Date muudetud;
	private String kommentaar;

	@ManyToOne
	private Intsident intsident;

	@ManyToOne
	private Piiririkkuja piiririkkuja;

	public Isik_intsidendis() {
		super();
	}

	public Long getIsik_intsidendis_ID() {
		return isik_intsidendis_ID;
	}

	public void setIsik_intsidendis_ID(Long isik_intsidendis_ID) {
		this.isik_intsidendis_ID = isik_intsidendis_ID;
	}

	public Date getAlates() {
		return alates;
	}

	public void setAlates(Date alates) {
		this.alates = alates;
	}

	public Date getKuni() {
		return kuni;
	}

	public void setKuni(Date kuni) {
		this.kuni = kuni;
	}

	public String getKirjeldus() {
		return kirjeldus;
	}

	public void setKirjeldus(String kirjeldus) {
		this.kirjeldus = kirjeldus;
	}

	public ee.itcollege.jejee.entities.Intsident getIntsident_ID() {
		return intsident_ID;
	}

	public void setIntsident_ID(ee.itcollege.jejee.entities.Intsident intsident_ID) {
		this.intsident_ID = intsident_ID;
	}

	public ee.itcollege.jejee.entities.Piiririkkuja getPiiririkkuja_ID() {
		return piiririkkuja_ID;
	}

	public void setPiiririkkuja_ID(
			ee.itcollege.jejee.entities.Piiririkkuja piiririkkuja_ID) {
		this.piiririkkuja_ID = piiririkkuja_ID;
	}

	public String getAvaja() {
		return avaja;
	}

	public void setAvaja(String avaja) {
		this.avaja = avaja;
	}

	public Date getAvatud() {
		return avatud;
	}

	public void setAvatud(Date avatud) {
		this.avatud = avatud;
	}

	public String getSulgeja() {
		return sulgeja;
	}

	public void setSulgeja(String sulgeja) {
		this.sulgeja = sulgeja;
	}

	public Date getSuletud() {
		return suletud;
	}

	public void setSuletud(Date suletud) {
		this.suletud = suletud;
	}

	public String getMuutja() {
		return muutja;
	}

	public void setMuutja(String muutja) {
		this.muutja = muutja;
	}

	public Date getMuudetud() {
		return muudetud;
	}

	public void setMuudetud(Date muudetud) {
		this.muudetud = muudetud;
	}

	public String getKommentaar() {
		return kommentaar;
	}

	public void setKommentaar(String kommentaar) {
		this.kommentaar = kommentaar;
	}

	public Intsident getIntsident() {
	    return intsident;
	}

	public void setIntsident(Intsident param) {
	    this.intsident = param;
	}

	public Piiririkkuja getPiiririkkuja() {
	    return piiririkkuja;
	}

	public void setPiiririkkuja(Piiririkkuja param) {
	    this.piiririkkuja = param;
	}

	
}
