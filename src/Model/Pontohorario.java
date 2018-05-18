/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

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
    , @NamedQuery(name = "Pontohorario.findByDiasemana", query = "SELECT p FROM Pontohorario p WHERE p.pontohorarioPK.diasemana = :diasemana")
    , @NamedQuery(name = "Pontohorario.findByIdhorario", query = "SELECT p FROM Pontohorario p WHERE p.idhorario = :idhorario")
    , @NamedQuery(name = "Pontohorario.findByIdfuncionario", query = "SELECT p FROM Pontohorario p WHERE p.pontohorarioPK.idfuncionario = :idfuncionario")})
public class Pontohorario implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PontohorarioPK pontohorarioPK;
    @Basic(optional = false)
    @Column(name = "IDHORARIO")
    private BigInteger idhorario;

    public Pontohorario() {
    }

    public Pontohorario(PontohorarioPK pontohorarioPK) {
        this.pontohorarioPK = pontohorarioPK;
    }

    public Pontohorario(PontohorarioPK pontohorarioPK, BigInteger idhorario) {
        this.pontohorarioPK = pontohorarioPK;
        this.idhorario = idhorario;
    }

    public Pontohorario(BigInteger idpontohorario, Date data, short diasemana, BigInteger idfuncionario) {
        this.pontohorarioPK = new PontohorarioPK(idpontohorario, data, diasemana, idfuncionario);
    }

    public PontohorarioPK getPontohorarioPK() {
        return pontohorarioPK;
    }

    public void setPontohorarioPK(PontohorarioPK pontohorarioPK) {
        this.pontohorarioPK = pontohorarioPK;
    }

    public BigInteger getIdhorario() {
        return idhorario;
    }

    public void setIdhorario(BigInteger idhorario) {
        this.idhorario = idhorario;
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
