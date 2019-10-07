package pl.coderslab.finalproject.securityEntity.securityService;

import org.springframework.validation.BindingResult;
import pl.coderslab.finalproject.exceptions.ValidationException;
import pl.coderslab.finalproject.securityEntity.User;


public interface UserService {

    User findByUserName(String username);

    void saveUser(User user);

    void savePhysiotherapist(User user);

//    void register(UserData userData, BindingResult result);

    User authorization(UserData userData) throws ValidationException;

}

