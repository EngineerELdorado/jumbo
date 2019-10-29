package denis.jumbo.Jumbo.controllers;

import com.vividsolutions.jts.geom.Geometry;
import com.vividsolutions.jts.io.ParseException;
import denis.jumbo.Jumbo.entities.Phone;
import denis.jumbo.Jumbo.entities.Vendor;
import denis.jumbo.Jumbo.models.ApiResponse;
import denis.jumbo.Jumbo.services.IVendorService;
import denis.jumbo.Jumbo.services.IphoneService;
import denis.jumbo.Jumbo.utils.GeoUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

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


}
