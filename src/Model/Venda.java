/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
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
@Table(name = "VENDA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Venda.findAll", query = "SELECT v FROM Venda v")
    , @NamedQuery(name = "Venda.findByIdvenda", query = "SELECT v FROM Venda v WHERE v.idvenda = :idvenda")
    , @NamedQuery(name = "Venda.findByDatavenda", query = "SELECT v FROM Venda v WHERE v.datavenda = :datavenda")
    , @NamedQuery(name = "Venda.findByValortotal", query = "SELECT v FROM Venda v WHERE v.valortotal = :valortotal")
    , @NamedQuery(name = "Venda.findByValorganho", query = "SELECT v FROM Venda v WHERE v.valorganho = :valorganho")
    , @NamedQuery(name = "Venda.findByEstado", query = "SELECT v FROM Venda v WHERE v.estado = :estado")})
public class Venda implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "IDVENDA")
    private Long idvenda;
    @Basic(optional = false)
    @Column(name = "DATAVENDA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datavenda;
    @Basic(optional = false)
    @Column(name = "VALORTOTAL")
    private long valortotal;
    @Basic(optional = false)
    @Column(name = "VALORGANHO")
    private long valorganho;
    @Basic(optional = false)
    @Column(name = "ESTADO")
    private short estado;
    @JoinColumn(name = "IDFUNCIONARIO", referencedColumnName = "IDFUNCIONARIO")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Funcionario idfuncionario;
    @JoinColumn(name = "IDLOJA", referencedColumnName = "IDLOJA")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Loja idloja;
    @JoinColumn(name = "TIPOPAGAMENTO", referencedColumnName = "IDTIPOPAGAMENTO")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Tipopagamento tipopagamento;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "venda", fetch = FetchType.LAZY)
    private List<Produtovenda> produtovendaList;

    public Venda() {
    }

    public Venda(Long idvenda) {
        this.idvenda = idvenda;
    }

    public Venda(Long idvenda, Date datavenda, long valortotal, long valorganho, short estado) {
        this.idvenda = idvenda;
        this.datavenda = datavenda;
        this.valortotal = valortotal;
        this.valorganho = valorganho;
        this.estado = estado;
    }

    public Long getIdvenda() {
        return idvenda;
    }

    public void setIdvenda(Long idvenda) {
        this.idvenda = idvenda;
    }

    public Date getDatavenda() {
        return datavenda;
    }

    public void setDatavenda(Date datavenda) {
        this.datavenda = datavenda;
    }

    public long getValortotal() {
        return valortotal;
    }

    public void setValortotal(long valortotal) {
        this.valortotal = valortotal;
    }

    public long getValorganho() {
        return valorganho;
    }

    public void setValorganho(long valorganho) {
        this.valorganho = valorganho;
    }

    public short getEstado() {
        return estado;
    }

    public void setEstado(short estado) {
        this.estado = estado;
    }

    public Funcionario getIdfuncionario() {
        return idfuncionario;
    }

    public void setIdfuncionario(Funcionario idfuncionario) {
        this.idfuncionario = idfuncionario;
    }

    public Loja getIdloja() {
        return idloja;
    }

    public void setIdloja(Loja idloja) {
        this.idloja = idloja;
    }

    public Tipopagamento getTipopagamento() {
        return tipopagamento;
    }

    public void setTipopagamento(Tipopagamento tipopagamento) {
        this.tipopagamento = tipopagamento;
    }

    @XmlTransient
    public List<Produtovenda> getProdutovendaList() {
        return produtovendaList;
    }

    public void setProdutovendaList(List<Produtovenda> produtovendaList) {
        this.produtovendaList = produtovendaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idvenda != null ? idvenda.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Venda)) {
            return false;
        }
        Venda other = (Venda) object;
        if ((this.idvenda == null && other.idvenda != null) || (this.idvenda != null && !this.idvenda.equals(other.idvenda))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.Venda[ idvenda=" + idvenda + " ]";
    }
    
}
