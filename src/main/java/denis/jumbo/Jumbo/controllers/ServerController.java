package denis.jumbo.Jumbo.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * This is just an endpoint to help me keep my heroku server alive.
 * I am using the free version of Heroku and after 30 min of inactivity it sleeps.
 * So after every 10 min, I am hitting this endpoint just to make the app continue running
 */

@RequestMapping("/keeServerAlive")
@RestController
public class ServerController {

    @GetMapping("/")
    ResponseEntity<?>keepAlive(){
        return new ResponseEntity<>("Keeping server alive", HttpStatus.OK);
    }

}
