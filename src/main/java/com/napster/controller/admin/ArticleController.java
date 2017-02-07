package com.napster.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * 后台文章管理Controller
 */
@Controller
@RequestMapping(value = "/admin")
public class ArticleController {

    @RequestMapping(value = "/article/toAdd", method = RequestMethod.GET)
    public String toAddArticle() {
        return "/article/addArticle";
    }

}
