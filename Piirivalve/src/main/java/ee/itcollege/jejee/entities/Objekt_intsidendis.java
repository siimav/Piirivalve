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
public class Objekt_intsidendis extends BaseEntity {

	private static final long serialVersionUID = 1L;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date alates;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date kuni;
	private String kirjeldus;
	private String kommentaar;
	
	@NotNull
	@ManyToOne
	private Intsident intsident;
	
	@NotNull
	@ManyToOne
	private Objekt objekt;
	
	public Objekt_intsidendis() {
		
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

	public Objekt getObjekt() {
		return objekt;
	}

	public void setObjekt(Objekt objekt) {
		this.objekt = objekt;
	}

    
    @SuppressWarnings("unchecked")
	public static List<Objekt_intsidendis> findAllObjekt_intsidendisForIntsident(Intsident ints) {
    	Query q = entityManager().createQuery("SELECT o FROM Objekt_intsidendis o WHERE o.intsident=:ints", Objekt_intsidendis.class);
    	q.setParameter("ints", ints);
        return q.getResultList();
    }
	
}
