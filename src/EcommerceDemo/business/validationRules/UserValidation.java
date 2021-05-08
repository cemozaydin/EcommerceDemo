package EcommerceDemo.business.validationRules;

import EcommerceDemo.entities.concretes.User;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserValidation {
    public static boolean validators(User user){

        boolean result = true;

        if (!isValidFirstNameLastName(user)){
            System.out.println("Ad ve Soyad en az 2 karakter olmalıdır.");
            result=false;
        }
        if(!isValidPassword(user)){
            System.out.println("Şifre en az 6 karakter olmalıdır.");
            result=false;
        }
        if(!isValidMail(user)){
            System.out.println("Geçersiz E-Mail adresi girdiniz.");
            result=false;
        }

        return result;
    }

    private static boolean isValidFirstNameLastName(User user){
        boolean result = true;
        if(user.getFirstName().length()<2 || user.getLastName().length()<2){
            result=false;
        }
        return result;
    }

    private static boolean isValidPassword(User user){
        boolean result = true;
        if(user.getPassword().length()<6){
            result=false;
        }
        return result;
    }

    private static boolean isValidMail(User user){
        String regex = "^[-a-z0-9~!$%^&*_=+}{\\'?]+(\\.[-a-z0-9~!$%^&*_=+}{\\'?]+)*@([a-z0-9_][-a-z0-9_]*(\\.[-a-z0-9_]+)*\\.(aero|arpa|biz|com|coop|edu|gov|info|int|mil|museum|name|net|org|pro|travel|mobi|[a-z][a-z])|([0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}))(:[0-9]{1,5})?$";
        Pattern p = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);

        if (user.getEmail()==null){
            return false;
        }
        Matcher m = p.matcher(user.getEmail());

        return  m.matches();
    }

}
