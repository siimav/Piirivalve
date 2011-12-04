package ee.itcollege.jejee.entities;

import java.util.Collection;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Query;
import javax.validation.constraints.NotNull;

import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.tostring.RooToString;

@Entity
@RooEntity
@RooToString
public class Objekti_liik extends BaseEntity {

	private static final long serialVersionUID = 1L;

	private String kood;
	@NotNull
	private String nimetus;
	private String kommentaar;
	
	@OneToMany(mappedBy = "objekti_liik")
	private Collection<Objekt> objekt;

	public Objekti_liik() {
		super();
	}
	

	public Objekti_liik(String kood, String nimetus, String kommentaar) {
		super();
		this.kood = kood;
		this.nimetus = nimetus;
		this.kommentaar = kommentaar;
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

	public Collection<Objekt> getObjekt() {
	    return objekt;
	}

	public void setObjekt(Collection<Objekt> param) {
	    this.objekt = param;
	}

	
    public static long countObjekti_liiks() {
    	Query q = entityManager().createQuery("SELECT COUNT(o) FROM Objekti_liik o WHERE o.suletud=:d", Long.class);
    	q.setParameter("d", SURROGATE_DATE);
        return (Long) q.getSingleResult();
    }
    
    @SuppressWarnings("unchecked")
	public static List<Objekti_liik> findAllObjekti_liiks() {
    	Query q = entityManager().createQuery("SELECT o FROM Objekti_liik o WHERE o.suletud=:d", Objekti_liik.class);
    	q.setParameter("d", SURROGATE_DATE);
        return q.getResultList();
    }
    
    @SuppressWarnings("unchecked")
	public static List<Objekti_liik> findObjekti_liikEntries(int firstResult, int maxResults) {
    	Query q = entityManager().createQuery("SELECT o FROM Objekti_liik o WHERE o.suletud=:d", Objekti_liik.class).setFirstResult(firstResult).setMaxResults(maxResults);
    	q.setParameter("d", SURROGATE_DATE);
        return q.getResultList();
    }
   
}
