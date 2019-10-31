package denis.jumbo.Jumbo.services;

import denis.jumbo.Jumbo.entities.Vendor;
import denis.jumbo.Jumbo.models.UserLocation;
import denis.jumbo.Jumbo.repositories.VendorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class VendorServiceImp implements IVendorService {


    @Autowired
    VendorRepository vendorRepository;

    @Override
    public void save(Vendor vendor) {
        vendorRepository.save(vendor);
    }

    @Override
    public Page<Vendor> findClosest(UserLocation userLocation, int page, int size, String param) {

        Page<Vendor>vendors;
        Double latitude = userLocation.getLatitude();
        Double longitude = userLocation.getLongitude();
        Pageable pageable = PageRequest.of(page,size);
        vendors = vendorRepository.findClosest(longitude,latitude, param,pageable);
        if (param.equalsIgnoreCase("verified")){
            vendors = vendorRepository.findUnVerified(longitude, latitude,pageable);
        }else if (param.equalsIgnoreCase("unverified")){
            vendors = vendorRepository.findUnVerified(longitude, latitude,pageable);
        }else if (param.equalsIgnoreCase("individual")){
            vendors = vendorRepository.findIndividuals(longitude, latitude,pageable);
        }
        else if (param.equalsIgnoreCase("business")){
            vendors = vendorRepository.findBusinesses(longitude, latitude,pageable);
        }
        return vendors;
    }

    @Override
    public Vendor findById(Long id) {
        return vendorRepository.getOne(id);
    }

    @Override
    public Vendor findByUsername(String username) {
        return vendorRepository.findByUsername(username);
    }

    @Override
    public void delete(Long id) {
        vendorRepository.deleteById(id);
    }


}
