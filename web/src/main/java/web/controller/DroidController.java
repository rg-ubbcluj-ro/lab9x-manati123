package web.controller;


import core.exceptions.NotFoundException;
import core.service.interfaces.IDroidService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import web.converter.DroidConverter;

import web.dto.CollectionDto;
import web.dto.DroidDto;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class DroidController {
    public static final Logger logger = LoggerFactory.getLogger(DroidController.class);

    @Autowired
    private IDroidService droidService;

    @Autowired
    private DroidConverter droidConverter;

    @RequestMapping(value = "/droids", method = RequestMethod.GET)
    CollectionDto<Long, DroidDto> getAllDroids() {
        logger.info("Requesting droids..");
        return new CollectionDto<>(droidService.getAllDroids()
                .stream()
                .map((droid -> droidConverter.toDto(droid)))
                .collect(Collectors.toList()));
    }

    @RequestMapping(value = "/droid", method = RequestMethod.POST)
    ResponseEntity<?> addDroid(@RequestBody DroidDto droidDto) {
        logger.info("Adding droid.");
        logger.trace("Adding droid.");
        droidService.addDroid(
                droidDto.getPowerUsage(),
                droidDto.getPrice(),
                droidDto.getBatteryTime(),
                droidDto.getModel(),
                droidDto.isDriver());
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @RequestMapping(value = "/droid/{id}", method = RequestMethod.PUT)
    ResponseEntity<?> updateDroid(@PathVariable Long id, @RequestBody DroidDto dto) {
        try {
            droidService.updateDroid(id,
                    dto.getPowerUsage(),
                    dto.getPrice(),
                    dto.getBatteryTime(),
                    dto.getModel(),
                    dto.isDriver());
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/droid/{id}", method = RequestMethod.DELETE)
    ResponseEntity<?> deleteDroid(@PathVariable Long id) {
        try {
            droidService.deleteDroid(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/droids/{power}", method = RequestMethod.GET)
    CollectionDto<Long, DroidDto> getDroidsByMinimumPowerUsage(@PathVariable int power) {
        return new CollectionDto<>(droidService.getDroidsByMinimumPowerUsage(power)
                .stream()
                .map((droid) -> droidConverter.toDto(droid))
                .collect(Collectors.toList()));
    }

    @RequestMapping(value = "/droids/{id}", method = RequestMethod.GET)
    CollectionDto<Long, DroidDto> getDroidsById(@PathVariable Long id) {
        return new CollectionDto<>(droidService.getDroidsById(id)
                .stream()
                .map((droid) -> droidConverter.toDto(droid))
                .collect(Collectors.toList()));
    }

    @RequestMapping(value = "/droids/{model}", method = RequestMethod.GET)
    CollectionDto<Long, DroidDto> getDroidsByModel(@PathVariable String model) {
        return new CollectionDto<>(droidService.getDroidsByModel(model)
                .stream()
                .map((droid) -> droidConverter.toDto(droid))
                .collect(Collectors.toList()));
    }
}
