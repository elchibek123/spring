package java15.entity;

import jakarta.persistence.*;
import java15.enums.HouseType;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;

@Entity
@Table(name = "houses")
@Getter
@Setter
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class House {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "house_gen")
    @SequenceGenerator(name = "house_gen", sequenceName = "house_seq", allocationSize = 1)
    Long id;
    String address;
    String country;
    BigDecimal price;
    int room;
    String description;
    @Enumerated(EnumType.STRING)
    HouseType houseType;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    Agency agency;
}