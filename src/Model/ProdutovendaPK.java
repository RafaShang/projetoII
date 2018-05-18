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
public class ProdutovendaPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "CODBARRAS")
    private long codbarras;
    @Basic(optional = false)
    @Column(name = "IDVENDA")
    private int idvenda;

    public ProdutovendaPK() {
    }

    public ProdutovendaPK(long codbarras, int idvenda) {
        this.codbarras = codbarras;
        this.idvenda = idvenda;
    }

    public long getCodbarras() {
        return codbarras;
    }

    public void setCodbarras(long codbarras) {
        this.codbarras = codbarras;
    }

    public int getIdvenda() {
        return idvenda;
    }

    public void setIdvenda(int idvenda) {
        this.idvenda = idvenda;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codbarras;
        hash += (int) idvenda;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProdutovendaPK)) {
            return false;
        }
        ProdutovendaPK other = (ProdutovendaPK) object;
        if (this.codbarras != other.codbarras) {
            return false;
        }
        if (this.idvenda != other.idvenda) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.ProdutovendaPK[ codbarras=" + codbarras + ", idvenda=" + idvenda + " ]";
    }
    
}
