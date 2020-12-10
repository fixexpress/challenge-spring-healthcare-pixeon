package com.pixel.challenge.healthcare.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 * Database table Exam
 * 
 * @author lct
 */
@Entity
@Table(name = "exam")
@NamedQueries({
    @NamedQuery(name = "Exam.findAll", query = "SELECT e FROM Exam e"),
    @NamedQuery(name = "Exam.findByIdExam", query = "SELECT e FROM Exam e WHERE e.idExam = :idExam"),
    @NamedQuery(name = "Exam.findByPatientName", query = "SELECT e FROM Exam e WHERE e.patientName = :patientName"),
    @NamedQuery(name = "Exam.findByPatientAge", query = "SELECT e FROM Exam e WHERE e.patientAge = :patientAge"),
    @NamedQuery(name = "Exam.findByPatientGender", query = "SELECT e FROM Exam e WHERE e.patientGender = :patientGender"),
    @NamedQuery(name = "Exam.findByPhysicianName", query = "SELECT e FROM Exam e WHERE e.physicianName = :physicianName"),
    @NamedQuery(name = "Exam.findByPhysicianCRM", query = "SELECT e FROM Exam e WHERE e.physicianCRM = :physicianCRM"),
    @NamedQuery(name = "Exam.findByProcedureName", query = "SELECT e FROM Exam e WHERE e.procedureName = :procedureName")})
public class Exam implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IdExam")
    private Long idExam;
    @Size(max = 100)
    @Column(name = "PatientName")
    private String patientName;
    @Column(name = "PatientAge")
    private Integer patientAge;
    @Size(max = 20)
    @Column(name = "PatientGender")
    private String patientGender;
    @Size(max = 100)
    @Column(name = "PhysicianName")
    private String physicianName;
    @Size(max = 20)
    @Column(name = "PhysicianCRM")
    private String physicianCRM;
    @Size(max = 100)
    @Column(name = "ProcedureName")
    private String procedureName;
    @JoinColumn(name = "IdHealthcareInstitution", referencedColumnName = "IdHealthcareInstitution")
    @ManyToOne(optional = false)
    private Healthcareinstitution idHealthcareInstitution;

    public Exam() {
    }

    public Exam(Long idExam) {
        this.idExam = idExam;
    }

    public Long getIdExam() {
        return idExam;
    }

    public void setIdExam(Long idExam) {
        this.idExam = idExam;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public Integer getPatientAge() {
        return patientAge;
    }

    public void setPatientAge(Integer patientAge) {
        this.patientAge = patientAge;
    }

    public String getPatientGender() {
        return patientGender;
    }

    public void setPatientGender(String patientGender) {
        this.patientGender = patientGender;
    }

    public String getPhysicianName() {
        return physicianName;
    }

    public void setPhysicianName(String physicianName) {
        this.physicianName = physicianName;
    }

    public String getPhysicianCRM() {
        return physicianCRM;
    }

    public void setPhysicianCRM(String physicianCRM) {
        this.physicianCRM = physicianCRM;
    }

    public String getProcedureName() {
        return procedureName;
    }

    public void setProcedureName(String procedureName) {
        this.procedureName = procedureName;
    }

    public Healthcareinstitution getIdHealthcareInstitution() {
        return idHealthcareInstitution;
    }

    public void setIdHealthcareInstitution(Healthcareinstitution idHealthcareInstitution) {
        this.idHealthcareInstitution = idHealthcareInstitution;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idExam != null ? idExam.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Exam)) {
            return false;
        }
        Exam other = (Exam) object;
        if ((this.idExam == null && other.idExam != null) || (this.idExam != null && !this.idExam.equals(other.idExam))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
    	return idExam.toString() ;
    }
    
}
