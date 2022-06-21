
package com.moringaschool.balleralert;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class TheTeams {

    @SerializedName("data")
    @Expose
    private List<Datum> data = null;
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
    public TheTeams(List<Datum> data, Meta meta) {
        super();
        this.data = data;
        this.meta = meta;
    }

    public List<Datum> getData() {
        return data;
    }

    public void setData(List<Datum> data) {
        this.data = data;
    }

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

}
