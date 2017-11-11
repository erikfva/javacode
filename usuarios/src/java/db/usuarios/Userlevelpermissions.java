/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db.usuarios;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author evargas
 */
@Entity
@Table(name = "registro_derecho.userlevelpermissions")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Userlevelpermissions.findAll", query = "SELECT u FROM Userlevelpermissions u")
    , @NamedQuery(name = "Userlevelpermissions.findByUserlevelid", query = "SELECT u FROM Userlevelpermissions u WHERE u.userlevelpermissionsPK.userlevelid = :userlevelid")
    , @NamedQuery(name = "Userlevelpermissions.findByTablename", query = "SELECT u FROM Userlevelpermissions u WHERE u.userlevelpermissionsPK.tablename = :tablename")
    , @NamedQuery(name = "Userlevelpermissions.findByPermission", query = "SELECT u FROM Userlevelpermissions u WHERE u.permission = :permission")})
public class Userlevelpermissions implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected UserlevelpermissionsPK userlevelpermissionsPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "permission")
    private int permission;
    @JoinColumn(name = "userlevelid", referencedColumnName = "userlevelid", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Userlevels userlevels;

    public Userlevelpermissions() {
    }

    public Userlevelpermissions(UserlevelpermissionsPK userlevelpermissionsPK) {
        this.userlevelpermissionsPK = userlevelpermissionsPK;
    }

    public Userlevelpermissions(UserlevelpermissionsPK userlevelpermissionsPK, int permission) {
        this.userlevelpermissionsPK = userlevelpermissionsPK;
        this.permission = permission;
    }

    public Userlevelpermissions(int userlevelid, String tablename) {
        this.userlevelpermissionsPK = new UserlevelpermissionsPK(userlevelid, tablename);
    }

    public UserlevelpermissionsPK getUserlevelpermissionsPK() {
        return userlevelpermissionsPK;
    }

    public void setUserlevelpermissionsPK(UserlevelpermissionsPK userlevelpermissionsPK) {
        this.userlevelpermissionsPK = userlevelpermissionsPK;
    }

    public int getPermission() {
        return permission;
    }

    public void setPermission(int permission) {
        this.permission = permission;
    }

    public Userlevels getUserlevels() {
        return userlevels;
    }

    public void setUserlevels(Userlevels userlevels) {
        this.userlevels = userlevels;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userlevelpermissionsPK != null ? userlevelpermissionsPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Userlevelpermissions)) {
            return false;
        }
        Userlevelpermissions other = (Userlevelpermissions) object;
        if ((this.userlevelpermissionsPK == null && other.userlevelpermissionsPK != null) || (this.userlevelpermissionsPK != null && !this.userlevelpermissionsPK.equals(other.userlevelpermissionsPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "db.usuarios.Userlevelpermissions[ userlevelpermissionsPK=" + userlevelpermissionsPK + " ]";
    }
    
}
