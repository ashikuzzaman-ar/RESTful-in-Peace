package com.studevs.dummy.restful.in.peace.controllers.rest_controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.studevs.dummy.restful.in.peace.models.user.Doctor;
import com.studevs.dummy.restful.in.peace.models.user.Patient;
import com.studevs.dummy.restful.in.peace.models.user.provider.DoctorProvider;
import com.studevs.dummy.restful.in.peace.models.user.provider.PatientProvider;
import com.studevs.dummy.restful.in.peace.utility.service.Encrypt;
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
@RequestMapping(value = "services/api/user")
public class UserLoginController extends BeanProvider {

    private static final long serialVersionUID = 1L;

    /**
     * login is a secured service so only POST method can perform to get token from this service, other all method will be restricted by this request handler to prevent user's to login.
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "login")
    protected String allUserLogin(HttpServletRequest request) {

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
     * This is a method for accepting POST request from client side. This method will generate token for patient or doctor if username and password matches. userType must be defined properly.
     *
     * @param request
     * @param userType
     * @param username
     * @param password
     * @return
     */
    @RequestMapping(value = "login", method = RequestMethod.POST)
    protected String postUserLogin(HttpServletRequest request,
            @RequestParam(value = "userType", required = true, defaultValue = "") String userType,
            @RequestParam(value = "username", required = true, defaultValue = "") String username,
            @RequestParam(value = "password", required = true, defaultValue = "") String password) {

        this.initializer(request);

        String json = "";

        try {

            /**
             * First of all, every new attempt will remove it's previous user session.
             */
            request.getSession().setAttribute("doctor", null);
            request.getSession().setAttribute("patient", null);

            /**
             * Empty username or password can't be accepted for login.
             */
            if (!(userType.isEmpty() || password.isEmpty())) {

                Encrypt encrypt = this.getBean("encrypt");

                switch (userType) {

                    case "PATIENT": {

                        PatientProvider patientProvider = this.getBean("patientProvider");
                        Patient patientFromDB = patientProvider.getPatientByUsername(username, this);

                        /**
                         * If patient fetching from database is null that means no data found in database which have such username.
                         */
                        if (patientFromDB == null) {

                            this.getMessage().add("User doesn't exist!");
                            json = this.getMapper().writeValueAsString(this.getMessages());
                        } else if (encrypt.generateHash(password, patientFromDB.getId()).equals(patientFromDB.getPassword())) {

                            /**
                             * If these two password is not same then patient provided wrong password.
                             */
                            patientFromDB.setToken(encrypt.generateHash((patientFromDB.getUsername() + this.getBean("date") + patientFromDB.getPassword()), patientFromDB.getId()));
                            Patient patient = this.getBean("patient");
                            patient.replicate(patientFromDB);
                            json = this.getMapper().writeValueAsString(patient);
                            patient.setVisitings(null);//setting visitings null for consuming less session memory.
                        } else {

                            this.getMessage().add("Password is incorrect!");
                            json = this.getMapper().writeValueAsString(this.getMessages());
                        }
                        break;
                    }
                    case "DOCTOR": {

                        DoctorProvider doctorProvider = this.getBean("doctorProvider");
                        Doctor doctorFromDB = doctorProvider.getDoctorByUsername(username, this);

                        /**
                         * If doctor fetching from database is null that means no data found in database which have such username.
                         */
                        if (doctorFromDB == null) {

                            this.getMessage().add("User doesn't exist!");
                            json = this.getMapper().writeValueAsString(this.getMessages());
                        } else if (encrypt.generateHash(password, doctorFromDB.getId()).equals(doctorFromDB.getPassword())) {

                            /**
                             * If these two password is not same then doctor provided wrong password.
                             */
                            doctorFromDB.setToken(encrypt.generateHash((doctorFromDB.getUsername() + this.getBean("date") + doctorFromDB.getPassword()), doctorFromDB.getId()));
                            Doctor doctor = this.getBean("doctor");
                            doctor.replicate(doctorFromDB);
                            json = this.getMapper().writeValueAsString(doctor);
                            doctor.setVisitings(null);//setting visitings null for consuming less session memory.
                        } else {

                            this.getMessage().add("Password is incorrect!");
                            json = this.getMapper().writeValueAsString(this.getMessages());
                        }
                        break;
                    }
                    default: {

                        this.getMessage().add("Unspecified user type!");
                        json = this.getMapper().writeValueAsString(this.getMessages());
                        break;
                    }
                }
            } else {

                this.getMessage().add("Username and/or password is empty!");
                json = this.getMapper().writeValueAsString(this.getMessages());
            }
        } catch (JsonProcessingException e) {

            this.logger(e, null, null);
        }

        return json;
    }

    /**
     * logout is a secured service so only POST method can perform to get token from this service, other all method will be restricted by this request handler to prevent user's to logout.
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "logout")
    protected String allUserLogout(HttpServletRequest request) {

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
     * This is a method for logging out of an user account. This method will take token as security reason. If the token is valid then and only then the current user session will be dismissed.
     *
     * @param request
     * @param userType
     * @param token
     * @return
     */
    @RequestMapping(value = "logout", method = RequestMethod.POST)
    protected String postUserLogout(HttpServletRequest request,
            @RequestParam(value = "userType", required = true, defaultValue = "") String userType,
            @RequestParam(value = "token", required = true, defaultValue = "") String token) {

        this.initializer(request);

        String json = "";

        try {

            String authenticationToken;

            switch (userType) {

                /**
                 * Getting authentication token from user's model.
                 */
                case "PATIENT": {

                    authenticationToken = ((Patient) this.getBean("patient")).getToken();
                    break;
                }
                case "DOCTOR": {

                    authenticationToken = ((Doctor) this.getBean("doctor")).getToken();
                    break;
                }
                default: {

                    authenticationToken = null;
                    break;
                }
            }

            if (token.isEmpty()) { //If the token is enpty then no action will be taken.

                this.getMessage().add("Empty token!");
                json = this.getMapper().writeValueAsString(this.getMessages());
            } else if (token.equals(authenticationToken)) { //If token is authenticated then both admin and patient will be destroyed thou only one should present.

                request.getSession().setAttribute("patient", null);
                request.getSession().setAttribute("doctor", null);
                this.getMessage().add("Logout successful!");
                json = this.getMapper().writeValueAsString(this.getMessages());
            } else { //If token is not empty and it does not match to session token then the token must be incorrect.

                this.getMessage().add("Invalid token!");
                json = this.getMapper().writeValueAsString(this.getMessages());
            }
        } catch (JsonProcessingException e) {

            this.logger(e, null, null);
        }

        return json;
    }
}
