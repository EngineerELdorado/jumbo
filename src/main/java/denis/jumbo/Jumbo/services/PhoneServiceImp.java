package denis.jumbo.Jumbo.services;

import denis.jumbo.Jumbo.entities.Phone;
import denis.jumbo.Jumbo.models.UserLocation;
import denis.jumbo.Jumbo.repositories.PhoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PhoneServiceImp implements IphoneService {

    @Autowired
    PhoneRepository phoneRepository;

    @Override
    public Phone save(Phone phone) {

        return phoneRepository.save(phone);
    }

    @Override
    public Page<Phone> findClosest(UserLocation userLocation, int page, int size, String param) {

        Pageable pageable = PageRequest.of(page, size);
        return phoneRepository.findCloses(userLocation.getLongitude(), userLocation.getLatitude(), param, pageable);
    }

    @Override
    public Page<Phone> findByVendor(int page, int size, String param, Long businessId) {

        Pageable pageable = PageRequest.of(page, size);
        return phoneRepository.findByVendor(param, pageable,businessId);
    }

    @Override
    public Page<Phone> findByPriceRange(UserLocation userLocation, int page, int size, String param, Double min, Double max) {
        Pageable pageable = PageRequest.of(page, size);
        return phoneRepository.findByPriceRange(userLocation.getLongitude(), userLocation.getLatitude(), param,min,max,pageable);
    }

    @Override
    public Page<Phone> findByCheapest(UserLocation userLocation, int page, int size, String param) {
        Pageable pageable = PageRequest.of(page, size);
        return phoneRepository.findByCheapest(userLocation.getLongitude(), userLocation.getLatitude(), param,pageable);

    }

    @Override
    public Page<Phone> findByMostExpensive(UserLocation userLocation, int page, int size, String param) {
        Pageable pageable = PageRequest.of(page, size);
        return phoneRepository.findByMostExpensive(userLocation.getLongitude(), userLocation.getLatitude(), param,pageable);

    }

    @Override
    public void delete(Long id) {
       phoneRepository.deleteById(id);
    }
}
