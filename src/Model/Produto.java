/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Rafael
 */
@Entity
@Table(name = "PRODUTO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Produto.findAll", query = "SELECT p FROM Produto p")
    , @NamedQuery(name = "Produto.findByCodbarras", query = "SELECT p FROM Produto p WHERE p.codbarras = :codbarras")
    , @NamedQuery(name = "Produto.findByDescricao", query = "SELECT p FROM Produto p WHERE p.descricao = :descricao")
    , @NamedQuery(name = "Produto.findByPrecocompra", query = "SELECT p FROM Produto p WHERE p.precocompra = :precocompra")
    , @NamedQuery(name = "Produto.findByPrecovenda", query = "SELECT p FROM Produto p WHERE p.precovenda = :precovenda")
    , @NamedQuery(name = "Produto.findByGenero", query = "SELECT p FROM Produto p WHERE p.genero = :genero")})
public class Produto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODBARRAS")
    private Long codbarras;
    @Basic(optional = false)
    @Column(name = "DESCRICAO")
    private String descricao;
    @Basic(optional = false)
    @Column(name = "PRECOCOMPRA")
    private long precocompra;
    @Basic(optional = false)
    @Column(name = "PRECOVENDA")
    private long precovenda;
    @Basic(optional = false)
    @Column(name = "GENERO")
    private Character genero;
    @JoinColumn(name = "IDCOR", referencedColumnName = "IDCOR")
    @ManyToOne(optional = false)
    private Cor idcor;
    @JoinColumn(name = "IDMARCA", referencedColumnName = "IDMARCA")
    @ManyToOne(optional = false)
    private Marca idmarca;
    @JoinColumn(name = "IDTAMANHO", referencedColumnName = "IDTAMANHO")
    @ManyToOne(optional = false)
    private Tamanho idtamanho;
    @JoinColumn(name = "IDTIPOPRODUTO", referencedColumnName = "IDTIPOPRODUTO")
    @ManyToOne(optional = false)
    private Tipoproduto idtipoproduto;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "produto")
    private Collection<Produtoloja> produtolojaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "produto")
    private Collection<Produtoentrega> produtoentregaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "produto")
    private Collection<Produtovenda> produtovendaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "produto")
    private Collection<Caixa> caixaCollection;

    public Produto() {
    }

    public Produto(Long codbarras) {
        this.codbarras = codbarras;
    }

    public Produto(Long codbarras, String descricao, long precocompra, long precovenda, Character genero) {
        this.codbarras = codbarras;
        this.descricao = descricao;
        this.precocompra = precocompra;
        this.precovenda = precovenda;
        this.genero = genero;
    }

    public Long getCodbarras() {
        return codbarras;
    }

    public void setCodbarras(Long codbarras) {
        this.codbarras = codbarras;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public long getPrecocompra() {
        return precocompra;
    }

    public void setPrecocompra(long precocompra) {
        this.precocompra = precocompra;
    }

    public long getPrecovenda() {
        return precovenda;
    }

    public void setPrecovenda(long precovenda) {
        this.precovenda = precovenda;
    }

    public Character getGenero() {
        return genero;
    }

    public void setGenero(Character genero) {
        this.genero = genero;
    }

    public Cor getIdcor() {
        return idcor;
    }

    public void setIdcor(Cor idcor) {
        this.idcor = idcor;
    }

    public Marca getIdmarca() {
        return idmarca;
    }

    public void setIdmarca(Marca idmarca) {
        this.idmarca = idmarca;
    }

    public Tamanho getIdtamanho() {
        return idtamanho;
    }

    public void setIdtamanho(Tamanho idtamanho) {
        this.idtamanho = idtamanho;
    }

    public Tipoproduto getIdtipoproduto() {
        return idtipoproduto;
    }

    public void setIdtipoproduto(Tipoproduto idtipoproduto) {
        this.idtipoproduto = idtipoproduto;
    }

    @XmlTransient
    public Collection<Produtoloja> getProdutolojaCollection() {
        return produtolojaCollection;
    }

    public void setProdutolojaCollection(Collection<Produtoloja> produtolojaCollection) {
        this.produtolojaCollection = produtolojaCollection;
    }

    @XmlTransient
    public Collection<Produtoentrega> getProdutoentregaCollection() {
        return produtoentregaCollection;
    }

    public void setProdutoentregaCollection(Collection<Produtoentrega> produtoentregaCollection) {
        this.produtoentregaCollection = produtoentregaCollection;
    }

    @XmlTransient
    public Collection<Produtovenda> getProdutovendaCollection() {
        return produtovendaCollection;
    }

    public void setProdutovendaCollection(Collection<Produtovenda> produtovendaCollection) {
        this.produtovendaCollection = produtovendaCollection;
    }

    @XmlTransient
    public Collection<Caixa> getCaixaCollection() {
        return caixaCollection;
    }

    public void setCaixaCollection(Collection<Caixa> caixaCollection) {
        this.caixaCollection = caixaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codbarras != null ? codbarras.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Produto)) {
            return false;
        }
        Produto other = (Produto) object;
        if ((this.codbarras == null && other.codbarras != null) || (this.codbarras != null && !this.codbarras.equals(other.codbarras))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.Produto[ codbarras=" + codbarras + " ]";
    }
    
}
