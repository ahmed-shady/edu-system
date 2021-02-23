package com.segmatek.scienceclub.core;

import lombok.Data;

import javax.validation.constraints.NotNull;


@Data
public class JoinRequest {
    @NotNull
    private String name;

    @NotNull
    private Specialization specialization;
}
