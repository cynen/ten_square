package com.myth.article.pojo;

import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.util.Date;

/**
 * 评论的实体类.
 * 因为不和数据库交互,所以不需要使用Entity的注解.
 */
public class Comment implements Serializable {

    @Id
    private String _id; //评论id
    private String articleid; // 文章
    private String content; // 评论内容
    private String userid; // 评论用户
    private String parentid; // 评论的对象.0表示是一级.
    private Date publishdate; // 发布时间.

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getArticleid() {
        return articleid;
    }

    public void setArticleid(String articleid) {
        this.articleid = articleid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getParentid() {
        return parentid;
    }

    public void setParentid(String parentid) {
        this.parentid = parentid;
    }

    public Date getPublishdate() {
        return publishdate;
    }

    public void setPublishdate(Date publishdate) {
        this.publishdate = publishdate;
    }
}
