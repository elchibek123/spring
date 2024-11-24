package cinema.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Entity
@Table(name = "movie_details")
@Getter
@Setter
@NoArgsConstructor
public class MovieDetail extends BaseEntity {
    @NotBlank(message = "Director cannot be blank")
    private String director;

    private String actors;
    private String country;
    private String language;

    @Size(max = 500, message = "Description must not exceed 500 characters")
    private String description;

    @OneToOne(mappedBy = "movieDetail", cascade = CascadeType.ALL)
    private Movie movie;
}
