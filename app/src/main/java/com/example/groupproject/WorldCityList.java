package com.example.groupproject;

public class WorldCityList {

    String name;
    String country;

    public WorldCityList() {
    }

    public WorldCityList(String name, String country) {
        this.name = name;
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return name + ',' + country;

    }
}
