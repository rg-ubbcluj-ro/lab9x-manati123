package core.repository;

import core.domain.Droid;

import java.util.List;

public interface IDroidRepository extends IRepository<Droid, Long> {
    List<Droid> findDroidsByModelLike(String model);
}
