package ee.itcollege.jejee.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.tostring.RooToString;
import ee.itcollege.jejee.entities.Vahtkond_piiriloigul;
import javax.persistence.JoinColumn;
import javax.persistence.Basic;

/**
 * Entity implementation class for Entity: Vahtkond
 * 
 */
@Entity
@RooEntity
@RooToString
public class Vahtkond implements Serializable {

	private static final long serialVersionUID = 1L;

	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private Long vahtkond_ID;
	private String kood;
	private String nimetus;
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

	@OneToMany(mappedBy = "vahtkond")
	private Collection<Vahtkonna_liige> vahtkonna_liige;

	@ManyToOne
	private Vaeosa vaeosa;

	@OneToMany(mappedBy = "vahtkond")
	private Collection<Vahtkond_piiriloigul> vahtkond_piiriloigul;

	@ManyToOne
	private Piiripunkt piiripunkt;

	public Vahtkond() {
		super();
	}

	public Long getVahtkond_ID() {
		return vahtkond_ID;
	}

	public void setVahtkond_ID(Long vahtkond_ID) {
		this.vahtkond_ID = vahtkond_ID;
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

	public Collection<Vahtkonna_liige> getVahtkonna_liige() {
		return vahtkonna_liige;
	}

	public void setVahtkonna_liige(Collection<Vahtkonna_liige> param) {
		this.vahtkonna_liige = param;
	}

	public Vaeosa getVaeosa() {
		return vaeosa;
	}

	public void setVaeosa(Vaeosa param) {
		this.vaeosa = param;
	}

	public Collection<Vahtkond_piiriloigul> getVahtkond_piiriloigul() {
		return vahtkond_piiriloigul;
	}

	public void setVahtkond_piiriloigul(Collection<Vahtkond_piiriloigul> param) {
		this.vahtkond_piiriloigul = param;
	}

	public void setPiiripunkt(Piiripunkt param) {
		this.piiripunkt = param;
	}

	public Piiripunkt getPiiripunkt() {
		return piiripunkt;
	}

}
