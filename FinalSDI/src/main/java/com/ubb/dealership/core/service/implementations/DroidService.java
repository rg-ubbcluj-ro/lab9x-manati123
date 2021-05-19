package com.ubb.dealership.core.service.implementations;


import com.ubb.dealership.core.domain.Droid;
import com.ubb.dealership.core.domain.Purchase;
import com.ubb.dealership.core.exceptions.DealershipException;
import com.ubb.dealership.core.exceptions.NotFoundException;
import com.ubb.dealership.core.repository.IDroidRepository;
import com.ubb.dealership.core.service.interfaces.IDroidService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
@AllArgsConstructor
@Service
public class DroidService implements IDroidService {
    public static final Logger logger = LoggerFactory.getLogger(DroidService.class);



    private final IDroidRepository repository;


    @Override
    public void addDroid(double powerUsage, double price, int batteryTime, String model, boolean driver) {
        logger.trace("Began adding droid" + Runtime.getRuntime());
        long id = 0;
        for (Droid d : this.repository.findAll())
            id = Math.max(id, d.getId() + 1);
        var newDroid = new Droid(id, powerUsage, price, batteryTime, model, driver);
        repository.save(newDroid);
        logger.trace("Droid was added" + Runtime.getRuntime());
    }

    @Override
    public void deleteDroid(Long id) {
        logger.trace("Began deleting droid" +   Runtime.getRuntime());
        repository.findById(id)
                .ifPresentOrElse((droid) -> repository.deleteById(droid.getId()),
                        () -> {
                            throw new NotFoundException("Droid does not exist!");
                        });
        logger.trace("Droid was removed" + Runtime.getRuntime());
    }

    @Override
    public List<Droid> getAllDroids() {
        logger.trace("finding droids" + Runtime.getRuntime());
        return repository.findAll();
    }

    @Override
    public List<Droid> getDroidsByMinimumPowerUsage(int filter) {
        logger.trace("Filtering by min power usage" + Runtime.getRuntime());
        return repository.findAll()
                .stream()
                .filter(d -> d.getPowerUsage() > filter)
                .collect(Collectors.toList());
    }

    @Override
    public List<Droid> getDroidsById(Long id) {
        logger.trace("Not a really useful filter...." + Runtime.getRuntime());
        return repository.findAll()
                .stream()
                .filter(s -> Objects.equals(s.getId(), id))
                .collect(Collectors.toList());
    }



    @Override
    public List<Droid> getDroidsByModel(String model) {
        logger.trace("Filtering droids by model" + Runtime.getRuntime());
        return repository.findDroidsByModelLike(model);
    }

    @Override
    @Transactional
    public void updateDroid(Long id, double powerUsage, double price, int batteryTime, String model, boolean driver) {
        logger.trace("Began updating droid with id: " + id + " " + Runtime.getRuntime());
        repository.findById(id)
                .ifPresentOrElse((droid) -> {
                            droid.setPowerUsage(powerUsage);
                            droid.setPrice(price);
                            droid.setBatteryTime(batteryTime);
                            droid.setModel(model);
                            droid.setDriver(driver);
                        },
                        () -> {
                            throw new NotFoundException("Droid does not exist");
                        }
                );
        logger.trace("Finished updating the droid" + Runtime.getRuntime());
    }
}
