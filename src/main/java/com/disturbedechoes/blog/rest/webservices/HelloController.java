package com.disturbedechoes.blog.rest.webservices;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class HelloController {

    @GetMapping(path = "/info")
    public InfoBean Info() {
        return new InfoBean("These are my articles on disturbedechoes.com ");
    }

    @GetMapping(path = "/info/name/{name}")
    public InfoBean HelloBeanName(@PathVariable String name) {
        return new InfoBean(String.format("Hi %s. An overview of my articles on disturbedechoes.com ", name));
    }
}
