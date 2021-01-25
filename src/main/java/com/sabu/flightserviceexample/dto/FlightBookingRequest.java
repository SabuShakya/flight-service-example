package com.sabu.flightserviceexample.dto;

import com.sabu.flightserviceexample.entity.PassengerInfo;
import com.sabu.flightserviceexample.entity.PaymentInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FlightBookingRequest {

    private PassengerInfo passengerInfo;

    private PaymentInfo paymentInfo;
}
