// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package ee.itcollege.jejee.entities;

import ee.itcollege.jejee.entities.Riigi_admin_yksuse_liik;
import java.lang.Long;

privileged aspect Riigi_admin_yksuse_liik_Roo_Entity {
    
    public static Riigi_admin_yksuse_liik Riigi_admin_yksuse_liik.findRiigi_admin_yksuse_liik(Long id) {
        if (id == null) return null;
        return entityManager().find(Riigi_admin_yksuse_liik.class, id);
    }
    
}
