package com.xiong.video.bean;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

/**
 * YoukuVideoCategoriesBean
 * Created by 杨超 on 2016/5/4.
 */
public class YoukuVideoCategoriesBean implements Parcelable {

    /**
     * id : 85
     * term : Variety
     * label : 综艺
     * lang : zh_CN
     * genres : [{"term":"crosstalk","label":"相声","lang":"zh_CN"},{"term":"sketch","label":"小品","lang":"zh_CN"}]
     */

    private int id;
    private String term;
    private String label;
    private String lang;
    /**
     * term : crosstalk
     * label : 相声
     * lang : zh_CN
     */

    private List<YouKuVideoGenresBean> genres;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public List<YouKuVideoGenresBean> getGenres() {
        return genres;
    }

    public void setGenres(List<YouKuVideoGenresBean> genres) {
        this.genres = genres;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeString(this.term);
        dest.writeString(this.label);
        dest.writeString(this.lang);
        dest.writeList(this.genres);
    }

    public YoukuVideoCategoriesBean() {
    }

    protected YoukuVideoCategoriesBean(Parcel in) {
        this.id = in.readInt();
        this.term = in.readString();
        this.label = in.readString();
        this.lang = in.readString();
        this.genres = new ArrayList<YouKuVideoGenresBean>();
        in.readList(this.genres, YouKuVideoGenresBean.class.getClassLoader());
    }

    public static final Parcelable.Creator<YoukuVideoCategoriesBean> CREATOR = new Parcelable.Creator<YoukuVideoCategoriesBean>() {
        @Override
        public YoukuVideoCategoriesBean createFromParcel(Parcel source) {
            return new YoukuVideoCategoriesBean(source);
        }

        @Override
        public YoukuVideoCategoriesBean[] newArray(int size) {
            return new YoukuVideoCategoriesBean[size];
        }
    };
}
