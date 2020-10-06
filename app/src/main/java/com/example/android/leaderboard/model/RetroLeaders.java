package com.example.android.leaderboard.model;

import com.google.gson.annotations.SerializedName;

public class RetroLeaders {
    @SerializedName("name")

    private String name;



    @SerializedName("hours")

    private int hours;



    @SerializedName("score")

    private int score;



    @SerializedName("country")

    private String country;



    @SerializedName("badgeUrl")

    private String badgeUrl;



    public RetroLeaders(String name, String country, int score, String badgeUrl) {

        this.name = name;

        this.score = score;

        this.country = country;

        this.badgeUrl = badgeUrl;

    }



    public RetroLeaders(String name, int hours, String country, String badgeUrl) {

        this.name = name;

        this.hours = hours;

        this.country = country;

        this.badgeUrl = badgeUrl;

    }



    public int getScore() {

        return score;

    }



    public void setScore(int score) {

        this.score = score;

    }





    public String getName() {

        return name;

    }



    public void setName(String name) {

        this.name = name;

    }



    public int getHours() {

        return hours;

    }



    public void setHours(int hours) {

        this.hours = hours;

    }



    public String getCountry() {

        return country;

    }



    public void setCountry(String country) {

        this.country = country;

    }



    public String getBadgeUrl() {

        return badgeUrl;

    }



    public void setBadgeUrl(String badgeUrl) {

        this.badgeUrl = badgeUrl;

    }

}
