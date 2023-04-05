package CustomFormLogin.controllers;

import CustomFormLogin.services.JpaUserDetailsService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;

@AllArgsConstructor
public class DemoController {

    private final JpaUserDetailsService jpaUserDetailsService;

    @GetMapping("/demo")
    public String demo(){
        return "Hello from demo endpoint";
    }







}
