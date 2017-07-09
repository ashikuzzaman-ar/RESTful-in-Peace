package com.studevs.dummy.restful.in.peace.controllers;

import java.io.Serializable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author ashik
 */
@Controller
public class IndexController implements Serializable {

    private static final long serialVersionUID = 1L;

    @RequestMapping(value = "index")
    protected String doGetIndex() {

        return "index";
    }
}
