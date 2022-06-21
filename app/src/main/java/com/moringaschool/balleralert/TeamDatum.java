
package com.moringaschool.balleralert;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class Datum {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("abbreviation")
    @Expose
    private String abbreviation;
    @SerializedName("city")
    @Expose
    private String city;
    @SerializedName("conference")
    @Expose
    private String conference;
    @SerializedName("division")
    @Expose
    private String division;
    @SerializedName("full_name")
    @Expose
    private String fullName;
    @SerializedName("name")
    @Expose
    private String name;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Datum() {
    }

    /**
     * 
     * @param division
     * @param conference
     * @param city
     * @param name
     * @param fullName
     * @param id
     * @param abbreviation
     */
    public Datum(Integer id, String abbreviation, String city, String conference, String division, String fullName, String name) {
        super();
        this.id = id;
        this.abbreviation = abbreviation;
        this.city = city;
        this.conference = conference;
        this.division = division;
        this.fullName = fullName;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getConference() {
        return conference;
    }

    public void setConference(String conference) {
        this.conference = conference;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
