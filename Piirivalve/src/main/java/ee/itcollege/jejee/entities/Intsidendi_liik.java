package ee.itcollege.jejee.entities;

import java.util.Collection;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Query;

import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.tostring.RooToString;

@RooToString
@RooEntity
@Entity
public class Intsidendi_liik  extends BaseEntity {

	private static final long serialVersionUID = 1L;

	private String kood;
	private String nimetus;
	private String kommentaar;

	@OneToMany(mappedBy = "intsidendi_liik")
	private Collection<Intsident> intsident;

	public Intsidendi_liik(){
		super();
	}
	
	public Intsidendi_liik(String kood, String nimetus, String kommentaar) {
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
	public Collection<Intsident> getIntsident() {
	    return intsident;
	}
	public void setIntsident(Collection<Intsident> param) {
	    this.intsident = param;
	}
	
	
    public static long countIntsidendi_liiks() {
    	Query q = entityManager().createQuery("SELECT COUNT(o) FROM Intsidendi_liik o WHERE o.suletud > :date", Long.class);
    	q.setParameter("date", getDate());
        return (Long) q.getSingleResult();
    }
    
    @SuppressWarnings("unchecked")
	public static List<Intsidendi_liik> findAllIntsidendi_liiks() {
    	Query q = entityManager().createQuery("SELECT o FROM Intsidendi_liik o WHERE o.suletud > :date", Intsidendi_liik.class);
    	q.setParameter("date", getDate());
        return q.getResultList();
    }
    
    @SuppressWarnings("unchecked")
	public static List<Intsidendi_liik> findIntsidendi_liikEntries(int firstResult, int maxResults) {
    	Query q = entityManager().createQuery("SELECT o FROM Intsidendi_liik o WHERE o.suletud > :date", Intsidendi_liik.class).setFirstResult(firstResult).setMaxResults(maxResults);
    	q.setParameter("date", getDate());
        return q.getResultList();
    }
	
}
