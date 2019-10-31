package denis.jumbo.Jumbo.controllers;

import denis.jumbo.Jumbo.entities.Review;
import denis.jumbo.Jumbo.models.ApiResponse;
import denis.jumbo.Jumbo.repositories.ReviewRepository;
import denis.jumbo.Jumbo.services.IReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reviews")
public class ReviewController {

    @Autowired
    IReviewService reviewService;
    ApiResponse apiResponse = new ApiResponse();

    @PostMapping("/save")
    public ResponseEntity<?>save(@RequestBody Review review){

        reviewService.save(review);
        apiResponse.setResponseCode("00");
        apiResponse.setResponseMessage("Review Saved");
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }
    @GetMapping("/by-vendor/{id}")
    public ResponseEntity<?>findByVendor(@PathVariable Long id,@RequestParam int page,@RequestParam int size){
        Page<Review>reviews = reviewService.findByBusiness(page, size, id);
        apiResponse.setData(reviews);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }
    @GetMapping("/by-phone/{id}")
    public ResponseEntity<?>findByPhone(@PathVariable Long id,@RequestParam int page,@RequestParam int size){
        Page<Review>reviews = reviewService.findByBusiness(page, size, id);
        apiResponse.setData(reviews);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }
}
