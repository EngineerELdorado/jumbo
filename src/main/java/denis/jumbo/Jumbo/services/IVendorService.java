package denis.jumbo.Jumbo.services;

import denis.jumbo.Jumbo.entities.Vendor;
import denis.jumbo.Jumbo.models.UserLocation;

import java.util.Collection;

public interface IVendorService {

    /**
     * This is just a contract.
     * It means the classes implementing this service should respect the contract by
     * implementing all the methods
     * @param vendor
     */
    void save(Vendor vendor);
    Collection<Vendor> findClosest(UserLocation userLocation);
    Vendor findById(Long id);
}
