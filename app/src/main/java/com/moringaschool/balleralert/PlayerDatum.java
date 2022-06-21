
package com.moringaschool.balleralert;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;


public class PlayerDatum {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("first_name")
    @Expose
    private String firstName;
    @SerializedName("height_feet")
    @Expose
    private Object heightFeet;
    @SerializedName("height_inches")
    @Expose
    private Object heightInches;
    @SerializedName("last_name")
    @Expose
    private String lastName;
    @SerializedName("position")
    @Expose
    private String position;
    @SerializedName("team")
    @Expose
    private Team team;
    @SerializedName("weight_pounds")
    @Expose
    private Object weightPounds;

    /**
     * No args constructor for use in serialization
     * 
     */
    public PlayerDatum() {
    }

    /**
     * 
     * @param firstName
     * @param lastName
     * @param weightPounds
     * @param heightInches
     * @param id
     * @param heightFeet
     * @param position
     * @param team
     */
    private ArrayList<PlayerDatum> listplayers = new ArrayList<>();
    public PlayerDatum(Integer id, String firstName, Object heightFeet, Object heightInches, String lastName, String position, Team team, Object weightPounds) {
        super();
        this.id = id;
        this.firstName = firstName;
        this.heightFeet = heightFeet;
        this.heightInches = heightInches;
        this.lastName = lastName;
        this.position = position;
        this.team = team;
        this.weightPounds = weightPounds;
        this.listplayers.add(this);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Object getHeightFeet() {
        return heightFeet;
    }

    public void setHeightFeet(Object heightFeet) {
        this.heightFeet = heightFeet;
    }

    public Object getHeightInches() {
        return heightInches;
    }

    public void setHeightInches(Object heightInches) {
        this.heightInches = heightInches;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Team getTeam() {
        return team;
    }

    public List<PlayerDatum> getAll(){
        return listplayers;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public Object getWeightPounds() {
        return weightPounds;
    }

    public void setWeightPounds(Object weightPounds) {
        this.weightPounds = weightPounds;
    }

}
