package core.repository;

import core.domain.Client;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IClientRepository extends IRepository<Client, Long>{

}
