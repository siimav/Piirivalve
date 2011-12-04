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
public class Vahtkond_piiriloigul extends BaseEntity {

	private static final long serialVersionUID = 1L;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date alates;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date kuni;
	private String kommentaar;
	
	@NotNull
	@ManyToOne
	private Piiriloik piiriloik;
	
	@NotNull
	@ManyToOne
	private Vahtkond vahtkond;

	public Vahtkond_piiriloigul(){
		super();
	}
	
	public Vahtkond_piiriloigul(Date alates, Date kuni, String kommentaar,
			Piiriloik piiriloik, Vahtkond vahtkond) {
		super();
		this.alates = alates;
		this.kuni = kuni;
		this.kommentaar = kommentaar;
		this.piiriloik = piiriloik;
		this.vahtkond = vahtkond;
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
	
	public Piiriloik getPiiriloik() {
		return piiriloik;
	}
	
	public void setPiiriloik(Piiriloik piiriloik) {
		this.piiriloik = piiriloik;
	}
	
	public Vahtkond getVahtkond() {
		return vahtkond;
	}
	
	public void setVahtkond(Vahtkond vahtkond) {
		this.vahtkond = vahtkond;
	}
	
	
    public static long countVahtkond_piiriloiguls() {
    	Query q = entityManager().createQuery("SELECT COUNT(o) FROM Vahtkond_piiriloigul o WHERE o.suletud=:d", Long.class);
    	q.setParameter("d", SURROGATE_DATE);
        return (Long) q.getSingleResult();
    }
    
    @SuppressWarnings("unchecked")
	public static List<Vahtkond_piiriloigul> findAllVahtkond_piiriloiguls() {
    	Query q = entityManager().createQuery("SELECT o FROM Vahtkond_piiriloigul o WHERE o.suletud=:d", Vahtkond_piiriloigul.class);
    	q.setParameter("d", SURROGATE_DATE);
        return q.getResultList();
    }
    
    @SuppressWarnings("unchecked")
	public static List<Vahtkond_piiriloigul> findVahtkond_piiriloigulEntries(int firstResult, int maxResults) {
    	Query q = entityManager().createQuery("SELECT o FROM Vahtkond_piiriloigul o WHERE o.suletud=:d", Vahtkond_piiriloigul.class).setFirstResult(firstResult).setMaxResults(maxResults);
    	q.setParameter("d", SURROGATE_DATE);
        return q.getResultList();
    }
	
}
