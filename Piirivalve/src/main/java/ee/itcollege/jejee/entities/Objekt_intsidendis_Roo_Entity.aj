// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package ee.itcollege.jejee.entities;

import ee.itcollege.jejee.entities.Objekt_intsidendis;
import java.lang.Long;
import java.util.List;

privileged aspect Objekt_intsidendis_Roo_Entity {
    
    public static long Objekt_intsidendis.countObjekt_intsidendises() {
        return entityManager().createQuery("SELECT COUNT(o) FROM Objekt_intsidendis o", Long.class).getSingleResult();
    }
    
    public static List<Objekt_intsidendis> Objekt_intsidendis.findAllObjekt_intsidendises() {
        return entityManager().createQuery("SELECT o FROM Objekt_intsidendis o", Objekt_intsidendis.class).getResultList();
    }
    
    public static Objekt_intsidendis Objekt_intsidendis.findObjekt_intsidendis(Long id) {
        if (id == null) return null;
        return entityManager().find(Objekt_intsidendis.class, id);
    }
    
    public static List<Objekt_intsidendis> Objekt_intsidendis.findObjekt_intsidendisEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM Objekt_intsidendis o", Objekt_intsidendis.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
}
