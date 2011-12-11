package ee.itcollege.jejee.entities;

import java.util.Collection;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Query;

import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.tostring.RooToString;

@Entity
@RooEntity
@RooToString
public class Piirivalvur extends BaseEntity {

	private static final long serialVersionUID = 1L;

	private String isikukood;
	private String eesnimed;
	private String perekonnanimi;
	private String sugu;
	private String soduri_kood;
	private String kommentaar;

	@OneToMany(mappedBy = "piirivalvur")
	private Collection<Vahtkonna_liige> vahtkonna_liige;
	
	@OneToMany(mappedBy = "piirivalvur")
	private Collection<Piirivalvur_intsidendis> piirivalvur_intsidendis;
	
	
	public Piirivalvur() {
		super();
	}
	
	public Piirivalvur(String isikukood, String eesnimed, String perekonnanimi,
			String sugu, String soduri_kood, String kommentaar) {
		super();
		this.isikukood = isikukood;
		this.eesnimed = eesnimed;
		this.perekonnanimi = perekonnanimi;
		this.sugu = sugu;
		this.soduri_kood = soduri_kood;
		this.kommentaar = kommentaar;
	}



	public String getIsikukood() {
		return this.isikukood;
	}

	public void setIsikukood(String isikukood) {
		this.isikukood = isikukood;
	}

	public String getEesnimed() {
		return this.eesnimed;
	}

	public void setEesnimed(String eesnimed) {
		this.eesnimed = eesnimed;
	}

	public String getPerekonnanimi() {
		return this.perekonnanimi;
	}

	public void setPerekonnanimi(String perekonnanimi) {
		this.perekonnanimi = perekonnanimi;
	}

	public String getSugu() {
		return this.sugu;
	}

	public void setSugu(String sugu) {
		this.sugu = sugu;
	}

	public String getSoduri_kood() {
		return this.soduri_kood;
	}

	public void setSoduri_kood(String soduri_kood) {
		this.soduri_kood = soduri_kood;
	}

	public String getKommentaar() {
		return this.kommentaar;
	}

	public void setKommentaar(String kommentaar) {
		this.kommentaar = kommentaar;
	}

	public Collection<Vahtkonna_liige> getVahtkonna_liige() {
	    return vahtkonna_liige;
	}

	public void setVahtkonna_liige(Collection<Vahtkonna_liige> param) {
	    this.vahtkonna_liige = param;
	}

	public Collection<Piirivalvur_intsidendis> getPiirivalvur_intsidendis() {
		return piirivalvur_intsidendis;
	}

	public void setPiirivalvur_intsidendis(Collection<Piirivalvur_intsidendis> piirivalvur_intsidendis) {
		this.piirivalvur_intsidendis = piirivalvur_intsidendis;
	}
	
	
	public String getName() {
		return eesnimed + " " + perekonnanimi;
	}
	
	
    public static long countPiirivalvurs() {
    	Query q = entityManager().createQuery("SELECT COUNT(o) FROM Piirivalvur o WHERE o.suletud > :date", Long.class);
    	q.setParameter("date", getDate());
        return (Long) q.getSingleResult();
    }
    
    @SuppressWarnings("unchecked")
	public static List<Piirivalvur> findAllPiirivalvurs() {
    	Query q = entityManager().createQuery("SELECT o FROM Piirivalvur o WHERE o.suletud > :date", Piirivalvur.class);
    	q.setParameter("date", getDate());
        return q.getResultList();
    }
    
    @SuppressWarnings("unchecked")
	public static List<Piirivalvur> findPiirivalvurEntries(int firstResult, int maxResults) {
    	Query q = entityManager().createQuery("SELECT o FROM Piirivalvur o WHERE o.suletud > :date", Piirivalvur.class).setFirstResult(firstResult).setMaxResults(maxResults);
    	q.setParameter("date", getDate());
        return q.getResultList();
    }
	
	
    @SuppressWarnings("unchecked")
	public static List<Piirivalvur> findAllPiirivalvuridForIntsident(Intsident ints) {
    	Query q = entityManager().createQuery("SELECT o FROM Piirivalvur o JOIN o.piirivalvur_intsidendis pi WHERE pi.intsident=:ints AND o.suletud > :date", Piirivalvur.class);
    	q.setParameter("ints", ints);
    	q.setParameter("date", getDate());
        return q.getResultList();
    }    
    
    @SuppressWarnings("unchecked")
	public static List<Piirivalvur> findAllPiirivalvuridNotInIntsident(Intsident ints) {
    	Query q = entityManager().createQuery("SELECT o FROM Piirivalvur o WHERE o.suletud > :date AND o NOT IN (SELECT o1 FROM Piirivalvur o1 JOIN o1.piirivalvur_intsidendis pi WHERE pi.intsident=:ints)", Piirivalvur.class);
    	q.setParameter("ints", ints);
    	q.setParameter("date", getDate());
        return q.getResultList();
    }
    
    
    
    @SuppressWarnings("unchecked")
	public static List<Piirivalvur> findAllPiirivalvuridForPiiriloik(Piiriloik piir) {
    	Query q = entityManager().createQuery("SELECT p FROM Piirivalvur p JOIN p.piirivalvur_intsidendis pi WHERE pi.intsident.piiriloik=:piir AND p.suletud > :date", Piirivalvur.class);
    	q.setParameter("piir", piir);
    	q.setParameter("date", getDate());
        return q.getResultList();
    }

    @SuppressWarnings("unchecked")
	public static List<Piirivalvur> findAllPiirivalvuridExceptFor(Piirivalvur piirivalvur) {
    	Query q = entityManager().createQuery("SELECT p FROM Piirivalvur p WHERE p!=:piirivalvur AND p.suletud > :date", Piirivalvur.class);
    	q.setParameter("piirivalvur", piirivalvur);
    	q.setParameter("date", getDate());
        return q.getResultList();
    }

}
