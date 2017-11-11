/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db.usuarios;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author evargas
 */
@Entity
@Table(name = "registro_derecho.userlevels")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Userlevels.findAll", query = "SELECT u FROM Userlevels u")
    , @NamedQuery(name = "Userlevels.findByUserlevelid", query = "SELECT u FROM Userlevels u WHERE u.userlevelid = :userlevelid")
    , @NamedQuery(name = "Userlevels.findByUserlevelname", query = "SELECT u FROM Userlevels u WHERE u.userlevelname = :userlevelname")
    , @NamedQuery(name = "Userlevels.findByPerfil", query = "SELECT u FROM Userlevels u WHERE u.perfil = :perfil")})
public class Userlevels implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "userlevelid")
    private Integer userlevelid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "userlevelname")
    private String userlevelname;
    @Size(max = 200)
    @Column(name = "perfil")
    private String perfil;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userlevels")
    private List<Userlevelpermissions> userlevelpermissionsList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userlevelid")
    private List<Usuario> usuarioList;

    public Userlevels() {
    }

    public Userlevels(Integer userlevelid) {
        this.userlevelid = userlevelid;
    }

    public Userlevels(Integer userlevelid, String userlevelname) {
        this.userlevelid = userlevelid;
        this.userlevelname = userlevelname;
    }

    public Integer getUserlevelid() {
        return userlevelid;
    }

    public void setUserlevelid(Integer userlevelid) {
        this.userlevelid = userlevelid;
    }

    public String getUserlevelname() {
        return userlevelname;
    }

    public void setUserlevelname(String userlevelname) {
        this.userlevelname = userlevelname;
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

    @XmlTransient
    public List<Userlevelpermissions> getUserlevelpermissionsList() {
        return userlevelpermissionsList;
    }

    public void setUserlevelpermissionsList(List<Userlevelpermissions> userlevelpermissionsList) {
        this.userlevelpermissionsList = userlevelpermissionsList;
    }

    @XmlTransient
    public List<Usuario> getUsuarioList() {
        return usuarioList;
    }

    public void setUsuarioList(List<Usuario> usuarioList) {
        this.usuarioList = usuarioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userlevelid != null ? userlevelid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Userlevels)) {
            return false;
        }
        Userlevels other = (Userlevels) object;
        if ((this.userlevelid == null && other.userlevelid != null) || (this.userlevelid != null && !this.userlevelid.equals(other.userlevelid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "db.usuarios.Userlevels[ userlevelid=" + userlevelid + " ]";
    }
    
}
