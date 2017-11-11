/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db.usuarios;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author evargas
 */
@Embeddable
public class UserlevelpermissionsPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "userlevelid")
    private int userlevelid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "tablename")
    private String tablename;

    public UserlevelpermissionsPK() {
    }

    public UserlevelpermissionsPK(int userlevelid, String tablename) {
        this.userlevelid = userlevelid;
        this.tablename = tablename;
    }

    public int getUserlevelid() {
        return userlevelid;
    }

    public void setUserlevelid(int userlevelid) {
        this.userlevelid = userlevelid;
    }

    public String getTablename() {
        return tablename;
    }

    public void setTablename(String tablename) {
        this.tablename = tablename;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) userlevelid;
        hash += (tablename != null ? tablename.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserlevelpermissionsPK)) {
            return false;
        }
        UserlevelpermissionsPK other = (UserlevelpermissionsPK) object;
        if (this.userlevelid != other.userlevelid) {
            return false;
        }
        if ((this.tablename == null && other.tablename != null) || (this.tablename != null && !this.tablename.equals(other.tablename))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "db.usuarios.UserlevelpermissionsPK[ userlevelid=" + userlevelid + ", tablename=" + tablename + " ]";
    }
    
}
