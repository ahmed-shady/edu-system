package com.segmatek.scienceclub.service;

import com.segmatek.scienceclub.core.JoinRequest;
import com.segmatek.scienceclub.core.ScoreReport;
import com.segmatek.scienceclub.core.Specialization;
import com.segmatek.scienceclub.core.StatusResponse;
import com.segmatek.scienceclub.repository.ScientistRepository;
import org.hibernate.mapping.Join;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;


@Service
public class ScientistService {

    @Autowired
    ScientistRepository scientistRepository;

    @Value("${microservices.university.url}")
    String univesrityUrl;


    @Cacheable("join_requests")
    public StatusResponse checkJoinRequest(JoinRequest joinRequest){
        String name = joinRequest.getName();
        Specialization specialization = joinRequest.getSpecialization();
        RestTemplate restTemplate = new RestTemplate();
        String dashedName = String.join("-", name.split(" "));
        String studentScoresUrl = String.format("%s/student/%s/scores", univesrityUrl, dashedName);
        try {
            ResponseEntity<ScoreReport[]> response =
                    restTemplate.getForEntity(
                            studentScoresUrl,
                            ScoreReport[].class);
            if(response.getStatusCode() == HttpStatus.OK){
                ScoreReport[] scores = response.getBody();
                return new StatusResponse("accepted");
            }

        }catch (HttpClientErrorException ex){
            return new StatusResponse("rejected");
        }

        return new StatusResponse("rejected");
    }
}
