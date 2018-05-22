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
@Table(name = "PRODUTOVENDA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Produtovenda.findAll", query = "SELECT p FROM Produtovenda p")
    , @NamedQuery(name = "Produtovenda.findByCodbarras", query = "SELECT p FROM Produtovenda p WHERE p.produtovendaPK.codbarras = :codbarras")
    , @NamedQuery(name = "Produtovenda.findByIdvenda", query = "SELECT p FROM Produtovenda p WHERE p.produtovendaPK.idvenda = :idvenda")
    , @NamedQuery(name = "Produtovenda.findByQuantidade", query = "SELECT p FROM Produtovenda p WHERE p.quantidade = :quantidade")})
public class Produtovenda implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ProdutovendaPK produtovendaPK;
    @Basic(optional = false)
    @Column(name = "QUANTIDADE")
    private short quantidade;
    @JoinColumn(name = "CODBARRAS", referencedColumnName = "CODBARRAS", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Produto produto;
    @JoinColumn(name = "IDVENDA", referencedColumnName = "IDVENDA", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Venda venda;

    public Produtovenda() {
    }

    public Produtovenda(ProdutovendaPK produtovendaPK) {
        this.produtovendaPK = produtovendaPK;
    }

    public Produtovenda(ProdutovendaPK produtovendaPK, short quantidade) {
        this.produtovendaPK = produtovendaPK;
        this.quantidade = quantidade;
    }

    public Produtovenda(long codbarras, int idvenda) {
        this.produtovendaPK = new ProdutovendaPK(codbarras, idvenda);
    }

    public ProdutovendaPK getProdutovendaPK() {
        return produtovendaPK;
    }

    public void setProdutovendaPK(ProdutovendaPK produtovendaPK) {
        this.produtovendaPK = produtovendaPK;
    }

    public short getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(short quantidade) {
        this.quantidade = quantidade;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (produtovendaPK != null ? produtovendaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Produtovenda)) {
            return false;
        }
        Produtovenda other = (Produtovenda) object;
        if ((this.produtovendaPK == null && other.produtovendaPK != null) || (this.produtovendaPK != null && !this.produtovendaPK.equals(other.produtovendaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.Produtovenda[ produtovendaPK=" + produtovendaPK + " ]";
    }
    
}
