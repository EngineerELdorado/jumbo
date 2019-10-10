package denis.jumbo.Jumbo.repositories;

import denis.jumbo.Jumbo.entities.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface StoreRepository extends JpaRepository<Store, Long> {

    @Query(value = "update store s set location = ST_MakePoint(s.longitude, s.latitude)", nativeQuery = true)
   void updateLocations();
     @Query(value = "SELECT * from store ORDER BY ST_AsGeoJSON(location) <-> ST_MakePoint(?1,?2) limit 5;",nativeQuery = true)
    Collection<Store>findCloses( Double longitude,Double latitude);
}
