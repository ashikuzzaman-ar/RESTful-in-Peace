package com.studevs.dummy.restful.in.peace.controllers.rest_controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.studevs.dummy.restful.in.peace.models.user.Admin;
import com.studevs.dummy.restful.in.peace.models.user.provider.AdminProvider;
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
@RequestMapping(value = "services/api/admin")
public class UpdateAdminController extends BeanProvider {

    private static final long serialVersionUID = 1L;

    @RequestMapping(value = "update", method = RequestMethod.POST)
    protected String postUpdateAdmin(HttpServletRequest request,
            @ModelAttribute Admin adminFromModel,
            BindingResult bindingResult) {

        this.initializer(request);

        String json = "";

        try {

            if (bindingResult.hasErrors()) {

                this.getMessage().add("Binding error!");
                json = this.getMapper().writeValueAsString(this.getMessages());
            } else {

                Admin admin = this.getBean("admin");

                if (adminFromModel.getToken() != null && adminFromModel.getToken().equals(admin.getToken())) {

                    adminFromModel.setId(admin.getId());
                    adminFromModel.setAdminPrivilege(admin.getAdminPrivilege());

                    if (adminFromModel.getAdminPrivilege() == null) {
                        adminFromModel.setAdminPrivilege(admin.getAdminPrivilege());
                    }

                    boolean passwordTrigger = false;

                    if (adminFromModel.getPassword() == null || adminFromModel.getPassword().isEmpty()) {

                        adminFromModel.setPassword(admin.getPassword());
                        passwordTrigger = true;
                    }

                    if (adminFromModel.getUsername() == null || adminFromModel.getUsername().isEmpty()) {

                        adminFromModel.setUsername(admin.getUsername());
                    }

                    AdminProvider adminProvider = this.getBean("adminProvider");

                    if (adminProvider.updateAdmin(adminFromModel, this, passwordTrigger)) {

                        this.getMessage().add("Update : " + true);
                        admin.replicate(adminFromModel);
                        json = this.getMapper().writeValueAsString(new Object[]{this.getMessages(), admin});
                    } else {

                        this.getMessage().add("Update : " + false);
                        json = this.getMapper().writeValueAsString(new Object[]{this.getMessages(), admin});
                    }
                } else {

                    this.getMessage().add("Invalid token!");
                    json = this.getMapper().writeValueAsString(this.getMessages());
                }
            }
        } catch (JsonProcessingException e) {

            this.logger(e, adminFromModel, null);
        }

        return json;
    }
}
