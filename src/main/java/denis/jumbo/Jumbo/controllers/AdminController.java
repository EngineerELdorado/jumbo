package denis.jumbo.Jumbo.controllers;


import denis.jumbo.Jumbo.entities.Admin;
import denis.jumbo.Jumbo.models.ApiResponse;
import denis.jumbo.Jumbo.models.LoginObject;
import denis.jumbo.Jumbo.repositories.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/admins")
@RestController
public class AdminController {
    @Autowired
    AdminRepository adminRepository;

    ApiResponse apiResponse = new ApiResponse();
    @PostMapping("/save")
    public ResponseEntity<?>addAdmin(@RequestBody Admin admin){

        adminRepository.save(admin);
        apiResponse.setResponseCode("00");
        apiResponse.setResponseMessage("Admin saved");
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<?>login(@RequestBody LoginObject loginObject){
        Admin admin = adminRepository.findByUsername(loginObject.getUsername());
        return null;
    }


}
