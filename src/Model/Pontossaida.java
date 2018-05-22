/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Rafael
 */
@Entity
@Table(name = "PONTOSSAIDA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pontossaida.findAll", query = "SELECT p FROM Pontossaida p")
    , @NamedQuery(name = "Pontossaida.findByIdpontossaida", query = "SELECT p FROM Pontossaida p WHERE p.idpontossaida = :idpontossaida")})
public class Pontossaida implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "IDPONTOSSAIDA")
    private BigDecimal idpontossaida;
    @JoinColumns({
        @JoinColumn(name = "IDPONTOHORARIO", referencedColumnName = "IDPONTOHORARIO")
        , @JoinColumn(name = "HORA", referencedColumnName = "DATA")
        , @JoinColumn(name = "IDPONTOSSAIDA", referencedColumnName = "IDFUNCIONARIO", insertable = false, updatable = false)})
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Pontohorario pontohorario;

    public Pontossaida() {
    }

    public Pontossaida(BigDecimal idpontossaida) {
        this.idpontossaida = idpontossaida;
    }

    public BigDecimal getIdpontossaida() {
        return idpontossaida;
    }

    public void setIdpontossaida(BigDecimal idpontossaida) {
        this.idpontossaida = idpontossaida;
    }

    public Pontohorario getPontohorario() {
        return pontohorario;
    }

    public void setPontohorario(Pontohorario pontohorario) {
        this.pontohorario = pontohorario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idpontossaida != null ? idpontossaida.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pontossaida)) {
            return false;
        }
        Pontossaida other = (Pontossaida) object;
        if ((this.idpontossaida == null && other.idpontossaida != null) || (this.idpontossaida != null && !this.idpontossaida.equals(other.idpontossaida))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.Pontossaida[ idpontossaida=" + idpontossaida + " ]";
    }
    
}
