package core.repository;

import core.domain.Receipt;
import org.springframework.stereotype.Repository;

@Repository
public interface IReceiptRepository extends IRepository<Receipt, Long>{
}