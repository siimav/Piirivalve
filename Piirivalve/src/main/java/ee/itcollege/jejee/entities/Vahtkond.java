package ee.itcollege.jejee.entities;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Query;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.tostring.RooToString;

@Entity
@RooEntity
@RooToString
public class Vahtkond extends BaseEntity {

	private static final long serialVersionUID = 1L;

	private String kood;
	private String nimetus;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date alates;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date kuni;
	private String kommentaar;

	@OneToMany(mappedBy = "vahtkond")
	private Collection<Vahtkonna_liige> vahtkonna_liige;

	@ManyToOne
	private Vaeosa vaeosa;

	@OneToMany(mappedBy = "vahtkond")
	private Collection<Vahtkond_piiriloigul> vahtkond_piiriloigul;

	@ManyToOne
	private Piiripunkt piiripunkt;
	
	@OneToMany(mappedBy = "vahtkond")
	private Collection<Vahtkond_intsidendis> vahtkonnad_intsidendis;

	public Vahtkond() {
		super();
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

	public Collection<Vahtkonna_liige> getVahtkonna_liige() {
		return vahtkonna_liige;
	}

	public void setVahtkonna_liige(Collection<Vahtkonna_liige> param) {
		this.vahtkonna_liige = param;
	}

	public Vaeosa getVaeosa() {
		return vaeosa;
	}

	public void setVaeosa(Vaeosa param) {
		this.vaeosa = param;
	}

	public Collection<Vahtkond_piiriloigul> getVahtkond_piiriloigul() {
		return vahtkond_piiriloigul;
	}

	public void setVahtkond_piiriloigul(Collection<Vahtkond_piiriloigul> param) {
		this.vahtkond_piiriloigul = param;
	}

	public void setPiiripunkt(Piiripunkt param) {
		this.piiripunkt = param;
	}

	public Piiripunkt getPiiripunkt() {
		return piiripunkt;
	}	
	
    public Collection<Vahtkond_intsidendis> getVahtkonnad_intsidendis() {
		return vahtkonnad_intsidendis;
	}

	public void setVahtkonnad_intsidendis(Collection<Vahtkond_intsidendis> vahtkonnad_intsidendis) {
		this.vahtkonnad_intsidendis = vahtkonnad_intsidendis;
	}
	

	@SuppressWarnings("unchecked")
	public static List<Vahtkond> findAllVahtkonnadForIntsident(Intsident ints) {
    	Query q = entityManager().createQuery("SELECT o FROM Vahtkond o JOIN o.vahtkonnad_intsidendis vi WHERE vi.intsident=:ints", Vahtkond.class);
    	q.setParameter("ints", ints);
        return q.getResultList();
    }

    @SuppressWarnings("unchecked")
	public static Collection<Vahtkond> findAllVahtkonnadNotInIntsident(Intsident ints) {
    	Query q = entityManager().createQuery("SELECT o FROM Vahtkond o WHERE o NOT IN (SELECT o1 FROM Vahtkond o1 JOIN o1.vahtkonnad_intsidendis vi WHERE vi.intsident=:ints)", Vahtkond.class);
    	q.setParameter("ints", ints);
        return q.getResultList();
    }

}
