package com.napster.mapper;

import com.napster.model.Category;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface CategoryMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Category record);

    int insertSelective(Category record);

    Category selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Category record);

    int updateByPrimaryKey(Category record);

    /**
     * 根据文章性质查询该性质下所有类别
     *
     * @param itOrLife 文章性质 IT/Life
     * @return 类别列表
     */
    List<Category> listCategoriesByIL(@Param("itOrLife") String itOrLife);
}