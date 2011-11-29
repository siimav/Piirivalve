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
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@MappedSuperclass
public class BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

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
    }

    @PreUpdate
    public void recordModified() {
    	setMuudetud(new Date());
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
	
}
