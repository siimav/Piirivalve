package ee.itcollege.jejee.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Query;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.tostring.RooToString;

@Entity
@RooEntity
@RooToString
public class Vahtkonna_liige extends BaseEntity {

	private static final long serialVersionUID = 1L;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date alates;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date kuni;
	private String kommentaar;

	@ManyToOne
	private Vahtkond vahtkond;

	@ManyToOne
	private Piirivalvur piirivalvur;

	public Vahtkonna_liige() {
		super();
	}
	
	public Vahtkonna_liige(Date alates, Date kuni, String kommentaar,
			Vahtkond vahtkond, Piirivalvur piirivalvur) {
		super();
		this.alates = alates;
		this.kuni = kuni;
		this.kommentaar = kommentaar;
		this.vahtkond = vahtkond;
		this.piirivalvur = piirivalvur;
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

	public String getKommentaar() {
		return kommentaar;
	}

	public void setKommentaar(String kommentaar) {
		this.kommentaar = kommentaar;
	}

	public Vahtkond getVahtkond() {
		return vahtkond;
	}

	public void setVahtkond(Vahtkond param) {
		this.vahtkond = param;
	}

	public void setPiirivalvur(Piirivalvur param) {
		this.piirivalvur = param;
	}

	public Piirivalvur getPiirivalvur() {
		return piirivalvur;
	}
	
	
    public static long countVahtkonna_liiges() {
    	Query q = entityManager().createQuery("SELECT COUNT(o) FROM Vahtkonna_liige o WHERE o.suletud=:d", Long.class);
    	q.setParameter("d", SURROGATE_DATE);
        return (Long) q.getSingleResult();
    }
    
    @SuppressWarnings("unchecked")
	public static List<Vahtkonna_liige> findAllVahtkonna_liiges() {
    	Query q = entityManager().createQuery("SELECT o FROM Vahtkonna_liige o WHERE o.suletud=:d", Vahtkonna_liige.class);
    	q.setParameter("d", SURROGATE_DATE);
        return q.getResultList();
    }
    
    @SuppressWarnings("unchecked")
	public static List<Vahtkonna_liige> findVahtkonna_liigeEntries(int firstResult, int maxResults) {
    	Query q = entityManager().createQuery("SELECT o FROM Vahtkonna_liige o WHERE o.suletud=:d", Vahtkonna_liige.class).setFirstResult(firstResult).setMaxResults(maxResults);
    	q.setParameter("d", SURROGATE_DATE);
        return q.getResultList();
    }

}
