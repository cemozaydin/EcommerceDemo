package EcommerceDemo.business.abstracts;

import EcommerceDemo.entities.concretes.User;
import EcommerceDemo.utils.VerificationCodeGenerator;

import java.util.List;

public interface UserService {
    void register(User user);
    void login(User user);
    User get(int id);
    List<User> getAll();
    boolean checkMail(User user);

}
