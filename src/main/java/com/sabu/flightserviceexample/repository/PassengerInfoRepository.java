package com.sabu.flightserviceexample.repository;

import com.sabu.flightserviceexample.entity.PassengerInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassengerInfoRepository extends JpaRepository<PassengerInfo,Long>{
}
