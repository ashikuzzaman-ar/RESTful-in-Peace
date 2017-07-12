package com.studevs.dummy.restful.in.peace.controllers.rest_controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.studevs.dummy.restful.in.peace.models.user.Doctor;
import com.studevs.dummy.restful.in.peace.models.user.Patient;
import com.studevs.dummy.restful.in.peace.models.user.Visiting;
import com.studevs.dummy.restful.in.peace.models.user.provider.VisitingProvider;
import com.studevs.dummy.restful.in.peace.utility.service.providers.BeanProvider;
import javax.servlet.http.HttpServletRequest;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
public class UpdateVisitingController extends BeanProvider {

    private static final long serialVersionUID = 1L;

    @RequestMapping(value = "visiting/update/{user}", method = RequestMethod.POST)
    protected String postUpdateVisitingByUser(HttpServletRequest request,
            @PathVariable(value = "user", required = true) String user,
            @RequestParam(value = "token", required = true, defaultValue = "") String token,
            @ModelAttribute Visiting visiting,
            BindingResult bindingResult) {

        this.initializer(request);

        String json = "";

        try {

            if (bindingResult.hasErrors()) {

                this.getMessage().add("Binding error!");
            } else {

                String userToken = null;
                if (user.equals("patient")) {
                    userToken = ((Patient) this.getBean("patient")).getToken();
                } else if (user.equals("doctor")) {
                    userToken = ((Doctor) this.getBean("doctor")).getToken();
                }

                if (!token.isEmpty() && token.equals(userToken)) {

                    VisitingProvider visitingProvider = this.getBean("visitingProvider");
                    this.getMessage().add("Update : " + visitingProvider.updateVisiting(visiting, this));
                } else {

                    this.getMessage().add("Invalid token!");
                }
            }
            json = this.getMapper().writeValueAsString(this.getMessages());
        } catch (JsonProcessingException e) {

            this.logger(e, visiting, visiting.getId());
        }

        return json;
    }
}
