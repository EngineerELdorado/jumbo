package denis.jumbo.Jumbo.repositories;

import denis.jumbo.Jumbo.entities.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;

/**
 * This is our Repository. It communicates with the Database by using Hibernate and JPA.
 * Hibernate is like an huge interface that we are implementing in this project by JPA
 */
@Repository
public interface StoreRepository extends JpaRepository<Vendor, Long> {


     @Query(value = "SELECT * from vendors ORDER BY location <-> ST_MakePoint(?2, ?1) limit 10",nativeQuery = true)
    Collection<Vendor>findCloses(Double longitude, Double latitude);
}
