package ee.itcollege.jejee.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.tostring.RooToString;

/**
 * Entity implementation class for Entity: Objekti_liik
 *
 */
@Entity
@RooEntity
@RooToString
public class Objekti_liik implements Serializable {

	@GeneratedValue(strategy = GenerationType.AUTO)   
	@Id
	private Long objekt_liik_ID;
	private String kood;
	private String nimetus;
	private String avaja;
	private Date avatud;
	private String sulgeja;
	private Date suletud;
	private String muutja;
	private Date muudetud;
	private String kommentaar;
	private static final long serialVersionUID = 1L;

	public Objekti_liik() {
		super();
	}

	public Long getObjekt_liik_ID() {
		return objekt_liik_ID;
	}

	public void setObjekt_liik_ID(Long objekt_liik_ID) {
		this.objekt_liik_ID = objekt_liik_ID;
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
