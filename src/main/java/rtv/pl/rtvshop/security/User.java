package rtv.pl.rtvshop.security;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import rtv.pl.rtvshop.model.Order;

import java.util.Collection;
import java.util.List;

@Entity
@Data
@RequiredArgsConstructor
@NoArgsConstructor(access = lombok.AccessLevel.PRIVATE, force = true)
@Table(name = "user_")
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(unique = true)
    private final String username;
    private final String password;

    private final String firstName;
    private final String lastName;
    private final String email;
    private final String street;
    private final String zip;
    private final String city;
    private final String buildingNo;
    private final String apartmentNo;
    private final String role;
    @OneToMany(mappedBy = "user")
    private List<Order> orders;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_" + role.toUpperCase()));
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", street='" + street + '\'' +
                ", zip='" + zip + '\'' +
                ", city='" + city + '\'' +
                ", buildingNo='" + buildingNo + '\'' +
                ", apartmentNo='" + apartmentNo + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
