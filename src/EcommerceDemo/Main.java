package EcommerceDemo;

import EcommerceDemo.business.abstracts.UserService;
import EcommerceDemo.business.concretes.UserManager;
import EcommerceDemo.core.adapters.JRegisterWithGoogleManagerAdapter;
import EcommerceDemo.core.concretes.AccountManagerAdapter;
import EcommerceDemo.dataAccess.abstracts.UserDao;
import EcommerceDemo.dataAccess.concretes.InMemoryUserDao;
import EcommerceDemo.entities.concretes.User;
import EcommerceDemo.googleAuth.concretes.GoogleAuthManager;
import EcommerceDemo.utils.VerificationCodeGenerator;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        boolean _loop = true;

        //UserService userManager = new UserManager(new InMemoryUserDao(), new AccountManagerAdapter());
        UserService userManager = new UserManager(new InMemoryUserDao(), new JRegisterWithGoogleManagerAdapter());

       // ---------------- MENU ---------------------
        do
        {
            System.out.println();
            System.out.println("__________ eCommerce Demo __________");
            System.out.println();
            System.out.println("1.  Yeni Kullanıcı Kayıt");
            System.out.println("2.  Kullanıcı Listeleme - Tümü");
            System.out.println("3.  Kullanıcı Listeleme - ID'ye Göre");
            System.out.println("4.  Kullanıcı Login");
            System.out.println();
            System.out.println("5. ÇIKIŞ");
            System.out.println();
            System.out.print("Seçiminiz <1-5> : ");
            int secim = Integer.parseInt(scn.nextLine());
            System.out.println();


            switch (secim) {
                case 1:
                    System.out.println("----- Yeni Kayıt -----");
                    String verificationCodeGenerator = VerificationCodeGenerator.verificationCode();
                    userManager.register(new User(10,"atilla","yeşil","atillayesil@mail.com","552322",verificationCodeGenerator,false));

                    System.out.print("\nMenüye dönmek için ENTER tuşuna basınız.");
                    scn.nextLine();
                    break;
                case 2:
                    System.out.println("----Tüm Liste------");
                    var result = userManager.getAll();
                    for (User user:result) {
                        System.out.println(user.getId() + " - " + user.getFirstName() + " " + user.getLastName() + " - " + user.getEmail() + " - " + user.isStatus());
                    }

                    System.out.print("\nMenüye dönmek için ENTER tuşuna basınız.");
                    scn.nextLine();
                    break;
                case 3:
                    System.out.println("----ID ye göre------");
                    User result2 = userManager.get(5);
                    System.out.println("Kullanıcı bulundu : " + result2.getFirstName() + "  " + result2.getLastName());

                    System.out.print("\nMenüye dönmek için ENTER tuşuna basınız.");
                    scn.nextLine();
                    break;
                case 4:
                    System.out.println("------ Login Ekranı ------- ");
                    userManager.login(new User("cemozaydin@mail.com","123456"));

                    System.out.print("\nMenüye dönmek için ENTER tuşuna basınız.");
                    scn.nextLine();
                    break;
                case 5:
                    _loop=false;
                    break;
                default:
                    System.out.println("Hatalı Seçim !!!");
                    System.out.print("Menüye dönmek için ENTER tuşuna basınız.");
                    scn.nextLine();
                    break;
            }

        }
        while(_loop);

        scn.close();
    }
}
