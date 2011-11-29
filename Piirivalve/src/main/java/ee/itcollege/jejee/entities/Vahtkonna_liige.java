package ee.itcollege.jejee.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.tostring.RooToString;

@Entity
@RooEntity
@RooToString
public class Vahtkonna_liige extends BaseEntity {

	private static final long serialVersionUID = 1L;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date alates;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date kuni;
	private String kommentaar;

	@ManyToOne
	private Vahtkond vahtkond;

	@ManyToOne
	private Piirivalvur piirivalvur;

	public Vahtkonna_liige() {
		super();
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

	public String getKommentaar() {
		return kommentaar;
	}

	public void setKommentaar(String kommentaar) {
		this.kommentaar = kommentaar;
	}

	public Vahtkond getVahtkond() {
		return vahtkond;
	}

	public void setVahtkond(Vahtkond param) {
		this.vahtkond = param;
	}

	public void setPiirivalvur(Piirivalvur param) {
		this.piirivalvur = param;
	}

	public Piirivalvur getPiirivalvur() {
		return piirivalvur;
	}

}
