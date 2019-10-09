package denis.jumbo.Jumbo.controllers;

import denis.jumbo.Jumbo.models.ApiResponse;
import denis.jumbo.Jumbo.models.UserLocation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
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
    Resource resource = new ClassPathResource("stores.json");
    ApiResponse apiResponse = new ApiResponse();

/* In the methode below I am using a custom object called UserLocation. it contains the latitude and longitude.
   I could have alternatively used a PathVariable or a RequestParam.
    But I think using the custom object gives me flexibility and in case later I need to change something I
      only have one place to change.
**/
    @PostMapping("/closest")
    public ResponseEntity<?>findClosestStore(@RequestBody UserLocation userLocation){

        JSONParser parser = new JSONParser();
        try{
            Object object = parser.parse(resource.getFile().getAbsolutePath());
            JSONObject jsonObject = (JSONObject)object;

            LOGGER.info(jsonObject);

        }catch (Exception e){
            // TODO: 09/10/2019 catch exception here.
        }

        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<?>findAll(){
        apiResponse.setResponseCode("00");
        apiResponse.setResponseMessage("All Stores");
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }
}
