package denis.jumbo.Jumbo.services;

import denis.jumbo.Jumbo.entities.Review;
import org.springframework.data.domain.Page;

public interface IReviewService {

    Review save(Review review);
    Page<Review>findByBusiness(int page, int size,Long businessId);
    Page<Review>findByPhone(int page, int size, Long phoneId);
}
