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
@Table(name = "TIPOPAGAMENTO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tipopagamento.findAll", query = "SELECT t FROM Tipopagamento t")
    , @NamedQuery(name = "Tipopagamento.findByIdtipopagamento", query = "SELECT t FROM Tipopagamento t WHERE t.idtipopagamento = :idtipopagamento")
    , @NamedQuery(name = "Tipopagamento.findByNome", query = "SELECT t FROM Tipopagamento t WHERE t.nome = :nome")})
public class Tipopagamento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "IDTIPOPAGAMENTO")
    private Short idtipopagamento;
    @Basic(optional = false)
    @Column(name = "NOME")
    private String nome;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipopagamento")
    private Collection<Venda> vendaCollection;

    public Tipopagamento() {
    }

    public Tipopagamento(Short idtipopagamento) {
        this.idtipopagamento = idtipopagamento;
    }

    public Tipopagamento(Short idtipopagamento, String nome) {
        this.idtipopagamento = idtipopagamento;
        this.nome = nome;
    }

    public Short getIdtipopagamento() {
        return idtipopagamento;
    }

    public void setIdtipopagamento(Short idtipopagamento) {
        this.idtipopagamento = idtipopagamento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @XmlTransient
    public Collection<Venda> getVendaCollection() {
        return vendaCollection;
    }

    public void setVendaCollection(Collection<Venda> vendaCollection) {
        this.vendaCollection = vendaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtipopagamento != null ? idtipopagamento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tipopagamento)) {
            return false;
        }
        Tipopagamento other = (Tipopagamento) object;
        if ((this.idtipopagamento == null && other.idtipopagamento != null) || (this.idtipopagamento != null && !this.idtipopagamento.equals(other.idtipopagamento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.Tipopagamento[ idtipopagamento=" + idtipopagamento + " ]";
    }
    
}
