package cinema.entities;

import cinema.enums.Role;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User extends BaseEntity {
    private String name;
    @Email
    private String email;
    private String password;
    private String phoneNumber;
    private Role role;
    private LocalDateTime registrationDate;
}
