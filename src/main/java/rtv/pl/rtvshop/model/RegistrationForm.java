package rtv.pl.rtvshop.model;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import rtv.pl.rtvshop.security.User;

public record RegistrationForm(String username,
                               String firstName,
                               String lastName,
                               String email,
                               String password,
                               String city,
                               String street,
                               String zip,
                               String buildingNo,
                               String apartmentNo) {
}