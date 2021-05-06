package core.service.implementations;

import core.domain.Client;
import core.domain.ClientDroidPrimaryKey;
import core.domain.Droid;
import core.domain.Purchase;
import core.exceptions.DealershipException;
import core.exceptions.NotFoundException;
import core.repository.IClientRepository;
import core.repository.IDroidRepository;
import core.repository.IPurchaseRepository;
import core.service.interfaces.IPurchaseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;


@Service
public class PurchaseService implements IPurchaseService {
    public static final Logger logger = LoggerFactory.getLogger(PurchaseService.class);

    @Autowired
    private IPurchaseRepository purchaseRepository;

    @Autowired
    private IDroidRepository droidRepo;

    @Autowired
    private IClientRepository clientRepository;





    @Override
    public void addPurchase(Long clientId, Long droidId, double totalPrice) {
        logger.trace("addPurchase - method started");
        Optional<Droid> droid = droidRepo.findById(droidId);
        droid.ifPresentOrElse((Droid d) ->{
            Optional<Client> client = clientRepository.findById(clientId);
            client.ifPresentOrElse((Client c) -> {
                Purchase purchase = new Purchase(
                        new ClientDroidPrimaryKey(c.getId(),d.getId()),c,d,totalPrice);
                purchaseRepository.save(purchase);
            }, () -> {
                throw new NotFoundException("Client does not exist!");
            });
        }, () -> {
            throw new NotFoundException("Droid does not exist!");
        });
        logger.trace("addPurchase - method finished");
    }

    @Override
    public void deletePurchase(Long clientId, Long droidId) {
        logger.trace("deletePurchase - method started");
        this.purchaseRepository.findById(new ClientDroidPrimaryKey(clientId,droidId))
                .ifPresentOrElse(
                        purchase -> {purchaseRepository.deleteById(purchase.getId());},
                        () -> {throw new DealershipException("Purchase does not exist!");}
                );
        logger.trace("deletePurchse - method finished");
    }

    @Override
    public List<Purchase> getAllPurchases() {
        logger.trace("getAllPurchases - method started");
        return this.purchaseRepository.findAll();
    }

    @Override
    public Set<Client> filterClientsThatBoughtModelOfDroid(String model) {
        logger.trace("filterClientsThatBoughtModelOfDroid - method started");
        return purchaseRepository.findAllByDroid_Model(model).stream()
                .map(Purchase::getClient)
                .collect(Collectors.toSet());

    }

    @Override
    public List<Purchase> findAllByTotalPriceGreaterThanEqual(double totalPrice) {
        logger.trace("findAllByTotalPriceGreaterThanEqual - method started");
        return purchaseRepository.findAllByTotalPriceGreaterThanEqual(totalPrice);
    }
}
