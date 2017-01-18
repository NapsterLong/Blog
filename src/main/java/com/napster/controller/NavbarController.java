package com.napster.controller;

import com.napster.mapper.TestMapper;
import com.napster.model.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 导航栏跳转Controller
 */
@Controller
@RequestMapping("/")
public class NavbarController {

    @Autowired()
    private TestMapper testMapper;

    @RequestMapping("")
    public String toIndex() {
        temp();
        return "index";

    }

    @Transactional(rollbackFor = Exception.class)
    public void temp() {
        Test test1 = testMapper.selectByPrimaryKey(1);
        System.out.println(test1.getId());
        System.out.println(test1.getName());
        System.out.println(test1.getNum());
        System.out.println(test1.getText());
        System.out.println(test1.getDate());
        System.out.println(test1.getDateTime());
        System.out.println(test1.getTimestamp());
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
