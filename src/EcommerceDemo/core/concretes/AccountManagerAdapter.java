package EcommerceDemo.core.concretes;

import EcommerceDemo.core.abstracts.BaseAccountService;
import EcommerceDemo.entities.concretes.User;

public class AccountManagerAdapter implements BaseAccountService {

    @Override
    public void register(User user) {
        this.register(user);
    }

    @Override
    public void login(User user) {
        this.register(user);
    }
}
