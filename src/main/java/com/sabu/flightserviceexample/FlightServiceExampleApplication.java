package com.sabu.flightserviceexample;

import com.sabu.flightserviceexample.dto.FlightBookingAcknowledgement;
import com.sabu.flightserviceexample.dto.FlightBookingRequest;
import com.sabu.flightserviceexample.service.FlightBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableTransactionManagement
public class FlightServiceExampleApplication {

    private final FlightBookingService flightBookingService;

    @Autowired
    public FlightServiceExampleApplication(FlightBookingService flightBookingService) {
        this.flightBookingService = flightBookingService;
    }

    @PostMapping("/bookFlightTicket")
    public FlightBookingAcknowledgement bookFlightTicket(
            @RequestBody FlightBookingRequest flightBookingRequest) {
        return flightBookingService.bookFlightTicket(flightBookingRequest);
    }

    public static void main(String[] args) {
        SpringApplication.run(FlightServiceExampleApplication.class, args);
    }
}
