package co.Reto5.Reto5.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import co.Reto5.Reto5.model.Fragance;
import co.Reto5.Reto5.repository.crud.FraganceCrudRepository;

/**
 *
 * @author Leonel Prato
 */
@Repository
public class FraganceRepository {
    @Autowired
    private FraganceCrudRepository fraganceCrudRepository;

    public List<Fragance> getAll() {
        return fraganceCrudRepository.findAll();
    }

    public Optional<Fragance> getFragance(String reference) {
        return fraganceCrudRepository.findById(reference);
    }
    public Fragance create(Fragance fragance) {
        return fraganceCrudRepository.save(fragance);
    }

    public void update(Fragance fragance) {
        fraganceCrudRepository.save(fragance);
    }
    
    public void delete(Fragance fragance) {
        fraganceCrudRepository.delete(fragance);
    }

    public List<Fragance> gadgetsByPrice(double precio) {
        return fraganceCrudRepository.findByPriceLessThanEqual(precio);
    }

    public List<Fragance> findByDescriptionLike(String description) {
        return fraganceCrudRepository.findByDescriptionLike(description);
    }
    
}
