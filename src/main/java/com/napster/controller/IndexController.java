package com.napster.controller;

import com.napster.common.constant.SystemConstant;
import com.napster.model.Article;
import com.napster.model.vo.ArticleTitleContent;
import com.napster.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * 主页Controller
 */
@Controller
@RequestMapping(value = "/")
public class IndexController {

    @Autowired
    private BlogService blogService;

    @RequestMapping(value = "")
    public String index(Model model) {
        List<Article> recentArticleList = blogService.listArticleByRecent(SystemConstant.LIST_ARTICLE_COUNT5);
        List<ArticleTitleContent> rankTitleList = blogService.listArticleByRank(SystemConstant.LIST_ARTICLE_COUNT10);
        model.addAttribute("recentArticleList", recentArticleList);
        model.addAttribute("rankTitleList", rankTitleList);
        return "index";
    }

}
