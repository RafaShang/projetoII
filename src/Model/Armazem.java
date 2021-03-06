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
@Table(name = "ARMAZEM")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Armazem.findAll", query = "SELECT a FROM Armazem a")
    , @NamedQuery(name = "Armazem.findByIdarmazem", query = "SELECT a FROM Armazem a WHERE a.idarmazem = :idarmazem")
    , @NamedQuery(name = "Armazem.findByNome", query = "SELECT a FROM Armazem a WHERE a.nome = :nome")})
public class Armazem implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "IDARMAZEM")
    private Short idarmazem;
    @Basic(optional = false)
    @Column(name = "NOME")
    private String nome;
    @JoinColumn(name = "IDLOCALIDADE", referencedColumnName = "IDLOCALIDADE")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Localidade idlocalidade;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idarmazem", fetch = FetchType.LAZY)
    private List<Entrega> entregaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "armazem", fetch = FetchType.LAZY)
    private List<Caixa> caixaList;

    public Armazem() {
    }

    public Armazem(Short idarmazem) {
        this.idarmazem = idarmazem;
    }

    public Armazem(Short idarmazem, String nome) {
        this.idarmazem = idarmazem;
        this.nome = nome;
    }

    public Short getIdarmazem() {
        return idarmazem;
    }

    public void setIdarmazem(Short idarmazem) {
        this.idarmazem = idarmazem;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Localidade getIdlocalidade() {
        return idlocalidade;
    }

    public void setIdlocalidade(Localidade idlocalidade) {
        this.idlocalidade = idlocalidade;
    }

    @XmlTransient
    public List<Entrega> getEntregaList() {
        return entregaList;
    }

    public void setEntregaList(List<Entrega> entregaList) {
        this.entregaList = entregaList;
    }

    @XmlTransient
    public List<Caixa> getCaixaList() {
        return caixaList;
    }

    public void setCaixaList(List<Caixa> caixaList) {
        this.caixaList = caixaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idarmazem != null ? idarmazem.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Armazem)) {
            return false;
        }
        Armazem other = (Armazem) object;
        if ((this.idarmazem == null && other.idarmazem != null) || (this.idarmazem != null && !this.idarmazem.equals(other.idarmazem))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.Armazem[ idarmazem=" + idarmazem + " ]";
    }
    
}
