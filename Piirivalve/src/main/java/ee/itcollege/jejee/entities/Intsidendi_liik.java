package ee.itcollege.jejee.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.tostring.RooToString;

@RooToString
@RooEntity
@Entity
public class Intsidendi_liik implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@GeneratedValue(strategy = GenerationType.AUTO)   
	@Id
	private Long intsidendi_liik_ID;
	@NotNull
	private String avaja;
	@DateTimeFormat(style = "M-")
	@NotNull
	private Date avatud;
	@NotNull
	private String muutja;
	@DateTimeFormat(style = "M-")
	@NotNull
	private Date muudetud;
	private String sulgeja;
	@DateTimeFormat(style = "M-")
	@NotNull
	private Date suletud;
	private String kood;
	private String nimetus;
	private String kommentaar;

	@OneToMany(mappedBy = "intsidendi_liik")
	private Collection<Intsident> intsident;
	
	public Long getIntsidendi_liik_ID() {
		return intsidendi_liik_ID;
	}
	public void setIntsidendi_liik_ID(Long intsidendi_liik_ID) {
		this.intsidendi_liik_ID = intsidendi_liik_ID;
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
	public String getKommentaar() {
		return kommentaar;
	}
	public void setKommentaar(String kommentaar) {
		this.kommentaar = kommentaar;
	}
	public Collection<Intsident> getIntsident() {
	    return intsident;
	}
	public void setIntsident(Collection<Intsident> param) {
	    this.intsident = param;
	}
	
}
