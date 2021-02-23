package com.segmatek.university.core;

import javax.validation.constraints.NotNull;

public class PostponeRequest {
    @NotNull
    private String name;
    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }
}
