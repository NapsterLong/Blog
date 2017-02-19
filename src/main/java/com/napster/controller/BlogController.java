package com.napster.controller;

import com.napster.util.LogUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 博客正文Controller
 */
@Controller
public class BlogController {

    @RequestMapping("/blog/{contentFile:.*}")
    public String toBlog(@PathVariable String contentFile, Model model) {
        LogUtil.logInfo(contentFile);
        return "redirect:/";
    }
}
