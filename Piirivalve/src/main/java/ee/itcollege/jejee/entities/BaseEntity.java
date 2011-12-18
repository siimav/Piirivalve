package ee.itcollege.jejee.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;
import javax.persistence.Query;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.tostring.RooToString;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.transaction.annotation.Transactional;

@MappedSuperclass
@Configurable
@RooToString
@RooEntity(mappedSuperclass=true)
public abstract class BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	public static final Date SURROGATE_DATE = new Date(253402232400000l);	// 9999-12-31
	
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private Long id;
	
	private String avaja;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	
	private Date avatud;
	
	private String muutja;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date muudetud;
	
	private String sulgeja;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date suletud;
	
	
    @PrePersist
    public void recordCreated() {
        setAvatud(new Date());
        setMuudetud(new Date());
        setSuletud(SURROGATE_DATE);
        String user = SecurityContextHolder.getContext().getAuthentication().getName();
        setAvaja(user);
        setMuutja(user);
    }

    @PreUpdate
    public void recordModified() {
    	setMuudetud(new Date());
        String user = SecurityContextHolder.getContext().getAuthentication().getName();
        setMuutja(user);
    }

    @PreRemove
    public void preventRemove() {
        throw new SecurityException("Removing is prohibited!");
    }
    

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
	
	
	// Saaks teha ka objekt.merge() abil, aga siis muudetakse muutmise kuupäev ka ära
	@Transactional
    public void remove() { 
        String table = this.getClass().getSimpleName();
        Query q = entityManager().createQuery("UPDATE " + table + " SET suletud=:date WHERE id=" + id);
        q.setParameter("date", new Date());
//        this.entityManager.getTransaction().begin();
        if(q.executeUpdate() != 1) {
        	//FAILED
//        	this.entityManager.getTransaction().rollback();
        	//TODO: write to log
        	return;
        }

        String user = SecurityContextHolder.getContext().getAuthentication().getName();
        q =  entityManager().createQuery("UPDATE " + table + " SET sulgeja=:sulgeja WHERE id=" + id);
        q.setParameter("sulgeja", user);
        if(q.executeUpdate() != 1) {
        	//FAILED
//        	this.entityManager.getTransaction().rollback();
        	//TODO: write to log
        	return;
        }        
        
//        this.entityManager.getTransaction().commit();
    }
	
}
