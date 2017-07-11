package com.studevs.dummy.restful.in.peace.controllers.rest_controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.studevs.dummy.restful.in.peace.models.user.Doctor;
import com.studevs.dummy.restful.in.peace.models.user.provider.DoctorProvider;
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

    @RequestMapping(value = "doctor/update", method = RequestMethod.POST)
    protected String postUpdateDoctor(HttpServletRequest request,
            @ModelAttribute Doctor doctorFromModel,
            BindingResult bindingResult) {

        this.initializer(request);

        String json = "";

        try {

            if (bindingResult.hasErrors()) {

                this.getMessage().add("Binding error!");
                json = this.getMapper().writeValueAsString(this.getMessages());
            } else {

                Doctor doctor = this.getBean("doctor");

                if (doctor.getToken() == null) {

                    this.getMessage().add("Login first!");
                    json = this.getMapper().writeValueAsString(this.getMessages());
                } else {

                    if (doctor.getToken().equals(doctorFromModel.getToken())) {

                        DoctorProvider doctorProvider = this.getBean("doctorProvider");
                        doctorFromModel.setId(doctor.getId());

                        if (doctorProvider.updateDoctor(doctorFromModel, this)) {

                            doctor.replicate(doctorFromModel);
                            this.getMessage().add("Update successful!");
                            json = this.getMapper().writeValueAsString(new Object[]{this.getMessages(), doctor});
                        } else {

                            this.getMessage().add("Update failed!");
                            json = this.getMapper().writeValueAsString(new Object[]{this.getMessages(), doctor});
                        }
                    } else {

                        this.getMessage().add("Invalid token!");
                        json = this.getMapper().writeValueAsString(this.getMessages());
                    }
                }
            }
        } catch (JsonProcessingException e) {

            this.logger(e, null, null);
        }

        return json;
    }
}
