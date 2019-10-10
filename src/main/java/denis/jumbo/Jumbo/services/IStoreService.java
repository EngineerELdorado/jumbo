package denis.jumbo.Jumbo.services;

import denis.jumbo.Jumbo.entities.Store;
import denis.jumbo.Jumbo.models.UserLocation;

import java.util.List;

public interface IStoreService {

    void save(List<Store> stores);
    List<Store> findClosest(UserLocation userLocation);
    List<Store>findAll();
}
