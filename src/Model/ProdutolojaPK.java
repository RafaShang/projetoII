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
public class ProdutolojaPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "CODBARRAS")
    private long codbarras;
    @Basic(optional = false)
    @Column(name = "IDLOJA")
    private short idloja;

    public ProdutolojaPK() {
    }

    public ProdutolojaPK(long codbarras, short idloja) {
        this.codbarras = codbarras;
        this.idloja = idloja;
    }

    public long getCodbarras() {
        return codbarras;
    }

    public void setCodbarras(long codbarras) {
        this.codbarras = codbarras;
    }

    public short getIdloja() {
        return idloja;
    }

    public void setIdloja(short idloja) {
        this.idloja = idloja;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codbarras;
        hash += (int) idloja;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProdutolojaPK)) {
            return false;
        }
        ProdutolojaPK other = (ProdutolojaPK) object;
        if (this.codbarras != other.codbarras) {
            return false;
        }
        if (this.idloja != other.idloja) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.ProdutolojaPK[ codbarras=" + codbarras + ", idloja=" + idloja + " ]";
    }
    
}
