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
import ee.itcollege.jejee.entities.Seadus;
import ee.itcollege.jejee.entities.Piirivalvuri_seadus_intsidendi;

@RooToString
@RooEntity
@Entity
public class Seaduse_punkt extends BaseEntity {
	
	private static final long serialVersionUID = 1L;

	private String paragrahv;
	private String pais;
	private String tekst;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date kehtiv_alates;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date kehtiv_kuni;
	private String kommentaar;

	@ManyToOne
	private Seadus seadus;

	@OneToMany(mappedBy = "seaduse_punkt")
	private Collection<Piirivalvuri_seadus_intsidendi> piirivalvuri_seadus_intsidendi;
	
	public Seaduse_punkt(){
		super();
	}
	
	public Seaduse_punkt(
			String paragrahv,
			String pais,
			String tekst,
			Date kehtiv_alates,
			Date kehtiv_kuni,
			String kommentaar,
			Seadus seadus) {
		super();
		this.paragrahv = paragrahv;
		this.pais = pais;
		this.tekst = tekst;
		this.kehtiv_alates = kehtiv_alates;
		this.kehtiv_kuni = kehtiv_kuni;
		this.kommentaar = kommentaar;
		this.seadus = seadus;
	}
	public String getParagrahv() {
		return paragrahv;
	}
	public void setParagrahv(String paragrahv) {
		this.paragrahv = paragrahv;
	}
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	public String getTekst() {
		return tekst;
	}
	public void setTekst(String tekst) {
		this.tekst = tekst;
	}
	public Date getKehtiv_alates() {
		return kehtiv_alates;
	}
	public void setKehtiv_alates(Date kehtiv_alates) {
		this.kehtiv_alates = kehtiv_alates;
	}
	public Date getKehtiv_kuni() {
		return kehtiv_kuni;
	}
	public void setKehtiv_kuni(Date kehtiv_kuni) {
		this.kehtiv_kuni = kehtiv_kuni;
	}
	public String getKommentaar() {
		return kommentaar;
	}
	public void setKommentaar(String kommentaar) {
		this.kommentaar = kommentaar;
	}
	public Seadus getSeadus() {
		return seadus;
	}
	public void setSeadus(Seadus seadus) {
		this.seadus = seadus;
	}

	public Collection<Piirivalvuri_seadus_intsidendi> getPiirivalvuri_seadus_intsidendi() {
	    return piirivalvuri_seadus_intsidendi;
	}
	public void setPiirivalvuri_seadus_intsidendi(Collection<Piirivalvuri_seadus_intsidendi> param) {
	    this.piirivalvuri_seadus_intsidendi = param;
	}
	
	@SuppressWarnings("unchecked")
	public static List<Seaduse_punkt> findAllSeadusePunktsWithout(Seaduse_punkt sp) {
    	Query q = entityManager().createQuery("SELECT o FROM seaduse_punkt o WHERE o.seaduse_punkt!=:sp and o.suletud=:d", Seaduse_punkt.class);
    	q.setParameter("d", SURROGATE_DATE);
        return q.getResultList();
    }
	
	@SuppressWarnings("unchecked")
	public static List<Seaduse_punkt> findAllSeadusePunktsWithout2(Piirivalvur_intsidendis pi) {
    	Query q = entityManager().createQuery("SELECT o FROM Seaduse_punkt o WHERE o NOT IN(SELECT o1 from Seaduse_punkt o1 JOIN o1.piirivalvuri_seadus_intsidendi psi WHERE psi.piirivalvur_intsidendis=:pi and psi.suletud=:d) and o.suletud=:d", Seaduse_punkt.class);
    	q.setParameter("pi", pi);
    	q.setParameter("d", SURROGATE_DATE);
        return q.getResultList();
    }
	
	
}
