package ee.itcollege.jejee.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.tostring.RooToString;

/**
 * Entity implementation class for Entity: Piiripunkt
 *
 */
@Entity
@RooEntity
@RooToString
public class Piiripunkt implements Serializable {

	@GeneratedValue(strategy = GenerationType.AUTO)   
	@Id
	private Long piiripunkt_ID;
	private String kood;
	private String nimetus;
	private String GPS_longituide;
	private String GPS_latitude;
	private String korgus_merepinnast;
	@DateTimeFormat(style = "M-")
	private Date alates;
	@DateTimeFormat(style = "M-")
	private Date kuni;
	private String avaja;
	@DateTimeFormat(style = "M-")
	private Date avatud;
	private String sulgeja;
	@DateTimeFormat(style = "M-")
	private Date suletud;
	private String muutja;
	@DateTimeFormat(style = "M-")
	private Date muudetud;
	private String kommentaar;
	private static final long serialVersionUID = 1L;

	public Piiripunkt() {
		super();
	}

	public Long getPiiripunkt_ID() {
		return piiripunkt_ID;
	}

	public void setPiiripunkt_ID(Long piiripunkt_ID) {
		this.piiripunkt_ID = piiripunkt_ID;
	}

	public String getKood() {
		return kood;
	}

	public void setKood(String kood) {
		this.kood = kood;
	}

	public String getNimetus() {
		return nimetus;
	}

	public void setNimetus(String nimetus) {
		this.nimetus = nimetus;
	}

	public String getGPS_longituide() {
		return GPS_longituide;
	}

	public void setGPS_longituide(String gPS_longituide) {
		GPS_longituide = gPS_longituide;
	}

	public String getGPS_latitude() {
		return GPS_latitude;
	}

	public void setGPS_latitude(String gPS_latitude) {
		GPS_latitude = gPS_latitude;
	}

	public String getKorgus_merepinnast() {
		return korgus_merepinnast;
	}

	public void setKorgus_merepinnast(String korgus_merepinnast) {
		this.korgus_merepinnast = korgus_merepinnast;
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
	
   
}
