package com.napster.mapper;

import com.napster.model.Tag;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface TagMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Tag record);

    int insertSelective(Tag record);

    Tag selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Tag record);

    int updateByPrimaryKey(Tag record);

    /**
     * 去重插入一个标签
     *
     * @param tag 标签
     * @return 记录的主键
     */
    long insertIgnore(Tag tag);

    /**
     * 根据标签名称插入标签
     *
     * @param tagName 标签名称
     * @return 标签
     */
    Tag selectByTagName(@Param("tagName") String tagName);

    /**
     * 根据文章ID查询该文章的所有标签
     *
     * @param articleId 文章ID
     * @return 标签列表
     */
    List<Tag> selectTagsByArticleId(Long articleId);
}