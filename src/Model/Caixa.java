/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Rafael
 */
@Entity
@Table(name = "CAIXA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Caixa.findAll", query = "SELECT c FROM Caixa c")
    , @NamedQuery(name = "Caixa.findByIdarmazem", query = "SELECT c FROM Caixa c WHERE c.caixaPK.idarmazem = :idarmazem")
    , @NamedQuery(name = "Caixa.findByCodbarras", query = "SELECT c FROM Caixa c WHERE c.caixaPK.codbarras = :codbarras")
    , @NamedQuery(name = "Caixa.findByIdcaixa", query = "SELECT c FROM Caixa c WHERE c.idcaixa = :idcaixa")
    , @NamedQuery(name = "Caixa.findByQuantidade", query = "SELECT c FROM Caixa c WHERE c.quantidade = :quantidade")})
public class Caixa implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CaixaPK caixaPK;
    @Basic(optional = false)
    @Column(name = "IDCAIXA")
    private short idcaixa;
    @Basic(optional = false)
    @Column(name = "QUANTIDADE")
    private short quantidade;
    @JoinColumn(name = "IDARMAZEM", referencedColumnName = "IDARMAZEM", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Armazem armazem;
    @JoinColumn(name = "CODBARRAS", referencedColumnName = "CODBARRAS", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Produto produto;

    public Caixa() {
    }

    public Caixa(CaixaPK caixaPK) {
        this.caixaPK = caixaPK;
    }

    public Caixa(CaixaPK caixaPK, short idcaixa, short quantidade) {
        this.caixaPK = caixaPK;
        this.idcaixa = idcaixa;
        this.quantidade = quantidade;
    }

    public Caixa(short idarmazem, long codbarras) {
        this.caixaPK = new CaixaPK(idarmazem, codbarras);
    }

    public CaixaPK getCaixaPK() {
        return caixaPK;
    }

    public void setCaixaPK(CaixaPK caixaPK) {
        this.caixaPK = caixaPK;
    }

    public short getIdcaixa() {
        return idcaixa;
    }

    public void setIdcaixa(short idcaixa) {
        this.idcaixa = idcaixa;
    }

    public short getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(short quantidade) {
        this.quantidade = quantidade;
    }

    public Armazem getArmazem() {
        return armazem;
    }

    public void setArmazem(Armazem armazem) {
        this.armazem = armazem;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (caixaPK != null ? caixaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Caixa)) {
            return false;
        }
        Caixa other = (Caixa) object;
        if ((this.caixaPK == null && other.caixaPK != null) || (this.caixaPK != null && !this.caixaPK.equals(other.caixaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.Caixa[ caixaPK=" + caixaPK + " ]";
    }
    
}
