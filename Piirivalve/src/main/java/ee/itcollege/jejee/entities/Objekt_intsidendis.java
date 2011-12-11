package ee.itcollege.jejee.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Query;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooEntity
@Entity
public class Objekt_intsidendis extends BaseEntity implements Cloneable {

	private static final long serialVersionUID = 1L;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date alates;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date kuni;
	private String kirjeldus;
	private String kommentaar;
	
	@NotNull
	@ManyToOne
	private Intsident intsident;
	
	@NotNull
	@ManyToOne
	private Objekt objekt;
	
	public Objekt_intsidendis() {
		
	}

	public Objekt_intsidendis(Date alates, Date kuni, String kirjeldus,
			String kommentaar, Intsident intsident, Objekt objekt) {
		super();
		this.alates = alates;
		this.kuni = kuni;
		this.kirjeldus = kirjeldus;
		this.kommentaar = kommentaar;
		this.intsident = intsident;
		this.objekt = objekt;
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

	public void setIntsident(Intsident intsident) {
		this.intsident = intsident;
	}

	public Objekt getObjekt() {
		return objekt;
	}

	public void setObjekt(Objekt objekt) {
		this.objekt = objekt;
	}
	
	
	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	
    public static long countObjekt_intsidendises() {
    	Query q = entityManager().createQuery("SELECT COUNT(o) FROM Objekt_intsidendis o WHERE o.suletud > :date", Long.class);
    	q.setParameter("date", getDate());
        return (Long) q.getSingleResult();
    }
    
    @SuppressWarnings("unchecked")
	public static List<Objekt_intsidendis> findAllObjekt_intsidendises() {
    	Query q = entityManager().createQuery("SELECT o FROM Objekt_intsidendis o WHERE o.suletud > :date", Objekt_intsidendis.class);
    	q.setParameter("date", getDate());
    	return q.getResultList();
    }
    
    @SuppressWarnings("unchecked")
	public static List<Objekt_intsidendis> findObjekt_intsidendisEntries(int firstResult, int maxResults) {
    	Query q = entityManager().createQuery("SELECT o FROM Objekt_intsidendis o WHERE o.suletud > :date", Objekt_intsidendis.class).setFirstResult(firstResult).setMaxResults(maxResults);
    	q.setParameter("date", getDate());
        return q.getResultList();
    }

    
    @SuppressWarnings("unchecked")
	public static List<Objekt_intsidendis> findAllObjekt_intsidendisForIntsident(Intsident ints) {
    	Query q = entityManager().createQuery("SELECT o FROM Objekt_intsidendis o WHERE o.intsident=:ints AND o.suletud > :date", Objekt_intsidendis.class);
    	q.setParameter("ints", ints);
    	q.setParameter("date", getDate());
        return q.getResultList();
    }
	
}
