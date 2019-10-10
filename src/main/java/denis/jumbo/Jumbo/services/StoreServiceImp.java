package denis.jumbo.Jumbo.services;

import denis.jumbo.Jumbo.entities.Store;
import denis.jumbo.Jumbo.models.UserLocation;
import denis.jumbo.Jumbo.repositories.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class StoreServiceImp implements IStoreService {

    @Autowired
    StoreRepository storeRepository;

    @Override
    public void saveAll(List<Store> stores) {
        storeRepository.saveAll(stores);
    }

    @Override
    public void save(Store store) {
        storeRepository.save(store);
    }

    @Override
    public Collection<Store> findClosest(UserLocation userLocation) {

        Double latitude = userLocation.getLatitude();
        Double longitude = userLocation.getLongitude();
        return storeRepository.findCloses(longitude,latitude);
    }

    @Override
    public Collection<Store> findAll() {
        return storeRepository.findAll();
    }

    @Override
    public void updateLocations() {

        storeRepository.updateLocations();
    }
}
