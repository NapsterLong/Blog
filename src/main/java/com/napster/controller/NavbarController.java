package com.napster.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 导航栏跳转Controller
 */
@Controller
public class NavbarController {


    @RequestMapping("/navbar/program")
    public String toProgram() {
        return "program";
    }

    @RequestMapping("/navbar/life")
    public String toLife() {
        return "life";
    }

    @RequestMapping("/navbar/about")
    public String toAbout() {
        return "about";
    }

    @RequestMapping("/404")
    public String error404() {
        return "404";
    }

    @RequestMapping("/500")
    public String error500() {
        return "500";
    }


}
