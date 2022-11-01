package com.portfolio.fontana.Dto;

import javax.validation.constraints.NotBlank;


public class dtoExperience {
    @NotBlank
    private String nameE;
    @NotBlank
    private String descriptionE;
    @NotBlank
    private String imageE;

    public dtoExperience() {
    }

    public dtoExperience(String nameE, String descriptionE, String imageE) {
        this.nameE = nameE;
        this.descriptionE = descriptionE;
        this.imageE = imageE;
    }

    public String getNameE() {
        return nameE;
    }

    public void setNameE(String nameE) {
        this.nameE = nameE;
    }

    public String getDescriptionE() {
        return descriptionE;
    }

    public void setDescriptionE(String descriptionE) {
        this.descriptionE = descriptionE;
    }

    public String getImageE() {
        return imageE;
    }

    public void setImageE(String imageE) {
        this.imageE = imageE;
    }
    
    
}
