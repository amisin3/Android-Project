package com.booklisting.android.zomato;


import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Post {

    @SerializedName("location_suggestions")
    @Expose
    private ArrayList<LocationSuggestion> locationSuggestions = null;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("has_more")
    @Expose
    private Integer hasMore;
    @SerializedName("has_total")
    @Expose
    private Integer hasTotal;

    public ArrayList<LocationSuggestion> getLocationSuggestions() {
        return locationSuggestions;
    }

    public void setLocationSuggestions(ArrayList<LocationSuggestion> locationSuggestions) {
        this.locationSuggestions = locationSuggestions;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getHasMore() {
        return hasMore;
    }

    public void setHasMore(Integer hasMore) {
        this.hasMore = hasMore;
    }

    public Integer getHasTotal() {
        return hasTotal;
    }

    public void setHasTotal(Integer hasTotal) {
        this.hasTotal = hasTotal;
    }

}