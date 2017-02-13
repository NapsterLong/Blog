package com.napster.controller.admin;

import com.napster.common.response.ResponseResult;
import com.napster.enums.ITOrLifeEnum;
import com.napster.enums.ResultCodeEnum;
import com.napster.model.Category;
import com.napster.service.admin.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * 文章类别Controller
 */
@RestController
@RequestMapping(value = "/admin")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @RequestMapping(value = "/category/listCategoriesByIL")
    public ResponseResult<List<Category>> listCategoriesByIL(@RequestBody Map<String, String> map) {
        ITOrLifeEnum itOrLifeEnum = null;
        ResponseResult<List<Category>> responseResult = new ResponseResult<>();

        if (!map.isEmpty()) {
            itOrLifeEnum = ITOrLifeEnum.getByValue(map.get("itOrLife"));
        }
        if (Objects.isNull(itOrLifeEnum)) {
            responseResult.setCode(ResultCodeEnum.ARGUMENT_ERROR);
            responseResult.setMessage("文章性质不是合法参数");
        } else {
            List<Category> categoryList = categoryService.listCategoriesByIL(itOrLifeEnum);
            responseResult.setCode(ResultCodeEnum.SUCCESS);
            responseResult.setData(categoryList);
        }
        return responseResult;
    }
}
