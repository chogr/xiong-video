package com.xiong.video.bean;

import java.util.List;

/**
 * 优酷视频Info
 * Created by 杨超 on 2016/5/2.
 */
public class YouKuVideoInfo {

    /**
     * id : XMTU1NDE4NTYyMA==
     * title : 马云大谈互联网王健林雷军陈安之徐鹤宁谈现在安利权健无限极直销趋势
     * link : http://v.youku.com/v_show/id_XMTU1NDE4NTYyMA==.html
     * thumbnail : http://r2.ykimg.com/054201015726D1846A0A43045744D793
     * bigThumbnail : http://r2.ykimg.com/054101015726D1846A0A43045744D793
     * thumbnail_v2 : http://r2.ykimg.com/054201015726D1846A0A43045744D793
     * duration : 539
     * category : 资讯
     * state : normal
     * view_count : 33497144
     * favorite_count : 3
     * comment_count : 4
     * up_count : 25
     * down_count : 0
     * published : 2016-05-01 10:11:04
     * user : {"id":482187291,"name":null,"link":"http://i.youku.com/u/UMTkyODc0OTE2NA=="}
     * operation_limit : []
     * streamtypes : ["3gphd","flvhd","hd","hd2"]
     * public_type : all
     * tags : 马云,互联网,王健林,雷军,陈安之,徐鹤宁,安利,权健,无限极,直销趋势
     * day_vv : 31248
     */

    private String id;
    private String title;
    private String link;
    private String thumbnail;
    private String bigThumbnail;
    private String thumbnail_v2;
    private double duration;
    private String category;
    private String state;
    private int view_count;
    private int favorite_count;
    private int comment_count;
    private int up_count;
    private int down_count;
    private String published;
    /**
     * id : 482187291
     * name : null
     * link : http://i.youku.com/u/UMTkyODc0OTE2NA==
     */

    private UserBean user;
    private String public_type;
    private String tags;
    private int day_vv;
    private List<?> operation_limit;
    private List<String> streamtypes;

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

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getBigThumbnail() {
        return bigThumbnail;
    }

    public void setBigThumbnail(String bigThumbnail) {
        this.bigThumbnail = bigThumbnail;
    }

    public String getThumbnail_v2() {
        return thumbnail_v2;
    }

    public void setThumbnail_v2(String thumbnail_v2) {
        this.thumbnail_v2 = thumbnail_v2;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getView_count() {
        return view_count;
    }

    public void setView_count(int view_count) {
        this.view_count = view_count;
    }

    public int getFavorite_count() {
        return favorite_count;
    }

    public void setFavorite_count(int favorite_count) {
        this.favorite_count = favorite_count;
    }

    public int getComment_count() {
        return comment_count;
    }

    public void setComment_count(int comment_count) {
        this.comment_count = comment_count;
    }

    public int getUp_count() {
        return up_count;
    }

    public void setUp_count(int up_count) {
        this.up_count = up_count;
    }

    public int getDown_count() {
        return down_count;
    }

    public void setDown_count(int down_count) {
        this.down_count = down_count;
    }

    public String getPublished() {
        return published;
    }

    public void setPublished(String published) {
        this.published = published;
    }

    public UserBean getUser() {
        return user;
    }

    public void setUser(UserBean user) {
        this.user = user;
    }

    public String getPublic_type() {
        return public_type;
    }

    public void setPublic_type(String public_type) {
        this.public_type = public_type;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public int getDay_vv() {
        return day_vv;
    }

    public void setDay_vv(int day_vv) {
        this.day_vv = day_vv;
    }

    public List<?> getOperation_limit() {
        return operation_limit;
    }

    public void setOperation_limit(List<?> operation_limit) {
        this.operation_limit = operation_limit;
    }

    public List<String> getStreamtypes() {
        return streamtypes;
    }

    public void setStreamtypes(List<String> streamtypes) {
        this.streamtypes = streamtypes;
    }

    public static class UserBean {
        private int id;
        private Object name;
        private String link;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public Object getName() {
            return name;
        }

        public void setName(Object name) {
            this.name = name;
        }

        public String getLink() {
            return link;
        }

        public void setLink(String link) {
            this.link = link;
        }
    }
}
