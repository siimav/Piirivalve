// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package ee.itcollege.jejee.entities;

import java.lang.String;

privileged aspect Vahtkond_Roo_ToString {
    
    public String Vahtkond.toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Alates: ").append(getAlates()).append(", ");
        sb.append("Avaja: ").append(getAvaja()).append(", ");
        sb.append("Avatud: ").append(getAvatud()).append(", ");
        sb.append("Id: ").append(getId()).append(", ");
        sb.append("Kommentaar: ").append(getKommentaar()).append(", ");
        sb.append("Kood: ").append(getKood()).append(", ");
        sb.append("Kuni: ").append(getKuni()).append(", ");
        sb.append("Muudetud: ").append(getMuudetud()).append(", ");
        sb.append("Muutja: ").append(getMuutja()).append(", ");
        sb.append("Nimetus: ").append(getNimetus()).append(", ");
        sb.append("Piiripunkt: ").append(getPiiripunkt()).append(", ");
        sb.append("Suletud: ").append(getSuletud()).append(", ");
        sb.append("Sulgeja: ").append(getSulgeja()).append(", ");
        sb.append("Vaeosa: ").append(getVaeosa()).append(", ");
        sb.append("Vahtkond_piiriloigul: ").append(getVahtkond_piiriloigul() == null ? "null" : getVahtkond_piiriloigul().size()).append(", ");
        sb.append("Vahtkonna_liige: ").append(getVahtkonna_liige() == null ? "null" : getVahtkonna_liige().size()).append(", ");
        sb.append("Vahtkonnad_intsidendis: ").append(getVahtkonnad_intsidendis() == null ? "null" : getVahtkonnad_intsidendis().size()).append(", ");
        sb.append("Version: ").append(getVersion());
        return sb.toString();
    }
    
}
