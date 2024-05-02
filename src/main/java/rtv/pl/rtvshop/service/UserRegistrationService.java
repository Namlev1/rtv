package rtv.pl.rtvshop.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import rtv.pl.rtvshop.model.RegistrationForm;
import rtv.pl.rtvshop.repository.UserRepository;
import rtv.pl.rtvshop.security.User;

@Service
@RequiredArgsConstructor
public class UserRegistrationService {
    private final BCryptPasswordEncoder encoder;
    private final UserRepository userRepository;

    public User registerUser(RegistrationForm form) {
        return userRepository.save(toUser(form));
    }

    public User registerUser(User user) {
        return userRepository.save(user);
    }

    public User toUser(RegistrationForm form) {
        return new User(form.getUsername(),
                encoder.encode(form.getPassword()),
                form.getFirstName(),
                form.getLastName(),
                form.getEmail(),
                form.getStreet(),
                form.getZip(),
                form.getCity(),
                form.getBuildingNo(),
                form.getApartmentNo());
    }
}
