package denis.jumbo.Jumbo.services;

import denis.jumbo.Jumbo.entities.Vendor;
import denis.jumbo.Jumbo.models.UserLocation;
import denis.jumbo.Jumbo.repositories.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * This class is an implementation of our StoreService.
 * It respects the contract by implementing all the methods.
 * This is where I put all the logics of the applciation.
 *
 */
@Service
public class StoreServiceImp implements IStoreService {

    /**
     * Creating an instance of our Store repository.
     * more details about the repository is found in the Repository class
     */
    @Autowired
    StoreRepository storeRepository;

    @Override
    public void save(Vendor vendor) {
        storeRepository.save(vendor);
    }

    /**
     * This method takes an parameter of type userLocation from the controller.
     * it extracts the latitude and logintude and send them to the repository.
     * The repository will query the Database, get the response, send it to this class then
     * this class will send the response back to the controller.
     * @param userLocation
     * @return
     */
    @Override
    public Collection<Vendor> findClosest(UserLocation userLocation) {

        Double latitude = userLocation.getLatitude();
        Double longitude = userLocation.getLongitude();
        return storeRepository.findCloses(longitude,latitude);
    }

}
