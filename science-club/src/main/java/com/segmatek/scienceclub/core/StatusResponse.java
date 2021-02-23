package com.segmatek.scienceclub.core;

public class StatusResponse {

    final String status;
    public StatusResponse(String status){
        this.status = status;
    }

    public String getStatus(){
        return status;
    }
}
