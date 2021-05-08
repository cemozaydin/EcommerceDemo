package EcommerceDemo.dataAccess.abstracts;

import EcommerceDemo.entities.concretes.User;

import java.util.List;

public interface UserDao {
    void register(User user);
    boolean login(User user);
    User get(int id);
    List<User> getAll();


}
