package com.ubb.dealership.core.repository;



import com.ubb.dealership.core.domain.Droid;
import com.ubb.dealership.core.domain.Purchase;

import java.util.List;

public interface IDroidRepository extends IRepository<Droid, Long> {
    List<Droid> findDroidsByModelLike(String model);


}
