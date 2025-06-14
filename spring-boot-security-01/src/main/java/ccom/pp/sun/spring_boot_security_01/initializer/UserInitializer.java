package ccom.pp.sun.spring_boot_security_01.initializer;

import ccom.pp.sun.spring_boot_security_01.dao.Hdfcuser;
import ccom.pp.sun.spring_boot_security_01.security.SecurityUserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;


@Component
public class UserInitializer {

//    @Autowired
//    private SecurityUserRepository securityUserRepository;
//
//    @Override
//    public void run(String... args) throws Exception {
//
//        User user = new User();
//        user.setUsername("prasun");
//        user.setUserrole("admin");
//        user.setUserpassword("12345");
//        User userRepo = securityUserRepository.save(user);
//        System.out.printf("User inserted : " + userRepo);
//
//    }

    @Bean
    public CommandLineRunner CustomUserInitializer(SecurityUserRepository securityUserRepository, PasswordEncoder passwordEncoder) {

        return args -> {
            if (securityUserRepository.findByUsername("admin").isEmpty()) {
                Hdfcuser user = new Hdfcuser();
                user.setUserpassword(passwordEncoder.encode("admin"));
                user.setUsername("admin");
                user.setUserrole("ROLE_ADMIN");
                System.out.printf(securityUserRepository.save(user).getUsername());
            }
            if (securityUserRepository.findByUsername("prasun").isEmpty()) {
                Hdfcuser user = new Hdfcuser();
                user.setUserpassword(passwordEncoder.encode("prasun"));
                user.setUsername("prasun");
                user.setUserrole("ROLE_USER");
                System.out.printf(securityUserRepository.save(user).getUsername());
            }
        };
    }
}
