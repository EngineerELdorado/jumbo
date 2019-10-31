package denis.jumbo.Jumbo.repositories;

import denis.jumbo.Jumbo.entities.Vendor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface VendorRepository extends JpaRepository<Vendor, Long> {


     @Query(value = "SELECT * from vendors where LOWER (name) like %?3%  or lower (country) like %?3% or lower (city) like %?3% or lower (area) like %?3% or lower (type) like %?3% ORDER BY location <-> ST_MakePoint(?2, ?1)",nativeQuery = true)
     Page<Vendor> findClosest(Double longitude, Double latitude, String param, Pageable pageable);

    @Query(value = "SELECT * from vendors where verified=true ORDER BY location <-> ST_MakePoint(?2, ?1)",nativeQuery = true)
    Page<Vendor> findVerified(Double longitude, Double latitude, Pageable pageable);

    @Query(value = "SELECT * from vendors where verified=false ORDER BY location <-> ST_MakePoint(?2, ?1)",nativeQuery = true)
    Page<Vendor> findUnVerified(Double longitude, Double latitude, Pageable pageable);

    @Query(value = "SELECT * from vendors where type='INDIVIDUAL' ORDER BY location <-> ST_MakePoint(?2, ?1)",nativeQuery = true)
    Page<Vendor> findIndividuals(Double longitude, Double latitude, Pageable pageable);

    @Query(value = "SELECT * from vendors where type='BUSINESS' ORDER BY location <-> ST_MakePoint(?2, ?1)",nativeQuery = true)
    Page<Vendor> findBusinesses(Double longitude, Double latitude, Pageable pageable);
    @Query(value = "select * from vendors where username=?1 order by id limit 1", nativeQuery = true)
    Vendor findByUsername(String username);
}
