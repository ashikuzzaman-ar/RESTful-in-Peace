package com.studevs.dummy.restful.in.peace.controllers.rest_controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.studevs.dummy.restful.in.peace.models.user.Patient;
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
}
