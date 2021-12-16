package co.Reto5.Reto5.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.Reto5.Reto5.model.User;
import co.Reto5.Reto5.repository.UserRepository;

/**
 *
 * @author Leonel Prato
 */
@Service
public class UserService {
    
    /**
     * get principal funtion
     */
    @Autowired
    private UserRepository repositorio;
    /**
     * 
     */
    public Optional<User> getUser(int id) {
        return repositorio.getUser(id);
    }

    /**
     * 
     * @return
     */
    public List<User> listAll() {
        return repositorio.listAll();
    }

    /**
     * 
     * @param email
     * @return
     */
    public boolean emailExists(String email) {
        return repositorio.emailExists(email);
    }

    /**
     * 
     * @param email
     * @param password
     * @return
     */
    public User autenticateUser(String email, String password) {
        Optional<User> usuario = repositorio.autenticateUser(email, password);

        if (usuario.isEmpty()) {
            return new User();
        } else {
            return usuario.get();
        }
    }

    /**
     * 
     * @param user
     * @return
     */
    public User create(User user) {
        
        Optional<User> userIdMaximo;
        
        if (user.getId() == null) {
            
            userIdMaximo = repositorio.lastUserId();
            
            if (userIdMaximo.isEmpty())
                user.setId(1);
            else
                user.setId(userIdMaximo.get().getId() + 1);
        }
    
        Optional<User> e = repositorio.getUser(user.getId());
        if (e.isEmpty()) {
            if (emailExists(user.getEmail())==false){
                return repositorio.create(user);
            }else{
                return user;
            }
        }else{
            return user;
        }
    }

    /**
     * 
     * @param user
     * @return
     */
    public User update(User user) {

        if (user.getId() != null) {
            Optional<User> userDb = repositorio.getUser(user.getId());
            if (!userDb.isEmpty()) {
                if (user.getIdentification() != null) {
                    userDb.get().setIdentification(user.getIdentification());
                }
                if (user.getName() != null) {
                    userDb.get().setName(user.getName());
                }
                if (user.getAddress() != null) {
                    userDb.get().setAddress(user.getAddress());
                }
                if (user.getCellPhone() != null) {
                    userDb.get().setCellPhone(user.getCellPhone());
                }
                if (user.getEmail() != null) {
                    userDb.get().setEmail(user.getEmail());
                }
                if (user.getPassword() != null) {
                    userDb.get().setPassword(user.getPassword());
                }
                if (user.getZone() != null) {
                    userDb.get().setZone(user.getZone());
                }

                repositorio.update(userDb.get());
                return userDb.get();
            } else {
                return user;
            }
        } else {
            return user;
        }
    }

    /**
     * 
     * @param userId
     * @return
     */
    public boolean delete(int userId) {
        Optional<User> usuario = getUser(userId);

        if (usuario.isEmpty()){
            return false;
        }else{
            repositorio.delete(usuario.get());
            return true;
        }
        /*
        Boolean aBoolean = getUser(userId).map(user -> {
            repositorio.delete(user);
            return true;
        }).orElse(false);
        return aBoolean;

        */
    }
    
    /**
     * 
     * @param monthBirthtDay
     * @return
     */
    public List<User> birthtDayList(String monthBirthtDay) {
        return repositorio.birthtDayList(monthBirthtDay);
    }
}