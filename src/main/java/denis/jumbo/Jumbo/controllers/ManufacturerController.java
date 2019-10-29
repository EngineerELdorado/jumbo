package denis.jumbo.Jumbo.controllers;

import denis.jumbo.Jumbo.entities.Manufacturer;
import denis.jumbo.Jumbo.models.ApiResponse;
import denis.jumbo.Jumbo.repositories.ManufacturerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/manufacturers")
public class ManufacturerController {

    @Autowired
    ManufacturerRepository manufacturerRepository;
    ApiResponse apiResponse = new ApiResponse();
    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody Manufacturer manufacturer){

        manufacturerRepository.save(manufacturer);
        apiResponse.setResponseCode("00");
        apiResponse.setResponseMessage("Manufacturer saved");
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<?>findAll(){
        apiResponse.setData(manufacturerRepository.findAll());
        return new ResponseEntity<>(apiResponse,HttpStatus.OK);
    }
}
