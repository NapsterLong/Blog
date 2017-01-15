package com.napster.controller.admin;

import com.alibaba.fastjson.JSONObject;
import com.baidu.ueditor.ActionEnter;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * UEditor编辑器后台Controller
 */
@Controller
@RequestMapping(value = "/admin")
public class UEditorController {

    @Value("${rootPath}")
    private String rootPath;

    @RequestMapping(value = "/config")
    @ResponseBody
    public String config(HttpServletRequest request, HttpServletResponse response) {
        String state = "";

        try {
            response.setContentType("application/json");
            request.setCharacterEncoding("utf-8");
            response.setHeader("Content-Type", "text/html");

            JSONObject params = new JSONObject();
            String param[] = request.getQueryString().split("&");
            for (int i = 0, length = param.length; i < length; i++) {
                if (StringUtils.isNotBlank(param[i])) {
                    String temp[] = param[i].split("=");
                    params.put(temp[0], temp[1]);
                }
            }
            ActionEnter action = new ActionEnter(request, params, rootPath);
            state = action.exec();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return state;
    }
}
