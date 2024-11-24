package cinema.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "cinemas")
@Getter
@Setter
@NoArgsConstructor
public class Cinema extends BaseEntity {
    @NotBlank
    @Column(nullable = false)
    private String name;

    private String imageLogo;

    @ManyToMany(mappedBy = "cinemas", fetch = FetchType.EAGER)
    private Set<Movie> movies = new HashSet<>();
}
