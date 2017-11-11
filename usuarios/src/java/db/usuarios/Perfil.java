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
@Table(name = "registro_derecho.perfil")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Perfil.findAll", query = "SELECT p FROM Perfil p")
    , @NamedQuery(name = "Perfil.findByIdperfil", query = "SELECT p FROM Perfil p WHERE p.idperfil = :idperfil")
    , @NamedQuery(name = "Perfil.findByInterfaz", query = "SELECT p FROM Perfil p WHERE p.interfaz = :interfaz")
    , @NamedQuery(name = "Perfil.findByComportamiento", query = "SELECT p FROM Perfil p WHERE p.comportamiento = :comportamiento")
    , @NamedQuery(name = "Perfil.findByOpciones", query = "SELECT p FROM Perfil p WHERE p.opciones = :opciones")})
public class Perfil implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "idperfil")
    private String idperfil;
    @Size(max = 2147483647)
    @Column(name = "interfaz")
    private String interfaz;
    @Size(max = 255)
    @Column(name = "comportamiento")
    private String comportamiento;
    @Size(max = 2147483647)
    @Column(name = "opciones")
    private String opciones;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "perfil")
    private List<Usuario> usuarioList;

    public Perfil() {
    }

    public Perfil(String idperfil) {
        this.idperfil = idperfil;
    }

    public String getIdperfil() {
        return idperfil;
    }

    public void setIdperfil(String idperfil) {
        this.idperfil = idperfil;
    }

    public String getInterfaz() {
        return interfaz;
    }

    public void setInterfaz(String interfaz) {
        this.interfaz = interfaz;
    }

    public String getComportamiento() {
        return comportamiento;
    }

    public void setComportamiento(String comportamiento) {
        this.comportamiento = comportamiento;
    }

    public String getOpciones() {
        return opciones;
    }

    public void setOpciones(String opciones) {
        this.opciones = opciones;
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
        hash += (idperfil != null ? idperfil.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Perfil)) {
            return false;
        }
        Perfil other = (Perfil) object;
        if ((this.idperfil == null && other.idperfil != null) || (this.idperfil != null && !this.idperfil.equals(other.idperfil))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "db.usuarios.Perfil[ idperfil=" + idperfil + " ]";
    }
    
}
