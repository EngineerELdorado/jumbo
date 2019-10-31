package denis.jumbo.Jumbo.services;

import denis.jumbo.Jumbo.entities.Vendor;
import denis.jumbo.Jumbo.models.UserLocation;
import org.springframework.data.domain.Page;

import java.util.Collection;

public interface IVendorService {

    /**
     * This is just a contract.
     * It means the classes implementing this service should respect the contract by
     * implementing all the methods
     * @param vendor
     */
    void save(Vendor vendor);
    Page<Vendor> findClosest(UserLocation userLocation, int page, int size, String param);
    Vendor findById(Long id);
    Vendor findByUsername(String username);
    void delete(Long id);
}
