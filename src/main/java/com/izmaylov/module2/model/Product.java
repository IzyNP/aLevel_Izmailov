package com.izmaylov.module2.model;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Product{
    private String type;
    private String series;
    private String screenType;
    private int price;
    private String model;
    private String diagonal;
    private String country;
    private boolean emptyValue;

    public void setCountry(String country) {
        if(country.equals("")){
            emptyValue = true;
        }else{
            this.country = country;
        }
    }

    public void setDiagonal(String diagonal) {
        if(country.equals("")){
            emptyValue = true;
        }else {
            this.diagonal = diagonal;
        }
    }

    public void setModel(String model) {
        if(country.equals("")){
            emptyValue = true;
        }else {
            this.model = model;
        }
    }

    public void setPrice(String price) {
        if(country.equals("")){
            emptyValue = true;
        }else {
            this.price =Integer.parseInt(price);
        }
    }

    public void setScreenType(String screenType) {
        if(country.equals("")){
            emptyValue = true;
        }else {
            this.screenType = screenType;
        }
    }

    public void setSeries(String series) {
        if(country.equals("")){
            emptyValue = true;
        }else {
            this.series = series;
        }
    }

    public void setType(String type) {
        if(type.equals("")){
            emptyValue = true;
        }else {
            this.type = type;
        }
    }
}
