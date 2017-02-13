package com.napster.mapper;

import com.napster.model.Article;
import org.springframework.stereotype.Component;

@Component
public interface ArticleMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Article record);

    long insertSelective(Article record);

    Article selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Article record);

    int updateByPrimaryKey(Article record);

    /**
     * 计算文章总记录数
     *
     * @return 总记录数
     */
    int count();
}