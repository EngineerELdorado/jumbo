package denis.jumbo.Jumbo.services;

import denis.jumbo.Jumbo.entities.Review;
import denis.jumbo.Jumbo.repositories.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ReviewServiceImp implements IReviewService {

    @Autowired
    ReviewRepository reviewRepository;

    @Override
    public Review save(Review review) {
        return reviewRepository.save(review);
    }

    @Override
    public Page<Review> findByBusiness(int page, int size, Long businessId) {
        Pageable pageable = PageRequest.of(page,size);
        return reviewRepository.findByVendor(businessId, pageable);
    }

    @Override
    public Page<Review> findByPhone(int page, int size,Long phoneId) {
        Pageable pageable = PageRequest.of(page,size);
        return reviewRepository.findByPhone(phoneId,pageable);
    }
}
