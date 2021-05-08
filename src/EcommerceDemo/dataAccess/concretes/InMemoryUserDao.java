package EcommerceDemo.dataAccess.concretes;

import EcommerceDemo.dataAccess.abstracts.UserDao;
import EcommerceDemo.entities.concretes.User;

import java.util.ArrayList;
import java.util.List;

public class InMemoryUserDao implements UserDao {
    private List<User> users;

    public InMemoryUserDao() {
        users = new ArrayList<>();
        this.users.add(new User(1, "Cem", "Özaydın", "cemozaydin@mail.com", "123456","1234",true));
        this.users.add(new User(2, "Engin", "Demiroğ", "engindemirog@mail.com", "134456","1234",true));
        this.users.add(new User(3, "Sedef", "Demircan", "sedefdemircan@mail.com", "134456","1234",true));
        this.users.add(new User(4, "Nifüler", "Akıncı", "nilüferakinci@mail.com", "134456","1234",true));
        this.users.add(new User(5, "Yasin", "Kaçar", "yasinkacar@mail.com", "134456","1234",true));
        this.users.add(new User(6, "Meltem", "Koşar", "meltemkosar@mail.com", "134456","1234",true));
        this.users.add(new User(7, "Cihan", "Yazar", "cihanyazar@mail.com", "134456","1234",true));
    }


    @Override
    public void register(User user) {
        this.users.add(user);
    }

    @Override
    public boolean login(User user) {
        return this.users.stream().anyMatch(u->u.getEmail()==user.getEmail() && u.getPassword()==user.getPassword());
    }

    @Override
    public User get(int id) {
        return this.users.stream().filter(u -> u.getId()==id).findFirst().orElse(null);
    }

    @Override
    public List<User> getAll() {
        return this.users.stream().toList();
    }

}
