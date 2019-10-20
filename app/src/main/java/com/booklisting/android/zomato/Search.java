package com.booklisting.android.zomato;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Search {

    @SerializedName("location_suggestions")
    @Expose
    private String location_suggestions;

    @SerializedName("status")
    @Expose
    private String status;

    @SerializedName("has_more")
    @Expose
    private int has_more;

    @SerializedName("has_total")
    @Expose
    private int has_total;

    public Search(String location_suggestions, String status, int has_more, int has_total) {
        this.location_suggestions = location_suggestions;
        this.status = status;
        this.has_more = has_more;
        this.has_total = has_total;
    }

    public String getLocation_suggestions() {
        return location_suggestions;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getHas_more() {
        return has_more;
    }

    public void setHas_more(int has_more) {
        this.has_more = has_more;
    }

    public int getHas_total() {
        return has_total;
    }

    public void setHas_total(int has_total) {
        this.has_total = has_total;
    }

    public void setLocation_suggestions(String location_suggestions) {
        this.location_suggestions = location_suggestions;
    }

    @Override
    public String toString() {
        return "Search{" +
                "location_suggestions='" + location_suggestions + '\'' +
                ", status='" + status + '\'' +
                ", has_more=" + has_more +
                ", has_total=" + has_total +
                '}';
    }
}
