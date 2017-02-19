package com.napster.service;

import com.napster.model.Article;
import com.napster.model.vo.ArticleTitleContent;

import java.util.List;

/**
 * 前端页面博客Service
 */
public interface BlogService {

    /**
     * 获取最近更新的文章，用于首页展示
     *
     * @param num 文章数量
     * @return 文章列表
     */
    List<Article> listArticleByRecent(int num);

    /**
     * 获取阅读排行的文章列表
     *
     * @param num 文章数量
     * @return 文章列表
     */
    List<ArticleTitleContent> listArticleByRank(int num);
}
