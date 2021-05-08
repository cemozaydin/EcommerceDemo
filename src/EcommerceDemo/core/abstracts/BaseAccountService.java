package EcommerceDemo.core.abstracts;

import EcommerceDemo.entities.concretes.User;

public interface BaseAccountService {
    void register(User user);
    void login (User user);
}
