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
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooEntity
@Entity
public class Vahtkond_intsidendis extends BaseEntity implements Cloneable {
	
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
	private Vahtkond vahtkond;
	
	@OneToMany(mappedBy = "vahtkond_intsidendis")
	private Collection<Piirivalvur_intsidendis> piirivalvurid_intsidendis;

	public Vahtkond_intsidendis(){
		super();
	}
	
	public Vahtkond_intsidendis(Date alates, Date kuni, String kirjeldus,
			String kommentaar, Intsident intsident, Vahtkond vahtkond) {
		super();
		this.alates = alates;
		this.kuni = kuni;
		this.kirjeldus = kirjeldus;
		this.kommentaar = kommentaar;
		this.intsident = intsident;
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

	public Vahtkond getVahtkond() {
		return vahtkond;
	}

	public void setVahtkond(Vahtkond vahtkond) {
		this.vahtkond = vahtkond;
	}

	public Collection<Piirivalvur_intsidendis> getPiirivalvurid_intsidendis() {
		return piirivalvurid_intsidendis;
	}

	public void setPiirivalvurid_intsidendis(Collection<Piirivalvur_intsidendis> piirivalvurid_intsidendis) {
		this.piirivalvurid_intsidendis = piirivalvurid_intsidendis;
	}
	
	
	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	
    public static long countVahtkond_intsidendises() {
    	Query q = entityManager().createQuery("SELECT COUNT(o) FROM Vahtkond_intsidendis o WHERE o.suletud > :date", Long.class);
    	q.setParameter("date", getDate());
        return (Long) q.getSingleResult();
    }
    
    @SuppressWarnings("unchecked")
	public static List<Vahtkond_intsidendis> findAllVahtkond_intsidendises() {
    	Query q = entityManager().createQuery("SELECT o FROM Vahtkond_intsidendis o WHERE o.suletud > :date", Vahtkond_intsidendis.class);
    	q.setParameter("date", getDate());
        return q.getResultList();
    }
    
    @SuppressWarnings("unchecked")
	public static List<Vahtkond_intsidendis> findVahtkond_intsidendisEntries(int firstResult, int maxResults) {
    	Query q = entityManager().createQuery("SELECT o FROM Vahtkond_intsidendis o WHERE o.suletud > :date", Vahtkond_intsidendis.class).setFirstResult(firstResult).setMaxResults(maxResults);
    	q.setParameter("date", getDate());
        return q.getResultList();
    }


	@SuppressWarnings("unchecked")
	public static Collection<Vahtkond_intsidendis> findAllVahtkonnadIntsidendisForIntsident(Intsident ints) {
    	Query q = entityManager().createQuery("SELECT vi FROM Vahtkond_intsidendis vi WHERE vi.intsident=:ints AND vi.suletud > :date", Vahtkond_intsidendis.class);
    	q.setParameter("ints", ints);
    	q.setParameter("date", getDate());
        return q.getResultList();
	}

}
