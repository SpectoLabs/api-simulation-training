package com.example.consumer.controller;

import com.example.consumer.model.Flight;
import com.example.consumer.service.FlightConsumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FlightDisplayController {

    private FlightConsumer flightConsumer;

    @Autowired
    public FlightDisplayController(FlightConsumer flightConsumer) {
        this.flightConsumer = flightConsumer;
    }

    @RequestMapping(name = "/flights", method = RequestMethod.GET, produces = "application/json")
    public List<Flight> getFlights() {
        return flightConsumer.getAvailableFlights();
    }
}
