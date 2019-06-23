package com.myth.search.pojo;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;

import java.io.Serializable;

/**
 * 文章索引的实体类,其实也就是取Article实体类的部分字段,用于索引库中.
 */
@Document(indexName = "tensquare",type = "article")
public class Article implements Serializable {

    @Id
    private String id; //文章ID

    // 是否索引,就是该域是否能被搜索
    // 是否分词,就是表示搜索的时候,是整体匹配和是分词匹配
    // 是否存储,就是是否在页面展示.
    @Field(index = true,analyzer = "ik_max_word",searchAnalyzer = "ik_max_word")
    private String title; // 文章的Title

    @Field(index = true,analyzer = "ik_max_word",searchAnalyzer = "ik_max_word")
    private String content; // 文章的内容

    private String state; // 状态

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
