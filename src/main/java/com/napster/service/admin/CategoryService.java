package com.napster.service.admin;

import com.napster.enums.ITOrLifeEnum;
import com.napster.model.Category;

import java.util.List;

/**
 * 文章类别Service
 */
public interface CategoryService {

    /**
     * 根据itOrLife获取对应文章类别
     *
     * @param itOrLifeEnum 技术/随笔
     * @return 文章类别列表
     */
    List<Category> listCategoriesByIL(ITOrLifeEnum itOrLifeEnum);
}
