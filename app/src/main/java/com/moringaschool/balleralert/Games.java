
package com.moringaschool.balleralert;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Games {

    @SerializedName("data")
    @Expose
    private List<PlayerDatum> data = null;
    @SerializedName("meta")
    @Expose
    private Meta meta;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Games() {
    }

    /**
     * 
     * @param data
     * @param meta
     */
    public Games(List<PlayerDatum> data, Meta meta) {
        super();
        this.data = data;
        this.meta = meta;
    }

    public List<PlayerDatum> getData() {
        return data;
    }

    public void setData(List<PlayerDatum> data) {
        this.data = data;
    }

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

}
