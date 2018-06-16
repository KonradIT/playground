package com.chernowii.retrofitexample.ApiSections;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class PebbleApp {

    @SerializedName("name")
    public String name;
    @SerializedName("appSource")
    public String source;
    @SerializedName("path_pbw")
    public String pbw;
    @SerializedName("website")
    public String website;
    @SerializedName("description")
    public String desc;
    @SerializedName("hearts")
    public String hearts;
    @SerializedName("path_screenshots")
    public ArrayList<String> screenshots;
    @SerializedName("path_icon")
    public String icon;
    @SerializedName("id")
    public String appid;

    public PebbleApp(String name, String id, String website, String source, String desc, String hearts, String icon, ArrayList<String> screenshots, String pbw) {
        this.name = name;
        this.source = source;
        this.appid = id;
        this.website = website;
        this.desc = desc;
        this.hearts = hearts;
        this.screenshots = screenshots;
        this.icon = icon;
        this.pbw = pbw;
    }
}
