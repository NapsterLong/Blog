package com.napster.model;

import java.util.Date;

public class Tag {
    private Long id;

    private String tagName;

    private String creator;

    private String itOrLife;

    private Date createTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName == null ? null : tagName.trim();
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator == null ? null : creator.trim();
    }

    public String getItOrLife() {
        return itOrLife;
    }

    public void setItOrLife(String itOrLife) {
        this.itOrLife = itOrLife == null ? null : itOrLife.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}