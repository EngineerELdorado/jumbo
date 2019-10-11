package denis.jumbo.Jumbo.controllers;

import denis.jumbo.Jumbo.models.ApiResponse;
import denis.jumbo.Jumbo.models.UserLocation;
import denis.jumbo.Jumbo.services.IStoreService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/stores")
@CrossOrigin(origins = "*")
public class StoreController {

    ApiResponse apiResponse = new ApiResponse();

    /**
     * I am creating an instance of the implementation of my service.
     * I am using the interface which only contains the method.
     * Spring will pick the right implementation of this service at runtime.
     * I am coding on the interface inste to make my codes flexible and easy to extend.
     * I can explain this better in person.
     */
    @Autowired
    IStoreService storeService;

    /**
     * Here I am receiving an HttpRequest. It is a POST request.
     * I decided to use POST instead of GET to make the paramaters flexible.
     * By Flexible I mean I only need to create a single Object named UserLocation.
     * It will contain the Latitude and Longitude of the person searching for stores.
     * This wasy is possible because if in the future I want to change, I will ony change one place(the object)
     * @param userLocation
     * @return
     */
    @PostMapping("/closest")
    ResponseEntity<?>findClosest(@RequestBody UserLocation userLocation){

        /**
         * Here I am fetching the closest stores.
         * I put them into my ApiResponse object.
         * then I send the response to the REST clients(for example: a web app and mobile app)
         * I use ResponseEntity to take advantage of its Generics capabilities.
         * but of course any other return type coul work
         */

        apiResponse.setData(storeService.findClosest(userLocation));
        return new ResponseEntity<>(apiResponse,HttpStatus.OK);
    }


}
