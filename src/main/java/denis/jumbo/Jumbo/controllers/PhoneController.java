package denis.jumbo.Jumbo.controllers;

import com.vividsolutions.jts.geom.Geometry;
import com.vividsolutions.jts.io.ParseException;
import denis.jumbo.Jumbo.entities.Phone;
import denis.jumbo.Jumbo.entities.Vendor;
import denis.jumbo.Jumbo.models.ApiResponse;
import denis.jumbo.Jumbo.models.UserLocation;
import denis.jumbo.Jumbo.services.IVendorService;
import denis.jumbo.Jumbo.services.IphoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RequestMapping("/phones")
public class PhoneController {

    ApiResponse apiResponse =new ApiResponse();
    @Autowired
    IVendorService vendorService;
    @Autowired
    IphoneService iphoneService;
    @PostMapping("/save/vendorId")
    ResponseEntity<?> save(@RequestBody Phone phone, @PathVariable Long vendorId){

        Vendor vendor = vendorService.findById(vendorId);
        phone.setVendor_latitude(vendor.getLatitude());
        phone.setVendor_longitude(vendor.getLongitude());
        phone.setVendor_type(vendor.getType());
        phone.setVendor_verified(vendor.isVerified());
        phone.setVendor_country(vendor.getCountry());
        phone.setVendor_city(vendor.getCity());
        phone.setVendor_area(vendor.getArea());
        phone.setVendor_location(vendor.getLocation());
        phone.setCreationDate(new Date());
        phone.setCreationTime(System.currentTimeMillis());
        iphoneService.save(phone);
        apiResponse.setResponseCode("00");
        apiResponse.setResponseMessage("Phone saved");
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @GetMapping("/closest")
    ResponseEntity<?>findClosest(@RequestBody UserLocation userLocation,
                                 @RequestParam int page,@RequestParam int size,
                                 @RequestParam String param){

   Page<Phone> phones = iphoneService.findClosest(userLocation, page, size, param);
   apiResponse.setData(phones);
   return  new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }


    @GetMapping("/by-business/{businessId}")
    ResponseEntity<?>findBusiness(
                                 int page, int size, String param,@PathVariable Long businessId){

        Page<Phone> phones = iphoneService.findByVendor( page, size, param, businessId);

        apiResponse.setData(phones);
        return  new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @GetMapping("/findByCheapest")
    public ResponseEntity<?>findByCheapest(@RequestBody UserLocation userLocation,
                                          @RequestParam int page,@RequestParam int size,@RequestParam String param){
        Page<Phone>phones = iphoneService.findByCheapest(userLocation, page, size, param);
        apiResponse.setData(phones);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @GetMapping("/findByMostExpensive")
    public ResponseEntity<?>findByMostExpensive(@RequestBody UserLocation userLocation,
                                           @RequestParam int page,@RequestParam int size,@RequestParam String param){
        Page<Phone>phones = iphoneService.findByCheapest(userLocation, page, size, param);
        apiResponse.setData(phones);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }
    @GetMapping("/delete/{id}")
    public ResponseEntity<?>delete(@PathVariable Long id){
        iphoneService.delete(id);
        apiResponse.setResponseCode("00");
        apiResponse.setResponseMessage("Phone deleted");
        return new ResponseEntity<>(apiResponse,HttpStatus.OK);
    }

}
