package denis.jumbo.Jumbo.services;

import denis.jumbo.Jumbo.entities.Phone;
import denis.jumbo.Jumbo.repositories.PhoneRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class PhoneServiceImp implements IphoneService {

    @Autowired
    PhoneRepository phoneRepository;

    @Override
    public Phone save(Phone phone) {

        return phoneRepository.save(phone);
    }
}
