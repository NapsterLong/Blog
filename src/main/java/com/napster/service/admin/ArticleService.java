package com.napster.service.admin;

import com.napster.common.response.ResponseResult;
import com.napster.model.Article;

import java.util.List;
import java.util.Map;

/**
 * 文章管理Service
 */
public interface ArticleService {

    /**
     * 发布一篇文章
     *
     * @param map 参数列表
     * @return 发布结果
     */
    ResponseResult<String> saveArticle(Map<String, Object> map) throws Exception;

    /**
     * 根据条件分页查询文章列表
     * @param map 查询条件
     * @param pageNum 页码
     * @return 文章列表
     */
    List<Article> listArticleByPage(Map<String, Object> map, int pageNum);
}
