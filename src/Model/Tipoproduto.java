/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
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
@Table(name = "TIPOPRODUTO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tipoproduto.findAll", query = "SELECT t FROM Tipoproduto t")
    , @NamedQuery(name = "Tipoproduto.findByIdtipoproduto", query = "SELECT t FROM Tipoproduto t WHERE t.idtipoproduto = :idtipoproduto")
    , @NamedQuery(name = "Tipoproduto.findByNome", query = "SELECT t FROM Tipoproduto t WHERE t.nome = :nome")})
public class Tipoproduto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "IDTIPOPRODUTO")
    private Short idtipoproduto;
    @Basic(optional = false)
    @Column(name = "NOME")
    private String nome;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idtipoproduto", fetch = FetchType.LAZY)
    private List<Produto> produtoList;

    public Tipoproduto() {
    }

    public Tipoproduto(Short idtipoproduto) {
        this.idtipoproduto = idtipoproduto;
    }

    public Tipoproduto(Short idtipoproduto, String nome) {
        this.idtipoproduto = idtipoproduto;
        this.nome = nome;
    }

    public Short getIdtipoproduto() {
        return idtipoproduto;
    }

    public void setIdtipoproduto(Short idtipoproduto) {
        this.idtipoproduto = idtipoproduto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @XmlTransient
    public List<Produto> getProdutoList() {
        return produtoList;
    }

    public void setProdutoList(List<Produto> produtoList) {
        this.produtoList = produtoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtipoproduto != null ? idtipoproduto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tipoproduto)) {
            return false;
        }
        Tipoproduto other = (Tipoproduto) object;
        if ((this.idtipoproduto == null && other.idtipoproduto != null) || (this.idtipoproduto != null && !this.idtipoproduto.equals(other.idtipoproduto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.Tipoproduto[ idtipoproduto=" + idtipoproduto + " ]";
    }
    
}
