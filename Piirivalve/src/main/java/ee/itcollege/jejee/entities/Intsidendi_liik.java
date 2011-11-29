package ee.itcollege.jejee.entities;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.tostring.RooToString;

@RooToString
@RooEntity
@Entity
public class Intsidendi_liik  extends BaseEntity {

	private static final long serialVersionUID = 1L;

	private String kood;
	private String nimetus;
	private String kommentaar;

	@OneToMany(mappedBy = "intsidendi_liik")
	private Collection<Intsident> intsident;

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
	public Collection<Intsident> getIntsident() {
	    return intsident;
	}
	public void setIntsident(Collection<Intsident> param) {
	    this.intsident = param;
	}
	
}
