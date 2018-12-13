package com.ac.hosptial.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * Created by zhenchao.bi on 6/26/2017.
 */
@Data
public class MedicineDetailModel {

    @JsonProperty("Id")
    private String id;

    @JsonProperty("Name")
    private String name;

    @JsonProperty("Price")
    private int price;

    @JsonProperty("Number")
    private int number;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
    
    
}
