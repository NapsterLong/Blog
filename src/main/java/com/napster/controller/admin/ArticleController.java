package com.napster.controller.admin;

import com.napster.common.response.ResponseResult;
import com.napster.enums.ITOrLifeEnum;
import com.napster.enums.ResultCodeEnum;
import com.napster.model.Category;
import com.napster.service.admin.ArticleService;
import com.napster.service.admin.CategoryService;
import com.napster.util.LogUtil;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;


/**
 * 后台文章管理Controller
 */
@Controller
@RequestMapping(value = "/admin")
public class ArticleController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ArticleService articleService;

    /**
     * 跳转到添加文章页面
     *
     * @param model 参数
     * @return addArticle页面
     */
    @RequestMapping(value = "/article/toAdd", method = RequestMethod.GET)
    public String toAddArticle(Model model) {
        List<Category> categoryList = categoryService.listCategoriesByIL(ITOrLifeEnum.IT);
        if (CollectionUtils.isNotEmpty(categoryList)) {
            model.addAttribute("categories", categoryList);
        }
        return "/article/addArticle";
    }

    /**
     * 发布一篇新文章
     *
     * @param map 参数
     * @return 处理结果
     */
    @RequestMapping(value = "/article/add", method = RequestMethod.POST)
    @ResponseBody
    public ResponseResult<String> addArticle(@RequestBody Map<String, Object> map) {

        ResponseResult<String> responseResult = new ResponseResult<>();
        try {
            responseResult = articleService.saveArticle(map);
        } catch (Exception e) {
            LogUtil.logError(e);
            responseResult.setCode(ResultCodeEnum.SYS_ERROR);
            responseResult.setMessage("系统错误");
        }
        return responseResult;
    }

}
