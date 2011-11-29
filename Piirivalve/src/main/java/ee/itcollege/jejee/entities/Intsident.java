package ee.itcollege.jejee.entities;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Query;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.tostring.RooToString;

@RooToString
@RooEntity
@Entity
public class Intsident extends BaseEntity {
	
	private static final long serialVersionUID = 1L;

	private String kood;
	private String nimetus;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date toimumise_algus;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date toimumise_lopp;
	private String kirjeldus;
	private String kommentaar;
	private String GPS_longituud;
	private String GPS_latituud;

	@ManyToOne
	private Piiriloik piiriloik;

	@NotNull
	@ManyToOne
	private Intsidendi_liik intsidendi_liik;

	@OneToMany(mappedBy = "intsident")
	private Collection<Objekt_intsidendis> objekt_intsidendis;

	@OneToMany(mappedBy = "intsident")
	private Collection<Isik_intsidendis> isik_intsidendis;
	
	@OneToMany(mappedBy = "intsident")
	private Collection<Vahtkond_intsidendis> vahtkonnad_intsidendis;
	
	@OneToMany(mappedBy = "intsident")
	private Collection<Piirivalvur_intsidendis> piirivalvurid_intsidendis;
	

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

	public void setIntsidendi_liik(Intsidendi_liik param) {
		this.intsidendi_liik = param;
	}

	public Intsidendi_liik getIntsidendi_liik() {
		return intsidendi_liik;
	}

	public Collection<Objekt_intsidendis> getObjekt_intsidendis() {
	    return objekt_intsidendis;
	}

	public void setObjekt_intsidendis(Collection<Objekt_intsidendis> param) {
	    this.objekt_intsidendis = param;
	}

	public Collection<Isik_intsidendis> getIsik_intsidendis() {
	    return isik_intsidendis;
	}

	public void setIsik_intsidendis(Collection<Isik_intsidendis> param) {
	    this.isik_intsidendis = param;
	}

	public Collection<Vahtkond_intsidendis> getVahtkonnad_intsidendis() {
		return vahtkonnad_intsidendis;
	}

	public void setVahtkonnad_intsidendis(Collection<Vahtkond_intsidendis> vahtkonnad_intsidendis) {
		this.vahtkonnad_intsidendis = vahtkonnad_intsidendis;
	}

	public Collection<Piirivalvur_intsidendis> getPiirivalvurid_intsidendis() {
		return piirivalvurid_intsidendis;
	}

	public void setPiirivalvurid_intsidendis(Collection<Piirivalvur_intsidendis> piirivalvurid_intsidendis) {
		this.piirivalvurid_intsidendis = piirivalvurid_intsidendis;
	}

	
	@SuppressWarnings("unchecked")
	public static List<Intsident> findAllIntsidentsForPiiriloik(Piiriloik piir) {
		Query q = entityManager().createQuery("SELECT o FROM Intsident o WHERE o.piiriloik=:piir", Intsident.class);
		q.setParameter("piir", piir);
		return q.getResultList();
	}

	@SuppressWarnings("unchecked")
	public static List<Intsident> findIntsidentsForPiiriloikWithInterval(Piiriloik piir, Date toimumise_algus, Date toimumise_lopp) {
		Query q = entityManager().createQuery("SELECT o FROM Intsident o WHERE o.piiriloik=:piir and o.toimumise_algus>=:toimumise_algus and o.toimumise_lopp<=:toimumise_lopp", Intsident.class);
		q.setParameter("piir", piir);
		q.setParameter("toimumise_algus", toimumise_algus);
		q.setParameter("toimumise_lopp", toimumise_lopp);
		return q.getResultList();
	}

	@SuppressWarnings("unchecked")
	public static List<Intsident> findAllIntsidentsWithInterval(Date toimumise_algus, Date toimumise_lopp) {
		Query q = entityManager().createQuery("SELECT o FROM Intsident o WHERE o.toimumise_algus>=:toimumise_algus and o.toimumise_lopp<=:toimumise_lopp", Intsident.class);
		q.setParameter("toimumise_algus", toimumise_algus);
		q.setParameter("toimumise_lopp", toimumise_lopp);
		return q.getResultList();
	}

}
