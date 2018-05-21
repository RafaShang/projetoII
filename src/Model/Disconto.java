/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Rafael
 */
@Entity
@Table(name = "DISCONTO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Disconto.findAll", query = "SELECT d FROM Disconto d")
    , @NamedQuery(name = "Disconto.findByIddesconto", query = "SELECT d FROM Disconto d WHERE d.iddesconto = :iddesconto")
    , @NamedQuery(name = "Disconto.findByDatainicio", query = "SELECT d FROM Disconto d WHERE d.datainicio = :datainicio")
    , @NamedQuery(name = "Disconto.findByDatafim", query = "SELECT d FROM Disconto d WHERE d.datafim = :datafim")
    , @NamedQuery(name = "Disconto.findByValor", query = "SELECT d FROM Disconto d WHERE d.valor = :valor")})
public class Disconto implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "IDDESCONTO")
    private BigDecimal iddesconto;
    @Basic(optional = false)
    @Column(name = "DATAINICIO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datainicio;
    @Basic(optional = false)
    @Column(name = "DATAFIM")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datafim;
    @Basic(optional = false)
    @Column(name = "VALOR")
    private double valor;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "iddisconto")
    private Collection<Produtoloja> produtolojaCollection;

    public Disconto() {
    }

    public Disconto(BigDecimal iddesconto) {
        this.iddesconto = iddesconto;
    }

    public Disconto(BigDecimal iddesconto, Date datainicio, Date datafim, double valor) {
        this.iddesconto = iddesconto;
        this.datainicio = datainicio;
        this.datafim = datafim;
        this.valor = valor;
    }

    public BigDecimal getIddesconto() {
        return iddesconto;
    }

    public void setIddesconto(BigDecimal iddesconto) {
        this.iddesconto = iddesconto;
    }

    public Date getDatainicio() {
        return datainicio;
    }

    public void setDatainicio(Date datainicio) {
        this.datainicio = datainicio;
    }

    public Date getDatafim() {
        return datafim;
    }

    public void setDatafim(Date datafim) {
        this.datafim = datafim;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    @XmlTransient
    public Collection<Produtoloja> getProdutolojaCollection() {
        return produtolojaCollection;
    }

    public void setProdutolojaCollection(Collection<Produtoloja> produtolojaCollection) {
        this.produtolojaCollection = produtolojaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iddesconto != null ? iddesconto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Disconto)) {
            return false;
        }
        Disconto other = (Disconto) object;
        if ((this.iddesconto == null && other.iddesconto != null) || (this.iddesconto != null && !this.iddesconto.equals(other.iddesconto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.Disconto[ iddesconto=" + iddesconto + " ]";
    }
    
}
