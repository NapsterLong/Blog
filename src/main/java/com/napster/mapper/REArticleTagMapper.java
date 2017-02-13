package com.napster.mapper;

import com.napster.model.REArticleTag;
import org.springframework.stereotype.Component;

@Component
public interface REArticleTagMapper {
    int deleteByPrimaryKey(Long id);

    int insert(REArticleTag record);

    int insertSelective(REArticleTag record);

    REArticleTag selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(REArticleTag record);

    int updateByPrimaryKey(REArticleTag record);
}