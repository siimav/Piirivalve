package ee.itcollege.jejee.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.tostring.RooToString;
import javax.persistence.Basic;

/**
 * Entity implementation class for Entity: Vahtkonna_liige
 * 
 */
@Entity
@RooEntity
@RooToString
public class Vahtkonna_liige implements Serializable {

	private static final long serialVersionUID = 1L;

	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private Long vahtkonna_liige_ID;
	@DateTimeFormat(style = "M-")
	private Date alates;
	@DateTimeFormat(style = "M-")
	private Date kuni;
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
	private Vahtkond vahtkond;

	@ManyToOne
	private Piirivalvur piirivalvur;

	public Vahtkonna_liige() {
		super();
	}

	public Long getVahtkonna_liige_ID() {
		return vahtkonna_liige_ID;
	}

	public void setVahtkonna_liige_ID(Long vahtkonna_liige_ID) {
		this.vahtkonna_liige_ID = vahtkonna_liige_ID;
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

	public Vahtkond getVahtkond() {
		return vahtkond;
	}

	public void setVahtkond(Vahtkond param) {
		this.vahtkond = param;
	}

	public void setPiirivalvur(Piirivalvur param) {
		this.piirivalvur = param;
	}

	public Piirivalvur getPiirivalvur() {
		return piirivalvur;
	}

}
