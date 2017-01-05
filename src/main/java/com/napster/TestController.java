package com.napster;

/**
 * Created by mfhj-dz-001-324 on 2017/1/5.
 */

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class TestController {

    @RequestMapping(value = "index")
    public String index() {
        return "index";
    }
}
