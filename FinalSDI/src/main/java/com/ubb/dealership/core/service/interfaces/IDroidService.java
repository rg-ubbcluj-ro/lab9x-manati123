package com.ubb.dealership.core.service.interfaces;


import com.ubb.dealership.core.domain.Droid;
import com.ubb.dealership.core.domain.Purchase;

import java.util.List;

public interface IDroidService {

    void addDroid(double powerUsage, double price, int batteryTime, String model, boolean driver);

    void deleteDroid(Long id);

    List<Droid> getAllDroids();



    List<Droid> getDroidsByMinimumPowerUsage(int filter);

    List<Droid> getDroidsById(Long id);

    List<Droid> getDroidsByModel(String model);

    void updateDroid(Long id, double powerUsage, double price, int batteryTime, String model, boolean driver);

}
