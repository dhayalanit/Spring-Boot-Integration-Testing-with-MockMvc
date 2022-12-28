package com.dhayalanit.spring_boot_integration_testing_with_mockmvc.repository;

import com.dhayalanit.spring_boot_integration_testing_with_mockmvc.entity.Battery;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BatteryRepository extends JpaRepository<Battery, Integer> {
}
