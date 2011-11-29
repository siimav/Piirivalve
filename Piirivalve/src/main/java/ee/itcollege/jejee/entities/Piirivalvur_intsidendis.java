package ee.itcollege.jejee.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
public class Piirivalvur_intsidendis implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private Long piirivalvur_intsidendis_ID;
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
	private String avaja;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@NotNull
	private Date avatud;
	@NotNull
	private String muutja;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@NotNull
	private Date muudetud;
	private String sulgeja;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@NotNull
	private Date suletud;
	
	@NotNull
	@ManyToOne
	private Intsident intsident;
	
	@NotNull
	@ManyToOne
	private Piirivalvur piirivalvur;
	
	@ManyToOne
	private Vahtkond_intsidendis vahtkond_intsidendis;
	

	public Long getPiirivalvur_intsidendis_ID() {
		return piirivalvur_intsidendis_ID;
	}

	public void setPiirivalvur_intsidendis_ID(Long piirivalvur_intsidendis_ID) {
		this.piirivalvur_intsidendis_ID = piirivalvur_intsidendis_ID;
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

	public String getAvaja() {
		return avaja;
	}

	public void setAvaja(String avaja) {
		this.avaja = avaja;
	}

	public Date getAvatud() {
		return avatud;
	}

	public void setAvatud(Date avatud) {
		this.avatud = avatud;
	}

	public String getMuutja() {
		return muutja;
	}

	public void setMuutja(String muutja) {
		this.muutja = muutja;
	}

	public Date getMuudetud() {
		return muudetud;
	}

	public void setMuudetud(Date muudetud) {
		this.muudetud = muudetud;
	}

	public String getSulgeja() {
		return sulgeja;
	}

	public void setSulgeja(String sulgeja) {
		this.sulgeja = sulgeja;
	}

	public Date getSuletud() {
		return suletud;
	}

	public void setSuletud(Date suletud) {
		this.suletud = suletud;
	}

	public Intsident getIntsident() {
		return intsident;
	}

	public void setIntsident(Intsident intsident) {
		this.intsident = intsident;
	}

	public Piirivalvur getPiirivalvur() {
		return piirivalvur;
	}

	public void setPiirivalvur(Piirivalvur piirivalvur) {
		this.piirivalvur = piirivalvur;
	}

	public Vahtkond_intsidendis getVahtkond_intsidendis() {
		return vahtkond_intsidendis;
	}

	public void setVahtkond_intsidendis(Vahtkond_intsidendis vahtkond_intsidendis) {
		this.vahtkond_intsidendis = vahtkond_intsidendis;
	}
	
	
	 @SuppressWarnings("unchecked")
		public static List<Piirivalvur_intsidendis> findAllPiirivalvurIntsidentsForPiiriloik(Piiriloik piir) {
	    	Query q = entityManager().createQuery("SELECT pi FROM Piirivalvur_intsidendis pi JOIN pi.intsident i WHERE i.piiriloik=:piir", Piirivalvur_intsidendis.class);
	    	q.setParameter("piir", piir);
	        return q.getResultList();
	    }
	
		@SuppressWarnings("unchecked")
		public static List<Piirivalvur_intsidendis> findAllPiirivalvurIntsidentsForPiiriloikWithInterval(Piiriloik piir, Date alates, Date kuni) {
	    	Query q = entityManager().createQuery("SELECT pi FROM Piirivalvur_intsidendis pi JOIN pi.intsident i WHERE i.piiriloik=:piir and (pi.alates>=:alates and pi.kuni<=:kuni)", Piirivalvur_intsidendis.class);
	    	q.setParameter("piir", piir);
	    	q.setParameter("alates", alates);
	    	q.setParameter("kuni", kuni);
	        return q.getResultList();
	    }
		
		@SuppressWarnings("unchecked")
		public static List<Piirivalvur_intsidendis> findAllPiirivalvurIntsidentsWithInterval(Date alates, Date kuni) {
	    	Query q = entityManager().createQuery("SELECT pi FROM Piirivalvur_intsidendis pi WHERE pi.alates>=:alates and pi.kuni<=:kuni", Piirivalvur_intsidendis.class);
	    	q.setParameter("alates", alates);
	    	q.setParameter("kuni", kuni);
	        return q.getResultList();
	    }
		
		@SuppressWarnings("unchecked")
		public static List<Piirivalvur_intsidendis> findAllPiirivalvurIntsidentsForPiirivalvur(Piirivalvur piirivalvur) {
	    	Query q = entityManager().createQuery("SELECT pi FROM Piirivalvur_intsidendis pi WHERE pi.piirivalvur=:piirivalvur", Piirivalvur_intsidendis.class);
	    	q.setParameter("piirivalvur", piirivalvur);
	        return q.getResultList();
	    }
	
	
}
