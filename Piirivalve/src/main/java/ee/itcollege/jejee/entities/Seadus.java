package ee.itcollege.jejee.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Query;
import javax.validation.constraints.NotNull;

import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.tostring.RooToString;
import ee.itcollege.jejee.entities.Seaduse_punkt;
import java.util.Collection;
import javax.persistence.OneToMany;

@Entity
@RooEntity
@RooToString
public class Seadus extends BaseEntity {

	private static final long serialVersionUID = 1L;

	@NotNull
	private String kood;
	@NotNull
	private String nimetus;
	private String kehtiv_alates;
	private String kehtiv_kuni;
	@NotNull
	private String kommentaar;

	@OneToMany(mappedBy = "seadus")
	private Collection<Seaduse_punkt> seaduse_punkt;
	
	public Seadus() {
		super();
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

	public String getKehtiv_alates() {
		return kehtiv_alates;
	}

	public void setKehtiv_alates(String kehtiv_alates) {
		this.kehtiv_alates = kehtiv_alates;
	}

	public String getKehtiv_kuni() {
		return kehtiv_kuni;
	}

	public void setKehtiv_kuni(String kehtiv_kuni) {
		this.kehtiv_kuni = kehtiv_kuni;
	}

	public String getKommentaar() {
		return kommentaar;
	}

	public void setKommentaar(String kommentaar) {
		this.kommentaar = kommentaar;
	}
	
	
    public static long countSeaduses() {
    	Query q = entityManager().createQuery("SELECT COUNT(o) FROM Seadus o WHERE o.suletud=:d", Long.class);
    	q.setParameter("d", SURROGATE_DATE);
    	return (Long) q.getSingleResult();
    }
    
    @SuppressWarnings("unchecked")
	public static List<Seadus> findAllSeaduses() {
    	Query q = entityManager().createQuery("SELECT o FROM Seadus o WHERE o.suletud=:d", Seadus.class);
    	q.setParameter("d", SURROGATE_DATE);
        return q.getResultList();
    }
    
    @SuppressWarnings("unchecked")
	public static List<Seadus> findSeadusEntries(int firstResult, int maxResults) {
    	Query q = entityManager().createQuery("SELECT o FROM Seadus o WHERE o.suletud=:d", Seadus.class).setFirstResult(firstResult).setMaxResults(maxResults);
    	q.setParameter("d", SURROGATE_DATE);
        return q.getResultList();
    }

	public Collection<Seaduse_punkt> getSeaduse_punkt() {
	    return seaduse_punkt;
	}

	public void setSeaduse_punkt(Collection<Seaduse_punkt> param) {
	    this.seaduse_punkt = param;
	}

}
