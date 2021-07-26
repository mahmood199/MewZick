package com.example.wednesdaysolutionchallenge.Models.DeezerModels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Data {

    public int id ;
    public boolean readable ;


    @SerializedName("title")
    @Expose
    public String title ;


    @SerializedName("title")
    @Expose
    public String title_short ;


    public String title_version ;
    public String link ;


    @SerializedName("title")
    @Expose
    public int duration ;
    public int rank ;
    public String explicit_lyrics ;
    public int explicit_content_lyrics ;
    public int explicit_content_cover ;


    @SerializedName("title")
    @Expose
    public String preview ;
    public String md5_image ;
    public Artist artist ;
    public String type ;

    public Data() {
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isReadable() {
        return readable;
    }

    public void setReadable(boolean readable) {
        this.readable = readable;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle_short() {
        return title_short;
    }

    public void setTitle_short(String title_short) {
        this.title_short = title_short;
    }

    public String getTitle_version() {
        return title_version;
    }

    public void setTitle_version(String title_version) {
        this.title_version = title_version;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public String getExplicit_lyrics() {
        return explicit_lyrics;
    }

    public void setExplicit_lyrics(String explicit_lyrics) {
        this.explicit_lyrics = explicit_lyrics;
    }

    public int getExplicit_content_lyrics() {
        return explicit_content_lyrics;
    }

    public void setExplicit_content_lyrics(int explicit_content_lyrics) {
        this.explicit_content_lyrics = explicit_content_lyrics;
    }

    public int getExplicit_content_cover() {
        return explicit_content_cover;
    }

    public void setExplicit_content_cover(int explicit_content_cover) {
        this.explicit_content_cover = explicit_content_cover;
    }

    public String getPreview() {
        return preview;
    }

    public void setPreview(String preview) {
        this.preview = preview;
    }

    public String getMd5_image() {
        return md5_image;
    }

    public void setMd5_image(String md5_image) {
        this.md5_image = md5_image;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
