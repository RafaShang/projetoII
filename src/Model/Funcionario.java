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
@Table(name = "FUNCIONARIO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Funcionario.findAll", query = "SELECT f FROM Funcionario f")
    , @NamedQuery(name = "Funcionario.findByIdfuncionario", query = "SELECT f FROM Funcionario f WHERE f.idfuncionario = :idfuncionario")
    , @NamedQuery(name = "Funcionario.findByNome", query = "SELECT f FROM Funcionario f WHERE f.nome = :nome")
    , @NamedQuery(name = "Funcionario.findByUsername", query = "SELECT f FROM Funcionario f WHERE f.username = :username")
    , @NamedQuery(name = "Funcionario.findByPassword", query = "SELECT f FROM Funcionario f WHERE f.password = :password")
    , @NamedQuery(name = "Funcionario.findByDatanascimento", query = "SELECT f FROM Funcionario f WHERE f.datanascimento = :datanascimento")
    , @NamedQuery(name = "Funcionario.findBySexo", query = "SELECT f FROM Funcionario f WHERE f.sexo = :sexo")
    , @NamedQuery(name = "Funcionario.findByActivo", query = "SELECT f FROM Funcionario f WHERE f.activo = :activo")
    , @NamedQuery(name = "Funcionario.findByTipo", query = "SELECT f FROM Funcionario f WHERE f.tipo = :tipo")})
public class Funcionario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "IDFUNCIONARIO")
    private Short idfuncionario;
    @Basic(optional = false)
    @Column(name = "NOME")
    private String nome;
    @Basic(optional = false)
    @Column(name = "USERNAME")
    private String username;
    @Basic(optional = false)
    @Column(name = "PASSWORD")
    private short password;
    @Basic(optional = false)
    @Column(name = "DATANASCIMENTO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datanascimento;
    @Basic(optional = false)
    @Column(name = "SEXO")
    private Character sexo;
    @Basic(optional = false)
    @Column(name = "ACTIVO")
    private short activo;
    @Basic(optional = false)
    @Column(name = "TIPO")
    private short tipo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idfuncionario", fetch = FetchType.LAZY)
    private List<Venda> vendaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "funcionario", fetch = FetchType.LAZY)
    private List<Pontohorario> pontohorarioList;
    @JoinColumn(name = "IDHORARIO", referencedColumnName = "IDHORARIO")
    @ManyToOne(fetch = FetchType.LAZY)
    private Horario idhorario;
    @JoinColumn(name = "IDLOCALTRABALHO", referencedColumnName = "IDLOCALTRABALHO")
    @ManyToOne(fetch = FetchType.LAZY)
    private Localtrabalho idlocaltrabalho;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idfuncionarioentrega", fetch = FetchType.LAZY)
    private List<Entrega> entregaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idfuncionariorecebe", fetch = FetchType.LAZY)
    private List<Entrega> entregaList1;

    public Funcionario() {
    }

    public Funcionario(Short idfuncionario) {
        this.idfuncionario = idfuncionario;
    }

    public Funcionario(Short idfuncionario, String nome, String username, short password, Date datanascimento, Character sexo, short activo, short tipo) {
        this.idfuncionario = idfuncionario;
        this.nome = nome;
        this.username = username;
        this.password = password;
        this.datanascimento = datanascimento;
        this.sexo = sexo;
        this.activo = activo;
        this.tipo = tipo;
    }

    public Short getIdfuncionario() {
        return idfuncionario;
    }

    public void setIdfuncionario(Short idfuncionario) {
        this.idfuncionario = idfuncionario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public short getPassword() {
        return password;
    }

    public void setPassword(short password) {
        this.password = password;
    }

    public Date getDatanascimento() {
        return datanascimento;
    }

    public void setDatanascimento(Date datanascimento) {
        this.datanascimento = datanascimento;
    }

    public Character getSexo() {
        return sexo;
    }

    public void setSexo(Character sexo) {
        this.sexo = sexo;
    }

    public short getActivo() {
        return activo;
    }

    public void setActivo(short activo) {
        this.activo = activo;
    }

    public short getTipo() {
        return tipo;
    }

    public void setTipo(short tipo) {
        this.tipo = tipo;
    }

    @XmlTransient
    public List<Venda> getVendaList() {
        return vendaList;
    }

    public void setVendaList(List<Venda> vendaList) {
        this.vendaList = vendaList;
    }

    @XmlTransient
    public List<Pontohorario> getPontohorarioList() {
        return pontohorarioList;
    }

    public void setPontohorarioList(List<Pontohorario> pontohorarioList) {
        this.pontohorarioList = pontohorarioList;
    }

    public Horario getIdhorario() {
        return idhorario;
    }

    public void setIdhorario(Horario idhorario) {
        this.idhorario = idhorario;
    }

    public Localtrabalho getIdlocaltrabalho() {
        return idlocaltrabalho;
    }

    public void setIdlocaltrabalho(Localtrabalho idlocaltrabalho) {
        this.idlocaltrabalho = idlocaltrabalho;
    }

    @XmlTransient
    public List<Entrega> getEntregaList() {
        return entregaList;
    }

    public void setEntregaList(List<Entrega> entregaList) {
        this.entregaList = entregaList;
    }

    @XmlTransient
    public List<Entrega> getEntregaList1() {
        return entregaList1;
    }

    public void setEntregaList1(List<Entrega> entregaList1) {
        this.entregaList1 = entregaList1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idfuncionario != null ? idfuncionario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Funcionario)) {
            return false;
        }
        Funcionario other = (Funcionario) object;
        if ((this.idfuncionario == null && other.idfuncionario != null) || (this.idfuncionario != null && !this.idfuncionario.equals(other.idfuncionario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.Funcionario[ idfuncionario=" + idfuncionario + " ]";
    }
    
}
