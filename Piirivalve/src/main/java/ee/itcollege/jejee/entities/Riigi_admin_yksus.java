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
public class Riigi_admin_yksus extends BaseEntity {

	private static final long serialVersionUID = 1L;

	private String kood;
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
	private Riigi_admin_yksuse_liik riigi_admin_yksuse_liik;
	
	@OneToMany(mappedBy = "riigi_admin_yksus")
	private Collection<Vaeosa> vaeosa;

	public Riigi_admin_yksus() {
		super();
	}
	
	public Riigi_admin_yksus(String kood, String nimetus, Date alates,
			Date kuni, String kommentaar,
			Riigi_admin_yksuse_liik riigi_admin_yksuse_liik) {
		super();
		this.kood = kood;
		this.nimetus = nimetus;
		this.alates = alates;
		this.kuni = kuni;
		this.kommentaar = kommentaar;
		this.riigi_admin_yksuse_liik = riigi_admin_yksuse_liik;
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
	
	public Riigi_admin_yksuse_liik getRiigi_admin_yksuse_liik() {
	    return riigi_admin_yksuse_liik;
	}
	
	public void setRiigi_admin_yksuse_liik(Riigi_admin_yksuse_liik param) {
	    this.riigi_admin_yksuse_liik = param;
	}
	
	public Collection<Vaeosa> getVaeosa() {
	    return vaeosa;
	}
	
	public void setVaeosa(Collection<Vaeosa> param) {
	    this.vaeosa = param;
	}
	
	
    public static long countRiigi_admin_yksuses() {
    	Query q = entityManager().createQuery("SELECT COUNT(o) FROM Riigi_admin_yksus o WHERE o.suletud > :date", Long.class);
    	q.setParameter("date", getDate());
        return (Long) q.getSingleResult();
    }
    
    @SuppressWarnings("unchecked")
	public static List<Riigi_admin_yksus> findAllRiigi_admin_yksuses() {
    	Query q = entityManager().createQuery("SELECT o FROM Riigi_admin_yksus o WHERE o.suletud > :date", Riigi_admin_yksus.class);
    	q.setParameter("date", getDate());
        return q.getResultList();
    }
    
    @SuppressWarnings("unchecked")
	public static List<Riigi_admin_yksus> findRiigi_admin_yksusEntries(int firstResult, int maxResults) {
    	Query q = entityManager().createQuery("SELECT o FROM Riigi_admin_yksus o WHERE o.suletud > :date", Riigi_admin_yksus.class).setFirstResult(firstResult);
    	q.setParameter("date", getDate());
        return q.setMaxResults(maxResults).getResultList();
    }
   
}
