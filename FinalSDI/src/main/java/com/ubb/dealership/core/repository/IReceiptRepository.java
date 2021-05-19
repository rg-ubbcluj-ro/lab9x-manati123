package com.ubb.dealership.core.repository;

import com.ubb.dealership.core.domain.Receipt;
import org.springframework.stereotype.Repository;

@Repository
public interface IReceiptRepository extends IRepository<Receipt, Long>{
}