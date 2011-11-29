package ee.itcollege.jejee.entities;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.tostring.RooToString;

@Entity
@RooEntity
@RooToString
public class Objekti_liik extends BaseEntity {

	private static final long serialVersionUID = 1L;

	private String kood;
	@NotNull
	private String nimetus;
	private String kommentaar;
	
	@OneToMany(mappedBy = "objekti_liik")
	private Collection<Objekt> objekt;

	public Objekti_liik() {
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

	public String getKommentaar() {
		return kommentaar;
	}

	public void setKommentaar(String kommentaar) {
		this.kommentaar = kommentaar;
	}

	public Collection<Objekt> getObjekt() {
	    return objekt;
	}

	public void setObjekt(Collection<Objekt> param) {
	    this.objekt = param;
	}

   
}
