package com.studevs.dummy.restful.in.peace.controllers.rest_controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.studevs.dummy.restful.in.peace.models.user.Admin;
import com.studevs.dummy.restful.in.peace.models.user.provider.AdminProvider;
import com.studevs.dummy.restful.in.peace.utility.service.Encrypt;
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
public class AdminLoginController extends BeanProvider {

    private static final long serialVersionUID = 1L;
    private Admin admin;

    /**
     * login is a secured service so only POST method can perform to get token from this service, other all method will be restricted by this request handler to prevent user's to login.
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "login")
    protected String allAdminLogin(HttpServletRequest request) {

        this.initializer(request);

        String json = "";

        try {

            this.getMessage().add("Request method is not supported!");
            json = this.getMapper().writeValueAsString(this.getMessages());
        } catch (JsonProcessingException e) {

            this.logger(e, this.getMessages(), null);
        }

        return json;
    }

    /**
     * This is a method for accepting POST requests from client side. This method will be used for authenticating and generating token for admins.
     *
     * @param request
     * @param adminModel
     * @param bindingResult
     * @return
     */
    @RequestMapping(value = "login", method = RequestMethod.POST)
    protected String postAdminLogin(HttpServletRequest request,
            @ModelAttribute Admin adminModel,
            BindingResult bindingResult) {

        this.initializer(request);

        String json = "";

        try {

            /**
             * If any binding error occurred then further attempt will not be taken.
             */
            if (!bindingResult.hasErrors()) {

                /**
                 * username and password should not null and empty for authentication an admin.
                 */
                if ((adminModel.getUsername() != null && !adminModel.getUsername().isEmpty()) && (adminModel.getPassword() != null && !adminModel.getPassword().isEmpty())) {

                    try {

                        AdminProvider adminProvider = this.getBean("adminProvider");
                        Admin adminFromDB = adminProvider.getAdminByUsername(adminModel.getUsername(), this);
                        Encrypt encrypt = this.getBean("encrypt");

                        /**
                         * If admin fetching from database is null that means no data found in database which have such username.
                         */
                        if (adminFromDB == null) {

                            this.getMessage().add("User doesn't exist!");
                            json = this.getMapper().writeValueAsString(this.getMessages());
                        } else if (encrypt.generateHash(adminModel.getPassword(), adminFromDB.getId()).equals(adminFromDB.getPassword())) {

                            /**
                             * If these two password is not same then admin provided wrong password.
                             */
                            adminFromDB.setToken(encrypt.generateHash((adminFromDB.getUsername() + this.getBean("date") + adminFromDB.getPassword() + adminFromDB.getAdminPrivilege()), adminFromDB.getId()));
                            this.admin = this.getBean("admin");
                            this.admin.replicate(adminFromDB);
                            json = this.getMapper().writeValueAsString(this.admin);
                        } else {

                            this.getMessage().add("Password is incorrect!");
                            json = this.getMapper().writeValueAsString(this.getMessages());
                        }
                    } catch (JsonProcessingException e) {

                        this.logger(e, adminModel, null);
                    }
                } else {

                    this.getMessage().add("Username and/or password is empty!");
                    json = this.getMapper().writeValueAsString(this.getMessages());
                }
            } else {

                this.getMessage().add("Data binding error!");
                json = this.getMapper().writeValueAsString(this.getMessages());
            }
        } catch (JsonProcessingException e) {

            this.logger(e, null, null);
        }

        return json;
    }
}
