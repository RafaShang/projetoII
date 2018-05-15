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
    , @NamedQuery(name = "Funcionario.findByActivo", query = "SELECT f FROM Funcionario f WHERE f.activo = :activo")})
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idfuncionario", fetch = FetchType.LAZY)
    private Collection<Venda> vendaCollection;
    @JoinColumn(name = "IDLOCALTRABALHO", referencedColumnName = "IDLOCALTRABALHO")
    @ManyToOne(fetch = FetchType.LAZY)
    private Localtrabalho idlocaltrabalho;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idfuncionarioentrega", fetch = FetchType.LAZY)
    private Collection<Entrega> entregaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idfuncionariorecebe", fetch = FetchType.LAZY)
    private Collection<Entrega> entregaCollection1;

    public Funcionario() {
    }

    public Funcionario(Short idfuncionario) {
        this.idfuncionario = idfuncionario;
    }

    public Funcionario(Short idfuncionario, String nome, String username, short password, Date datanascimento, Character sexo, short activo) {
        this.idfuncionario = idfuncionario;
        this.nome = nome;
        this.username = username;
        this.password = password;
        this.datanascimento = datanascimento;
        this.sexo = sexo;
        this.activo = activo;
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

    @XmlTransient
    public Collection<Venda> getVendaCollection() {
        return vendaCollection;
    }

    public void setVendaCollection(Collection<Venda> vendaCollection) {
        this.vendaCollection = vendaCollection;
    }

    public Localtrabalho getIdlocaltrabalho() {
        return idlocaltrabalho;
    }

    public void setIdlocaltrabalho(Localtrabalho idlocaltrabalho) {
        this.idlocaltrabalho = idlocaltrabalho;
    }

    @XmlTransient
    public Collection<Entrega> getEntregaCollection() {
        return entregaCollection;
    }

    public void setEntregaCollection(Collection<Entrega> entregaCollection) {
        this.entregaCollection = entregaCollection;
    }

    @XmlTransient
    public Collection<Entrega> getEntregaCollection1() {
        return entregaCollection1;
    }

    public void setEntregaCollection1(Collection<Entrega> entregaCollection1) {
        this.entregaCollection1 = entregaCollection1;
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
        return "BaseDados.Funcionario[ idfuncionario=" + idfuncionario + " ]";
    }
    
}
