package com.studevs.dummy.restful.in.peace.controllers.rest_controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.studevs.dummy.restful.in.peace.models.enums.AdminPrivilege;
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
public class DeleteAdminController extends BeanProvider {

    private static final long serialVersionUID = 1L;

    @RequestMapping(value = "delete", method = RequestMethod.POST)
    protected String postDeleteAdmin(HttpServletRequest request,
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

                    AdminProvider adminProvider = this.getBean("adminProvider");

                    if (admin.getId().equals(adminFromModel.getId())) {

                        this.getMessage().add("Delete : " + adminProvider.deleteAdmin(admin, this));
                        request.getSession().setAttribute("admin", null);
                        json = this.getMapper().writeValueAsString(this.getMessages());
                    } else if (admin.getAdminPrivilege().equals(AdminPrivilege.ALL)) {

                        this.getMessage().add("Delete : " + adminProvider.deleteAdmin(adminFromModel, this));
                        json = this.getMapper().writeValueAsString(this.getMessages());
                    } else {

                        this.getMessage().add("Access limited!");
                        json = this.getMapper().writeValueAsString(this.getMessages());
                    }
                } else {

                    this.getMessage().add("Invalid token!");
                    json = this.getMapper().writeValueAsString(this.getMessages());
                }
            }
        } catch (JsonProcessingException e) {

            this.logger(e, adminFromModel, adminFromModel.getId());
        }

        return json;
    }
}
