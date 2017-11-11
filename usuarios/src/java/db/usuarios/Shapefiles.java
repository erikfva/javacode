/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db.usuarios;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author evargas
 */
@Entity
@Table(name = "registro_derecho.shapefiles")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Shapefiles.findAll", query = "SELECT s FROM Shapefiles s")
    , @NamedQuery(name = "Shapefiles.findByIdshapefile", query = "SELECT s FROM Shapefiles s WHERE s.idshapefile = :idshapefile")
    , @NamedQuery(name = "Shapefiles.findByIdaplicacion", query = "SELECT s FROM Shapefiles s WHERE s.idaplicacion = :idaplicacion")
    , @NamedQuery(name = "Shapefiles.findByToken", query = "SELECT s FROM Shapefiles s WHERE s.token = :token")
    , @NamedQuery(name = "Shapefiles.findByIdusuario", query = "SELECT s FROM Shapefiles s WHERE s.idusuario = :idusuario")
    , @NamedQuery(name = "Shapefiles.findByTipo", query = "SELECT s FROM Shapefiles s WHERE s.tipo = :tipo")
    , @NamedQuery(name = "Shapefiles.findByFolder", query = "SELECT s FROM Shapefiles s WHERE s.folder = :folder")
    , @NamedQuery(name = "Shapefiles.findByNarchivo", query = "SELECT s FROM Shapefiles s WHERE s.narchivo = :narchivo")
    , @NamedQuery(name = "Shapefiles.findByNarchivoorigen", query = "SELECT s FROM Shapefiles s WHERE s.narchivoorigen = :narchivoorigen")
    , @NamedQuery(name = "Shapefiles.findByFechacreacion", query = "SELECT s FROM Shapefiles s WHERE s.fechacreacion = :fechacreacion")
    , @NamedQuery(name = "Shapefiles.findByTamano", query = "SELECT s FROM Shapefiles s WHERE s.tamano = :tamano")
    , @NamedQuery(name = "Shapefiles.findBySrid", query = "SELECT s FROM Shapefiles s WHERE s.srid = :srid")
    , @NamedQuery(name = "Shapefiles.findByTipogeom", query = "SELECT s FROM Shapefiles s WHERE s.tipogeom = :tipogeom")})
public class Shapefiles implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idshapefile")
    private Integer idshapefile;
    @Size(max = 255)
    @Column(name = "idaplicacion")
    private String idaplicacion;
    @Size(max = 50)
    @Column(name = "token")
    private String token;
    @Column(name = "idusuario")
    private Integer idusuario;
    @Size(max = 255)
    @Column(name = "tipo")
    private String tipo;
    @Size(max = 255)
    @Column(name = "folder")
    private String folder;
    @Size(max = 255)
    @Column(name = "narchivo")
    private String narchivo;
    @Size(max = 255)
    @Column(name = "narchivoorigen")
    private String narchivoorigen;
    @Column(name = "fechacreacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechacreacion;
    @Column(name = "tamano")
    private BigInteger tamano;
    @Column(name = "srid")
    private Integer srid;
    @Column(name = "tipogeom")
    private Integer tipogeom;

    public Shapefiles() {
    }

    public Shapefiles(Integer idshapefile) {
        this.idshapefile = idshapefile;
    }

    public Integer getIdshapefile() {
        return idshapefile;
    }

    public void setIdshapefile(Integer idshapefile) {
        this.idshapefile = idshapefile;
    }

    public String getIdaplicacion() {
        return idaplicacion;
    }

    public void setIdaplicacion(String idaplicacion) {
        this.idaplicacion = idaplicacion;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Integer getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(Integer idusuario) {
        this.idusuario = idusuario;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getFolder() {
        return folder;
    }

    public void setFolder(String folder) {
        this.folder = folder;
    }

    public String getNarchivo() {
        return narchivo;
    }

    public void setNarchivo(String narchivo) {
        this.narchivo = narchivo;
    }

    public String getNarchivoorigen() {
        return narchivoorigen;
    }

    public void setNarchivoorigen(String narchivoorigen) {
        this.narchivoorigen = narchivoorigen;
    }

    public Date getFechacreacion() {
        return fechacreacion;
    }

    public void setFechacreacion(Date fechacreacion) {
        this.fechacreacion = fechacreacion;
    }

    public BigInteger getTamano() {
        return tamano;
    }

    public void setTamano(BigInteger tamano) {
        this.tamano = tamano;
    }

    public Integer getSrid() {
        return srid;
    }

    public void setSrid(Integer srid) {
        this.srid = srid;
    }

    public Integer getTipogeom() {
        return tipogeom;
    }

    public void setTipogeom(Integer tipogeom) {
        this.tipogeom = tipogeom;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idshapefile != null ? idshapefile.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Shapefiles)) {
            return false;
        }
        Shapefiles other = (Shapefiles) object;
        if ((this.idshapefile == null && other.idshapefile != null) || (this.idshapefile != null && !this.idshapefile.equals(other.idshapefile))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "db.usuarios.Shapefiles[ idshapefile=" + idshapefile + " ]";
    }
    
}
