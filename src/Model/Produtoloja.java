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
@Table(name = "PRODUTOLOJA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Produtoloja.findAll", query = "SELECT p FROM Produtoloja p")
    , @NamedQuery(name = "Produtoloja.findByCodbarras", query = "SELECT p FROM Produtoloja p WHERE p.produtolojaPK.codbarras = :codbarras")
    , @NamedQuery(name = "Produtoloja.findByIdloja", query = "SELECT p FROM Produtoloja p WHERE p.produtolojaPK.idloja = :idloja")
    , @NamedQuery(name = "Produtoloja.findByQuantidade", query = "SELECT p FROM Produtoloja p WHERE p.quantidade = :quantidade")})
public class Produtoloja implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ProdutolojaPK produtolojaPK;
    @Basic(optional = false)
    @Column(name = "QUANTIDADE")
    private short quantidade;
    @JoinColumn(name = "IDDISCONTO", referencedColumnName = "IDDESCONTO")
    @ManyToOne(optional = false)
    private Disconto iddisconto;
    @JoinColumn(name = "IDLOJA", referencedColumnName = "IDLOJA", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Loja loja;
    @JoinColumn(name = "CODBARRAS", referencedColumnName = "CODBARRAS", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Produto produto;

    public Produtoloja() {
    }

    public Produtoloja(ProdutolojaPK produtolojaPK) {
        this.produtolojaPK = produtolojaPK;
    }

    public Produtoloja(ProdutolojaPK produtolojaPK, short quantidade) {
        this.produtolojaPK = produtolojaPK;
        this.quantidade = quantidade;
    }

    public Produtoloja(long codbarras, short idloja) {
        this.produtolojaPK = new ProdutolojaPK(codbarras, idloja);
    }

    public ProdutolojaPK getProdutolojaPK() {
        return produtolojaPK;
    }

    public void setProdutolojaPK(ProdutolojaPK produtolojaPK) {
        this.produtolojaPK = produtolojaPK;
    }

    public short getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(short quantidade) {
        this.quantidade = quantidade;
    }

    public Disconto getIddisconto() {
        return iddisconto;
    }

    public void setIddisconto(Disconto iddisconto) {
        this.iddisconto = iddisconto;
    }

    public Loja getLoja() {
        return loja;
    }

    public void setLoja(Loja loja) {
        this.loja = loja;
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
        hash += (produtolojaPK != null ? produtolojaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Produtoloja)) {
            return false;
        }
        Produtoloja other = (Produtoloja) object;
        if ((this.produtolojaPK == null && other.produtolojaPK != null) || (this.produtolojaPK != null && !this.produtolojaPK.equals(other.produtolojaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.Produtoloja[ produtolojaPK=" + produtolojaPK + " ]";
    }
    
}
