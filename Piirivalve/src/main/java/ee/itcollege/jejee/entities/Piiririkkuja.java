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

@Entity
@RooEntity
@RooToString
public class Piiririkkuja extends BaseEntity {
	
	private static final long serialVersionUID = 1L;

	private String isikukood;
	@NotNull
	private String eesnimi;
	@NotNull
	private String perek_nimi;
	@NotNull
	private String sugu;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date synniaeg;
	private String kommentaar;

	@ManyToOne
	private Objekt objekt;

	@OneToMany(mappedBy = "piiririkkuja")
	private Collection<Isik_intsidendis> isik_intsidendis;

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

	
	public String getName() {
		return eesnimi + " " + perek_nimi;		
	}
	
	
    @SuppressWarnings("unchecked")
	public static List<Piiririkkuja> findAllPiiririkkujadForIntsident(Intsident ints) {
    	Query q = entityManager().createQuery("SELECT o FROM Piiririkkuja o JOIN o.isik_intsidendis ii WHERE ii.intsident=:ints", Piiririkkuja.class);
    	q.setParameter("ints", ints);
        return q.getResultList();
    }
    
    
    @SuppressWarnings("unchecked")
	public static Collection<Piiririkkuja> findAllPiiririkkujadNotInIntsident(Intsident ints) {
    	Query q = entityManager().createQuery("SELECT o FROM Piiririkkuja o WHERE o NOT IN (SELECT o1 FROM Piiririkkuja o1 JOIN o1.isik_intsidendis ii WHERE ii.intsident=:ints)", Piiririkkuja.class);
    	q.setParameter("ints", ints);
        return q.getResultList();
    }
   
}
