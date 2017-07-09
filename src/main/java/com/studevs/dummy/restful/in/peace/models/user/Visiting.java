package com.studevs.dummy.restful.in.peace.models.user;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "doctor_patient_visiting")
public class Visiting implements Serializable {

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
    @Column(name = "visiting_date_time")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date visitingDate;

    /**
     * m-1 relationship between visiting history and doctor.
     */
    @ManyToOne(cascade = CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    private Doctor doctor;

    /**
     * m-1 relationship between visiting history and patient.
     */
    @ManyToOne(cascade = CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    private Patient patient;
}
