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
@Table(name = "PONTOSENTRADA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pontosentrada.findAll", query = "SELECT p FROM Pontosentrada p")
    , @NamedQuery(name = "Pontosentrada.findByIdentrada", query = "SELECT p FROM Pontosentrada p WHERE p.identrada = :identrada")})
public class Pontosentrada implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "IDENTRADA")
    private BigDecimal identrada;
    @JoinColumns({
        @JoinColumn(name = "IDPONTOHORARIO", referencedColumnName = "IDPONTOHORARIO")
        , @JoinColumn(name = "HORA", referencedColumnName = "DATA")
        , @JoinColumn(name = "IDENTRADA", referencedColumnName = "IDFUNCIONARIO", insertable = false, updatable = false)})
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Pontohorario pontohorario;

    public Pontosentrada() {
    }

    public Pontosentrada(BigDecimal identrada) {
        this.identrada = identrada;
    }

    public BigDecimal getIdentrada() {
        return identrada;
    }

    public void setIdentrada(BigDecimal identrada) {
        this.identrada = identrada;
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
        hash += (identrada != null ? identrada.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pontosentrada)) {
            return false;
        }
        Pontosentrada other = (Pontosentrada) object;
        if ((this.identrada == null && other.identrada != null) || (this.identrada != null && !this.identrada.equals(other.identrada))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.Pontosentrada[ identrada=" + identrada + " ]";
    }
    
}
