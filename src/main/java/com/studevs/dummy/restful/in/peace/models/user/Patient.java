package com.studevs.dummy.restful.in.peace.models.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.studevs.dummy.restful.in.peace.models.enums.Gender;
import com.studevs.dummy.restful.in.peace.utility.interfaces.Replicable;
import java.util.Arrays;
import java.util.Date;
import java.util.Objects;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

/**
 *
 * @author ashik
 */
@Entity
@Table(name = "patients", indexes = {
    @Index(columnList = "city_name", name = "patients_city_name")
    ,
    @Index(columnList = "username", name = "patient_username")
    ,
    @Index(columnList = "email", name = "patient_email")
})
public class Patient implements Replicable<Patient> {

    private static final long serialVersionUID = 1L;

    /**
     * ID and primary key
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    /**
     * Username of a patient for login to this portal. This field is not nullable.
     */
    @JsonIgnore
    @Column(name = "username", nullable = false, unique = true)
    private String username;

    /**
     * Password for a patient. This field is not nullable. This field will be ignored in json creation. This field will be stored in byte array format which is a encrypted format for security reason.
     */
    @JsonIgnore
    @Lob
    @Column(name = "password", nullable = false)
    private byte[] password;

    /**
     * Token for making any request. This field will not be persisted.
     */
    @Transient
    private String token;

    /**
     * Email id of the patient. This field is not nullable.
     */
    @Column(name = "email", nullable = false, unique = true)
    private String email;

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
    @JsonIgnore
    @Column(name = "birth_date")
    @Temporal(TemporalType.DATE)
    private Date birthDate;

    /**
     * 1-m relationship between patient and visiting history.
     */
    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    private Set<Visiting> visitings;

    public Patient() {

        this.birthDate = new Date();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserType() {

        return this.getClass().getSimpleName().toUpperCase();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {

        String result = "";
        for (byte b : this.password) {

            result += ((char) b);
        }
        return result;
    }

    public void setPassword(String password) {
        this.password = password.getBytes();
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getDateOfBirth() {
        return birthDate == null ? "" : birthDate.toString();
    }

    public Set<Visiting> getVisitings() {
        return visitings;
    }

    public void setVisitings(Set<Visiting> visitings) {
        this.visitings = visitings;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + Objects.hashCode(this.id);
        hash = 79 * hash + Objects.hashCode(this.username);
        hash = 79 * hash + Arrays.hashCode(this.password);
        hash = 79 * hash + Objects.hashCode(this.token);
        hash = 79 * hash + Objects.hashCode(this.email);
        hash = 79 * hash + Objects.hashCode(this.firstName);
        hash = 79 * hash + Objects.hashCode(this.lastName);
        hash = 79 * hash + Objects.hashCode(this.phone);
        hash = 79 * hash + Objects.hashCode(this.address);
        hash = 79 * hash + Objects.hashCode(this.city);
        hash = 79 * hash + Objects.hashCode(this.state);
        hash = 79 * hash + Objects.hashCode(this.country);
        hash = 79 * hash + Objects.hashCode(this.gender);
        hash = 79 * hash + Objects.hashCode(this.birthDate);
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
        final Patient other = (Patient) obj;
        if (!Objects.equals(this.username, other.username)) {
            return false;
        }
        if (!Objects.equals(this.token, other.token)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.firstName, other.firstName)) {
            return false;
        }
        if (!Objects.equals(this.lastName, other.lastName)) {
            return false;
        }
        if (!Objects.equals(this.phone, other.phone)) {
            return false;
        }
        if (!Objects.equals(this.address, other.address)) {
            return false;
        }
        if (!Objects.equals(this.city, other.city)) {
            return false;
        }
        if (!Objects.equals(this.state, other.state)) {
            return false;
        }
        if (!Objects.equals(this.country, other.country)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Arrays.equals(this.password, other.password)) {
            return false;
        }
        if (this.gender != other.gender) {
            return false;
        }
        if (!Objects.equals(this.birthDate, other.birthDate)) {
            return false;
        }
        return Objects.equals(this.visitings, other.visitings);
    }

    @Override
    public String toString() {
        return "Patient{" + "id=" + id + ", username=" + username + ", token=" + token + ", email=" + email + ", firstName=" + firstName + ", lastName=" + lastName + ", phone=" + phone + ", address=" + address + ", city=" + city + ", state=" + state + ", country=" + country + ", gender=" + gender + ", birthDate=" + birthDate + '}';
    }

    @Override
    public void replicate(final Patient type) {

        this.address = type.address;
        this.birthDate = type.birthDate;
        this.city = type.city;
        this.country = type.country;
        this.email = type.email;
        this.firstName = type.firstName;
        this.gender = type.gender;
        this.id = type.id;
        this.lastName = type.lastName;
        this.password = type.password;
        this.phone = type.phone;
        this.state = type.state;
        this.token = type.token;
        this.username = type.username;
        this.visitings = type.visitings;
    }
}
