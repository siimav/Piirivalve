// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package ee.itcollege.jejee.entities;

import ee.itcollege.jejee.entities.Vahtkonna_liige;
import java.lang.Long;

privileged aspect Vahtkonna_liige_Roo_Entity {
    
    public static Vahtkonna_liige Vahtkonna_liige.findVahtkonna_liige(Long id) {
        if (id == null) return null;
        return entityManager().find(Vahtkonna_liige.class, id);
    }
    
}
