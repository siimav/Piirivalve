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
import ee.itcollege.jejee.entities.Objekt;
import javax.persistence.ManyToOne;
import ee.itcollege.jejee.entities.Isik_intsidendis;
import java.util.Collection;
import javax.persistence.OneToMany;

/**
 * Entity implementation class for Entity: Piiririkkuja
 *
 */
@Entity
@RooEntity
@RooToString
public class Piiririkkuja implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@GeneratedValue(strategy = GenerationType.AUTO)   
	@Id
	private Long piiririkkuja_ID;
	private String isikukood;
	private String eesnimi;
	private String perek_nimi;
	private String sugu;
	@DateTimeFormat(style = "M-")
	private Date synniaeg;
	private ee.itcollege.jejee.entities.Objekt objekt_ID;
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
	private Objekt objekt;

	@OneToMany(mappedBy = "piiririkkuja")
	private Collection<Isik_intsidendis> isik_intsidendis;

	public Long getPiiririkkuja_ID() {
		return piiririkkuja_ID;
	}

	public void setPiiririkkuja_ID(Long piiririkkuja_ID) {
		this.piiririkkuja_ID = piiririkkuja_ID;
	}

	public String getIsikukood() {
		return isikukood;
	}

	public void setIsikukood(String isikukood) {
		this.isikukood = isikukood;
	}

	public String getEesnimi() {
		return eesnimi;
	}

	public void setEesnimi(String eesnimi) {
		this.eesnimi = eesnimi;
	}

	public String getPerek_nimi() {
		return perek_nimi;
	}

	public void setPerek_nimi(String perek_nimi) {
		this.perek_nimi = perek_nimi;
	}

	public String getSugu() {
		return sugu;
	}

	public void setSugu(String sugu) {
		this.sugu = sugu;
	}

	public Date getSynniaeg() {
		return synniaeg;
	}

	public void setSynniaeg(Date synniaeg) {
		this.synniaeg = synniaeg;
	}

	public ee.itcollege.jejee.entities.Objekt getObjekt_ID() {
		return objekt_ID;
	}

	public void setObjekt_ID(ee.itcollege.jejee.entities.Objekt objekt_ID) {
		this.objekt_ID = objekt_ID;
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

	public Piiririkkuja() {
		super();
	}

	public Objekt getObjekt() {
	    return objekt;
	}

	public void setObjekt(Objekt param) {
	    this.objekt = param;
	}

	public Collection<Isik_intsidendis> getIsik_intsidendis() {
	    return isik_intsidendis;
	}

	public void setIsik_intsidendis(Collection<Isik_intsidendis> param) {
	    this.isik_intsidendis = param;
	}

	
   
}
