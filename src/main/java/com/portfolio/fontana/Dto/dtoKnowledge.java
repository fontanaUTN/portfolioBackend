package com.portfolio.fontana.Dto;

import javax.validation.constraints.NotBlank;


public class dtoKnowledge {
    @NotBlank
    private String nameK;
    @NotBlank
    private String descriptionK;
    @NotBlank
    private String imageK;
    @NotBlank
    private String skillK;
    
    //constrictors
    public dtoKnowledge() {
    }

    public dtoKnowledge(String nameK, String descriptionK, String imageK, String skillK) {
        this.nameK = nameK;
        this.descriptionK = descriptionK;
        this.imageK = imageK;
        this.skillK = skillK;
    }
    
    //Getter and setters
    public String getNameK() {
        return nameK;
    }

    public void setNameK(String nameK) {
        this.nameK = nameK;
    }

    public String getDescriptionK() {
        return descriptionK;
    }

    public void setDescriptionK(String descriptionK) {
        this.descriptionK = descriptionK;
    }

    public String getImageK() {
        return imageK;
    }

    public void setImageK(String imageK) {
        this.imageK = imageK;
    }

    public String getSkillK() {
        return skillK;
    }

    public void setSkillK(String skillK) {
        this.skillK = skillK;
    }
    
}
