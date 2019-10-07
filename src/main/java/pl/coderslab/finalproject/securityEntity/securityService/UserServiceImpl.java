package pl.coderslab.finalproject.securityEntity.securityService;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import pl.coderslab.finalproject.exceptions.ObjectError;
import pl.coderslab.finalproject.exceptions.ValidationException;
import pl.coderslab.finalproject.securityEntity.Role;
import pl.coderslab.finalproject.securityEntity.User;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final Validator validator;
//
    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository, BCryptPasswordEncoder bCryptPasswordEncoder, Validator validator) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.validator = validator;
//
    }

    @Override
    public User findByUserName(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public void saveUser(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setEnabled(1);
        Role userRole = roleRepository.findByName("ROLE_USER");
        user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
        userRepository.save(user);
    }

    @Override
    public void savePhysiotherapist(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setEnabled(1);
        Role userRole = roleRepository.findByName("ROLE_PHYSIOTHERAPIST");
        user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
        userRepository.save(user);
    }

    @Override
    public User authorization(UserData userData) throws ValidationException{
        Set<ConstraintViolation<UserData>> errors = validator.validate(userData);
        ValidationException ex = new ValidationException();

        if(!errors.isEmpty()){
            for(ConstraintViolation<UserData> err : errors){
                ex.addError( new ObjectError(err.getPropertyPath().toString(), err.getMessage()));
            }
            throw ex;
        }

        User user = new User();
        User existing = findByUserName(userData.getUsername());
        if (existing != null) {
            ex.addError( new ObjectError("username","There is already an account registered with that email"));
//            result.rejectValue("username", null, "There is already an account registered with that email");
        }
        if (!userData.getPassword().equals(userData.getPassword2())) {
            ex.addError( new ObjectError("password","Passwords are incorrect"));

//            result.rejectValue("password", null, "Password2 are incorrect");
        }

        if (ex.hasErrors()) {
            throw ex;
//            return user;
        }
        user.setUsername(userData.getUsername());
        user.setPassword(userData.getPassword());
        //todo :: save
        userRepository.save(user);

        return user;
    }

//    @Override
//    public void register(UserData userData, BindingResult result) {
//        try {
//            User user = authorization(userData);
//            saveUser(user);
//            clientService.createAccount(userData.getName(),userData.getSurname(),userData.getUsername(),user);
//        } catch (ValidationException e) {
//
//            List<ObjectError> errors = e.getErrors();
//            for (ObjectError err : errors) {
//                if (result.getFieldError(err.getFieldName()) == null) {
//                    result.rejectValue(err.getFieldName(), null, err.getMessage());
//                }
//            }
//
//        }
//    }
}
