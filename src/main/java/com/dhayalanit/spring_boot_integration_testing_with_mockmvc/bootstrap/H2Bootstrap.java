package com.dhayalanit.spring_boot_integration_testing_with_mockmvc.bootstrap;

import com.dhayalanit.spring_boot_integration_testing_with_mockmvc.entity.Battery;
import com.dhayalanit.spring_boot_integration_testing_with_mockmvc.repository.BatteryRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * Bootstrap the in-memory H2 database with some Battery resources when
 * the application starts
 */
@Slf4j
@Configuration
public class H2Bootstrap {

    public static final List<Battery> mockBatteries = List.of(
            new Battery("Battery Loc 1", String.valueOf(1010), 20500),
            new Battery("Battery Loc 2", String.valueOf(1020), 20000),
            new Battery("Battery Loc 3", String.valueOf(1040), 30000),
            new Battery("Battery Loc 4", String.valueOf(1060), 30500)
    );

    @Bean
    CommandLineRunner intDb(BatteryRepository batteryRepository) {

        return args -> mockBatteries.forEach(
                battery -> log.info(String.format("Preloading %s", batteryRepository.save(battery)))
        );
    }


}
