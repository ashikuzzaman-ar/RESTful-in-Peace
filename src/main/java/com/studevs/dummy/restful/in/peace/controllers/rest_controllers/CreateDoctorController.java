package com.studevs.dummy.restful.in.peace.controllers.rest_controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.studevs.dummy.restful.in.peace.models.enums.AdminPrivilege;
import com.studevs.dummy.restful.in.peace.models.user.Admin;
import com.studevs.dummy.restful.in.peace.models.user.Doctor;
import com.studevs.dummy.restful.in.peace.models.user.provider.DoctorProvider;
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
public class CreateDoctorController extends BeanProvider {

    private static final long serialVersionUID = 1L;

    private ObjectMapper mapper;
    private List<String> message;
    private Map<String, List<String>> messages;
    private String json;

    private void initializer(HttpServletRequest request) {

        this.createContext(request);
        this.mapper = this.getBean("mapper");
        this.message = this.getBean("message");
        this.message.clear();
        this.messages = this.getBean("messages");
        this.messages.put("messages", this.message);
        this.json = "";
    }

    @RequestMapping(value = "doctor", method = RequestMethod.POST)
    protected String postCreateNewDoctor(HttpServletRequest request,
            @RequestParam(value = "token", defaultValue = "") String token,
            @ModelAttribute Doctor doctor,
            BindingResult bindingResult) {

        this.initializer(request);

        try {

            if (bindingResult.hasErrors()) {

                this.message.add("Binding error!");
            } else {

                if (token.isEmpty()) {

                    this.message.add("Empty token!");
                } else {

                    Admin admin = this.getBean("admin");
                    if (token.equals(admin.getToken())) {

                        if (admin.getAdminPrivilege() == AdminPrivilege.ALL || admin.getAdminPrivilege() == AdminPrivilege.CREATE) {

                            DoctorProvider doctorProvider = this.getBean("doctorProvider");
                            this.message.add("Insertion : " + doctorProvider.insertNewDoctor(doctor, this));
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
