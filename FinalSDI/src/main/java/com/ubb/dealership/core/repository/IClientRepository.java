package com.ubb.dealership.core.repository;


import com.ubb.dealership.core.domain.Client;
import com.ubb.dealership.core.domain.Purchase;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;
import java.util.List;

public interface IClientRepository extends IRepository<Client, Long>{
    @Query(value = "select c.* as name, sum(p.total_price) as totalCash from client c " +
            "inner join purchase p " +
            "on c.id = p.clientId " +
            "group by c.id " +
            "order by sum(p.total_price) desc", nativeQuery = true)
    List<Object[]> getCustomersSortedSpentCashInterface();

}
