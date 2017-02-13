package com.napster.model;

import java.util.Date;

public class Category {
    private Long id;

    private String categoryName;

    private String itOrLife;

    private String creator;

    private Date createTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName == null ? null : categoryName.trim();
    }

    public String getItOrLife() {
        return itOrLife;
    }

    public void setItOrLife(String itOrLife) {
        this.itOrLife = itOrLife == null ? null : itOrLife.trim();
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator == null ? null : creator.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}