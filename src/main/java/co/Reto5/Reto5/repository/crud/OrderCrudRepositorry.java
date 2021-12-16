package co.Reto5.Reto5.repository.crud;

import java.util.List;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import co.Reto5.Reto5.model.Order;

/**
 *
 * @author Leonel Prato
 */
public interface OrderCrudRepositorry extends MongoRepository<Order, Integer> {
   
        @Query("{'salesMan.zone': ?0}")
        List<Order> findByZone(final String zone);
        
        @Query("{status: ?0}")
        List<Order> findByStatus(final String status);

        Optional<Order> findTopByOrderByIdDesc();
    }