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
 * Entity implementation class for Entity: Vahtkonna_liige
 *
 */
@Entity
@RooEntity
@RooToString
public class Vahtkonna_liige implements Serializable {

	@GeneratedValue(strategy = GenerationType.AUTO)   
	@Id
	private Long vahtkonna_liige_ID;
	private ee.itcollege.jejee.entities.Vahtkond vahtkond_ID;
	private ee.itcollege.jejee.entities.Piirivalvur piirivalvur_ID;
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

	public Vahtkonna_liige() {
		super();
	}

	public Long getVahtkonna_liige_ID() {
		return vahtkonna_liige_ID;
	}

	public void setVahtkonna_liige_ID(Long vahtkonna_liige_ID) {
		this.vahtkonna_liige_ID = vahtkonna_liige_ID;
	}

	public ee.itcollege.jejee.entities.Vahtkond getVahtkond_ID() {
		return vahtkond_ID;
	}

	public void setVahtkond_ID(ee.itcollege.jejee.entities.Vahtkond vahtkond_ID) {
		this.vahtkond_ID = vahtkond_ID;
	}

	public ee.itcollege.jejee.entities.Piirivalvur getPiirivalvur_ID() {
		return piirivalvur_ID;
	}

	public void setPiirivalvur_ID(
			ee.itcollege.jejee.entities.Piirivalvur piirivalvur_ID) {
		this.piirivalvur_ID = piirivalvur_ID;
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
