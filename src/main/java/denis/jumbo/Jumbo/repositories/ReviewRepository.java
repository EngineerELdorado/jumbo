package denis.jumbo.Jumbo.repositories;

import denis.jumbo.Jumbo.entities.Review;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ReviewRepository extends JpaRepository<Review, Long> {

    @Query(value = "select * from reviews where vendor_id=?1", nativeQuery = true)
    Page<Review> findByVendor(Long vendorId, Pageable pageable);
    @Query(value = "select * from reviews where phone_id=?1", nativeQuery = true)
    Page<Review> findByPhone(Long phoneId, Pageable pageable);
}
