package com.disturbedechoes.blog.rest.webservices;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class BasicAuthController {

    @GetMapping(path = "/basicauth")
    public BasicAuthBean Authenticate() {
        return new BasicAuthBean("You are in ");
    }
}
