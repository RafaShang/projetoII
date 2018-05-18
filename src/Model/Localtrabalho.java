/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
@Table(name = "LOCALTRABALHO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Localtrabalho.findAll", query = "SELECT l FROM Localtrabalho l")
    , @NamedQuery(name = "Localtrabalho.findByIdlocaltrabalho", query = "SELECT l FROM Localtrabalho l WHERE l.idlocaltrabalho = :idlocaltrabalho")})
public class Localtrabalho implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "IDLOCALTRABALHO")
    private Short idlocaltrabalho;
    @OneToMany(mappedBy = "idlocaltrabalho", fetch = FetchType.LAZY)
    private List<Funcionario> funcionarioList;

    public Localtrabalho() {
    }

    public Localtrabalho(Short idlocaltrabalho) {
        this.idlocaltrabalho = idlocaltrabalho;
    }

    public Short getIdlocaltrabalho() {
        return idlocaltrabalho;
    }

    public void setIdlocaltrabalho(Short idlocaltrabalho) {
        this.idlocaltrabalho = idlocaltrabalho;
    }

    @XmlTransient
    public List<Funcionario> getFuncionarioList() {
        return funcionarioList;
    }

    public void setFuncionarioList(List<Funcionario> funcionarioList) {
        this.funcionarioList = funcionarioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idlocaltrabalho != null ? idlocaltrabalho.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Localtrabalho)) {
            return false;
        }
        Localtrabalho other = (Localtrabalho) object;
        if ((this.idlocaltrabalho == null && other.idlocaltrabalho != null) || (this.idlocaltrabalho != null && !this.idlocaltrabalho.equals(other.idlocaltrabalho))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.Localtrabalho[ idlocaltrabalho=" + idlocaltrabalho + " ]";
    }
    
}
