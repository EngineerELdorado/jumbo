package denis.jumbo.Jumbo.services;

import denis.jumbo.Jumbo.entities.Store;
import denis.jumbo.Jumbo.models.UserLocation;

import java.util.Collection;
import java.util.List;

public interface IStoreService {

    /**
     * This is just a contract.
     * It means the classes implementing this service should respect the contract by
     * implementing all the methods
     * @param store
     */
    void save(Store store);
    Collection<Store> findClosest(UserLocation userLocation);
}
