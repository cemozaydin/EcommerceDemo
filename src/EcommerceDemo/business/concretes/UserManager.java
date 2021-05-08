package EcommerceDemo.business.concretes;

import EcommerceDemo.business.abstracts.UserService;
import EcommerceDemo.business.validationRules.UserValidation;
import EcommerceDemo.core.abstracts.BaseAccountService;
import EcommerceDemo.dataAccess.abstracts.UserDao;
import EcommerceDemo.entities.concretes.User;

import java.util.List;
import java.util.Scanner;

public class UserManager implements UserService {
    private UserDao userDao;
    private BaseAccountService baseAccountService;

    public UserManager(UserDao userDao, BaseAccountService baseAccountService) {
        this.userDao = userDao;
        this.baseAccountService = baseAccountService;

    }

    @Override
    public void register(User user) {

        if(this.checkMail(user)){
            System.out.println("Kullanıcı sistemde mevcut.");
        }
        else if(!UserValidation.validators(user)){
            System.out.println("Kullanıcı kayıt edilemedi.");
        }
        else
        {
            System.out.println("Doğrulama kodunuz mail ile gönderildi : " + user.getVerificationCode());
            System.out.print("Kaydın tamamlanabilmesi için doğrulama kodunu giriniz : ");
            Scanner scn = new Scanner(System.in);
            String inputVerificationCode = scn.nextLine();

            if(user.getVerificationCode().equals(inputVerificationCode)){
                user.setStatus(true);
                this.userDao.register(user);
                //this.baseAccountService.register(user);
                System.out.println("Kullancı Kayıt oldu. " + user.getFirstName() + " " + user.getLastName() + " - verifyCode: " + user.getVerificationCode());
            }
            else
            {
                System.out.println("Doğrulama kodu hatalı. Kullanıcı kaydı geçersiz.");
            }
        }
    }

    @Override
    public void login(User user) {
        boolean result = this.userDao.login(user);
        if(result){
            System.out.println("Giriş Başarılı. Kullanıcı Login oldu. " + user.getEmail());
        }
        else
        {
            System.out.println("Giriş Başarısız. Bilgilerinizi kontrol ediniz...");
        }
    }

    @Override
    public User get(int id) {
        if(userDao.get(id)==null){
            System.out.println("Kayıt bulunamadı");
        }
        return userDao.get(id);
    }

    @Override
    public List<User> getAll() {
        return userDao.getAll();
    }

    @Override
    public boolean checkMail(User user) {
        List<User> users = userDao.getAll();
        for(User userMail:users){
            if(userMail.getEmail().equals(user.getEmail())){
                return true;
            }
        }
        return false;
    }
}
