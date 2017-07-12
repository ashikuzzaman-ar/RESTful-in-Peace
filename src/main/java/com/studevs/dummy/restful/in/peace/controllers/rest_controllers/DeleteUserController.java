package com.studevs.dummy.restful.in.peace.controllers.rest_controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.studevs.dummy.restful.in.peace.models.user.Doctor;
import com.studevs.dummy.restful.in.peace.models.user.Patient;
import com.studevs.dummy.restful.in.peace.models.user.provider.DoctorProvider;
import com.studevs.dummy.restful.in.peace.models.user.provider.PatientProvider;
import com.studevs.dummy.restful.in.peace.utility.service.providers.BeanProvider;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ashik
 */
@RestController
@RequestMapping(value = "services/api/user")
public class DeleteUserController extends BeanProvider {

    private static final long serialVersionUID = 1L;

    /**
     * This is a method for accepting POST request from user to delete an existing patient account.
     *
     * @param request
     * @param token
     * @return
     */
    @RequestMapping(value = "patient/delete", method = RequestMethod.POST)
    protected String postDeletePatient(HttpServletRequest request,
            @RequestParam(value = "token", required = true, defaultValue = "") String token) {

        this.initializer(request);

        String json = "";

        try {

            Patient patient = this.getBean("patient");

            if (!token.isEmpty() && token.equals(patient.getToken())) {

                PatientProvider patientProvider = this.getBean("patientProvider");
                boolean isDeleted = patientProvider.deletePatient(patient, this);
                this.getMessage().add("Delete : " + isDeleted);

                if (isDeleted) {

                    request.getSession().setAttribute("patient", null);
                }
            } else {

                this.getMessage().add("Invalid token!");
            }

            json = this.getMapper().writeValueAsString(this.getMessages());
        } catch (JsonProcessingException e) {

            this.logger(e, null, null);
        }

        return json;
    }

    /**
     * This is a method for accepting POST request from user to delete an existing doctor account.
     *
     * @param request
     * @param token
     * @return
     */
    @RequestMapping(value = "doctor/delete", method = RequestMethod.POST)
    protected String postDeleteDoctor(HttpServletRequest request,
            @RequestParam(value = "token", required = true, defaultValue = "") String token) {

        this.initializer(request);

        String json = "";

        try {

            Doctor doctor = this.getBean("doctor");

            if (!token.isEmpty() && token.equals(doctor.getToken())) {

                DoctorProvider doctorProvider = this.getBean("doctorProvider");
                boolean isDeleted = doctorProvider.deleteDoctor(doctor, this);
                this.getMessage().add("Delete : " + isDeleted);

                if (isDeleted) {

                    request.getSession().setAttribute("doctor", null);
                }
            } else {

                this.getMessage().add("Invalid token!");
            }

            json = this.getMapper().writeValueAsString(this.getMessages());
        } catch (JsonProcessingException e) {

            this.logger(e, null, null);
        }

        return json;
    }
}
