package ee.itcollege.jejee.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Query;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.tostring.RooToString;
import ee.itcollege.jejee.entities.Vahtkonna_liige;
import javax.persistence.OneToMany;
import java.util.Collection;

/**
 * Entity implementation class for Entity: Piirivalvur
 * 
 */
@Entity
@RooEntity
@RooToString
public class Piirivalvur implements Serializable {

	private static final long serialVersionUID = 1L;

	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private Long piirivalvur_ID;
	private String isikukood;
	private String eesnimed;
	private String perekonnanimi;
	private String sugu;
	private String soduri_kood;
	@NotNull
	private String avaja;
	@DateTimeFormat(style = "M-")
	@NotNull
	private Date avatud;
	private String sulgeja;
	@DateTimeFormat(style = "M-")
	@NotNull
	private Date suletud;
	@NotNull
	private String muutja;
	@DateTimeFormat(style = "M-")
	@NotNull
	private Date muudetud;
	private String kommentaar;

	@OneToMany(mappedBy = "piirivalvur")
	private Collection<Vahtkonna_liige> vahtkonna_liige;
	
	@OneToMany(mappedBy = "piirivalvur")
	private Collection<Piirivalvur_intsidendis> piirivalvur_intsidendis;
	
	
	public Piirivalvur() {
		super();
	}

	public Long getPiirivalvur_ID() {
		return this.piirivalvur_ID;
	}

	public void setPiirivalvur_ID(Long piirivalvur_ID) {
		this.piirivalvur_ID = piirivalvur_ID;
	}

	public String getIsikukood() {
		return this.isikukood;
	}

	public void setIsikukood(String isikukood) {
		this.isikukood = isikukood;
	}

	public String getEesnimed() {
		return this.eesnimed;
	}

	public void setEesnimed(String eesnimed) {
		this.eesnimed = eesnimed;
	}

	public String getPerekonnanimi() {
		return this.perekonnanimi;
	}

	public void setPerekonnanimi(String perekonnanimi) {
		this.perekonnanimi = perekonnanimi;
	}

	public String getSugu() {
		return this.sugu;
	}

	public void setSugu(String sugu) {
		this.sugu = sugu;
	}

	public String getSoduri_kood() {
		return this.soduri_kood;
	}

	public void setSoduri_kood(String soduri_kood) {
		this.soduri_kood = soduri_kood;
	}

	public String getAvaja() {
		return this.avaja;
	}

	public void setAvaja(String avaja) {
		this.avaja = avaja;
	}

	public Date getAvatud() {
		return this.avatud;
	}

	public void setAvatud(Date avatud) {
		this.avatud = avatud;
	}

	public String getSulgeja() {
		return this.sulgeja;
	}

	public void setSulgeja(String sulgeja) {
		this.sulgeja = sulgeja;
	}

	public Date getSuletud() {
		return this.suletud;
	}

	public void setSuletud(Date suletud) {
		this.suletud = suletud;
	}

	public String getMuutja() {
		return this.muutja;
	}

	public void setMuutja(String muutja) {
		this.muutja = muutja;
	}

	public Date getMuudetud() {
		return this.muudetud;
	}

	public void setMuudetud(Date muudetud) {
		this.muudetud = muudetud;
	}

	public String getKommentaar() {
		return this.kommentaar;
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

	public Collection<Piirivalvur_intsidendis> getPiirivalvur_intsidendis() {
		return piirivalvur_intsidendis;
	}

	public void setPiirivalvur_intsidendis(Collection<Piirivalvur_intsidendis> piirivalvur_intsidendis) {
		this.piirivalvur_intsidendis = piirivalvur_intsidendis;
	}
	
	
	public String getName() {
		return eesnimed + " " + perekonnanimi;
	}
	
	
    @SuppressWarnings("unchecked")
	public static List<Piirivalvur> findAllPiirivalvuridForIntsident(Intsident ints) {
    	Query q = entityManager().createQuery("SELECT o FROM Piirivalvur o JOIN o.piirivalvur_intsidendis pi WHERE pi.intsident=:ints", Piirivalvur.class);
    	q.setParameter("ints", ints);
        return q.getResultList();
    }    
    
    @SuppressWarnings("unchecked")
	public static List<Piirivalvur> findAllPiirivalvuridNotInIntsident(Intsident ints) {
    	Query q = entityManager().createQuery("SELECT o FROM Piirivalvur o WHERE o NOT IN (SELECT o1 FROM Piirivalvur o1 JOIN o1.piirivalvur_intsidendis pi WHERE pi.intsident=:ints)", Piirivalvur.class);
    	q.setParameter("ints", ints);
        return q.getResultList();
    }
    
    
    
    @SuppressWarnings("unchecked")
	public static List<Piirivalvur> findAllPiirivalvuridForPiiriloik(Piiriloik piir) {
    	Query q = entityManager().createQuery("SELECT p FROM Piirivalvur p JOIN p.piirivalvur_intsidendis pi WHERE pi.intsident.piiriloik=:piir", Piirivalvur.class);
    	q.setParameter("piir", piir);
        return q.getResultList();
    }

//	@SuppressWarnings("unchecked")
//	public static List<Piirivalvur> findAllPiirivalvurIntsidentsForPiiriloikWithInterval(Piiriloik piir, Date alates, Date kuni) {
//    	Query q = entityManager().createQuery("SELECT pi FROM Piirivalvur_intsidendis pi JOIN pi.intsident i WHERE i.piiriloik=:piir and (pi.alates>=:alates and pi.kuni<=:kuni)", Piirivalvur_intsidendis.class);
//    	q.setParameter("piir", piir);
//    	q.setParameter("alates", alates);
//    	q.setParameter("kuni", kuni);
//        return q.getResultList();
//    }
//	
//	@SuppressWarnings("unchecked")
//	public static List<Piirivalvur> findAllPiirivalvurIntsidentsWithInterval(Date alates, Date kuni) {
//    	Query q = entityManager().createQuery("SELECT pi FROM Piirivalvur_intsidendis pi WHERE pi.alates>=:alates and pi.kuni<=:kuni", Piirivalvur_intsidendis.class);
//    	q.setParameter("alates", alates);
//    	q.setParameter("kuni", kuni);
//        return q.getResultList();
//    }

}
