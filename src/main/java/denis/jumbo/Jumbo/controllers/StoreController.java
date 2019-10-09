package denis.jumbo.Jumbo.controllers;

import denis.jumbo.Jumbo.models.UserLocation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stores")
public class StoreController {

/* Here I am using a custom object called UserLocation. it contains the latitude and longitude.
   I could have alternatively used a PathVariable or a RequestParam.
    But I think using the custom object gives me flexibility and in case later I need to change something I
      only have one place to change.
**/
    @PostMapping("/closest")
    public ResponseEntity<?>findClosestStore(@RequestBody UserLocation userLocation){

        Gson
    }
}
