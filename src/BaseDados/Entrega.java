/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BaseDados;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Rafael
 */
@Entity
@Table(name = "ENTREGA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Entrega.findAll", query = "SELECT e FROM Entrega e")
    , @NamedQuery(name = "Entrega.findByIdentrega", query = "SELECT e FROM Entrega e WHERE e.identrega = :identrega")
    , @NamedQuery(name = "Entrega.findByDataenvio", query = "SELECT e FROM Entrega e WHERE e.dataenvio = :dataenvio")
    , @NamedQuery(name = "Entrega.findByDataentrega", query = "SELECT e FROM Entrega e WHERE e.dataentrega = :dataentrega")
    , @NamedQuery(name = "Entrega.findByConfirmado", query = "SELECT e FROM Entrega e WHERE e.confirmado = :confirmado")})
public class Entrega implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "IDENTREGA")
    private Integer identrega;
    @Basic(optional = false)
    @Column(name = "DATAENVIO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataenvio;
    @Basic(optional = false)
    @Column(name = "DATAENTREGA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataentrega;
    @Basic(optional = false)
    @Column(name = "CONFIRMADO")
    private short confirmado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "entrega", fetch = FetchType.LAZY)
    private Collection<Produtoentrega> produtoentregaCollection;
    @JoinColumn(name = "IDARMAZEM", referencedColumnName = "IDARMAZEM")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Armazem idarmazem;
    @JoinColumn(name = "IDFUNCIONARIOENTREGA", referencedColumnName = "IDFUNCIONARIO")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Funcionario idfuncionarioentrega;
    @JoinColumn(name = "IDFUNCIONARIORECEBE", referencedColumnName = "IDFUNCIONARIO")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Funcionario idfuncionariorecebe;
    @JoinColumn(name = "IDLOJA", referencedColumnName = "IDLOJA")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Loja idloja;

    public Entrega() {
    }

    public Entrega(Integer identrega) {
        this.identrega = identrega;
    }

    public Entrega(Integer identrega, Date dataenvio, Date dataentrega, short confirmado) {
        this.identrega = identrega;
        this.dataenvio = dataenvio;
        this.dataentrega = dataentrega;
        this.confirmado = confirmado;
    }

    public Integer getIdentrega() {
        return identrega;
    }

    public void setIdentrega(Integer identrega) {
        this.identrega = identrega;
    }

    public Date getDataenvio() {
        return dataenvio;
    }

    public void setDataenvio(Date dataenvio) {
        this.dataenvio = dataenvio;
    }

    public Date getDataentrega() {
        return dataentrega;
    }

    public void setDataentrega(Date dataentrega) {
        this.dataentrega = dataentrega;
    }

    public short getConfirmado() {
        return confirmado;
    }

    public void setConfirmado(short confirmado) {
        this.confirmado = confirmado;
    }

    @XmlTransient
    public Collection<Produtoentrega> getProdutoentregaCollection() {
        return produtoentregaCollection;
    }

    public void setProdutoentregaCollection(Collection<Produtoentrega> produtoentregaCollection) {
        this.produtoentregaCollection = produtoentregaCollection;
    }

    public Armazem getIdarmazem() {
        return idarmazem;
    }

    public void setIdarmazem(Armazem idarmazem) {
        this.idarmazem = idarmazem;
    }

    public Funcionario getIdfuncionarioentrega() {
        return idfuncionarioentrega;
    }

    public void setIdfuncionarioentrega(Funcionario idfuncionarioentrega) {
        this.idfuncionarioentrega = idfuncionarioentrega;
    }

    public Funcionario getIdfuncionariorecebe() {
        return idfuncionariorecebe;
    }

    public void setIdfuncionariorecebe(Funcionario idfuncionariorecebe) {
        this.idfuncionariorecebe = idfuncionariorecebe;
    }

    public Loja getIdloja() {
        return idloja;
    }

    public void setIdloja(Loja idloja) {
        this.idloja = idloja;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (identrega != null ? identrega.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Entrega)) {
            return false;
        }
        Entrega other = (Entrega) object;
        if ((this.identrega == null && other.identrega != null) || (this.identrega != null && !this.identrega.equals(other.identrega))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BaseDados.Entrega[ identrega=" + identrega + " ]";
    }
    
}
