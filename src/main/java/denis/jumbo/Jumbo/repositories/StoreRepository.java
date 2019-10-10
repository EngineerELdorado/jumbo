package denis.jumbo.Jumbo.repositories;

import denis.jumbo.Jumbo.entities.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface StoreRepository extends JpaRepository<Store, Long> {

    @Query(value = "update store s set location = ST_MakePoint(s.longitude, s.latitude)", nativeQuery = true)
   void updateLocations();
}
