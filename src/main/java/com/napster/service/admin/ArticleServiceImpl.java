package com.napster.service.admin;

import com.napster.common.response.ResponseResult;
import com.napster.enums.ResultCodeEnum;
import com.napster.mapper.ArticleMapper;
import com.napster.mapper.REArticleTagMapper;
import com.napster.mapper.TagMapper;
import com.napster.model.Article;
import com.napster.model.REArticleTag;
import com.napster.model.Tag;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Map;

/**
 * 文章管理Service
 */

@Service
public class ArticleServiceImpl implements ArticleService {

    private static final String HTML_PATH = "/html";
    private static final String HTML_SUFFIX = ".html";

    @Value("${rootPath}")
    private String rootPath;

    @Autowired
    private ArticleMapper articleMapper;

    @Autowired
    private TagMapper tagMapper;

    @Autowired
    private REArticleTagMapper reArticleTagMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResponseResult<String> saveArticle(Map<String, Object> map) throws Exception {
        ResponseResult<String> responseResult = new ResponseResult<>();
        if (map.isEmpty()) {
            responseResult.setCode(ResultCodeEnum.ARGUMENT_ERROR);
            responseResult.setMessage("参数为空");
            return responseResult;
        }
        String title = (String) map.get("title");
        String itOrLife = (String) map.get("itOrLife");
        int category = (int) map.get("category");
        ArrayList<String> tags = (ArrayList<String>) map.get("tags");
        String summary = (String) map.get("summary");
        String author = (String) map.get("author");
        String content = (String) map.get("content");
        if (StringUtils.isBlank(title) || StringUtils.isBlank(itOrLife) || StringUtils.isBlank(String.valueOf(category)) ||
                StringUtils.isBlank(summary) || StringUtils.isBlank(author) || StringUtils.isBlank(content)
                || CollectionUtils.isEmpty(tags)) {
            responseResult.setCode(ResultCodeEnum.ARGUMENT_ERROR);
            responseResult.setMessage("参数错误");
            return responseResult;
        }
        //将content写进文件
        int count = articleMapper.count() + 1;
        String contentFile = LocalDate.now().format(DateTimeFormatter.ISO_LOCAL_DATE) + "_" + String.valueOf(count) + HTML_SUFFIX;
        File htmlDir = new File(rootPath + HTML_PATH);
        File htmlFile = new File(rootPath + HTML_PATH + "/" + contentFile);
        FileUtils.forceMkdir(htmlDir);
        FileUtils.touch(htmlFile);
        FileUtils.writeStringToFile(htmlFile, content, "utf-8");
        //插入文章
        Article article = new Article();
        article.setTitle(title);
        article.setCategoryId(Long.parseLong(String.valueOf(category)));
        article.setAuthor(author);
        article.setSummary(summary);
        article.setContentFile(contentFile);
        article.setItOrLife(itOrLife);
        articleMapper.insertSelective(article);
        long articleId = article.getId();
        //插入标签及关系表
        for (String tagName : tags) {
            long tagId;
            Tag tempTag = tagMapper.selectByTagName(tagName);
            if (tempTag != null) {
                tagId = tempTag.getId();
            } else {
                tempTag = new Tag();
                tempTag.setTagName(tagName);
                tempTag.setCreator(author);
                tempTag.setItOrLife(itOrLife);
                tagMapper.insertIgnore(tempTag);
                tagId = tempTag.getId();
            }
            //插入文章标签关系表
            REArticleTag reArticleTag = new REArticleTag();
            reArticleTag.setTagId(tagId);
            reArticleTag.setArticleId(articleId);
            reArticleTagMapper.insertSelective(reArticleTag);
        }
        responseResult.setCode(ResultCodeEnum.SUCCESS);
        return responseResult;
    }
}
