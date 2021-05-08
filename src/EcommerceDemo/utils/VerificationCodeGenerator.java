package EcommerceDemo.utils;

import java.util.Random;

public class VerificationCodeGenerator {

    public static String verificationCode() {
        Random rnd = new Random();
        String verificationCode = String.format("%04d", rnd.nextInt(10000));
        return  verificationCode;
    }
}
