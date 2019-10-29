package denis.jumbo.Jumbo.controllers;

import denis.jumbo.Jumbo.entities.Category;
import denis.jumbo.Jumbo.entities.Manufacturer;
import denis.jumbo.Jumbo.models.ApiResponse;
import denis.jumbo.Jumbo.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    CategoryRepository categoryRepository;
    ApiResponse apiResponse = new ApiResponse();
    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody Category category){

        categoryRepository.save(category);
        apiResponse.setResponseCode("00");
        apiResponse.setResponseMessage("Manufacturer saved");
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<?>findAll(){
        apiResponse.setData(categoryRepository.findAll());
        return new ResponseEntity<>(apiResponse,HttpStatus.OK);
    }
}

