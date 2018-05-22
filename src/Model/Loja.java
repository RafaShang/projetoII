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
@Table(name = "LOJA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Loja.findAll", query = "SELECT l FROM Loja l")
    , @NamedQuery(name = "Loja.findByIdloja", query = "SELECT l FROM Loja l WHERE l.idloja = :idloja")
    , @NamedQuery(name = "Loja.findByNome", query = "SELECT l FROM Loja l WHERE l.nome = :nome")})
public class Loja implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "IDLOJA")
    private Short idloja;
    @Basic(optional = false)
    @Column(name = "NOME")
    private String nome;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idloja", fetch = FetchType.LAZY)
    private List<Venda> vendaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "loja", fetch = FetchType.LAZY)
    private List<Produtoloja> produtolojaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idloja", fetch = FetchType.LAZY)
    private List<Entrega> entregaList;
    @JoinColumn(name = "IDLOCALIDADE", referencedColumnName = "IDLOCALIDADE")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Localidade idlocalidade;

    public Loja() {
    }

    public Loja(Short idloja) {
        this.idloja = idloja;
    }

    public Loja(Short idloja, String nome) {
        this.idloja = idloja;
        this.nome = nome;
    }

    public Short getIdloja() {
        return idloja;
    }

    public void setIdloja(Short idloja) {
        this.idloja = idloja;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @XmlTransient
    public List<Venda> getVendaList() {
        return vendaList;
    }

    public void setVendaList(List<Venda> vendaList) {
        this.vendaList = vendaList;
    }

    @XmlTransient
    public List<Produtoloja> getProdutolojaList() {
        return produtolojaList;
    }

    public void setProdutolojaList(List<Produtoloja> produtolojaList) {
        this.produtolojaList = produtolojaList;
    }

    @XmlTransient
    public List<Entrega> getEntregaList() {
        return entregaList;
    }

    public void setEntregaList(List<Entrega> entregaList) {
        this.entregaList = entregaList;
    }

    public Localidade getIdlocalidade() {
        return idlocalidade;
    }

    public void setIdlocalidade(Localidade idlocalidade) {
        this.idlocalidade = idlocalidade;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idloja != null ? idloja.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Loja)) {
            return false;
        }
        Loja other = (Loja) object;
        if ((this.idloja == null && other.idloja != null) || (this.idloja != null && !this.idloja.equals(other.idloja))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.Loja[ idloja=" + idloja + " ]";
    }
    
}
