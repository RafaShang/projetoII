/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Rafael
 */
@Embeddable
public class CaixaPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "IDARMAZEM")
    private short idarmazem;
    @Basic(optional = false)
    @Column(name = "CODBARRAS")
    private long codbarras;

    public CaixaPK() {
    }

    public CaixaPK(short idarmazem, long codbarras) {
        this.idarmazem = idarmazem;
        this.codbarras = codbarras;
    }

    public short getIdarmazem() {
        return idarmazem;
    }

    public void setIdarmazem(short idarmazem) {
        this.idarmazem = idarmazem;
    }

    public long getCodbarras() {
        return codbarras;
    }

    public void setCodbarras(long codbarras) {
        this.codbarras = codbarras;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idarmazem;
        hash += (int) codbarras;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CaixaPK)) {
            return false;
        }
        CaixaPK other = (CaixaPK) object;
        if (this.idarmazem != other.idarmazem) {
            return false;
        }
        if (this.codbarras != other.codbarras) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.CaixaPK[ idarmazem=" + idarmazem + ", codbarras=" + codbarras + " ]";
    }
    
}
