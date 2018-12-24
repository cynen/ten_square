package com.myth.base.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * 字段名需要和表的字段一致,否则在设置字段的时候,需要提供columon注解.
 */
@Entity
@Table(name = "tb_label")
public class Label implements Serializable {
        @Id
        private String id;//
        @Column(name = "labelname") //#对应表中的字段名.
        private String labelname;//标签名称
        private String state;//状态
        private Long count;//使用数量
        private Long fans;//关注数
        private String recommend;//是否推荐

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLabelname() {
        return labelname;
    }

    public void setLabelname(String labelname) {
        this.labelname = labelname;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public Long getFans() {
        return fans;
    }

    public void setFans(Long fans) {
        this.fans = fans;
    }

    public String getRecommend() {
        return recommend;
    }

    public void setRecommend(String recommend) {
        this.recommend = recommend;
    }
}
