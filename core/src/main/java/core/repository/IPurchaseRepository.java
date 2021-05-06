package core.repository;

import core.domain.ClientDroidPrimaryKey;
import core.domain.Purchase;

import java.util.List;

public interface IPurchaseRepository extends IRepository<Purchase, ClientDroidPrimaryKey> {
    List<Purchase> findAllByDroid_Model(String model);
    List<Purchase> findAllByTotalPriceGreaterThanEqual(double totalPrice);
}
