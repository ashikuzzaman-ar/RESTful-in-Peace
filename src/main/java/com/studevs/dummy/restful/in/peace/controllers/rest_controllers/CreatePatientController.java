package com.studevs.dummy.restful.in.peace.controllers.rest_controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.studevs.dummy.restful.in.peace.models.enums.AdminPrivilege;
import com.studevs.dummy.restful.in.peace.models.user.Admin;
import com.studevs.dummy.restful.in.peace.models.user.Patient;
import com.studevs.dummy.restful.in.peace.models.user.provider.PatientProvider;
import com.studevs.dummy.restful.in.peace.utility.service.providers.BeanProvider;
import java.util.List;
import java.util.Map;
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

    private ObjectMapper mapper;
    private List<String> message;
    private Map<String, List<String>> messages;
    private String json;

    /**
     * This method will initialize some necessary fields before starting other works.
     *
     * @param request
     */
    private void initializer(HttpServletRequest request) {

        this.createContext(request);
        this.mapper = this.getBean("mapper");
        this.message = this.getBean("message");
        this.message.clear();
        this.messages = this.getBean("messages");
        this.messages.put("messages", this.message);
        this.json = "";
    }

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

        try {

            /**
             * If any binding error occurred then further attempt will not be taken.
             */
            if (bindingResult.hasErrors()) {

                this.message.add("Binding error!");
            } else {

                /**
                 * If token is empty then the user might not be a valid admin.
                 */
                if (token.isEmpty()) {

                    this.message.add("Empty token!");
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
                            this.message.add("Insertion : " + patientProvider.insertNewPatient(patient, this));
                        } else {

                            this.message.add("Access limited!");
                        }
                    } else {

                        this.message.add("Invalid token!");
                    }
                }
            }
            this.json = this.mapper.writeValueAsString(this.messages);
        } catch (JsonProcessingException e) {

            this.logger(e, null, null);
        }

        return this.json;
    }
}
