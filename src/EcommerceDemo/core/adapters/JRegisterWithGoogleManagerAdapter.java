package EcommerceDemo.core.adapters;

import EcommerceDemo.core.abstracts.BaseAccountService;
import EcommerceDemo.entities.concretes.User;
import EcommerceDemo.googleAuth.abstracts.GoogleAuthService;
import EcommerceDemo.googleAuth.concretes.GoogleAuthManager;

public class JRegisterWithGoogleManagerAdapter implements BaseAccountService {
    GoogleAuthService googleAuthService = new GoogleAuthManager();
    @Override
    public void register(User user) {
        this.googleAuthService.register(user);
    }

    @Override
    public void login(User user) {
        this.googleAuthService.login(user);
    }
}
