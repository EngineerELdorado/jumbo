package denis.jumbo.Jumbo.services;

import denis.jumbo.Jumbo.entities.Store;
import denis.jumbo.Jumbo.models.UserLocation;
import denis.jumbo.Jumbo.repositories.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoreServiceImp implements IStoreService {

    @Autowired
    StoreRepository storeRepository;

    @Override
    public void save(List<Store> stores) {
        storeRepository.saveAll(stores);
    }

    @Override
    public List<Store> findClosest(UserLocation userLocation) {



        return null;
    }

    @Override
    public List<Store> findAll() {
        return storeRepository.findAll();
    }
}
