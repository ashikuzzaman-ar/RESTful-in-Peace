package com.studevs.dummy.restful.in.peace.models.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.studevs.dummy.restful.in.peace.utility.interfaces.Replicable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

/**
 *
 * @author ashik
 */
@Entity
@Table(name = "doctor_patient_visiting", indexes = {
    @Index(columnList = "doctor_fee", name = "doctor_patient_visiting_doctor_fee")
    ,
    @Index(columnList = "patient_symptoms", name = "doctor_patient_visiting_patient_symptoms")
    ,
    @Index(columnList = "doctor_prediction", name = "doctor_patient_visiting_doctor_prediction")
    ,
    @Index(columnList = "doctor_suggestion", name = "doctor_patient_visiting_doctor_suggestion")
})
public class Visiting implements Replicable<Visiting> {

    private static final long serialVersionUID = 1L;

    /**
     * ID and primary key
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    /**
     * Doctor's fee. This field is not nullable.
     */
    @Column(name = "doctor_fee", nullable = false)
    private Double doctorFee;

    /**
     * Patient symptoms.
     */
    @Column(name = "patient_symptoms")
    private String symptoms;

    /**
     * Doctor's prediction for patient symptoms.
     */
    @Column(name = "doctor_prediction")
    private String prediction;

    /**
     * Doctor's suggestions/prescriptions for patient's problem.
     */
    @Column(name = "doctor_suggestion")
    private String suggestions;

    /**
     * This is a key for making trace that doctor's prediction was write and it's effective for patient.
     */
    @Column(name = "is_effective")
    private Boolean isEffective;

    /**
     * Visiting date and time.
     */
    @JsonIgnore
    @Column(name = "visiting_date_time")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date visitingDate;

    /**
     * m-1 relationship between visiting history and doctor.
     */
    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    private Doctor doctor;

    /**
     * m-1 relationship between visiting history and patient.
     */
    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    private Patient patient;

    public Visiting() {

        this.visitingDate = new Date();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getDoctorFee() {
        return doctorFee;
    }

    public void setDoctorFee(Double doctorFee) {
        this.doctorFee = doctorFee;
    }

    public String getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(String symptoms) {
        this.symptoms = symptoms;
    }

    public String getPrediction() {
        return prediction;
    }

    public void setPrediction(String prediction) {
        this.prediction = prediction;
    }

    public String getSuggestions() {
        return suggestions;
    }

    public void setSuggestions(String suggestions) {
        this.suggestions = suggestions;
    }

    public Boolean getIsEffective() {
        return isEffective;
    }

    public void setIsEffective(Boolean isEffective) {
        this.isEffective = isEffective;
    }

    public Date getVisitingDate() {
        return visitingDate;
    }

    public String getDateofVisiting() {
        return visitingDate == null ? "" : visitingDate.toString();
    }

    public void setVisitingDate(Date visitingDate) {
        this.visitingDate = visitingDate;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.id);
        hash = 83 * hash + Objects.hashCode(this.doctorFee);
        hash = 83 * hash + Objects.hashCode(this.symptoms);
        hash = 83 * hash + Objects.hashCode(this.prediction);
        hash = 83 * hash + Objects.hashCode(this.suggestions);
        hash = 83 * hash + Objects.hashCode(this.isEffective);
        hash = 83 * hash + Objects.hashCode(this.visitingDate);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Visiting other = (Visiting) obj;
        if (!Objects.equals(this.symptoms, other.symptoms)) {
            return false;
        }
        if (!Objects.equals(this.prediction, other.prediction)) {
            return false;
        }
        if (!Objects.equals(this.suggestions, other.suggestions)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.doctorFee, other.doctorFee)) {
            return false;
        }
        if (!Objects.equals(this.isEffective, other.isEffective)) {
            return false;
        }
        if (!Objects.equals(this.visitingDate, other.visitingDate)) {
            return false;
        }
        if (!Objects.equals(this.doctor, other.doctor)) {
            return false;
        }
        return Objects.equals(this.patient, other.patient);
    }

    @Override
    public String toString() {
        return "Visiting{" + "id=" + id + ", doctorFee=" + doctorFee + ", symptoms=" + symptoms + ", prediction=" + prediction + ", suggestions=" + suggestions + ", isEffective=" + isEffective + ", visitingDate=" + visitingDate + '}';
    }

    @Override
    public void replicate(final Visiting type) {

        this.isEffective = type.isEffective;
        this.prediction = type.prediction;
        this.suggestions = type.suggestions;
        this.symptoms = type.symptoms;
        this.visitingDate = type.visitingDate;
    }
}
