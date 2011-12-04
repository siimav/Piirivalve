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
public class Vaeosa extends BaseEntity {

	private static final long serialVersionUID = 1L;

	@NotNull
	private String kood;
	@NotNull
	private String nimetus;	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@NotNull
	private Date alates;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@NotNull
	private Date kuni;
	private String kommentaar;
	
	@ManyToOne
	@NotNull
	private Riigi_admin_yksus riigi_admin_yksus;
	
	@OneToMany(mappedBy = "vaeosa")
	private Collection<Vahtkond> vahtkond;

	public Vaeosa() {
		super();
	}
	
	public Vaeosa(String kood, String nimetus, Date alates, Date kuni,
			String kommentaar, Riigi_admin_yksus riigi_admin_yksus) {
		super();
		this.kood = kood;
		this.nimetus = nimetus;
		this.alates = alates;
		this.kuni = kuni;
		this.kommentaar = kommentaar;
		this.riigi_admin_yksus = riigi_admin_yksus;
		
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

	public Riigi_admin_yksus getRiigi_admin_yksus() {
	    return riigi_admin_yksus;
	}

	public void setRiigi_admin_yksus(Riigi_admin_yksus param) {
	    this.riigi_admin_yksus = param;
	}

	public Collection<Vahtkond> getVahtkond() {
	    return vahtkond;
	}

	public void setVahtkond(Collection<Vahtkond> param) {
	    this.vahtkond = param;
	}
	
	
    public static long countVaeosas() {
    	Query q = entityManager().createQuery("SELECT COUNT(o) FROM Vaeosa o WHERE o.suletud=:d", Long.class);
		q.setParameter("d", SURROGATE_DATE);
        return (Long) q.getSingleResult();
    }
    
    @SuppressWarnings("unchecked")
	public static List<Vaeosa> findAllVaeosas() {
    	Query q = entityManager().createQuery("SELECT o FROM Vaeosa o WHERE o.suletud=:d", Vaeosa.class);
		q.setParameter("d", SURROGATE_DATE);
        return q.getResultList();
    }
    
    @SuppressWarnings("unchecked")
	public static List<Vaeosa> findVaeosaEntries(int firstResult, int maxResults) {
    	Query q = entityManager().createQuery("SELECT o FROM Vaeosa o WHERE o.suletud=:d", Vaeosa.class).setFirstResult(firstResult).setMaxResults(maxResults);
		q.setParameter("d", SURROGATE_DATE);
        return q.getResultList();
    }
   
}
