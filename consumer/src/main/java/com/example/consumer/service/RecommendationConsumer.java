package com.example.consumer.service;

import com.example.consumer.model.Recommendation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RecommendationConsumer {

//    private RestTemplate restTemplate;
//
//    @Autowired
//    public RecommendationConsumer(RestTemplate restTemplate) {
//        this.restTemplate = restTemplate;
//    }
//
//    public Recommendation getRecommendation() {
//        Recommendation recommendation =
//                restTemplate.getForObject("http://localhost:8081/api/v1/recommendations", Recommendation.class);
//        return recommendation;
//    }
}
