package com.napster.serviceTest;

import com.napster.mapper.ArticleMapper;
import com.napster.model.Article;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 文章测试类
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class ArticleTest {

    @Autowired
    private ArticleMapper articleMapper;

    @Test
    public void testInsert() {
        Article article = new Article();
        article.setTitle("test");
        article.setCategoryId(Long.parseLong("11"));
        article.setAuthor("test");
        article.setSummary("test");
        article.setContentFile("test");
        article.setItOrLife("test");
        long what = articleMapper.insertSelective(article);
        System.out.println(what);

    }
}
