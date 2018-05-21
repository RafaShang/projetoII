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
@Table(name = "LOCALIDADE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Localidade.findAll", query = "SELECT l FROM Localidade l")
    , @NamedQuery(name = "Localidade.findByIdlocalidade", query = "SELECT l FROM Localidade l WHERE l.idlocalidade = :idlocalidade")
    , @NamedQuery(name = "Localidade.findByNome", query = "SELECT l FROM Localidade l WHERE l.nome = :nome")})
public class Localidade implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "IDLOCALIDADE")
    private Short idlocalidade;
    @Basic(optional = false)
    @Column(name = "NOME")
    private String nome;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idlocalidade")
    private Collection<Armazem> armazemCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idlocalidade")
    private Collection<Loja> lojaCollection;

    public Localidade() {
    }

    public Localidade(Short idlocalidade) {
        this.idlocalidade = idlocalidade;
    }

    public Localidade(Short idlocalidade, String nome) {
        this.idlocalidade = idlocalidade;
        this.nome = nome;
    }

    public Short getIdlocalidade() {
        return idlocalidade;
    }

    public void setIdlocalidade(Short idlocalidade) {
        this.idlocalidade = idlocalidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @XmlTransient
    public Collection<Armazem> getArmazemCollection() {
        return armazemCollection;
    }

    public void setArmazemCollection(Collection<Armazem> armazemCollection) {
        this.armazemCollection = armazemCollection;
    }

    @XmlTransient
    public Collection<Loja> getLojaCollection() {
        return lojaCollection;
    }

    public void setLojaCollection(Collection<Loja> lojaCollection) {
        this.lojaCollection = lojaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idlocalidade != null ? idlocalidade.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Localidade)) {
            return false;
        }
        Localidade other = (Localidade) object;
        if ((this.idlocalidade == null && other.idlocalidade != null) || (this.idlocalidade != null && !this.idlocalidade.equals(other.idlocalidade))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.Localidade[ idlocalidade=" + idlocalidade + " ]";
    }
    
}
