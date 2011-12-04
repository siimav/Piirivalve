package ee.itcollege.jejee.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Query;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.tostring.RooToString;

@RooToString
@RooEntity
@Entity
public class Piirivalvuri_seadus_intsidendi extends BaseEntity {
	
	private static final long serialVersionUID = 1L;

	private String kirjeldus;
	private String kommentaar;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@NotNull
	private Date alates;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@NotNull
	private Date kuni;
	
	@ManyToOne
	private Seaduse_punkt seaduse_punkt;

	@ManyToOne
	private Piirivalvur_intsidendis piirivalvur_intsidendis;
	
	public Piirivalvuri_seadus_intsidendi(){
		super();
	}
	
	public Piirivalvuri_seadus_intsidendi(String kirjeldus, String kommentaar,
			Date alates, Date kuni, Seaduse_punkt seaduse_punkt,
			Piirivalvur_intsidendis piirivalvur_intsidendis) {
		super();
		this.kirjeldus = kirjeldus;
		this.kommentaar = kommentaar;
		this.alates = alates;
		this.kuni = kuni;
		this.seaduse_punkt = seaduse_punkt;
		this.piirivalvur_intsidendis = piirivalvur_intsidendis;
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
	public Seaduse_punkt getSeaduse_punkt() {
		return seaduse_punkt;
	}
	public void setSeaduse_punkt(Seaduse_punkt seaduse_punkt) {
		this.seaduse_punkt = seaduse_punkt;
	}
	public Piirivalvur_intsidendis getPiirivalvur_intsidendis() {
		return piirivalvur_intsidendis;
	}
	public void setPiirivalvur_intsidendis(
			Piirivalvur_intsidendis piirivalvur_intsidendis) {
		this.piirivalvur_intsidendis = piirivalvur_intsidendis;
	}
	
	
	@SuppressWarnings("unchecked")
	public static List<Piirivalvuri_seadus_intsidendi> findAllPSIForPiirivalvurIntsidendis(Piirivalvur_intsidendis pi) {
		Query q = entityManager().createQuery("SELECT o FROM Piirivalvuri_seadus_intsidendi o WHERE o.piirivalvur_intsidendis=:pi AND o.suletud=:d", Piirivalvuri_seadus_intsidendi.class);
		q.setParameter("pi", pi);
		q.setParameter("d", SURROGATE_DATE);
		return q.getResultList();
	}
	
}
