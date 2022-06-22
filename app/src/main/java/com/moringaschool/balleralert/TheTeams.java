
package com.moringaschool.balleralert;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class TheTeams {

    @SerializedName("data")
    @Expose
    private List<Team> data = null;
    @SerializedName("meta")
    @Expose
    private Meta meta;

    /**
     * No args constructor for use in serialization
     * 
     */
    public TheTeams() {
    }

    /**
     * 
     * @param data
     * @param meta
     */
    public TheTeams(List<Team> data, Meta meta) {
        super();
        this.data = data;
        this.meta = meta;
    }

    public List<Team> getData() {
        return data;
    }

    public void setData(List<Team> data) {
        this.data = data;
    }

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

}
