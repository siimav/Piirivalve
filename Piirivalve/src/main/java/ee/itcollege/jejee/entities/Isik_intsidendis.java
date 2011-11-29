package ee.itcollege.jejee.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Query;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.tostring.RooToString;

@Entity
@RooEntity
@RooToString
public class Isik_intsidendis extends BaseEntity {
	
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

	@ManyToOne
	private Intsident intsident;

	@ManyToOne
	private Piiririkkuja piiririkkuja;

	public Isik_intsidendis() {
		super();
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

	public void setIntsident(Intsident param) {
	    this.intsident = param;
	}

	public Piiririkkuja getPiiririkkuja() {
	    return piiririkkuja;
	}

	public void setPiiririkkuja(Piiririkkuja param) {
	    this.piiririkkuja = param;
	}

	
    @SuppressWarnings("unchecked")
	public static List<Isik_intsidendis> findAllIsik_intsidendisForIntsident(Intsident ints) {
    	Query q = entityManager().createQuery("SELECT o FROM Isik_intsidendis o WHERE o.intsident=:ints", Isik_intsidendis.class);
    	q.setParameter("ints", ints);
        return q.getResultList();
    }
	
}
