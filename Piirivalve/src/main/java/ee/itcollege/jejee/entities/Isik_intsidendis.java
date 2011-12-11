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

@Entity
@RooEntity
@RooToString
public class Isik_intsidendis extends BaseEntity implements Cloneable {
	
	private static final long serialVersionUID = 1L;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@NotNull
	private Date alates;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@NotNull
	private Date kuni;
	@NotNull
	private String kirjeldus;
	private String kommentaar;

	@ManyToOne
	private Intsident intsident;

	@ManyToOne
	private Piiririkkuja piiririkkuja;

	public Isik_intsidendis() {
		super();
	}
	

	public Isik_intsidendis(Date alates, Date kuni, String kirjeldus,
			String kommentaar, Intsident intsident, Piiririkkuja piiririkkuja) {
		super();
		this.alates = alates;
		this.kuni = kuni;
		this.kirjeldus = kirjeldus;
		this.kommentaar = kommentaar;
		this.intsident = intsident;
		this.piiririkkuja = piiririkkuja;
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

	public Intsident getIntsident() {
	    return intsident;
	}

	public void setIntsident(Intsident param) {
	    this.intsident = param;
	}

	public Piiririkkuja getPiiririkkuja() {
	    return piiririkkuja;
	}

	public void setPiiririkkuja(Piiririkkuja param) {
	    this.piiririkkuja = param;
	}
	
	
	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	
    public static long countIsik_intsidendises() {
    	Query q = entityManager().createQuery("SELECT COUNT(o) FROM Isik_intsidendis o WHERE o.suletud > :date", Long.class);
    	q.setParameter("date", getDate());
        return (Long) q.getSingleResult();
    }
    
    @SuppressWarnings("unchecked")
	public static List<Isik_intsidendis> findAllIsik_intsidendises() {
    	Query q = entityManager().createQuery("SELECT o FROM Isik_intsidendis o WHERE o.suletud > :date", Isik_intsidendis.class);
    	q.setParameter("date", getDate());
        return q.getResultList();
    }
    
    @SuppressWarnings("unchecked")
	public static List<Isik_intsidendis> findIsik_intsidendisEntries(int firstResult, int maxResults) {
    	Query q = entityManager().createQuery("SELECT o FROM Isik_intsidendis o WHERE o.suletud > :date", Isik_intsidendis.class).setFirstResult(firstResult).setMaxResults(maxResults);
    	q.setParameter("date", getDate());
    	return q.getResultList();
    }

	
    @SuppressWarnings("unchecked")
	public static List<Isik_intsidendis> findAllIsik_intsidendisForIntsident(Intsident ints) {
    	Query q = entityManager().createQuery("SELECT o FROM Isik_intsidendis o WHERE o.intsident=:ints AND o.suletud > :date", Isik_intsidendis.class);
    	q.setParameter("ints", ints);
    	q.setParameter("date", getDate());
        return q.getResultList();
    }
	
}
