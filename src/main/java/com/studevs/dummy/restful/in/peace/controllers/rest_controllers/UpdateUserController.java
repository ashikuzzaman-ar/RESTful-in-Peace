package com.studevs.dummy.restful.in.peace.controllers.rest_controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.studevs.dummy.restful.in.peace.models.user.Doctor;
import com.studevs.dummy.restful.in.peace.models.user.Patient;
import com.studevs.dummy.restful.in.peace.models.user.provider.DoctorProvider;
import com.studevs.dummy.restful.in.peace.models.user.provider.PatientProvider;
import com.studevs.dummy.restful.in.peace.utility.service.providers.BeanProvider;
import javax.servlet.http.HttpServletRequest;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ashik
 */
@RestController
@RequestMapping(value = "services/api/user")
public class UpdateUserController extends BeanProvider {

    private static final long serialVersionUID = 1L;

    /**
     * This is a method for accepting POST request method from user to update patient model.
     *
     * @param request
     * @param patientFromModel
     * @param bindingResult
     * @return
     */
    @RequestMapping(value = "patient/update", method = RequestMethod.POST)
    protected String postUpdatePatient(HttpServletRequest request,
            @ModelAttribute Patient patientFromModel,
            BindingResult bindingResult) {

        this.initializer(request);

        String json = "";

        try {

            Patient patient = this.getBean("patient");

            //If the token of patient from session is null then the user is not logged in.
            if (patient.getToken() == null) {

                this.getMessage().add("Login first!");
                json = this.getMapper().writeValueAsString(this.getMessages());
            } else {

                //If the token is same then and only then further processing will be done.
                if (patient.getToken().equals(patientFromModel.getToken())) {

                    PatientProvider patientProvider = this.getBean("patientProvider");

                    /**
                     * If user don't set any password then the old password should not be changed or modified, this key will ensure that.
                     */
                    boolean passwordTrigger = patientFromModel.getPassword() == null || patientFromModel.getPassword().isEmpty();

                    //Null field will be replaced by it's previous value
                    this.replaceNullFieldsOfPatient(patientFromModel, patient);

                    if (patientProvider.updatePatient(patientFromModel, this, passwordTrigger)) {

                        patient.replicate(patientFromModel);
                        this.getMessage().add("Update successful!");
                        json = this.getMapper().writeValueAsString(new Object[]{this.getMessages(), patient});
                        patient.setVisitings(null);//setting visitings null for consuming less session memory.
                    } else {

                        this.getMessage().add("Update failed!");
                        json = this.getMapper().writeValueAsString(new Object[]{this.getMessages(), patient});
                    }
                } else {

                    this.getMessage().add("Invalid token!");
                    json = this.getMapper().writeValueAsString(this.getMessages());
                }
            }
        } catch (JsonProcessingException e) {

            this.logger(e, patientFromModel, patientFromModel.getId());
        }

        return json;
    }

    /**
     * This is a method for accepting POST request method from user to update doctor model.
     *
     * @param request
     * @param doctorFromModel
     * @param bindingResult
     * @return
     */
    @RequestMapping(value = "doctor/update", method = RequestMethod.POST)
    protected String postUpdateDoctor(HttpServletRequest request,
            @ModelAttribute Doctor doctorFromModel,
            BindingResult bindingResult) {

        this.initializer(request);

        String json = "";

        try {

            Doctor doctor = this.getBean("doctor");

            //If the token of doctor from session is null then the user is not logged in.
            if (doctor.getToken() == null) {

                this.getMessage().add("Login first!");
                json = this.getMapper().writeValueAsString(this.getMessages());
            } else {

                //If the token is same then and only then further processing will be done.
                if (doctor.getToken().equals(doctorFromModel.getToken())) {

                    DoctorProvider doctorProvider = this.getBean("doctorProvider");

                    /**
                     * If user don't set any password then the old password should not be changed or modified, this key will ensure that.
                     */
                    boolean passwordTrigger = doctorFromModel.getPassword() == null || doctorFromModel.getPassword().isEmpty();

                    //Null field will be replaced by it's previous value
                    this.replaceNullFieldsofDoctor(doctorFromModel, doctor);

                    if (doctorProvider.updateDoctor(doctorFromModel, this, passwordTrigger)) {

                        doctor.replicate(doctorFromModel);
                        this.getMessage().add("Update successful!");
                        json = this.getMapper().writeValueAsString(new Object[]{this.getMessages(), doctor});
                        doctor.setVisitings(null);//setting visitings null for consuming less session memory.
                    } else {

                        this.getMessage().add("Update failed!");
                        json = this.getMapper().writeValueAsString(new Object[]{this.getMessages(), doctor});
                    }
                } else {

                    this.getMessage().add("Invalid token!");
                    json = this.getMapper().writeValueAsString(this.getMessages());
                }
            }
        } catch (JsonProcessingException e) {

            this.logger(e, doctorFromModel, doctorFromModel.getId());
        }

        return json;
    }

    /**
     * This method will check a patient's fields binded from user. If any field is empty of null then the value of that field will be replaced by the previous value of that field.
     *
     * @param patientFromModel
     * @param patient
     */
    private void replaceNullFieldsOfPatient(final Patient patientFromModel, final Patient patient) {

        patientFromModel.setId(patient.getId());

        if (patientFromModel.getUsername() == null || patientFromModel.getUsername().isEmpty()) {

            patientFromModel.setUsername(patient.getUsername());
        }

        if (patientFromModel.getPassword() == null || patientFromModel.getPassword().isEmpty()) {

            patientFromModel.setPassword(patient.getPassword());
        }

        if (patientFromModel.getEmail() == null || patientFromModel.getEmail().isEmpty()) {

            patientFromModel.setEmail(patient.getEmail());
        }

        if (patientFromModel.getFirstName() == null || patientFromModel.getFirstName().isEmpty()) {

            patientFromModel.setFirstName(patient.getFirstName());
        }

        if (patientFromModel.getLastName() == null || patientFromModel.getLastName().isEmpty()) {

            patientFromModel.setLastName(patient.getLastName());
        }

        if (patientFromModel.getAddress() == null || patientFromModel.getAddress().isEmpty()) {

            patientFromModel.setAddress(patient.getAddress());
        }

        if (patientFromModel.getCity() == null || patientFromModel.getCity().isEmpty()) {

            patientFromModel.setCity(patient.getCity());
        }

        if (patientFromModel.getState() == null || patientFromModel.getState().isEmpty()) {

            patientFromModel.setCity(patient.getState());
        }

        if (patientFromModel.getCountry() == null || patientFromModel.getCountry().isEmpty()) {

            patientFromModel.setCountry(patient.getCountry());
        }

        if (patientFromModel.getGender() == null) {

            patientFromModel.setGender(patient.getGender());
        }

        if (patientFromModel.getBirthDate() == null) {

            patientFromModel.setBirthDate(patient.getBirthDate());
        }
    }

    /**
     * This method will check a doctor's fields binded from user. If any field is empty of null then the value of that field will be replaced by the previous value of that field.
     *
     * @param doctorFromModel
     * @param doctor
     */
    private void replaceNullFieldsofDoctor(final Doctor doctorFromModel, final Doctor doctor) {

        doctorFromModel.setId(doctor.getId());

        if (doctorFromModel.getUsername() == null || doctorFromModel.getUsername().isEmpty()) {

            doctorFromModel.setUsername(doctor.getUsername());
        }

        if (doctorFromModel.getPassword() == null || doctorFromModel.getPassword().isEmpty()) {

            doctorFromModel.setPassword(doctor.getPassword());
        }

        if (doctorFromModel.getEmail() == null || doctorFromModel.getEmail().isEmpty()) {

            doctorFromModel.setEmail(doctor.getEmail());
        }

        if (doctorFromModel.getFirstName() == null || doctorFromModel.getFirstName().isEmpty()) {

            doctorFromModel.setFirstName(doctor.getFirstName());
        }

        if (doctorFromModel.getLastName() == null || doctorFromModel.getLastName().isEmpty()) {

            doctorFromModel.setLastName(doctor.getLastName());
        }

        if (doctorFromModel.getAddress() == null || doctorFromModel.getAddress().isEmpty()) {

            doctorFromModel.setAddress(doctor.getAddress());
        }

        if (doctorFromModel.getCity() == null || doctorFromModel.getCity().isEmpty()) {

            doctorFromModel.setCity(doctor.getCity());
        }

        if (doctorFromModel.getState() == null || doctorFromModel.getState().isEmpty()) {

            doctorFromModel.setCity(doctor.getState());
        }

        if (doctorFromModel.getCountry() == null || doctorFromModel.getCountry().isEmpty()) {

            doctorFromModel.setCountry(doctor.getCountry());
        }

        if (doctorFromModel.getGender() == null) {

            doctorFromModel.setGender(doctor.getGender());
        }

        if (doctorFromModel.getBirthDate() == null) {

            doctorFromModel.setBirthDate(doctor.getBirthDate());
        }
    }
}
