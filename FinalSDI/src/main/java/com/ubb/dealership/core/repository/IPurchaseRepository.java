package com.ubb.dealership.core.repository;



import com.ubb.dealership.core.domain.ClientDroidPrimaryKey;
import com.ubb.dealership.core.domain.Purchase;

import java.util.List;

public interface IPurchaseRepository extends IRepository<Purchase, ClientDroidPrimaryKey> {
    List<Purchase> findAllByDroid_Model(String model);
    List<Purchase> findAllByTotalPriceGreaterThanEqual(double totalPrice);
}
