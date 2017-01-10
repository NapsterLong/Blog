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
        return "navbar/program";
    }

    @RequestMapping("life")
    public String toLife() {
        return "navbar/life";
    }

    @RequestMapping("about")
    public String toAbout() {
        return "navbar/about";
    }
}
