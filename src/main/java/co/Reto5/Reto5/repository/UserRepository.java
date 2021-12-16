package co.Reto5.Reto5.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import co.Reto5.Reto5.model.User;
import co.Reto5.Reto5.repository.crud.UserCrudRepository;

/**
 *
 * @author Leonel Prato
 */
@Repository
public class UserRepository {
    /**
     * Principal elemento de llamado
     */
    @Autowired
    private UserCrudRepository userCrudRepository;

    /**
     * Obtiene un Usuario por su ID
     * @param id
     * @return
     */
    public Optional<User> getUser(int id) {
        return userCrudRepository.findById(id);
    }

    /**
     * Genera Reporte de Usuarios
     * @return
     */
    public List<User> listAll() {
        return userCrudRepository.findAll();
    }

    /**
     * Responde a la existencia de un email
     * @param email
     * @return
     */
    public boolean emailExists(String email) {
        Optional<User> usuario = userCrudRepository.findByEmail(email);
        return !usuario.isEmpty();
    }

    /**
     * Autentica Usiario por email y password
     * @param email
     * @param password
     * @return
     */
    public Optional<User> autenticateUser(String email, String password) {
        return userCrudRepository.findByEmailAndPassword(email, password);
    }

    /**
     * Crea un nuevo Usuario
     * @param user
     * @return
     */
    public User create(User user) {
        return userCrudRepository.save(user);
    }
    
    /**
     * Actualiza Usuario por ID
     * @param user
     * @return
     */
    public User update(User user) {
        return userCrudRepository.save(user);
    }
    
    /**
     * Borra Usuario or ID
     * @param user
     */
    public void delete(User user) {
        userCrudRepository.delete(user);
    }
    
    /**
     * Consulta por ID de Usuario
     * @return
     */
    public Optional<User> lastUserId(){
        return userCrudRepository.findTopByOrderByIdDesc();
    }

    /**
     * Consulta usuario por mes y dia de nacimiento
     * @param monthBirthtDay
     * @return
     */
    public List<User> birthtDayList(String monthBirthtDay) {
        return userCrudRepository.findByMonthBirthtDay(monthBirthtDay);
    }
     
}