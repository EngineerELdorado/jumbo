package denis.jumbo.Jumbo.repositories;

import denis.jumbo.Jumbo.entities.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;

/**
 * This is our Repository. It communicates with the Database by using Hibernate and JPA.
 * Hibernate is like an huge interface that we are implementing in this project by JPA
 */
@Repository
public interface StoreRepository extends JpaRepository<Store, Long> {


     @Query(value = "SELECT * from stores ORDER BY location <-> ST_MakePoint(?2, ?1) limit 5",nativeQuery = true)
    Collection<Store>findCloses( Double longitude,Double latitude);
}
