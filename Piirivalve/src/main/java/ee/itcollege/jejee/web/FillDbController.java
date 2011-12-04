package ee.itcollege.jejee.web;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ee.itcollege.jejee.entities.*;


@RequestMapping("/filldb")
@Controller
public class FillDbController {

	@PersistenceContext
	EntityManager entityManager;
//	@Resource 
//	private UserTransaction userTransaction;
	
	@RequestMapping(method = RequestMethod.GET)
    public String fill(Model uiModel) throws IllegalStateException, SecurityException, SystemException {
		Query q = entityManager.createQuery("SELECT count(o) FROM Intsident o", Long.class);
//		if(((Long) q.getSingleResult()) == 0) {	  //Ã¼htegi kirjet pole
//			Connection conn = null;
//			try {
//	            Class.forName("org.hsqldb.jdbcDriver");	            
//	        	conn = DriverManager.getConnection("jdbc:hsqldb:file:${user.home}/i377/Team15/db;", "SA", "");
//	            conn.setAutoCommit(false);
//	            PreparedStatement statement = conn.prepareStatement("INSERT INTO INTSIDENT VALUES(11,'avaja','2011-12-01 15:31:39.212000000','2011-12-01 15:31:39.212000000','muutja','9999-12-31 07:00:00.000000000','sulgeja','','','','','','',NULL,NULL,0,1,1)");
//	            statement.executeUpdate();
//	            conn.commit();
//	        } catch(Exception e){
//	        	uiModel.addAttribute("error", e.toString());
//	            return "fill_db_fail";
//	        } finally {
//	            try {
//	                conn.close();
//	            } catch (SQLException e) {
//		        	uiModel.addAttribute("error", e.toString());
//		            return "fill_db_fail";
//	            }
//	        }
//		}
//		else {
//			return "fill_db_fail";
//		}
		
//		if(((Long) q.getSingleResult()) == 0) {	  //Ã¼htegi kirjet pole
//			try {
//				userTransaction.begin();
//			} catch(Exception e) {
//				uiModel.addAttribute("error", e.toString());
//				return "fill_db_fail";
//			}
//			
//			try {
//				q = entityManager.createNativeQuery("INSERT INTO INTSIDENT VALUES(12,'avaja','2011-12-01 15:31:39.212000000','2011-12-01 15:31:39.212000000','muutja','9999-12-31 07:00:00.000000000','sulgeja','','','','','','',NULL,NULL,0,1,1)");
//				userTransaction.commit();
//			} catch(Exception e) {
//				uiModel.addAttribute("error", e.toString());
//				userTransaction.rollback();
//				return "fill_db_fail";
//			}
//		}
//		else {
//			return "fill_db_fail";
//		}
		
//		EntityManagerFactory emf=Persistence.createEntityManagerFactory("persistenceUnit");
//		EntityManager em=emf.createEntityManager();
//		try{
//		EntityTransaction entr=em.getTransaction();
//		entr.begin();
//		Query query=em.createNativeQuery("SELECT id FROM Intsident");
//		List stList=query.getResultList();
//		Iterator stIterator=stList.iterator();
//		while(stIterator.hasNext()){
//		System.out.print("sname:"+stIterator.next());
//		System.out.println();
//		}
//		entr.commit();
//		}
//		finally{
//		em.close();
//		}
		
		
		if(((Long) q.getSingleResult()) == 0) {	  //ühtegi kirjet pole
			
			Intsidendi_liik il_1 = new Intsidendi_liik("IL4433","tõsine","väga jõhker");
			Intsidendi_liik il_2 = new Intsidendi_liik("IL6655","kerge","suht savi");
			il_1.persist();
			il_2.persist();
			
			Piiriloik p_1 = new Piiriloik("PL432","Põhja","32.445 54.654","põhjapoolne piirilõik");
			Piiriloik p_2 = new Piiriloik("PL444","Lõuna","31.435 52.664","lõunaapoolne piirilõik");
			p_1.persist();
			p_2.persist();
			
			Intsident i_1 = new Intsident("I5544","Karu jooksis üle piiri",new Date(),new Date(),"suur karu","kommentaar","34.543","43.667",p_1,il_2);
			Intsident i_2 = new Intsident("I6666","Põder jooksis üle piiri",new Date(),new Date(),"suur põder","kommentaar","34.543","43.667",p_2,il_2);
			Intsident i_3 = new Intsident("I5544","Venelased ründavad",new Date(),new Date(),"wtf?","kommentaar","34.543","43.667",p_1,il_1);
			Intsident i_4 = new Intsident("I5544","Traat on katki",new Date(),new Date(),"keegi on läbi tulnud","kommentaar","34.543","43.667",p_2,il_1);
			i_1.persist();
			i_2.persist();
			i_3.persist();
			i_4.persist();
			
			Objekti_liik ol_1 = new Objekti_liik("OL321", "Terariist", "kommentaar");
			Objekti_liik ol_2 = new Objekti_liik("OL657", "Tulirelv", "kommentaar");
			ol_1.persist();
			ol_2.persist();
			
			Objekt o_1 = new Objekt("Nuga","kööginuga",ol_1);
			Objekt o_2 = new Objekt("Kahvel","wtf",ol_1);
			Objekt o_3 = new Objekt("AK-47","pole paha",ol_2);
			o_1.persist();
			o_2.persist();
			o_3.persist();
			
			Objekt_intsidendis oi_1 = new Objekt_intsidendis(new Date(), new Date(), "kirjeldus", "kommentaar", i_4, o_1);
			Objekt_intsidendis oi_2 = new Objekt_intsidendis(new Date(), new Date(), "kirjeldus", "kommentaar", i_3, o_3);
			oi_1.persist();
			oi_2.persist();
			
			Piiririkkuja pr_1 = new Piiririkkuja("3879292", "Vova", "Mova", "Mees", new Date(), "kommentaar", o_1);
			Piiririkkuja pr_2 = new Piiririkkuja("5436546", "Loll", "Koll", "Mees", new Date(), "kommentaar", o_3);
			Piiririkkuja pr_3 = new Piiririkkuja("1234567", "Mari", "Nari", "Naine", new Date(), "kommentaar", o_2);
			pr_1.persist();
			pr_2.persist();
			pr_3.persist();
			
			Isik_intsidendis ii_1 = new Isik_intsidendis(new Date(), new Date(), "kirjeldus", "kommentaar", i_4, pr_1);
			Isik_intsidendis ii_2 = new Isik_intsidendis(new Date(), new Date(), "kirjeldus", "kommentaar", i_4, pr_2);
			Isik_intsidendis ii_3 = new Isik_intsidendis(new Date(), new Date(), "kirjeldus", "kommentaar", i_3, pr_3);
			ii_1.persist();
			ii_2.persist();
			ii_3.persist();
			
			Piiripunkt pp_1 = new Piiripunkt("PP4322", "Põhja piiripunkt", "43.555", "43.543", "43", new Date(), new Date(), "kommentaar");
			Piiripunkt pp_2 = new Piiripunkt("PP4542", "Lõuna piiripunkt", "41.555", "46.543", "65", new Date(), new Date(), "kommentaar");
			pp_1.persist();
			pp_2.persist();
			
			Piirivalvur pv_1 = new Piirivalvur("345643", "Peeter", "Ükskulm", "Mees", "SK4332", "Pikk poiss");
			Piirivalvur pv_2 = new Piirivalvur("435643", "Dolga", "Molga", "Naine", "SK4555", "nice");
			Piirivalvur pv_3 = new Piirivalvur("321235", "Vasja", "Masja", "Mees", "SK6789", "Normaalne vend");
			pv_1.persist();
			pv_2.persist();
			pv_3.persist();
			
			Riigi_admin_yksuse_liik rayl_1 = new Riigi_admin_yksuse_liik("RAYL332", "riigi_admin_yksuse_liik", new Date(), new Date(), "kommentaar");
			rayl_1.persist();
			
			Riigi_admin_yksus ray_1 = new Riigi_admin_yksus("RAY334", "riigi_admin_yksus", new Date(), new Date(), "kommentaar", rayl_1);
			ray_1.persist();
			
			Vaeosa v_1 = new Vaeosa("V3224", "Väeosa_1", new Date(), new Date(), "kommentaar", ray_1);
			v_1.persist();
			
			Vahtkond vk_1 = new Vahtkond("VK432", "Õhtune", new Date(), new Date(), "kommentaar", v_1, pp_1);
			Vahtkond vk_2 = new Vahtkond("VK667", "Hommikune", new Date(), new Date(), "kommentaar", v_1, pp_2);
			vk_1.persist();
			vk_2.persist();
			
			Vahtkonna_liige vkl_1 = new Vahtkonna_liige(new Date(), new Date(), "kommentaar", vk_1, pv_1);
			Vahtkonna_liige vkl_2 = new Vahtkonna_liige(new Date(), new Date(), "kommentaar", vk_2, pv_2);
			Vahtkonna_liige vkl_3 = new Vahtkonna_liige(new Date(), new Date(), "kommentaar", vk_1, pv_3);
			vkl_1.persist();
			vkl_2.persist();
			vkl_3.persist();
			
			Vahtkond_piiriloigul vkpl_1 = new Vahtkond_piiriloigul(new Date(), new Date(), "kommentaar", p_1, vk_1);
			Vahtkond_piiriloigul vkpl_2 = new Vahtkond_piiriloigul(new Date(), new Date(), "kommentaar", p_2, vk_2);
			vkpl_1.persist();
			vkpl_2.persist();
			
			Vahtkond_intsidendis vki_1 = new Vahtkond_intsidendis(new Date(), new Date(), "kirjeldus", "kommentaar", i_1, vk_2);
			Vahtkond_intsidendis vki_2 = new Vahtkond_intsidendis(new Date(), new Date(), "kirjeldus", "kommentaar", i_2, vk_2);
			Vahtkond_intsidendis vki_3 = new Vahtkond_intsidendis(new Date(), new Date(), "kirjeldus", "kommentaar", i_4, vk_1);
			vki_1.persist();
			vki_2.persist();
			vki_3.persist();
			
			Seadus s_1 = new Seadus("S443", "Relvaseadus", "2009-06-12","2015-12-04","kommentaar");
			Seadus s_2 = new Seadus("S3244", "Piiriseadus", "2010-11-09", "2013-05-05", "kommentaar");
			s_1.persist();
			s_2.persist();
			
			Seaduse_punkt sp_1 = new Seaduse_punkt("32", "4", "väga huvitav seadus", new Date(), new Date(), "kommentaar", s_1);
			Seaduse_punkt sp_2 = new Seaduse_punkt("45", "6", "väga huvitav seadus", new Date(), new Date(), "kommentaar", s_1);
			Seaduse_punkt sp_3 = new Seaduse_punkt("55", "2", "väga huvitav seadus", new Date(), new Date(), "kommentaar", s_2);
			Seaduse_punkt sp_4 = new Seaduse_punkt("11", "5", "väga huvitav seadus", new Date(), new Date(), "kommentaar", s_2);
			sp_1.persist();
			sp_2.persist();
			sp_3.persist();
			sp_4.persist();
			
			Piirivalvur_intsidendis pvi_1 = new Piirivalvur_intsidendis(new Date(), new Date(), "väga hull", "jube", i_1, pv_1, vki_1);
			Piirivalvur_intsidendis pvi_2 = new Piirivalvur_intsidendis(new Date(), new Date(), "kirjeldus", "kommentaar", i_1, pv_2, vki_2);
			Piirivalvur_intsidendis pvi_3 = new Piirivalvur_intsidendis(new Date(), new Date(), "krt kyll", "jee", i_2, pv_3, vki_2);
			Piirivalvur_intsidendis pvi_4 = new Piirivalvur_intsidendis(new Date(), new Date(), "intsident", "midagi", i_3, pv_3, vki_1);
			Piirivalvur_intsidendis pvi_5 = new Piirivalvur_intsidendis(new Date(), new Date(), "mis toimub", "komm", i_4, pv_3, vki_1);
			Piirivalvur_intsidendis pvi_6 = new Piirivalvur_intsidendis(new Date(), new Date(), "intsident", "midagi", i_2, pv_2, vki_2);
			Piirivalvur_intsidendis pvi_7 = new Piirivalvur_intsidendis(new Date(), new Date(), "midagi", "midagi", i_3, pv_1, vki_2);
			pvi_1.persist();
			pvi_2.persist();
			pvi_3.persist();
			pvi_4.persist();
			pvi_5.persist();
			pvi_6.persist();
			pvi_7.persist();
			
			Piirivalvuri_seadus_intsidendi psi_1 = new Piirivalvuri_seadus_intsidendi("kirjeldus", "komm", new Date(), new Date(), sp_1, pvi_1);
			Piirivalvuri_seadus_intsidendi psi_2 = new Piirivalvuri_seadus_intsidendi("kirjeldus", "komm", new Date(), new Date(), sp_2, pvi_2);
			Piirivalvuri_seadus_intsidendi psi_3 = new Piirivalvuri_seadus_intsidendi("kirjeldus", "komm", new Date(), new Date(), sp_3, pvi_3);
			Piirivalvuri_seadus_intsidendi psi_4 = new Piirivalvuri_seadus_intsidendi("kirjeldus", "komm", new Date(), new Date(), sp_1, pvi_4);
			Piirivalvuri_seadus_intsidendi psi_5 = new Piirivalvuri_seadus_intsidendi("kirjeldus", "komm", new Date(), new Date(), sp_2, pvi_5);
			Piirivalvuri_seadus_intsidendi psi_6 = new Piirivalvuri_seadus_intsidendi("kirjeldus", "komm", new Date(), new Date(), sp_3, pvi_6);
			Piirivalvuri_seadus_intsidendi psi_7 = new Piirivalvuri_seadus_intsidendi("kirjeldus", "komm", new Date(), new Date(), sp_1, pvi_7);
			Piirivalvuri_seadus_intsidendi psi_8 = new Piirivalvuri_seadus_intsidendi("kirjeldus", "komm", new Date(), new Date(), sp_2, pvi_1);
			Piirivalvuri_seadus_intsidendi psi_9 = new Piirivalvuri_seadus_intsidendi("kirjeldus", "komm", new Date(), new Date(), sp_3, pvi_2);
			psi_1.persist();
			psi_2.persist();
			psi_3.persist();
			psi_4.persist();
			psi_5.persist();
			psi_6.persist();
			psi_7.persist();
			psi_8.persist();
			psi_9.persist();
			
		}
		else {
			return "fill_db_fail";
		}

		
        return "fill_db_success";
    }
	
}
