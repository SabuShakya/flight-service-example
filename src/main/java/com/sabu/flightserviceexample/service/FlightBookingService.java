package com.sabu.flightserviceexample.service;

import com.sabu.flightserviceexample.dto.FlightBookingAcknowledgement;
import com.sabu.flightserviceexample.dto.FlightBookingRequest;
import com.sabu.flightserviceexample.entity.PassengerInfo;
import com.sabu.flightserviceexample.entity.PaymentInfo;
import com.sabu.flightserviceexample.repository.PassengerInfoRepository;
import com.sabu.flightserviceexample.repository.PaymentInfoRepository;
import com.sabu.flightserviceexample.utils.PaymentUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.UUID;

@Service
public class FlightBookingService {

    private final PassengerInfoRepository passengerInfoRepository;

    private final PaymentInfoRepository paymentInfoRepository;

    @Autowired
    public FlightBookingService(PassengerInfoRepository passengerInfoRepository, PaymentInfoRepository paymentInfoRepository) {
        this.passengerInfoRepository = passengerInfoRepository;
        this.paymentInfoRepository = paymentInfoRepository;
    }

    @Transactional
    public FlightBookingAcknowledgement bookFlightTicket(
            FlightBookingRequest flightBookingRequest
    ) {
        PassengerInfo passengerInfo = flightBookingRequest.getPassengerInfo();
        passengerInfo = passengerInfoRepository.save(passengerInfo);

        PaymentInfo paymentInfo = flightBookingRequest.getPaymentInfo();

        PaymentUtils.validateCreditLimit(
                paymentInfo.getAccountNo(),
                passengerInfo.getFare());

        paymentInfo.setPassengerId(passengerInfo.getId());
        paymentInfo.setAmount(passengerInfo.getFare());

        paymentInfoRepository.save(paymentInfo);
        return new FlightBookingAcknowledgement("SUCCESS",
                passengerInfo.getFare(),
                UUID.randomUUID().toString().split("-")[0],
                passengerInfo);
    }
}
