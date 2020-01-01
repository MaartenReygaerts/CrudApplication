package be.intecbrussel.cruddemo.cruddemo.repositories;

import be.intecbrussel.cruddemo.cruddemo.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;


public interface userRepository extends CrudRepository<User, Long>{

}
