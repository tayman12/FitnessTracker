import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Password {

    public static void main(String[] args){
        String pass = "pass";
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String hash = bCryptPasswordEncoder.encode(pass);
        System.out.println(hash);
    }
}
