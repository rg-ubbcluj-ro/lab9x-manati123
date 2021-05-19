package com.ubb.dealership.converter;


import com.ubb.dealership.core.domain.Droid;
import com.ubb.dealership.dto.DroidDto;
import org.springframework.stereotype.Component;

@Component
public class DroidConverter implements Converter<Long, Droid, DroidDto> {


    @Override
    public DroidDto toDto(Droid model) {
        var droid = new DroidDto();
        droid.setModel(model.getModel());
        droid.setBatteryTime(model.getBatteryTime());
        droid.setDriver(model.getDriver());
        droid.setPrice(model.getPrice());
        droid.setPowerUsage(model.getPowerUsage());
        droid.setId(model.getId());
        return droid;
    }



}