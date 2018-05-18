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
public class ProdutoentregaPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "CODBARRAS")
    private long codbarras;
    @Basic(optional = false)
    @Column(name = "IDENTREGA")
    private int identrega;

    public ProdutoentregaPK() {
    }

    public ProdutoentregaPK(long codbarras, int identrega) {
        this.codbarras = codbarras;
        this.identrega = identrega;
    }

    public long getCodbarras() {
        return codbarras;
    }

    public void setCodbarras(long codbarras) {
        this.codbarras = codbarras;
    }

    public int getIdentrega() {
        return identrega;
    }

    public void setIdentrega(int identrega) {
        this.identrega = identrega;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codbarras;
        hash += (int) identrega;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProdutoentregaPK)) {
            return false;
        }
        ProdutoentregaPK other = (ProdutoentregaPK) object;
        if (this.codbarras != other.codbarras) {
            return false;
        }
        if (this.identrega != other.identrega) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.ProdutoentregaPK[ codbarras=" + codbarras + ", identrega=" + identrega + " ]";
    }
    
}
