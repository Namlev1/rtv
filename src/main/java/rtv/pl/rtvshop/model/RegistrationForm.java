package rtv.pl.rtvshop.model;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RegistrationForm {
    @NotNull(message = "Nazwa użytkownika nie może być pusta")
    @Size(min = 3, max = 30, message = "Nazwa użytkownika musi mieć od 3 do 30 znaków")
    private String username;

    @NotNull(message = "Imię nie może być puste")
    @Size(min = 3, max = 30, message = "Imię musi mieć od 3 do 30 znaków")
    private String firstName;

    @NotNull(message = "Nazwisko nie może być puste")
    @Size(min = 3, max = 30, message = "Nazwisko musi mieć od 3 do 30 znaków")
    private String lastName;

    @NotNull(message = "Email nie może być pusty")
    @Pattern(regexp = "^[A-Za-z0-9+_.-]+@(.+)$", message = "Nieprawidłowy format email")
    @Size(min = 3, max = 30, message = "Email musi mieć od 3 do 30 znaków")
    private String email;

    @NotNull(message = "Hasło nie może być puste")
    @Size(min = 3, max = 30, message = "Hasło musi mieć od 3 do 30 znaków")
    private String password;

    @NotNull(message = "Miasto nie może być puste")
    @Size(min = 3, max = 30, message = "Miasto musi mieć od 3 do 30 znaków")
    private String city;

    @NotNull(message = "Ulica nie może być pusta")
    @Size(min = 3, max = 30, message = "Ulica musi mieć od 3 do 30 znaków")
    private String street;

    @NotNull(message = "Kod pocztowy nie może być pusty")
    @Size(min = 3, max = 30, message = "Kod pocztowy musi mieć od 3 do 30 znaków")
    @Pattern(regexp = "^\\d{2}-\\d{3}$", message = "Proszę podać kod pocztowy w formacie" + '\n' + "XX-XXX")
    private String zip;

    @NotNull(message = "Numer budynku nie może być pusty")
    @Size(min = 1, max = 30, message = "Numer budynku musi mieć od 1 do 30 znaków")
    private String buildingNo;

    @Nullable
    @Size(min = 0, max = 5, message = "Numer mieszkania musi mieć długość do 5 znaków")
    private String apartmentNo;
}