package com.studevs.dummy.restful.in.peace.controllers.rest_controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.studevs.dummy.restful.in.peace.models.user.Admin;
import com.studevs.dummy.restful.in.peace.models.user.provider.AdminProvider;
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
@RequestMapping(value = "services/api/admin")
public class AdminController extends BeanProvider {

    private static final long serialVersionUID = 1L;

    /**
     * This controller method will catch get request and return admins as a list.
     *
     * @param request
     * @param token
     * @param from
     * @param to
     * @return
     */
    @RequestMapping(value = "get", method = RequestMethod.GET)
    protected String getCurrentAdmin(HttpServletRequest request,
            @RequestParam(value = "token", required = true, defaultValue = "") String token,
            @RequestParam(value = "from", defaultValue = "0") Long from,
            @RequestParam(value = "to", defaultValue = "0") Long to) {

        this.initializer(request);

        String json = "";

        try {

            Admin admin = this.getBean("admin");

            if (token.equals(admin.getToken())) {

                if (from > -1L && to > -1L) {

                    if (from == 0L && to == 0L) {

                        json = this.getMapper().writeValueAsString(admin);
                    } else {

                        AdminProvider adminProvider = this.getBean("adminProvider");
                        json = this.getMapper().writeValueAsString(adminProvider.getAdmins(from, to, this));
                    }
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
