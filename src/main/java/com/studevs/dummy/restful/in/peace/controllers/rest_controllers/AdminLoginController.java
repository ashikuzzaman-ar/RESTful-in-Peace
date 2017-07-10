package com.studevs.dummy.restful.in.peace.controllers.rest_controllers;

import com.studevs.dummy.restful.in.peace.models.user.Admin;
import com.studevs.dummy.restful.in.peace.utility.service.providers.BeanProvider;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.RequestMapping;
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
    private String json;

    @RequestMapping(value = "login")
    protected String test(HttpServletRequest request) {

        this.createContext(request);
        this.json = "";
        try {

        } catch (Exception e) {

            this.logger(e, null, null);
        }

        return json;
    }
}
