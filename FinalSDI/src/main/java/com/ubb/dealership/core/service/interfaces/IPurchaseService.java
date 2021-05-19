package com.ubb.dealership.core.service.interfaces;



import com.ubb.dealership.core.domain.Client;
import com.ubb.dealership.core.domain.Purchase;


import java.util.List;
import java.util.Set;

public interface IPurchaseService {
    /**
     *
     * @param clientId
     * @param droidId
     * @param totalPrice
     */
    void addPurchase(Long clientId, Long droidId, double totalPrice);


    /**
     *
     * @param clientId
     * @param droidId
     */
    void deletePurchase(Long clientId, Long droidId);

    /**
     *
     * @return
     */
    List<Purchase> getAllPurchases();

    Set<Client> filterClientsThatBoughtModelOfDroid(String model);

    List<Purchase> findAllByTotalPriceGreaterThanEqual(double totalPrice);
}
