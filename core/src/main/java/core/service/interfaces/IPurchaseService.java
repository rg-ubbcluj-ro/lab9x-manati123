package core.service.interfaces;

import core.domain.Client;
import core.domain.Purchase;

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
     * @param id
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
