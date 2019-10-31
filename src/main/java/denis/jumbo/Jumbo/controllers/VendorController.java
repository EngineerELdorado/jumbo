package denis.jumbo.Jumbo.controllers;

import com.vividsolutions.jts.geom.Geometry;
import com.vividsolutions.jts.io.ParseException;
import denis.jumbo.Jumbo.entities.Phone;
import denis.jumbo.Jumbo.entities.Vendor;
import denis.jumbo.Jumbo.models.Address;
import denis.jumbo.Jumbo.models.ApiResponse;
import denis.jumbo.Jumbo.models.LoginObject;
import denis.jumbo.Jumbo.models.UserLocation;
import denis.jumbo.Jumbo.services.IVendorService;
import denis.jumbo.Jumbo.services.IphoneService;
import denis.jumbo.Jumbo.utils.GeoUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Date;

@RestController
@RequestMapping("/stores")
@CrossOrigin(origins = "*")
public class VendorController {

    ApiResponse apiResponse = new ApiResponse();

    @Autowired
    IVendorService storeService;
    @Autowired
    IphoneService iphoneService;


    @PostMapping("/closest")
    ResponseEntity<?>findClosest(@RequestBody UserLocation userLocation, int page, int size, String param){

        apiResponse.setData(storeService.findClosest(userLocation, page, size, param));
        return new ResponseEntity<>(apiResponse,HttpStatus.OK);
    }

    @PostMapping("/save/{id}")
    ResponseEntity<?>save(@RequestBody Vendor vendor,@PathVariable Long id){

        if (id==0){
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
        }else{
            Vendor existing = storeService.findById(id);
            existing.setName(vendor.getName());
            existing.setPhone(vendor.getPhone());
            storeService.save(existing);
            apiResponse.setResponseCode("00");
            apiResponse.setResponseMessage("Vendor saved");
            return new ResponseEntity<>(apiResponse,HttpStatus.OK);
        }
    }

    @PostMapping("/change-address/{id}")
    ResponseEntity<?>update(@RequestBody Address address, @PathVariable Long id){

        Vendor existing = storeService.findById(id);
        Geometry geometry = null;
        try {
            geometry = GeoUtils.wktToGeometry(String.format("POINT (%s %s)",String.valueOf( address.getLatitude()), String.valueOf(address.getLongitude())));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        existing.setLocation(geometry);
        existing.setLatitude(address.getLatitude());
        existing.setLongitude(address.getLongitude());

        storeService.save(existing);
        Page<Phone>phones = iphoneService.findByVendor(0, 1000,"", existing.getId());
        for (Phone phone: phones.getContent()){
            phone.setVendor_longitude(existing.getLongitude());
            phone.setVendor_latitude(existing.getLatitude());
            phone.setVendor_location(existing.getLocation());
            iphoneService.save(phone);
        }
        apiResponse.setResponseCode("00");
        apiResponse.setResponseMessage("Vendor's address saved");
        return new ResponseEntity<>(apiResponse,HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<?>login(@RequestBody LoginObject loginObject){

        Vendor vendor = storeService.findByUsername(loginObject.getUsername());
        return null;
    }
    @GetMapping("/delete/{id}")
    public ResponseEntity<?>delete(@PathVariable Long id){
        storeService.delete(id);
        apiResponse.setResponseCode("00");
        apiResponse.setResponseMessage("Vendor deleted");
        return new ResponseEntity<>(apiResponse,HttpStatus.OK);
    }



}
