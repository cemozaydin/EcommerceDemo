package EcommerceDemo.googleAuth.abstracts;

import EcommerceDemo.entities.concretes.User;

public interface GoogleAuthService {
    void register(User user);
    void login(User user);
}
