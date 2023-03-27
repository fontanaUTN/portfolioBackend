package com.portfolio.fontana.Dto;

import javax.validation.constraints.NotBlank;

public class dtoAbout {
    @NotBlank
    private String text;
    private String extra;
    
    //Constrcutos
    public dtoAbout() {
    }
    
    public dtoAbout(String text, String extra) {
        this.text = text;
        this.extra = extra;
    }
    //getter and setter
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
    
    public String getExtra() {
        return extra;
    }

    public void setExtra(String extra) {
        this.extra = extra;
    }
    
}
