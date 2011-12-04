package ee.itcollege.jejee.entities;

import java.util.Collection;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Query;
import javax.validation.constraints.NotNull;

import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.tostring.RooToString;

@Entity
@RooEntity
@RooToString
public class Objekt extends BaseEntity {
	
	private static final long serialVersionUID = 1L;

	private String nimetus;
	private String kommentaar;
		
	@ManyToOne
	@NotNull
	private Objekti_liik objekti_liik;

	@OneToMany(mappedBy = "objekt")
	private Collection<Objekt_intsidendis> objekt_intsidendis;

	@OneToMany(mappedBy = "objekt")
	private Collection<Piiririkkuja> piiririkkuja;

	public Objekt() {
		super();
	}
	

	public Objekt(String nimetus, String kommentaar, Objekti_liik objekti_liik) {
		super();
		this.nimetus = nimetus;
		this.kommentaar = kommentaar;
		this.objekti_liik = objekti_liik;
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

	public Collection<Piiririkkuja> getPiiririkkuja() {
	    return piiririkkuja;
	}

	public void setPiiririkkuja(Collection<Piiririkkuja> param) {
	    this.piiririkkuja = param;
	}
	
	
    public static long countObjekts() {
    	Query q = entityManager().createQuery("SELECT COUNT(o) FROM Objekt o WHERE o.suletud=:d", Long.class);
    	q.setParameter("d", SURROGATE_DATE);
        return (Long) q.getSingleResult();
    }
    
    @SuppressWarnings("unchecked")
	public static List<Objekt> findAllObjekts() {
    	Query q = entityManager().createQuery("SELECT o FROM Objekt o WHERE o.suletud=:d", Objekt.class);
    	q.setParameter("d", SURROGATE_DATE);
        return q.getResultList();
    }
    
    @SuppressWarnings("unchecked")
	public static List<Objekt> findObjektEntries(int firstResult, int maxResults) {
    	Query q = entityManager().createQuery("SELECT o FROM Objekt o WHERE o.suletud=:d", Objekt.class).setFirstResult(firstResult).setMaxResults(maxResults);
    	q.setParameter("d", SURROGATE_DATE);
        return q.getResultList();
    }
	

    @SuppressWarnings("unchecked")
	public static List<Objekt> findAllObjektidForIntsident(Intsident ints) {
    	Query q = entityManager().createQuery("SELECT o FROM Objekt o JOIN o.objekt_intsidendis oi WHERE oi.intsident=:ints AND o.suletud=:d", Objekt.class);
    	q.setParameter("ints", ints);
    	q.setParameter("d", SURROGATE_DATE);
        return q.getResultList();
    }
    
    @SuppressWarnings("unchecked")
	public static Collection<Objekt> findAllObjektidNotInIntsident(Intsident ints) {
    	Query q = entityManager().createQuery("SELECT o FROM Objekt o WHERE o NOT IN (SELECT o1 FROM Objekt o1 JOIN o1.objekt_intsidendis oi WHERE oi.intsident=:ints) AND o.suletud=:d", Objekt.class);
    	q.setParameter("ints", ints);
    	q.setParameter("d", SURROGATE_DATE);
        return q.getResultList();
    }
   
}
