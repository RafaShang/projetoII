/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Funcionario funcionario;
    @JoinColumn(name = "IDHORARIO", referencedColumnName = "IDHORARIO")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Horario idhorario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pontohorario", fetch = FetchType.LAZY)
    private List<Pontossaida> pontossaidaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pontohorario", fetch = FetchType.LAZY)
    private List<Pontosentrada> pontosentradaList;

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
    public List<Pontossaida> getPontossaidaList() {
        return pontossaidaList;
    }

    public void setPontossaidaList(List<Pontossaida> pontossaidaList) {
        this.pontossaidaList = pontossaidaList;
    }

    @XmlTransient
    public List<Pontosentrada> getPontosentradaList() {
        return pontosentradaList;
    }

    public void setPontosentradaList(List<Pontosentrada> pontosentradaList) {
        this.pontosentradaList = pontosentradaList;
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
