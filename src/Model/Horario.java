/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Rafael
 */
@Entity
@Table(name = "HORARIO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Horario.findAll", query = "SELECT h FROM Horario h")
    , @NamedQuery(name = "Horario.findByIdhorario", query = "SELECT h FROM Horario h WHERE h.idhorario = :idhorario")
    , @NamedQuery(name = "Horario.findByHoraprimeiraentrada", query = "SELECT h FROM Horario h WHERE h.horaprimeiraentrada = :horaprimeiraentrada")
    , @NamedQuery(name = "Horario.findByHoraprimeirasaida", query = "SELECT h FROM Horario h WHERE h.horaprimeirasaida = :horaprimeirasaida")
    , @NamedQuery(name = "Horario.findByHorasegundaentrada", query = "SELECT h FROM Horario h WHERE h.horasegundaentrada = :horasegundaentrada")
    , @NamedQuery(name = "Horario.findByHorasegundasaida", query = "SELECT h FROM Horario h WHERE h.horasegundasaida = :horasegundasaida")})
public class Horario implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "IDHORARIO")
    private BigDecimal idhorario;
    @Basic(optional = false)
    @Column(name = "HORAPRIMEIRAENTRADA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date horaprimeiraentrada;
    @Basic(optional = false)
    @Column(name = "HORAPRIMEIRASAIDA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date horaprimeirasaida;
    @Basic(optional = false)
    @Column(name = "HORASEGUNDAENTRADA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date horasegundaentrada;
    @Basic(optional = false)
    @Column(name = "HORASEGUNDASAIDA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date horasegundasaida;

    public Horario() {
    }

    public Horario(BigDecimal idhorario) {
        this.idhorario = idhorario;
    }

    public Horario(BigDecimal idhorario, Date horaprimeiraentrada, Date horaprimeirasaida, Date horasegundaentrada, Date horasegundasaida) {
        this.idhorario = idhorario;
        this.horaprimeiraentrada = horaprimeiraentrada;
        this.horaprimeirasaida = horaprimeirasaida;
        this.horasegundaentrada = horasegundaentrada;
        this.horasegundasaida = horasegundasaida;
    }

    public BigDecimal getIdhorario() {
        return idhorario;
    }

    public void setIdhorario(BigDecimal idhorario) {
        this.idhorario = idhorario;
    }

    public Date getHoraprimeiraentrada() {
        return horaprimeiraentrada;
    }

    public void setHoraprimeiraentrada(Date horaprimeiraentrada) {
        this.horaprimeiraentrada = horaprimeiraentrada;
    }

    public Date getHoraprimeirasaida() {
        return horaprimeirasaida;
    }

    public void setHoraprimeirasaida(Date horaprimeirasaida) {
        this.horaprimeirasaida = horaprimeirasaida;
    }

    public Date getHorasegundaentrada() {
        return horasegundaentrada;
    }

    public void setHorasegundaentrada(Date horasegundaentrada) {
        this.horasegundaentrada = horasegundaentrada;
    }

    public Date getHorasegundasaida() {
        return horasegundasaida;
    }

    public void setHorasegundasaida(Date horasegundasaida) {
        this.horasegundasaida = horasegundasaida;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idhorario != null ? idhorario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Horario)) {
            return false;
        }
        Horario other = (Horario) object;
        if ((this.idhorario == null && other.idhorario != null) || (this.idhorario != null && !this.idhorario.equals(other.idhorario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.Horario[ idhorario=" + idhorario + " ]";
    }
    
}
