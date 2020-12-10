package com.pixel.challenge.healthcare.model;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 * Database tabel HealthCare
 *
 * @author lct
 */
@Entity
@Table(name = "healthcareinstitution")
@NamedQueries({
    @NamedQuery(name = "Healthcareinstitution.findAll", query = "SELECT h FROM Healthcareinstitution h"),
    @NamedQuery(name = "Healthcareinstitution.findByIdHealthcareInstitution", query = "SELECT h FROM Healthcareinstitution h WHERE h.idHealthcareInstitution = :idHealthcareInstitution"),
    @NamedQuery(name = "Healthcareinstitution.findByName", query = "SELECT h FROM Healthcareinstitution h WHERE h.name = :name"),
    @NamedQuery(name = "Healthcareinstitution.findByCnpj", query = "SELECT h FROM Healthcareinstitution h WHERE h.cnpj = :cnpj")})
public class Healthcareinstitution implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IdHealthcareInstitution")
    private Long idHealthcareInstitution;
    @Size(max = 100)
    @Column(name = "Name")
    private String name;
    @Column(name = "Cnpj")
    private BigInteger cnpj;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idHealthcareInstitution")
    private Collection<Exam> examCollection;

    public Healthcareinstitution() {
    }

    public Healthcareinstitution(Long idHealthcareInstitution) {
        this.idHealthcareInstitution = idHealthcareInstitution;
    }

    public Long getIdHealthcareInstitution() {
        return idHealthcareInstitution;
    }

    public void setIdHealthcareInstitution(Long idHealthcareInstitution) {
        this.idHealthcareInstitution = idHealthcareInstitution;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigInteger getCnpj() {
        return cnpj;
    }

    public void setCnpj(BigInteger cnpj) {
        this.cnpj = cnpj;
    }

    public Collection<Exam> getExamCollection() {
        return examCollection;
    }

    public void setExamCollection(Collection<Exam> examCollection) {
        this.examCollection = examCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idHealthcareInstitution != null ? idHealthcareInstitution.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Healthcareinstitution)) {
            return false;
        }
        Healthcareinstitution other = (Healthcareinstitution) object;
        if ((this.idHealthcareInstitution == null && other.idHealthcareInstitution != null) || (this.idHealthcareInstitution != null && !this.idHealthcareInstitution.equals(other.idHealthcareInstitution))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return idHealthcareInstitution.toString();
    }
    
}
