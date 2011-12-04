package ee.itcollege.jejee.web;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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

import ee.itcollege.jejee.entities.Intsident;


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
//		if(((Long) q.getSingleResult()) == 0) {	  //ühtegi kirjet pole
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
		
//		if(((Long) q.getSingleResult()) == 0) {	  //ühtegi kirjet pole
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
			Intsident i = new Intsident();
			i.setKood("i763");
			i.setNimetus("Karu jooksis põõsasse");
//			i.setto
			//TODO:
		}
		else {
			return "fill_db_fail";
		}

		
        return "fill_db_success";
    }
	
}
