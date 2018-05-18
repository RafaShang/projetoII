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
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Rafael
 */
@Embeddable
public class PontohorarioPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "IDPONTOHORARIO")
    private BigInteger idpontohorario;
    @Basic(optional = false)
    @Column(name = "DATA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date data;
    @Basic(optional = false)
    @Column(name = "DIASEMANA")
    private short diasemana;
    @Basic(optional = false)
    @Column(name = "IDFUNCIONARIO")
    private BigInteger idfuncionario;

    public PontohorarioPK() {
    }

    public PontohorarioPK(BigInteger idpontohorario, Date data, short diasemana, BigInteger idfuncionario) {
        this.idpontohorario = idpontohorario;
        this.data = data;
        this.diasemana = diasemana;
        this.idfuncionario = idfuncionario;
    }

    public BigInteger getIdpontohorario() {
        return idpontohorario;
    }

    public void setIdpontohorario(BigInteger idpontohorario) {
        this.idpontohorario = idpontohorario;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public short getDiasemana() {
        return diasemana;
    }

    public void setDiasemana(short diasemana) {
        this.diasemana = diasemana;
    }

    public BigInteger getIdfuncionario() {
        return idfuncionario;
    }

    public void setIdfuncionario(BigInteger idfuncionario) {
        this.idfuncionario = idfuncionario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idpontohorario != null ? idpontohorario.hashCode() : 0);
        hash += (data != null ? data.hashCode() : 0);
        hash += (int) diasemana;
        hash += (idfuncionario != null ? idfuncionario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PontohorarioPK)) {
            return false;
        }
        PontohorarioPK other = (PontohorarioPK) object;
        if ((this.idpontohorario == null && other.idpontohorario != null) || (this.idpontohorario != null && !this.idpontohorario.equals(other.idpontohorario))) {
            return false;
        }
        if ((this.data == null && other.data != null) || (this.data != null && !this.data.equals(other.data))) {
            return false;
        }
        if (this.diasemana != other.diasemana) {
            return false;
        }
        if ((this.idfuncionario == null && other.idfuncionario != null) || (this.idfuncionario != null && !this.idfuncionario.equals(other.idfuncionario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.PontohorarioPK[ idpontohorario=" + idpontohorario + ", data=" + data + ", diasemana=" + diasemana + ", idfuncionario=" + idfuncionario + " ]";
    }
    
}
