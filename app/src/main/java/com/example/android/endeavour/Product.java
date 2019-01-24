package com.example.android.endeavour;

/**
 * Created by manvi on 28-01-2018.
 */
import com.google.gson.annotations.SerializedName;

/**
 * Created by Himanshu Gupta on 12/22/2016.
 */
public class Product
{
    @SerializedName("title")
    String title;
    @SerializedName("description")
    String description;
    @SerializedName("eventid")
    String eventid;
    @SerializedName("paystatus")
    String paystatus;
    @SerializedName("category")
    String category;


    public String getDesc()
    {
        return description;
    }

    public String getTitle()
    {
        return title;
    }

    public void setDesc(String desc)
    {
        this.description = description;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public String getPaystatus() {
        return paystatus;
    }

    public String getEventid() {
        return eventid;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setEventid(String eventid) {
        this.eventid = eventid;
    }

    public void setPaystatus(String paystatus) {
        this.paystatus = paystatus;
    }
}
