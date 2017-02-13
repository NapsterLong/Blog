package com.napster.service.admin;

import com.napster.common.response.ResponseResult;

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
}
