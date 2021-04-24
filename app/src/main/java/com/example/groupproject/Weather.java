package com.example.groupproject;

import java.io.Serializable;

public class Weather implements Serializable {

    String _id;
    Integer weather_id;
    String weather_main;
    String weather_description;
    String weather_icon;
    Integer timezone;
    String base;
    Float main_temp;
    Float main_feels_like;
    Float main_temp_min;
    Float main_temp_max;
    Integer main_pressure;
    Integer main_humidity;
    Integer visibility;
    Integer sys_sunrise;
    Integer sys_sunset;
    Integer objid;
    String name;
    Integer cod;
    Integer wind_deg;
    Float wind_speed;
    String country;
    String units;
    Integer __v;

    public Weather(String _id, Integer weather_id, String weather_main, String weather_description, String weather_icon, Integer timezone, String base, Float main_temp, Float main_feels_like, Float main_temp_min, Float main_temp_max, Integer main_pressure, Integer main_humidity, Integer visibility, Integer sys_sunrise, Integer sys_sunset, Integer objid, String name, Integer cod, Integer wind_deg, Float wind_speed, String country, String units, Integer __v) {
        this._id = _id;
        this.weather_id = weather_id;
        this.weather_main = weather_main;
        this.weather_description = weather_description;
        this.weather_icon = weather_icon;
        this.timezone = timezone;
        this.base = base;
        this.main_temp = main_temp;
        this.main_feels_like = main_feels_like;
        this.main_temp_min = main_temp_min;
        this.main_temp_max = main_temp_max;
        this.main_pressure = main_pressure;
        this.main_humidity = main_humidity;
        this.visibility = visibility;
        this.sys_sunrise = sys_sunrise;
        this.sys_sunset = sys_sunset;
        this.objid = objid;
        this.name = name;
        this.cod = cod;
        this.wind_deg = wind_deg;
        this.wind_speed = wind_speed;
        this.country = country;
        this.units = units;
        this.__v = __v;
    }

    public Weather() {
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public Integer getWeather_id() {
        return weather_id;
    }

    public void setWeather_id(Integer weather_id) {
        this.weather_id = weather_id;
    }

    public String getWeather_main() {
        return weather_main;
    }

    public void setWeather_main(String weather_main) {
        this.weather_main = weather_main;
    }

    public String getWeather_description() {
        return weather_description;
    }

    public void setWeather_description(String weather_description) {
        this.weather_description = weather_description;
    }

    public String getWeather_icon() {
        return weather_icon;
    }

    public void setWeather_icon(String weather_icon) {
        this.weather_icon = weather_icon;
    }

    public Integer getTimezone() {
        return timezone;
    }

    public void setTimezone(Integer timezone) {
        this.timezone = timezone;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public Float getMain_temp() {
        return main_temp;
    }

    public void setMain_temp(Float main_temp) {
        this.main_temp = main_temp;
    }

    public Float getMain_feels_like() {
        return main_feels_like;
    }

    public void setMain_feels_like(Float main_feels_like) {
        this.main_feels_like = main_feels_like;
    }

    public Float getMain_temp_min() {
        return main_temp_min;
    }

    public void setMain_temp_min(Float main_temp_min) {
        this.main_temp_min = main_temp_min;
    }

    public Float getMain_temp_max() {
        return main_temp_max;
    }

    public void setMain_temp_max(Float main_temp_max) {
        this.main_temp_max = main_temp_max;
    }

    public Integer getMain_pressure() {
        return main_pressure;
    }

    public void setMain_pressure(Integer main_pressure) {
        this.main_pressure = main_pressure;
    }

    public Integer getMain_humidity() {
        return main_humidity;
    }

    public void setMain_humidity(Integer main_humidity) {
        this.main_humidity = main_humidity;
    }

    public Integer getVisibility() {
        return visibility;
    }

    public void setVisibility(Integer visibility) {
        this.visibility = visibility;
    }

    public Integer getSys_sunrise() {
        return sys_sunrise;
    }

    public void setSys_sunrise(Integer sys_sunrise) {
        this.sys_sunrise = sys_sunrise;
    }

    public Integer getSys_sunset() {
        return sys_sunset;
    }

    public void setSys_sunset(Integer sys_sunset) {
        this.sys_sunset = sys_sunset;
    }

    public Integer getObjid() {
        return objid;
    }

    public void setObjid(Integer objid) {
        this.objid = objid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCod() {
        return cod;
    }

    public void setCod(Integer cod) {
        this.cod = cod;
    }

    public Integer getWind_deg() {
        return wind_deg;
    }

    public void setWind_deg(Integer wind_deg) {
        this.wind_deg = wind_deg;
    }

    public Float getWind_speed() {
        return wind_speed;
    }

    public void setWind_speed(Float wind_speed) {
        this.wind_speed = wind_speed;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getUnits() {
        return units;
    }

    public void setUnits(String units) {
        this.units = units;
    }

    public Integer get__v() {
        return __v;
    }

    public void set__v(Integer __v) {
        this.__v = __v;
    }
}
