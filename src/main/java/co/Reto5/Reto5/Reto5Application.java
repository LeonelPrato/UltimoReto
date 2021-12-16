package co.Reto5.Reto5;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import co.Reto5.Reto5.repository.crud.FraganceCrudRepository;
import co.Reto5.Reto5.repository.crud.OrderCrudRepositorry;
import co.Reto5.Reto5.repository.crud.UserCrudRepository;

/**
 *
 * @author Leonel Prato
 */
@SpringBootApplication
public class Reto5Application implements CommandLineRunner {

	@Autowired
    private UserCrudRepository userCrudRepository;

    @Autowired
    private FraganceCrudRepository fraganceCrudRepository;
    
    @Autowired
    private OrderCrudRepositorry orderCrudRepository;


	public static void main(String[] args) {
		SpringApplication.run(Reto5Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		userCrudRepository.deleteAll();
        fraganceCrudRepository.deleteAll();
        orderCrudRepository.deleteAll();
		
	}

}