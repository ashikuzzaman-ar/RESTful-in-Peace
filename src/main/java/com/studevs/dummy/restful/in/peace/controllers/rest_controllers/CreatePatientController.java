package com.studevs.dummy.restful.in.peace.controllers.rest_controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.studevs.dummy.restful.in.peace.models.enums.AdminPrivilege;
import com.studevs.dummy.restful.in.peace.models.user.Admin;
import com.studevs.dummy.restful.in.peace.models.user.Patient;
import com.studevs.dummy.restful.in.peace.models.user.provider.PatientProvider;
import com.studevs.dummy.restful.in.peace.utility.service.providers.BeanProvider;
import javax.servlet.http.HttpServletRequest;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ashik
 */
@RestController
@RequestMapping(value = "services/api/admin")
public class CreatePatientController extends BeanProvider {

    private static final long serialVersionUID = 1L;

    /**
     * This is a method for catching POST requests. This method will be used for inserting Patient model instance into database. request parameter will be used for creating application context and refreshing context. token will be used for authentication, only valid admins can insert data into database. patient instance will be used for persisting into database.
     *
     * @param request
     * @param token
     * @param patient
     * @param bindingResult
     * @return
     */
    @RequestMapping(value = "patient", method = RequestMethod.POST)
    protected String postCreateNewDoctor(HttpServletRequest request,
            @RequestParam(value = "token", defaultValue = "") String token,
            @ModelAttribute Patient patient,
            BindingResult bindingResult) {

        this.initializer(request);

        String json = "";
        try {

            /**
             * If any binding error occurred then further attempt will not be taken.
             */
            if (bindingResult.hasErrors()) {

                this.getMessage().add("Binding error!");
            } else {

                /**
                 * If token is empty then the user might not be a valid admin.
                 */
                if (token.isEmpty()) {

                    this.getMessage().add("Empty token!");
                } else {

                    Admin admin = this.getBean("admin");
                    /**
                     * If admin bean from session has equal token to this token then and only then the user is valid admin to do that.
                     */
                    if (token.equals(admin.getToken())) {

                        /**
                         * If admin have proper right to insert data into database then and only then an admin can do that.
                         */
                        if (admin.getAdminPrivilege() == AdminPrivilege.ALL || admin.getAdminPrivilege() == AdminPrivilege.CREATE) {

                            PatientProvider patientProvider = this.getBean("patientProvider");
                            this.getMessage().add("Insertion : " + patientProvider.insertNewPatient(patient, this));
                        } else {

                            this.getMessage().add("Access limited!");
                        }
                    } else {

                        this.getMessage().add("Invalid token!");
                    }
                }
            }
            json = this.getMapper().writeValueAsString(this.getMessages());
        } catch (JsonProcessingException e) {

            this.logger(e, null, null);
        }

        return json;
    }
}
