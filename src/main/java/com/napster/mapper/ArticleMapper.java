package com.napster.mapper;

import com.napster.model.Article;
import com.napster.model.vo.ArticleTitleContent;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ArticleMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Article record);

    int insertSelective(Article record);

    Article selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Article record);

    int updateByPrimaryKey(Article record);
    /**
     * 计算文章总记录数
     *
     * @return 总记录数
     */
    int count();

    /**
     * 列出最近更新的文章列表
     *
     * @param num 文章数量
     * @return 文章列表
     */
    List<Article> listArticleByRecent(int num);

    /**
     * 列出阅读排行的文章列表
     *
     * @param num 文章数量
     * @return 文章列表
     */
    List<ArticleTitleContent> listArticleByRank(int num);
}