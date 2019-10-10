package denis.jumbo.Jumbo.services;

import denis.jumbo.Jumbo.entities.Store;
import denis.jumbo.Jumbo.models.UserLocation;

import java.util.Collection;
import java.util.List;

public interface IStoreService {

    void saveAll(List<Store> stores);
    void save(Store store);
    Collection<Store> findClosest(UserLocation userLocation);
    Collection<Store>findAll();
    void updateLocations();
}
