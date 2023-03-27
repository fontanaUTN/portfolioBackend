package com.portfolio.fontana.Dto;

import javax.validation.constraints.NotBlank;

public class dtoPeople {

    @NotBlank
    private String name;
    @NotBlank
    private String lastname;
    @NotBlank
    private String description;
    @NotBlank
    private String image;

    // Constructor
    public dtoPeople() {
    }

    public dtoPeople(String name, String lastname, String description, String image) {
        this.name = name;
        this.lastname = lastname;
        this.description = description;
        this.image = image;
    }

    // Getter and Setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
    
    
}
