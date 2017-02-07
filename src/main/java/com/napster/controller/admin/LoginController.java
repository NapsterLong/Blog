package com.napster.controller.admin;

import com.napster.common.response.ResponseResult;
import com.napster.enums.ResultCodeEnum;
import com.napster.mapper.UserMapper;
import com.napster.model.User;
import com.napster.service.admin.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * 后台登陆Controller
 */
@Controller
@RequestMapping("/admin")
public class LoginController {

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/login")
    public String login() {
        return "/admin/login";
    }

    /**
     * 管理员登陆
     *
     * @param user 登陆用户信息
     * @return 登陆结果
     */
    @RequestMapping("/loginIn")
    @ResponseBody
    public ResponseResult<String> loginIn(@RequestBody User user, HttpServletRequest request) {
        ResponseResult<String> responseResult = userService.loginIn(user);
        if (responseResult.getCode().equals(ResultCodeEnum.SUCCESS)) {
            User loginUser = userMapper.selectByUserId(user.getUserId());
            HttpSession session = request.getSession(true);
            session.setAttribute("userId", loginUser.getUserId());
            session.setAttribute("userName", loginUser.getUserName());
        }
        return responseResult;
    }

    /**
     * 注销登陆
     */
    @RequestMapping("/logout")
    public String logout(HttpServletRequest request) {
        request.getSession().invalidate();
        return "redirect:/admin/login";
    }

}
