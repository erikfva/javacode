/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db.usuarios;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author evargas
 */
@Entity
@Table(name = "appacciones")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Appacciones.findAll", query = "SELECT a FROM Appacciones a")
    , @NamedQuery(name = "Appacciones.findByIdaccion", query = "SELECT a FROM Appacciones a WHERE a.idaccion = :idaccion")
    , @NamedQuery(name = "Appacciones.findByAccion", query = "SELECT a FROM Appacciones a WHERE a.accion = :accion")
    , @NamedQuery(name = "Appacciones.findByContexto", query = "SELECT a FROM Appacciones a WHERE a.contexto = :contexto")})
public class Appacciones implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "idaccion")
    private String idaccion;
    @Size(max = 200)
    @Column(name = "accion")
    private String accion;
    @Size(max = 200)
    @Column(name = "contexto")
    private String contexto;

    public Appacciones() {
    }

    public Appacciones(String idaccion) {
        this.idaccion = idaccion;
    }

    public String getIdaccion() {
        return idaccion;
    }

    public void setIdaccion(String idaccion) {
        this.idaccion = idaccion;
    }

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }

    public String getContexto() {
        return contexto;
    }

    public void setContexto(String contexto) {
        this.contexto = contexto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idaccion != null ? idaccion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Appacciones)) {
            return false;
        }
        Appacciones other = (Appacciones) object;
        if ((this.idaccion == null && other.idaccion != null) || (this.idaccion != null && !this.idaccion.equals(other.idaccion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "db.usuarios.Appacciones[ idaccion=" + idaccion + " ]";
    }
    
}
