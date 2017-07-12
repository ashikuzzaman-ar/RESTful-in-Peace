package com.studevs.dummy.restful.in.peace.controllers.rest_controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.studevs.dummy.restful.in.peace.models.user.Patient;
import com.studevs.dummy.restful.in.peace.models.user.Visiting;
import com.studevs.dummy.restful.in.peace.models.user.provider.VisitingProvider;
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
@RequestMapping(value = "services/api/user")
public class CreateVisitingController extends BeanProvider {

    private static final long serialVersionUID = 1L;

    @RequestMapping(value = "visiting/create", method = RequestMethod.POST)
    protected String postCraeteVisiting(HttpServletRequest request,
            @RequestParam(value = "token", required = true, defaultValue = "") String token,
            @RequestParam(value = "doctorId", required = true, defaultValue = "0L") Long doctorId,
            @ModelAttribute Visiting visiting,
            BindingResult bindingResult) {

        this.initializer(request);

        String json = "";

        try {

            if (bindingResult.hasErrors()) {

                this.getMessage().add("Binding error!");
            } else {

                Patient patient = this.getBean("patient");
                if (!token.isEmpty() && token.equals(patient.getToken())) {

                    if (doctorId > 0L) {

                        if (this.hasNoError(visiting)) {

                            VisitingProvider visitingProvider = this.getBean("visitingProvider");
                            this.getMessage().add("Insertion : " + visitingProvider.insertNewVisiting(visiting, patient.getId(), doctorId, this));
                        } else {

                            this.getMessage().add("Invalid information!");
                        }
                    } else {

                        this.getMessage().add("Invalid doctorId!");
                    }
                } else {

                    this.getMessage().add("Invalid token!");
                }
            }

            json = this.getMapper().writeValueAsString(this.getMessages());
        } catch (JsonProcessingException e) {

            this.logger(e, null, null);
        }

        return json;
    }

    /**
     * This method will check visiting model's validity.
     *
     * @param visiting
     * @return
     */
    private boolean hasNoError(final Visiting visiting) {

        visiting.setIsEffective(null);
        visiting.setPrediction(null);
        visiting.setSuggestions(null);
        visiting.setSymptoms(null);

        if (visiting.getDoctorFee() == null || visiting.getDoctorFee().isInfinite() || visiting.getDoctorFee().isNaN()) {

            return false;
        }

        return !(visiting.getVisitingDate() == null);
    }
}
