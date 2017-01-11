package com.napster.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 后台文章管理Controller
 */
@Controller
@RequestMapping("/admin")
public class ArticleController {

    @RequestMapping("/article/toAdd")
    public String toAddArticle() {
        return "admin/addArticle";
    }
}
