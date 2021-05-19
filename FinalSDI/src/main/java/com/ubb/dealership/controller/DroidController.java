package com.ubb.dealership.controller;



import com.ubb.dealership.converter.DroidConverter;
import com.ubb.dealership.core.domain.Droid;
import com.ubb.dealership.core.exceptions.NotFoundException;
import com.ubb.dealership.core.service.interfaces.IDroidService;
import com.ubb.dealership.dto.CollectionDto;
import com.ubb.dealership.dto.DroidDto;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.Comparator;
import java.util.stream.Collectors;


@CrossOrigin(origins = "http://localhost:8081")
@AllArgsConstructor
@RestController
public class DroidController {
    public static final Logger logger = LoggerFactory.getLogger(DroidController.class);


    private final IDroidService droidService;

    private final DroidConverter droidConverter;



    @CrossOrigin
    @RequestMapping(value = "/droid", method = RequestMethod.GET)
    CollectionDto<Long, DroidDto> getAllDroids() {
        logger.trace("Requesting droids..");
        return new CollectionDto<>(droidService.getAllDroids()
                .stream()
                .map((droidConverter::toDto))
                .collect(Collectors.toList()));
    }

    @RequestMapping(value = "/droids", method = RequestMethod.POST)
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

    @CrossOrigin
    @RequestMapping(value = "/droids/{id}", method = RequestMethod.PUT)
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

    @CrossOrigin
    @RequestMapping(value = "/droids/{id}", method = RequestMethod.DELETE)
    ResponseEntity<?> deleteDroid(@PathVariable Long id) {
        try {
            droidService.deleteDroid(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }



//    @CrossOrigin
//    @RequestMapping(value = "/droids/{power}", method = RequestMethod.GET)
//    CollectionDto<Long, DroidDto> getDroidsByMinimumPowerUsage(@PathVariable int power) {
//        return new CollectionDto<>(droidService.getDroidsByMinimumPowerUsage(power)
//                .stream()
//                .map(droidConverter::toDto)
//                .collect(Collectors.toList()));
//    }



    @CrossOrigin
    @RequestMapping(value = "/droids/{id}", method = RequestMethod.GET)
    CollectionDto<Long, DroidDto> getDroidsById(@PathVariable Long id) {
        return new CollectionDto<>(droidService.getDroidsById(id)
                .stream()
                .map(droidConverter::toDto)
                .collect(Collectors.toList()));
    }



    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    ResponseEntity<String> getDroidsByMinimumPowerUsage() {
        return new ResponseEntity<String>("Hello",new HttpHeaders(),HttpStatus.OK);
    }


    @RequestMapping(value = "/droid/{model}", method = RequestMethod.GET)
    CollectionDto<Long, DroidDto> getDroidsByModel(@PathVariable String model) {
        return new CollectionDto<>(droidService.getDroidsByModel(model)
                .stream()
                .map(droidConverter::toDto)
                .collect(Collectors.toList()));
    }


}
