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
@Table(name = "TAMANHO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tamanho.findAll", query = "SELECT t FROM Tamanho t")
    , @NamedQuery(name = "Tamanho.findByIdtamanho", query = "SELECT t FROM Tamanho t WHERE t.idtamanho = :idtamanho")
    , @NamedQuery(name = "Tamanho.findByDescricao", query = "SELECT t FROM Tamanho t WHERE t.descricao = :descricao")})
public class Tamanho implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "IDTAMANHO")
    private Short idtamanho;
    @Basic(optional = false)
    @Column(name = "DESCRICAO")
    private String descricao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idtamanho", fetch = FetchType.LAZY)
    private List<Produto> produtoList;

    public Tamanho() {
    }

    public Tamanho(Short idtamanho) {
        this.idtamanho = idtamanho;
    }

    public Tamanho(Short idtamanho, String descricao) {
        this.idtamanho = idtamanho;
        this.descricao = descricao;
    }

    public Short getIdtamanho() {
        return idtamanho;
    }

    public void setIdtamanho(Short idtamanho) {
        this.idtamanho = idtamanho;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
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
        hash += (idtamanho != null ? idtamanho.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tamanho)) {
            return false;
        }
        Tamanho other = (Tamanho) object;
        if ((this.idtamanho == null && other.idtamanho != null) || (this.idtamanho != null && !this.idtamanho.equals(other.idtamanho))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.Tamanho[ idtamanho=" + idtamanho + " ]";
    }
    
}
