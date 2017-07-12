package com.studevs.dummy.restful.in.peace.controllers.rest_controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.studevs.dummy.restful.in.peace.models.user.Admin;
import com.studevs.dummy.restful.in.peace.models.user.Doctor;
import com.studevs.dummy.restful.in.peace.models.user.Patient;
import com.studevs.dummy.restful.in.peace.models.user.provider.DoctorProvider;
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
public class DoctorController extends BeanProvider {

    private static final long serialVersionUID = 1L;

    @RequestMapping(value = "doctor/get", method = RequestMethod.GET)
    protected String getDoctors(HttpServletRequest request,
            @RequestParam(value = "token", required = true, defaultValue = "") String token,
            @RequestParam(value = "userType", required = true, defaultValue = "") String userType,
            @RequestParam(value = "from", defaultValue = "0") Long from,
            @RequestParam(value = "to", defaultValue = "0") Long to) {

        this.initializer(request);

        String json = "";

        try {

            String userToken;

            switch (userType) {
                case "PATIENT": {
                    userToken = ((Patient) this.getBean("patient")).getToken();
                    break;
                }
                case "DOCTOR": {
                    userToken = ((Doctor) this.getBean("doctor")).getToken();
                    break;
                }
                case "ADMIN": {
                    userToken = ((Admin) this.getBean("admin")).getToken();
                    break;
                }
                default: {
                    userToken = null;
                    break;
                }
            }

            if (userToken != null && token.equals(userToken)) {

                if (from > 0L && to > 0L) {

                    DoctorProvider doctorProvider = this.getBean("doctorProvider");
                    json = this.getMapper().writeValueAsString(doctorProvider.getDoctors(from, to, this));
                } else {

                    this.getMessage().add("Invalid parameter!");
                    json = this.getMapper().writeValueAsString(this.getMessages());
                }
            } else {

                this.getMessage().add("Invalid token!");
                json = this.getMapper().writeValueAsString(this.getMessages());
            }
        } catch (JsonProcessingException e) {

            this.logger(e, null, null);
        }

        return json;
    }
}
