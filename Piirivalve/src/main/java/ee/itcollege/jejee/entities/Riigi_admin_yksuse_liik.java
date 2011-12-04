package ee.itcollege.jejee.entities;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Query;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.tostring.RooToString;

@Entity
@RooEntity
@RooToString
public class Riigi_admin_yksuse_liik extends BaseEntity {

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
	
	@OneToMany(mappedBy = "riigi_admin_yksuse_liik")
	private Collection<Riigi_admin_yksus> riigi_admin_yksus;

	public Riigi_admin_yksuse_liik() {
		super();
	}
	
	public Riigi_admin_yksuse_liik(String kood, String nimetus, Date alates,
			Date kuni, String kommentaar) {
		super();
		this.kood = kood;
		this.nimetus = nimetus;
		this.alates = alates;
		this.kuni = kuni;
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

	public Collection<Riigi_admin_yksus> getRiigi_admin_yksus() {
	    return riigi_admin_yksus;
	}

	public void setRiigi_admin_yksus(Collection<Riigi_admin_yksus> param) {
	    this.riigi_admin_yksus = param;
	}

	
    public static long countRiigi_admin_yksuse_liiks() {
    	Query q = entityManager().createQuery("SELECT COUNT(o) FROM Riigi_admin_yksuse_liik o WHERE o.suletud=:d", Long.class);
    	q.setParameter("d", SURROGATE_DATE);
        return (Long) q.getSingleResult();
    }
    
    @SuppressWarnings("unchecked")
	public static List<Riigi_admin_yksuse_liik> findAllRiigi_admin_yksuse_liiks() {
    	Query q = entityManager().createQuery("SELECT o FROM Riigi_admin_yksuse_liik o WHERE o.suletud=:d", Riigi_admin_yksuse_liik.class);
    	q.setParameter("d", SURROGATE_DATE);
        return q.getResultList();
    }
    
    @SuppressWarnings("unchecked")
	public static List<Riigi_admin_yksuse_liik> findRiigi_admin_yksuse_liikEntries(int firstResult, int maxResults) {
    	Query q = entityManager().createQuery("SELECT o FROM Riigi_admin_yksuse_liik o WHERE o.suletud=:d", Riigi_admin_yksuse_liik.class).setFirstResult(firstResult).setMaxResults(maxResults);
    	q.setParameter("d", SURROGATE_DATE);
    	return q.getResultList();
    }
	  
}

