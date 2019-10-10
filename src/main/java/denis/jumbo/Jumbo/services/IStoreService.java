package denis.jumbo.Jumbo.services;

import denis.jumbo.Jumbo.entities.Store;
import denis.jumbo.Jumbo.models.UserLocation;

import java.util.List;

public interface IStoreService {

    void saveAll(List<Store> stores);
    void save(Store store);
    List<Store> findClosest(UserLocation userLocation);
    List<Store>findAll();
    void updateLocations();
}
