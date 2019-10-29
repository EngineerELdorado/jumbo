package denis.jumbo.Jumbo.services;

import denis.jumbo.Jumbo.entities.Phone;
import denis.jumbo.Jumbo.models.UserLocation;
import org.springframework.data.domain.Page;

import java.util.Collection;

public interface IphoneService {

    Phone save(Phone phone);
    Page<Phone> findClosest(UserLocation userLocation, int page, int size, String param);
    Page<Phone> findByVendor(UserLocation userLocation, int page, int size, String param, Long businessId);
}
