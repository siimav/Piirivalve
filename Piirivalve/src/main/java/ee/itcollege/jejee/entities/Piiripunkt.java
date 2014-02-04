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
public class Piiripunkt extends BaseEntity {

	private static final long serialVersionUID = 1L;

	@NotNull
	private String kood;
	@NotNull
	private String nimetus;
	@NotNull
	private String GPS_longitude;
	@NotNull
	private String GPS_latitude;
	@NotNull
	private String korgus_merepinnast;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@NotNull
	private Date alates;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@NotNull
	private Date kuni;
	private String kommentaar;

	@OneToMany(mappedBy = "piiripunkt")
	private Collection<Vahtkond> vahtkond;
	
	public Piiripunkt() {
		super();
	}

	
	public Piiripunkt(String kood, String nimetus, String gPS_longitude,
			String gPS_latitude, String korgus_merepinnast, Date alates,
			Date kuni, String kommentaar) {
		super();
		this.kood = kood;
		this.nimetus = nimetus;
		this.GPS_longitude = gPS_longitude;
		this.GPS_latitude = gPS_latitude;
		this.korgus_merepinnast = korgus_merepinnast;
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

	public String getGPS_longitude() {
		return GPS_longitude;
	}

	public void setGPS_longitude(String gPS_longitude) {
		GPS_longitude = gPS_longitude;
	}

	public String getGPS_latitude() {
		return GPS_latitude;
	}

	public void setGPS_latitude(String gPS_latitude) {
		GPS_latitude = gPS_latitude;
	}

	public String getKorgus_merepinnast() {
		return korgus_merepinnast;
	}

	public void setKorgus_merepinnast(String korgus_merepinnast) {
		this.korgus_merepinnast = korgus_merepinnast;
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

	public Collection<Vahtkond> getVahtkond() {
	    return vahtkond;
	}

	public void setVahtkond(Collection<Vahtkond> param) {
	    this.vahtkond = param;
	}   
	
   
    public static long countPiiripunkts() {
    	Query q = entityManager().createQuery("SELECT COUNT(o) FROM Piiripunkt o WHERE o.suletud > :date", Long.class);
    	q.setParameter("date", getDate());
        return (Long) q.getSingleResult();
    }
    
    @SuppressWarnings("unchecked")
	public static List<Piiripunkt> findAllPiiripunkts() {
    	Query q = entityManager().createQuery("SELECT o FROM Piiripunkt o WHERE o.suletud > :date", Piiripunkt.class);
    	q.setParameter("date", getDate());
        return q.getResultList();
    }
    
    @SuppressWarnings("unchecked")
	public static List<Piiripunkt> findPiiripunktEntries(int firstResult, int maxResults) {
    	Query q = entityManager().createQuery("SELECT o FROM Piiripunkt o WHERE o.suletud > :date", Piiripunkt.class).setFirstResult(firstResult).setMaxResults(maxResults);
    	q.setParameter("date", getDate());
        return q.getResultList();
    }
    
}
