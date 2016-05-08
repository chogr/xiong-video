package com.xiong.video.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * YouKuVideoGenresBean
 * Created by 杨超 on 2016/5/4.
 */
public class YouKuVideoGenresBean implements Parcelable {

    /**
     * term : crosstalk
     * label : 相声
     * lang : zh_CN
     */

    private String term;
    private String label;
    private String lang;

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.term);
        dest.writeString(this.label);
        dest.writeString(this.lang);
    }

    public YouKuVideoGenresBean() {
    }

    protected YouKuVideoGenresBean(Parcel in) {
        this.term = in.readString();
        this.label = in.readString();
        this.lang = in.readString();
    }

    public static final Parcelable.Creator<YouKuVideoGenresBean> CREATOR = new Parcelable.Creator<YouKuVideoGenresBean>() {
        @Override
        public YouKuVideoGenresBean createFromParcel(Parcel source) {
            return new YouKuVideoGenresBean(source);
        }

        @Override
        public YouKuVideoGenresBean[] newArray(int size) {
            return new YouKuVideoGenresBean[size];
        }
    };
}
