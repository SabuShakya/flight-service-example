package com.sabu.flightserviceexample.repository;

import com.sabu.flightserviceexample.entity.PaymentInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentInfoRepository extends JpaRepository<PaymentInfo, String> {
}
