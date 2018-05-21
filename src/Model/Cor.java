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
@Table(name = "COR")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cor.findAll", query = "SELECT c FROM Cor c")
    , @NamedQuery(name = "Cor.findByIdcor", query = "SELECT c FROM Cor c WHERE c.idcor = :idcor")
    , @NamedQuery(name = "Cor.findByNome", query = "SELECT c FROM Cor c WHERE c.nome = :nome")})
public class Cor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "IDCOR")
    private Short idcor;
    @Basic(optional = false)
    @Column(name = "NOME")
    private String nome;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idcor")
    private Collection<Produto> produtoCollection;

    public Cor() {
    }

    public Cor(Short idcor) {
        this.idcor = idcor;
    }

    public Cor(Short idcor, String nome) {
        this.idcor = idcor;
        this.nome = nome;
    }

    public Short getIdcor() {
        return idcor;
    }

    public void setIdcor(Short idcor) {
        this.idcor = idcor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @XmlTransient
    public Collection<Produto> getProdutoCollection() {
        return produtoCollection;
    }

    public void setProdutoCollection(Collection<Produto> produtoCollection) {
        this.produtoCollection = produtoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcor != null ? idcor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cor)) {
            return false;
        }
        Cor other = (Cor) object;
        if ((this.idcor == null && other.idcor != null) || (this.idcor != null && !this.idcor.equals(other.idcor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.Cor[ idcor=" + idcor + " ]";
    }

}
