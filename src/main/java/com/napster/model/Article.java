package com.napster.model;

import java.util.Date;
import java.util.List;

public class Article {
    private Long id;

    private String title;

    private String categoryName;

    private String author;

    private String summary;

    private String contentFile;

    private String coverFile;

    private String itOrLife;

    private Integer visitCount;

    private Integer commentCount;

    private Date createTime;

    private Date updateTime;

    //tags
    private List<Tag> tags;

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName == null ? null : categoryName.trim();
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author == null ? null : author.trim();
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary == null ? null : summary.trim();
    }

    public String getContentFile() {
        return contentFile;
    }

    public void setContentFile(String contentFile) {
        this.contentFile = contentFile == null ? null : contentFile.trim();
    }

    public String getCoverFile() {
        return coverFile;
    }

    public void setCoverFile(String coverFile) {
        this.coverFile = coverFile == null ? null : coverFile.trim();
    }

    public String getItOrLife() {
        return itOrLife;
    }

    public void setItOrLife(String itOrLife) {
        this.itOrLife = itOrLife == null ? null : itOrLife.trim();
    }

    public Integer getVisitCount() {
        return visitCount;
    }

    public void setVisitCount(Integer visitCount) {
        this.visitCount = visitCount;
    }

    public Integer getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(Integer commentCount) {
        this.commentCount = commentCount;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}