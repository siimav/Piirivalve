package ee.itcollege.jejee.entities;

import java.util.Collection;
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
import ee.itcollege.jejee.entities.Piirivalvuri_seadus_intsidendi;
import javax.persistence.OneToMany;

@RooJavaBean
@RooToString
@RooEntity
@Entity
public class Piirivalvur_intsidendis extends BaseEntity implements Cloneable {
	
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
	
	@NotNull
	@ManyToOne
	private Intsident intsident;
	
	@NotNull
	@ManyToOne
	private Piirivalvur piirivalvur;
	
	@ManyToOne
	private Vahtkond_intsidendis vahtkond_intsidendis;

	@OneToMany(mappedBy = "piirivalvur_intsidendis")
	private Collection<Piirivalvuri_seadus_intsidendi> piirivalvuri_seadus_intsidendi;

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

	public Piirivalvur getPiirivalvur() {
		return piirivalvur;
	}

	public void setPiirivalvur(Piirivalvur piirivalvur) {
		this.piirivalvur = piirivalvur;
	}

	public Vahtkond_intsidendis getVahtkond_intsidendis() {
		return vahtkond_intsidendis;
	}

	public void setVahtkond_intsidendis(Vahtkond_intsidendis vahtkond_intsidendis) {
		this.vahtkond_intsidendis = vahtkond_intsidendis;
	}
	
	
	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	
    public static long countPiirivalvur_intsidendises() {
    	Query q = entityManager().createQuery("SELECT COUNT(o) FROM Piirivalvur_intsidendis o WHERE o.suletud=:d", Long.class);
    	q.setParameter("d", SURROGATE_DATE);
        return (Long) q.getSingleResult();
    }
    
    @SuppressWarnings("unchecked")
	public static List<Piirivalvur_intsidendis> findAllPiirivalvur_intsidendises() {
    	Query q = entityManager().createQuery("SELECT o FROM Piirivalvur_intsidendis o WHERE o.suletud=:d", Piirivalvur_intsidendis.class);
    	q.setParameter("d", SURROGATE_DATE);
        return q.getResultList();
    }
    
    @SuppressWarnings("unchecked")
	public static List<Piirivalvur_intsidendis> findPiirivalvur_intsidendisEntries(int firstResult, int maxResults) {
    	Query q = entityManager().createQuery("SELECT o FROM Piirivalvur_intsidendis o WHERE o.suletud=:d", Piirivalvur_intsidendis.class).setFirstResult(firstResult).setMaxResults(maxResults);
    	q.setParameter("d", SURROGATE_DATE);
        return q.getResultList();
    }
	
	
	 @SuppressWarnings("unchecked")
		public static List<Piirivalvur_intsidendis> findAllPiirivalvurIntsidentsForPiiriloik(Piiriloik piir) {
	    	Query q = entityManager().createQuery("SELECT pi FROM Piirivalvur_intsidendis pi JOIN pi.intsident i WHERE i.piiriloik=:piir AND pi.suletud=:d", Piirivalvur_intsidendis.class);
	    	q.setParameter("piir", piir);
	    	q.setParameter("d", SURROGATE_DATE);
	        return q.getResultList();
	    }
	
		@SuppressWarnings("unchecked")
		public static List<Piirivalvur_intsidendis> findAllPiirivalvurIntsidentsForPiiriloikWithInterval(Piiriloik piir, Date alates, Date kuni) {
	    	Query q = entityManager().createQuery("SELECT pi FROM Piirivalvur_intsidendis pi JOIN pi.intsident i WHERE pi.suletud=:d AND i.piiriloik=:piir and (pi.alates>=:alates and pi.kuni<=:kuni)", Piirivalvur_intsidendis.class);
	    	q.setParameter("piir", piir);
	    	q.setParameter("alates", alates);
	    	q.setParameter("kuni", kuni);
	    	q.setParameter("d", SURROGATE_DATE);
	        return q.getResultList();
	    }
		
		@SuppressWarnings("unchecked")
		public static List<Piirivalvur_intsidendis> findAllPiirivalvurIntsidentsWithInterval(Date alates, Date kuni) {
	    	Query q = entityManager().createQuery("SELECT pi FROM Piirivalvur_intsidendis pi WHERE pi.alates>=:alates and pi.kuni<=:kuni AND pi.suletud=:d", Piirivalvur_intsidendis.class);
	    	q.setParameter("alates", alates);
	    	q.setParameter("kuni", kuni);
	    	q.setParameter("d", SURROGATE_DATE);
	        return q.getResultList();
	    }
		
		@SuppressWarnings("unchecked")
		public static List<Piirivalvur_intsidendis> findAllPiirivalvurIntsidentsForPiirivalvur(Piirivalvur piirivalvur) {
	    	Query q = entityManager().createQuery("SELECT pi FROM Piirivalvur_intsidendis pi WHERE pi.piirivalvur=:piirivalvur AND pi.suletud=:d", Piirivalvur_intsidendis.class);
	    	q.setParameter("piirivalvur", piirivalvur);
	    	q.setParameter("d", SURROGATE_DATE);
	        return q.getResultList();
	    }

		@SuppressWarnings("unchecked")
		public static Collection<Piirivalvur_intsidendis> findAllPiirivalvurIntsidendisForIntsident(Intsident ints) {
	    	Query q = entityManager().createQuery("SELECT pi FROM Piirivalvur_intsidendis pi WHERE pi.intsident=:ints AND pi.suletud=:d", Piirivalvur_intsidendis.class);
	    	q.setParameter("ints", ints);
	    	q.setParameter("d", SURROGATE_DATE);
	        return q.getResultList();
		}

		public Collection<Piirivalvuri_seadus_intsidendi> getPiirivalvuri_seadus_intsidendi() {
		    return piirivalvuri_seadus_intsidendi;
		}

		public void setPiirivalvuri_seadus_intsidendi(Collection<Piirivalvuri_seadus_intsidendi> param) {
		    this.piirivalvuri_seadus_intsidendi = param;
		}
	
	
}
