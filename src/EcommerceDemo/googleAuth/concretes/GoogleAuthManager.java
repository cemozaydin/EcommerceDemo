package EcommerceDemo.googleAuth.concretes;

import EcommerceDemo.entities.concretes.User;
import EcommerceDemo.googleAuth.abstracts.GoogleAuthService;

public class GoogleAuthManager implements GoogleAuthService {
    @Override
    public void register(User user) {
        System.out.println("Google hesabınızı kullanarak kayıt oldunuz. " + user.getEmail());
    }

    @Override
    public void login(User user) {
        System.out.println("Google hesabınızı kullanarak login oldunuz. " + user.getEmail());
    }

}
