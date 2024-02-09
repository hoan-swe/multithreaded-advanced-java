package edu.wgu.d387_sample_code.rest;

import edu.wgu.d387_sample_code.Multithread;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class WelcomeController {

    private Multithread multithread;
    @Autowired
    public WelcomeController(Multithread multithread) {
        this.multithread = multithread;
    }

    @GetMapping("/welcome")
    public String[] welcomeMessages(){
        return multithread.getMessages();
    }
}
