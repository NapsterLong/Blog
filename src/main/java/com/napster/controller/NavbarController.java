package com.napster.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 导航栏跳转Controller
 */
@Controller
@RequestMapping("/")
public class NavbarController {

    @RequestMapping("")
    public String toIndex() {
        return "index";
    }

    @RequestMapping("program")
    public String toProgram() {
        return "template/t_index";
    }

    @RequestMapping("life")
    public String toLife() {
        return "template/t_contact";
    }

    @RequestMapping("about")
    public String toAbout() {
        return "template/t_about";
    }
}
