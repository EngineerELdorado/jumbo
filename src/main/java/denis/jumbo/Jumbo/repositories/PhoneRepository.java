package denis.jumbo.Jumbo.repositories;
import denis.jumbo.Jumbo.entities.Phone;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
public interface PhoneRepository extends JpaRepository<Phone, Long> {

    @Query(value = "SELECT * from phones where LOWER (name) like %?3%  or lower (vendor_name) like %?3% or lower (manufacturer_name) like %?3% or lower (category_name) like %?3% or lower (vendor_type) like %?3% ORDER BY vendor_location <-> ST_MakePoint(?2, ?1) limit 50",nativeQuery = true)
    Page<Phone> findCloses(Double longitude, Double latitude, String param, Pageable pageable);

    @Query(value = "SELECT * from phones where LOWER (name) like %?3%  or lower (vendor_name) like %?3% or lower (manufacturer_name) like %?3% or lower (category_name) like %?3% or lower (vendor_type) like %?3% and vendor_id=?4 ORDER BY creation_time DESC",nativeQuery = true)
    Page<Phone> findByVendor(Double longitude, Double latitude, String param, Pageable pageable, Long businessId);
}
