package com.entity;

import java.io.Serializable;

/**
 * Created by abdul on 11/7/2016.
 */
public class City implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String name;

    private String state;

    private String country;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return getId() + "," + getName() + "," + getState() + "," + getCountry();
    }
}
