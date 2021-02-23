package com.segmatek.scienceclub.controller;


import com.segmatek.scienceclub.core.JoinRequest;
import com.segmatek.scienceclub.core.StatusResponse;
import com.segmatek.scienceclub.service.ScientistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin
@RestController
@RequestMapping(path = "/scientist")
public class ScientistController {
    @Autowired
    ScientistService scientistService;
    @PostMapping("/check")
    public StatusResponse checkJoinRequest(@Valid @RequestBody JoinRequest joinRequest){
        return scientistService.checkJoinRequest(joinRequest);
    }
}
