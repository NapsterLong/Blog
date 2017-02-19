package com.napster.service;

import com.napster.mapper.ArticleMapper;
import com.napster.mapper.TagMapper;
import com.napster.model.Article;
import com.napster.model.Tag;
import com.napster.model.vo.ArticleTitleContent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 前端页面博客Service
 */
@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    private ArticleMapper articleMapper;

    @Autowired
    private TagMapper tagMapper;

    @Override
    public List<Article> listArticleByRecent(int num) {
        if (num <= 0) {
            throw new IllegalArgumentException("错误的文章数量");
        }
        List<Article> recentArticleList = articleMapper.listArticleByRecent(num);
        for (Article article : recentArticleList) {
            List<Tag> tags = tagMapper.selectTagsByArticleId(article.getId());
            article.setTags(tags);
        }
        return recentArticleList;
    }

    @Override
    public List<ArticleTitleContent> listArticleByRank(int num) {
        if (num <= 0) {
            throw new IllegalArgumentException("错误的文章数量");
        }
        return articleMapper.listArticleByRank(num);
    }

}
