package com.portfolio.fontana.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Knowledge {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nameK;
    private String descriptionK;
    private String imageK;
    private String skillK;
    // contructors
    public Knowledge() {
    }

    public Knowledge(String nameK, String descriptionK, String imageK, String skillK) {
        this.nameK = nameK;
        this.descriptionK = descriptionK;
        this.imageK = imageK;
        this.skillK = skillK;
    }
    
    // Getter and setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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
