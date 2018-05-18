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
import javax.persistence.FetchType;
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
@Table(name = "PRODUTOENTREGA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Produtoentrega.findAll", query = "SELECT p FROM Produtoentrega p")
    , @NamedQuery(name = "Produtoentrega.findByCodbarras", query = "SELECT p FROM Produtoentrega p WHERE p.produtoentregaPK.codbarras = :codbarras")
    , @NamedQuery(name = "Produtoentrega.findByIdentrega", query = "SELECT p FROM Produtoentrega p WHERE p.produtoentregaPK.identrega = :identrega")
    , @NamedQuery(name = "Produtoentrega.findByQuantidade", query = "SELECT p FROM Produtoentrega p WHERE p.quantidade = :quantidade")})
public class Produtoentrega implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ProdutoentregaPK produtoentregaPK;
    @Basic(optional = false)
    @Column(name = "QUANTIDADE")
    private short quantidade;
    @JoinColumn(name = "IDENTREGA", referencedColumnName = "IDENTREGA", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Entrega entrega;
    @JoinColumn(name = "CODBARRAS", referencedColumnName = "CODBARRAS", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Produto produto;

    public Produtoentrega() {
    }

    public Produtoentrega(ProdutoentregaPK produtoentregaPK) {
        this.produtoentregaPK = produtoentregaPK;
    }

    public Produtoentrega(ProdutoentregaPK produtoentregaPK, short quantidade) {
        this.produtoentregaPK = produtoentregaPK;
        this.quantidade = quantidade;
    }

    public Produtoentrega(long codbarras, int identrega) {
        this.produtoentregaPK = new ProdutoentregaPK(codbarras, identrega);
    }

    public ProdutoentregaPK getProdutoentregaPK() {
        return produtoentregaPK;
    }

    public void setProdutoentregaPK(ProdutoentregaPK produtoentregaPK) {
        this.produtoentregaPK = produtoentregaPK;
    }

    public short getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(short quantidade) {
        this.quantidade = quantidade;
    }

    public Entrega getEntrega() {
        return entrega;
    }

    public void setEntrega(Entrega entrega) {
        this.entrega = entrega;
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
        hash += (produtoentregaPK != null ? produtoentregaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Produtoentrega)) {
            return false;
        }
        Produtoentrega other = (Produtoentrega) object;
        if ((this.produtoentregaPK == null && other.produtoentregaPK != null) || (this.produtoentregaPK != null && !this.produtoentregaPK.equals(other.produtoentregaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.Produtoentrega[ produtoentregaPK=" + produtoentregaPK + " ]";
    }
    
}
