package com.napster.service.admin;

import com.napster.enums.ITOrLifeEnum;
import com.napster.mapper.CategoryMapper;
import com.napster.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 文章类别Service
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public List<Category> listCategoriesByIL(ITOrLifeEnum itOrLifeEnum) {
        return categoryMapper.listCategoriesByIL(itOrLifeEnum.getValue());
    }

}
