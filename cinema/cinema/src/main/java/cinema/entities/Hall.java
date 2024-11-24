package cinema.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "halls")
@Getter
@Setter
@NoArgsConstructor
@ToString(exclude = "showTimes")
public class Hall extends BaseEntity {
    @NotBlank
    @Column(nullable = false, unique = true)
    private String name;

    @Positive
    @Column(name = "seat_count", nullable = false)
    private int seatCount;

    @OneToMany(mappedBy = "hall", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<ShowTime> showTimes = new HashSet<>();
}