/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
@Table(name = "PONTOHORARIO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pontohorario.findAll", query = "SELECT p FROM Pontohorario p")
    , @NamedQuery(name = "Pontohorario.findByIdpontohorario", query = "SELECT p FROM Pontohorario p WHERE p.pontohorarioPK.idpontohorario = :idpontohorario")
    , @NamedQuery(name = "Pontohorario.findByData", query = "SELECT p FROM Pontohorario p WHERE p.pontohorarioPK.data = :data")
    , @NamedQuery(name = "Pontohorario.findByDiasemana", query = "SELECT p FROM Pontohorario p WHERE p.diasemana = :diasemana")
    , @NamedQuery(name = "Pontohorario.findByIdfuncionario", query = "SELECT p FROM Pontohorario p WHERE p.pontohorarioPK.idfuncionario = :idfuncionario")})
public class Pontohorario implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PontohorarioPK pontohorarioPK;
    @Basic(optional = false)
    @Column(name = "DIASEMANA")
    private short diasemana;
    @JoinColumn(name = "IDFUNCIONARIO", referencedColumnName = "IDFUNCIONARIO", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Funcionario funcionario;
    @JoinColumn(name = "IDHORARIO", referencedColumnName = "IDHORARIO")
    @ManyToOne(optional = false)
    private Horario idhorario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pontohorario")
    private Collection<Pontossaida> pontossaidaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pontohorario")
    private Collection<Pontosentrada> pontosentradaCollection;

    public Pontohorario() {
    }

    public Pontohorario(PontohorarioPK pontohorarioPK) {
        this.pontohorarioPK = pontohorarioPK;
    }

    public Pontohorario(PontohorarioPK pontohorarioPK, short diasemana) {
        this.pontohorarioPK = pontohorarioPK;
        this.diasemana = diasemana;
    }

    public Pontohorario(BigInteger idpontohorario, Date data, BigInteger idfuncionario) {
        this.pontohorarioPK = new PontohorarioPK(idpontohorario, data, idfuncionario);
    }

    public PontohorarioPK getPontohorarioPK() {
        return pontohorarioPK;
    }

    public void setPontohorarioPK(PontohorarioPK pontohorarioPK) {
        this.pontohorarioPK = pontohorarioPK;
    }

    public short getDiasemana() {
        return diasemana;
    }

    public void setDiasemana(short diasemana) {
        this.diasemana = diasemana;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public Horario getIdhorario() {
        return idhorario;
    }

    public void setIdhorario(Horario idhorario) {
        this.idhorario = idhorario;
    }

    @XmlTransient
    public Collection<Pontossaida> getPontossaidaCollection() {
        return pontossaidaCollection;
    }

    public void setPontossaidaCollection(Collection<Pontossaida> pontossaidaCollection) {
        this.pontossaidaCollection = pontossaidaCollection;
    }

    @XmlTransient
    public Collection<Pontosentrada> getPontosentradaCollection() {
        return pontosentradaCollection;
    }

    public void setPontosentradaCollection(Collection<Pontosentrada> pontosentradaCollection) {
        this.pontosentradaCollection = pontosentradaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pontohorarioPK != null ? pontohorarioPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pontohorario)) {
            return false;
        }
        Pontohorario other = (Pontohorario) object;
        if ((this.pontohorarioPK == null && other.pontohorarioPK != null) || (this.pontohorarioPK != null && !this.pontohorarioPK.equals(other.pontohorarioPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.Pontohorario[ pontohorarioPK=" + pontohorarioPK + " ]";
    }
    
}
