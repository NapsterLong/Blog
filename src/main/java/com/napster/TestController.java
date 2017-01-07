package com.napster;

/**
 * Created by mfhj-dz-001-324 on 2017/1/5.
 */

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class TestController {

    @RequestMapping("")
    public String toIndex() {
        return "index";
    }

    @RequestMapping(value = "index")
    public String index() {
        return "index";
    }

    @RequestMapping(value = "about")
    public String about() {
        return "template/t_about";
    }

    @RequestMapping(value = "blog")
    public String blog() {
        return "template/t_blog";
    }

    @RequestMapping(value = "contact")
    public String contact() {
        return "template/t_contact";
    }
}
