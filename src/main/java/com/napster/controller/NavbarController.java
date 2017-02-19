package com.napster.controller;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.File;

/**
 * 导航栏跳转Controller
 */
@Controller
public class NavbarController {


    @RequestMapping("/navbar/it")
    public String toProgram() {
        return "navbar/it";
    }

    @RequestMapping("/navbar/life")
    public String toLife() {
        return "navbar/life";
    }

    @RequestMapping("/navbar/about")
    public String toAbout(Model model) {
        String blogContent = "";
        File file = new File("/data1/resources/html/2017-02-13_3.html");
        try {
            blogContent = FileUtils.readFileToString(file, "utf-8");
        } catch (Exception e) {

        }
        model.addAttribute("blogContent", blogContent);
        return "navbar/about";
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
