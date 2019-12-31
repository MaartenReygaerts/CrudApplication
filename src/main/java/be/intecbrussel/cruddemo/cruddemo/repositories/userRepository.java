package be.intecbrussel.cruddemo.cruddemo.repositories;

import be.intecbrussel.cruddemo.cruddemo.entities.User;
import org.springframework.data.repository.CrudRepository;

public interface userRepository extends CrudRepository<User, Long>{

}
