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

    Logger LOGGER = LogManager.getLogger(StoreController.class);
    ApiResponse apiResponse = new ApiResponse();
    @Autowired
    IStoreService storeService;

    @PostMapping("/closest")
    ResponseEntity<?>findClosest(@RequestBody UserLocation userLocation){

        apiResponse.setData(storeService.findClosest(userLocation));

        return new ResponseEntity<>(apiResponse,HttpStatus.OK);
    }


}
