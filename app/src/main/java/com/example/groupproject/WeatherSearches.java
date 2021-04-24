package com.example.groupproject;

import java.io.Serializable;

public class WeatherSearches implements Serializable {
    String _id;
    String country;
    String name;
    String units;
    String __v;

    public WeatherSearches() {
    }

    public WeatherSearches(String _id, String country, String name, String units, String __v) {
        this._id = _id;
        this.country = country;
        this.name = name;
        this.units = units;
        this.__v = __v;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUnits() {
        return units;
    }

    public void setUnits(String units) {
        this.units = units;
    }

    public String get__v() {
        return __v;
    }

    public void set__v(String __v) {
        this.__v = __v;
    }
}
