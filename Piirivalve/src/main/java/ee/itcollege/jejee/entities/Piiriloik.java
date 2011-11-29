package ee.itcollege.jejee.entities;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooEntity
@Entity
public class Piiriloik extends BaseEntity {

	private static final long serialVersionUID = 1L;

	private String kood;
	private String nimetus;
	private String GPS_koordinaadid;
	private String kommentaar;

	@OneToMany(mappedBy = "piiriloik")
	private Collection<Intsident> intsident;

	@OneToMany(mappedBy = "piiriloik")
	private Collection<Vahtkond_piiriloigul> vahtkond_piiriloigul;

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
	public String getGPS_koordinaadid() {
		return GPS_koordinaadid;
	}
	public void setGPS_koordinaadid(String gPS_koordinaadid) {
		GPS_koordinaadid = gPS_koordinaadid;
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
	public Collection<Vahtkond_piiriloigul> getVahtkond_piiriloigul() {
	    return vahtkond_piiriloigul;
	}
	public void setVahtkond_piiriloigul(Collection<Vahtkond_piiriloigul> param) {
	    this.vahtkond_piiriloigul = param;
	}
	
}
