package core.service.implementations;

import core.domain.Receipt;
import core.repository.IReceiptRepository;
import core.service.interfaces.IReceiptService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.lang.Math.max;

@Service
public class ReceiptService implements IReceiptService {
    public static final Logger logger = LoggerFactory.getLogger(ReceiptService.class);

    @Autowired
    private IReceiptRepository repository;

    @Override
    public void addReceipt(Long purchaseId, double totalPrice) {
        logger.trace("addReceipt - method started");
        var newReceipt = new Receipt(purchaseId, totalPrice);
        long id = 0;
        for(Receipt d : this.repository.findAll())
            id = max(id, d.getId() + 1);
        newReceipt.setId(id);
        var result = repository.save(newReceipt);
        logger.trace("addReceipt - method done");
    }

    @Override
    public List<Receipt> getAllReceipts() {
        return this.repository.findAll();
    }
}
