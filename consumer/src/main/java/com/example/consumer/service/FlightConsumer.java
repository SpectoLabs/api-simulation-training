package com.example.consumer.service;

import com.example.consumer.model.Flight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class FlightConsumer {

    private static final String FLIGHTS_SERVICE_URL = "http://localhost:8081/api/v1/flights";

    private RestTemplate restTemplate;

    @Autowired
    public FlightConsumer(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<Flight> getAvailableFlights() {
        ResponseEntity<List<Flight>> rateResponse =
                restTemplate.exchange(FLIGHTS_SERVICE_URL, HttpMethod.GET,
                        null, new ParameterizedTypeReference<List<Flight>>() {
                        });
        List<Flight> flights = rateResponse.getBody();
        return flights;
    }
}
