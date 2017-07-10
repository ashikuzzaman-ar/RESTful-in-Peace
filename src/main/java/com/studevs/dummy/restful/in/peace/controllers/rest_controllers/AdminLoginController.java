package com.studevs.dummy.restful.in.peace.controllers.rest_controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.studevs.dummy.restful.in.peace.models.user.Admin;
import com.studevs.dummy.restful.in.peace.models.user.provider.AdminProvider;
import com.studevs.dummy.restful.in.peace.utility.service.Encrypt;
import com.studevs.dummy.restful.in.peace.utility.service.providers.BeanProvider;
import java.util.List;
import java.util.Map;
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
@RequestMapping(value = "services/api/admin")
public class AdminLoginController extends BeanProvider {

    private static final long serialVersionUID = 1L;
    private Admin admin;
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

    @RequestMapping(value = "login")
    protected String allAdminLogin(HttpServletRequest request) {

        this.initializer(request);

        try {

            this.message.add("Request method is not supported!");
            this.json = this.mapper.writeValueAsString(this.messages);
        } catch (JsonProcessingException e) {

            this.logger(e, this.messages, null);
        }

        return json;
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    protected String postAdminLogin(HttpServletRequest request,
            @ModelAttribute Admin adminModel,
            BindingResult bindingResult) {

        this.initializer(request);

        try {

            if (!bindingResult.hasErrors()) {

                if ((adminModel.getUsername() != null && !adminModel.getUsername().isEmpty()) && (adminModel.getPassword() != null && !adminModel.getPassword().isEmpty())) {

                    try {

                        AdminProvider adminProvider = this.getBean("adminProvider");
                        Admin adminFromDB = adminProvider.getAdminByUsername(adminModel.getUsername(), this);
                        Encrypt encrypt = this.getBean("encrypt");

                        if (adminFromDB == null) {

                            this.message.add("User doesn't exist!");
                            this.json = this.mapper.writeValueAsString(this.messages);
                        } else if (encrypt.generateHash(adminModel.getPassword(), adminFromDB.getId()).equals(adminFromDB.getPassword())) {

                            adminFromDB.setToken(encrypt.generateHash((adminFromDB.getUsername() + this.getBean("date") + adminFromDB.getPassword() + adminFromDB.getAdminPrivilege()), adminFromDB.getId()));
                            this.admin = this.getBean("admin");
                            this.admin.replicate(adminFromDB);
                            this.json = this.mapper.writeValueAsString(this.admin);
                        } else {

                            this.message.add("Password is incorrect!");
                            this.json = this.mapper.writeValueAsString(this.messages);
                        }
                    } catch (JsonProcessingException e) {

                        this.logger(e, adminModel, null);
                    }
                } else {

                    this.message.add("Username and/or password is empty!");
                    this.json = this.mapper.writeValueAsString(this.messages);
                }
            } else {

                this.message.add("Data binding error!");
                this.json = this.mapper.writeValueAsString(this.messages);
            }
        } catch (JsonProcessingException e) {

            this.logger(e, null, null);
        }

        return json;
    }
}
