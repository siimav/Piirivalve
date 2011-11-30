package ee.itcollege.jejee.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PersistenceContext;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;
import javax.persistence.Query;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.transaction.annotation.Transactional;

@MappedSuperclass
@Configurable
public class BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@PersistenceContext
	transient EntityManager entityManager;

	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private Long id;
	
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
	
	
    @PrePersist
    public void recordCreated() {
        setAvatud(new Date());
        setMuudetud(new Date());
        setSuletud(new Date(253402232400000l));	  // 9999-12-31
    }

    @PreUpdate
    public void recordModified() {
    	setMuudetud(new Date());
    }

    @PreRemove
    public void preventRemove() {
        throw new SecurityException("Removing is prohibited!");
    }
    
    
    @Transactional
    public void persist() {
        if (entityManager == null) this.entityManager = entityManager();
        this.entityManager.persist(this);
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
	
	public EntityManager getEntityManager() {
		return entityManager;
	}
	
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	public static EntityManager entityManager() {
	    EntityManager em = new BaseEntity().entityManager;        
	    if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");        
	    return em;        
	}
	
//    @Transactional
//    public void Intsidendi_liik.remove() {
//        if (this.entityManager == null) this.entityManager = entityManager();
//        if (this.entityManager.contains(this)) {
//            this.entityManager.remove(this);
//        } else {
//            Intsidendi_liik attached = Intsidendi_liik.findIntsidendi_liik(this.id);
//            this.entityManager.remove(attached);
//        }
//    }
	
	@Transactional
    public void remove(String sulgeja) {
        if (this.entityManager == null) {
        	this.entityManager = entityManager();
        }
        
        String table = this.getClass().getSimpleName();
        Query q =  this.entityManager.createQuery("UPDATE " + table + " SET suletud=:date WHERE id=" + id);
        q.setParameter("date", new Date());
//        this.entityManager.getTransaction().begin();
        if(q.executeUpdate() != 1) {
        	//FAILED
//        	this.entityManager.getTransaction().rollback();
        	//TODO: write to log
        	return;
        }

        q =  this.entityManager.createQuery("UPDATE " + table + " SET sulgeja=:sulgeja WHERE id=" + id);
        q.setParameter("sulgeja", sulgeja);
        if(q.executeUpdate() != 1) {
        	//FAILED
//        	this.entityManager.getTransaction().rollback();
        	//TODO: write to log
        	return;
        }
        
//        this.entityManager.getTransaction().commit();
    }
	
}
