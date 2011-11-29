package ee.itcollege.jejee.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooEntity
@Entity
public class Vahtkond_piiriloigul extends BaseEntity {

	private static final long serialVersionUID = 1L;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date alates;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date kuni;
	private String kommentaar;
	
	@NotNull
	@ManyToOne
	private Piiriloik piiriloik;
	
	@NotNull
	@ManyToOne
	private Vahtkond vahtkond;

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
	public Piiriloik getPiiriloik() {
		return piiriloik;
	}
	public void setPiiriloik(Piiriloik piiriloik) {
		this.piiriloik = piiriloik;
	}
	public Vahtkond getVahtkond() {
		return vahtkond;
	}
	public void setVahtkond(Vahtkond vahtkond) {
		this.vahtkond = vahtkond;
	}
	
}
