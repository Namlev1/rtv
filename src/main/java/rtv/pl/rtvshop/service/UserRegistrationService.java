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
        return new User(form.username(),
                encoder.encode(form.password()),
                form.firstName(),
                form.lastName(),
                form.email(),
                form.street(),
                form.zip(),
                form.city(),
                form.buildingNo(),
                form.apartmentNo());
    }
}
