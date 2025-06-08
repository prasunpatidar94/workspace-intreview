package ccom.pp.sun.spring_boot_security_01.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/hdfc/")
public class RestController {

    @GetMapping(path = "/health")
    public String healthCheck() {
        return "I AM OK";
    }
}
