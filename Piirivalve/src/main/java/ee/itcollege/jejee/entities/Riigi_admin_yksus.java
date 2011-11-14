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

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.tostring.RooToString;

/**
 * Entity implementation class for Entity: Riigi_admin_yksus
 *
 */
@Entity
@RooEntity
@RooToString
public class Riigi_admin_yksus implements Serializable {

	@GeneratedValue(strategy = GenerationType.AUTO)   
	@Id
	private Long riigi_admin_yksus_ID;
	private String kood;
	private String nimetus;
	private ee.itcollege.jejee.entities.Riigi_admin_yksuse_liik riigi_admin_yksuse_liik_ID;
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
	@ManyToOne
	private Riigi_admin_yksuse_liik riigi_admin_yksuse_liik;
	@OneToMany(mappedBy = "riigi_admin_yksus")
	private Collection<Vaeosa> vaeosa;

	public Riigi_admin_yksus() {
		super();
	}
	public Long getRiigi_admin_yksus_ID() {
		return riigi_admin_yksus_ID;
	}

	public void setRiigi_admin_yksus_ID(Long riigi_admin_yksus_ID) {
		this.riigi_admin_yksus_ID = riigi_admin_yksus_ID;
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

	public ee.itcollege.jejee.entities.Riigi_admin_yksuse_liik getRiigi_admin_yksuse_liik_ID() {
		return riigi_admin_yksuse_liik_ID;
	}

	public void setRiigi_admin_yksuse_liik_ID(
			ee.itcollege.jejee.entities.Riigi_admin_yksuse_liik riigi_admin_yksuse_liik_ID) {
		this.riigi_admin_yksuse_liik_ID = riigi_admin_yksuse_liik_ID;
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
	public Riigi_admin_yksuse_liik getRiigi_admin_yksuse_liik() {
	    return riigi_admin_yksuse_liik;
	}
	public void setRiigi_admin_yksuse_liik(Riigi_admin_yksuse_liik param) {
	    this.riigi_admin_yksuse_liik = param;
	}
	public Collection<Vaeosa> getVaeosa() {
	    return vaeosa;
	}
	public void setVaeosa(Collection<Vaeosa> param) {
	    this.vaeosa = param;
	}	
   
}
