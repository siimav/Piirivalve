package ee.itcollege.jejee.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.tostring.RooToString;
import javax.persistence.Inheritance;
import static javax.persistence.InheritanceType.JOINED;
import javax.persistence.Basic;
import ee.itcollege.jejee.entities.Piiriloik;
import javax.persistence.ManyToOne;

@RooToString
@RooEntity
@Entity
public class Intsident implements Serializable {

	private static final long serialVersionUID = 1L;

	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private Long intsident_ID;
	private String avaja;
	private Date avatud;
	private String muutja;
	private Date muudetud;
	private String sulgeja;
	private Date suletud;
	private String kood;
	private String nimetus;
	private Date toimumise_algus;
	private Date toimumise_lopp;
	private String kirjeldus;
	private String kommentaar;
	private String GPS_longituud;
	private String GPS_latituud;

	@ManyToOne
	private Piiriloik piiriloik;

	@ManyToOne(targetEntity = ee.itcollege.jejee.entities.Intsidendi_liik.class)
	private String intsidendi_liik;

	public Long getIntsident_ID() {
		return intsident_ID;
	}

	public void setIntsident_ID(Long intsident_ID) {
		this.intsident_ID = intsident_ID;
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

	public Date getToimumise_algus() {
		return toimumise_algus;
	}

	public void setToimumise_algus(Date toimumise_algus) {
		this.toimumise_algus = toimumise_algus;
	}

	public Date getToimumise_lopp() {
		return toimumise_lopp;
	}

	public void setToimumise_lopp(Date toimumise_lopp) {
		this.toimumise_lopp = toimumise_lopp;
	}

	public String getKirjeldus() {
		return kirjeldus;
	}

	public void setKirjeldus(String kirjeldus) {
		this.kirjeldus = kirjeldus;
	}

	public String getKommentaar() {
		return kommentaar;
	}

	public void setKommentaar(String kommentaar) {
		this.kommentaar = kommentaar;
	}

	public String getGPS_longituud() {
		return GPS_longituud;
	}

	public void setGPS_longituud(String gPS_longituud) {
		GPS_longituud = gPS_longituud;
	}

	public String getGPS_latituud() {
		return GPS_latituud;
	}

	public void setGPS_latituud(String gPS_latituud) {
		GPS_latituud = gPS_latituud;
	}

	public void setPiiriloik(Piiriloik param) {
		this.piiriloik = param;
	}

	public Piiriloik getPiiriloik() {
		return piiriloik;
	}

	public void setIntsidendi_liik(String param) {
		this.intsidendi_liik = param;
	}

	public String getIntsidendi_liik() {
		return intsidendi_liik;
	}
}
