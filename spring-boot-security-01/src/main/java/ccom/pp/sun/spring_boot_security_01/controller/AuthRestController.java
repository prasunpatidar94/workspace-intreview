package ccom.pp.sun.spring_boot_security_01.controller;

import ccom.pp.sun.spring_boot_security_01.entity.AuthRequest;
import ccom.pp.sun.spring_boot_security_01.utility.JwtUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class AuthRestController {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtUtility jwtUtility;

    @PostMapping("/authenticate")
    public String createToken(@RequestBody AuthRequest authRequest) {
        try {

            System.out.println("createToken :: " + authRequest.getUserName());
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            authRequest.getUserName(), authRequest.getPassword()));

            return jwtUtility.creationAuthToken(authRequest.getUserName());
//        return "AUTH_TOKEN";

        } catch (Exception e) {
            throw e;
        }

    }
}
