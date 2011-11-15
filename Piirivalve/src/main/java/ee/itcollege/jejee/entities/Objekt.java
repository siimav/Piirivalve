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
import ee.itcollege.jejee.entities.Objekt_intsidendis;
import java.util.Collection;
import javax.persistence.OneToMany;
import javax.persistence.JoinColumn;

/**
 * Entity implementation class for Entity: Objekt
 *
 */
@Entity
@RooEntity
@RooToString
public class Objekt implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@GeneratedValue(strategy = GenerationType.AUTO)   
	@Id
	private Long objekt_ID;
	private String nimetus;	
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
	@NotNull
	private Objekti_liik objekti_liik;

	@OneToMany(mappedBy = "objekt")
	@JoinColumn(name = "Objekt_objekt_ID", referencedColumnName = "objekt_ID")
	private Collection<Objekt_intsidendis> objekt_intsidendis;

	public Objekt() {
		super();
	}

	public Long getObjekt_ID() {
		return objekt_ID;
	}

	public void setObjekt_ID(Long objekt_ID) {
		this.objekt_ID = objekt_ID;
	}

	public String getNimetus() {
		return nimetus;
	}

	public void setNimetus(String nimetus) {
		this.nimetus = nimetus;
	}

	public ee.itcollege.jejee.entities.Objekti_liik getObjekt_liik_ID() {
		return objekt_liik_ID;
	}

	public void setObjekt_liik_ID(ee.itcollege.jejee.entities.Objekti_liik objekt_liik_ID) {
		this.objekt_liik_ID = objekt_liik_ID;
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

	public Objekti_liik getObjekti_liik() {
	    return objekti_liik;
	}

	public void setObjekti_liik(Objekti_liik param) {
	    this.objekti_liik = param;
	}

	public Collection<Objekt_intsidendis> getObjekt_intsidendis() {
	    return objekt_intsidendis;
	}

	public void setObjekt_intsidendis(Collection<Objekt_intsidendis> param) {
	    this.objekt_intsidendis = param;
	}

   
}
