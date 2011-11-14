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
 * Entity implementation class for Entity: Vaeosa
 *
 */
@Entity
@RooEntity
@RooToString
public class Vaeosa implements Serializable {

	@GeneratedValue(strategy = GenerationType.AUTO)   
	@Id
	private Long vaeosa_ID ;
	private String kood;
	private String nimetus;
	private ee.itcollege.jejee.entities.Riigi_admin_yksus riigi_admin_yksus_ID;
	private Date alates;
	private Date kuni;
	private String avaja;
	private Date avatud;
	private String sulgeja;
	private Date suletud;
	private String muutja;
	private Date muudetud;
	private String kommentaar;
	private static final long serialVersionUID = 1L;

	public Vaeosa() {
		super();
	}

	public Long getVaeosa_ID() {
		return vaeosa_ID;
	}

	public void setVaeosa_ID(Long vaeosa_ID) {
		this.vaeosa_ID = vaeosa_ID;
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

	public ee.itcollege.jejee.entities.Riigi_admin_yksus getRiigi_admin_yksus_ID() {
		return riigi_admin_yksus_ID;
	}

	public void setRiigi_admin_yksus_ID(
			ee.itcollege.jejee.entities.Riigi_admin_yksus riigi_admin_yksus_ID) {
		this.riigi_admin_yksus_ID = riigi_admin_yksus_ID;
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
