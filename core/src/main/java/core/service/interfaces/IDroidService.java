package core.service.interfaces;

import core.domain.Droid;

import java.util.List;

public interface IDroidService {

    void addDroid(String name, String address, String phoneNumber);

    List<Droid> getDroidsFromRepository();

    List<Droid> getDroidsByModel(String model);

    void deleteDroid(Long id);

    void updateDroid(Long id, String name, String address, String phoneNumber);
}
