// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package ee.itcollege.jejee.entities;

import ee.itcollege.jejee.entities.Vahtkond_intsidendis;
import java.lang.Long;

privileged aspect Vahtkond_intsidendis_Roo_Entity {
    
    public static Vahtkond_intsidendis Vahtkond_intsidendis.findVahtkond_intsidendis(Long id) {
        if (id == null) return null;
        return entityManager().find(Vahtkond_intsidendis.class, id);
    }
    
}
