package com.ubb.dealership.core.service.implementations;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.math.BigInteger;
import java.util.*;

import com.ubb.dealership.core.domain.*;
import com.ubb.dealership.core.domain.ClientDroidPrimaryKey;
import com.ubb.dealership.core.domain.Droid;
import com.ubb.dealership.core.domain.Purchase;
import com.ubb.dealership.core.exceptions.DealershipException;
import com.ubb.dealership.core.exceptions.NotFoundException;
import com.ubb.dealership.core.repository.IClientRepository;
import com.ubb.dealership.core.repository.IDroidRepository;
import com.ubb.dealership.core.repository.IPurchaseRepository;
import com.ubb.dealership.core.service.interfaces.IPurchaseService;
import java.util.*;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class PurchaseService implements IPurchaseService {
    public static final Logger logger = LoggerFactory.getLogger(PurchaseService.class);


    private final IPurchaseRepository purchaseRepository;


    private final IDroidRepository droidRepo;


    private final IClientRepository clientRepository;





    @Override
    public void addPurchase(Long clientId, Long droidId, double totalPrice) {
        logger.trace("addPurchase - method started");
//        Optional<Droid> droid = droidRepo.findById(droidId);
//        droid.ifPresentOrElse((Droid d) ->{
//            Optional<Client> client = clientRepository.findById(clientId);
//            client.ifPresentOrElse((Client c) -> {
//                Purchase purchase = new Purchase(
//                        new ClientDroidPrimaryKey(c.getId(),d.getId()),c,d,totalPrice);
//                purchaseRepository.save(purchase);
//            }, () -> {
//                throw new NotFoundException("Client does not exist!");
//            });
//        }, () -> {
//            throw new NotFoundException("Droid does not exist!");
//        });
        Optional<Droid> droid = this.droidRepo.findById(droidId);
        Optional<Client> client = this.clientRepository.findById(clientId);
        if(droid.isPresent() && client.isPresent())
        {
            droid.get().addPurchase(client.get(),totalPrice);
            client.get().addPurchase(droid.get(), totalPrice);
        }
        else
            throw new DealershipException("Invalid purchase!");
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
