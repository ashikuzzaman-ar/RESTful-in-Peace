package com.studevs.dummy.restful.in.peace.models.user;

import com.studevs.dummy.restful.in.peace.models.enums.Gender;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

/**
 *
 * @author ashik
 */
@Entity
@Table(name = "patients")
public class Patient implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * ID and primary key
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    /**
     * First name of the patient. This field is not nullable.
     */
    @Column(name = "first_name", nullable = false)
    private String firstName;

    /**
     * Last name of the patient. This field is not nullable.
     */
    @Column(name = "last_name", nullable = false)
    private String lastName;

    /**
     * Phone number of the doctor. This field is nullable.
     */
    @Column(name = "phone_number")
    private String phone;

    /**
     * Address of the patient. This field is not nullable.
     */
    @Column(name = "address", nullable = false)
    private String address;

    /**
     * Present city of the patient. This field is not nullable.
     */
    @Column(name = "city_name", nullable = false)
    private String city;

    /**
     * Patient's present sate where s/he lives. This field is not nullable.
     */
    @Column(name = "state_name", nullable = false)
    private String state;

    /**
     * Country name where the patient lives. This field is not nullable.
     */
    @Column(name = "country_name", nullable = false)
    private String country;

    /**
     * Patient's gender. This field is not nullable.
     */
    @Column(name = "gender", nullable = false)
    private Gender gender;

    /**
     * Date of birth of a patient.
     */
    @Column(name = "birth_date")
    @Temporal(TemporalType.DATE)
    private Date birthDate;

    /**
     * 1-m relationship between patient and visiting history.
     */
    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    private Set<Visiting> visitings;
}
