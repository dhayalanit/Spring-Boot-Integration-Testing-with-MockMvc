package com.dhayalanit.spring_boot_integration_testing_with_mockmvc.controller;

import com.dhayalanit.spring_boot_integration_testing_with_mockmvc.entity.Battery;
import com.dhayalanit.spring_boot_integration_testing_with_mockmvc.repository.BatteryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping
public class BatteryController {

    @Autowired
    private BatteryRepository batteryRepository;

    @GetMapping("batteries")
    public List<Battery> getAllBatteries() {
        return batteryRepository.findAll();
    }

    @PostMapping("createbatteries")
    @ResponseStatus(HttpStatus.CREATED)
    public Battery crate(@RequestBody Battery battery) {
        return batteryRepository.save(battery);
    }

    @GetMapping("batteries/{id}")
    public Battery getBatteryId(@PathVariable int id) {

        Optional<Battery> battery = batteryRepository.findById(id);
        battery.orElseThrow(
                () -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, String.format("Battery ID %s not found",id)
                )
        );
        return battery.get();
    }

}
