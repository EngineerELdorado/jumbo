package denis.jumbo.Jumbo.controllers;

import com.vividsolutions.jts.geom.Geometry;
import com.vividsolutions.jts.io.ParseException;
import denis.jumbo.Jumbo.entities.Vendor;
import denis.jumbo.Jumbo.models.ApiResponse;
import denis.jumbo.Jumbo.models.UserLocation;
import denis.jumbo.Jumbo.services.IVendorService;
import denis.jumbo.Jumbo.utils.GeoUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/stores")
@CrossOrigin(origins = "*")
public class VendorController {

    ApiResponse apiResponse = new ApiResponse();

    @Autowired
    IVendorService storeService;


    @PostMapping("/closest")
    ResponseEntity<?>findClosest(@RequestBody UserLocation userLocation){

        apiResponse.setData(storeService.findClosest(userLocation));
        return new ResponseEntity<>(apiResponse,HttpStatus.OK);
    }

    @PostMapping("/save")
    ResponseEntity<?>save(@RequestBody Vendor vendor){

        Geometry geometry = null;
        try {
            geometry = GeoUtils.wktToGeometry(String.format("POINT (%s %s)",String.valueOf( vendor.getLatitude()), String.valueOf(vendor.getLongitude())));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        vendor.setLocation(geometry);
        vendor.setCreationDate(new Date());
        vendor.setCreationTime(System.currentTimeMillis());
        storeService.save(vendor);
        apiResponse.setResponseCode("00");
        apiResponse.setResponseMessage("Vendor saved");
        return new ResponseEntity<>(apiResponse,HttpStatus.OK);
    }


}
