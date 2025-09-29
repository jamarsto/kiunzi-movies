package uk.co.jasonmarston.movies.output.data;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

import static jakarta.persistence.GenerationType.UUID;
import static lombok.AccessLevel.PACKAGE;
import static lombok.AccessLevel.PRIVATE;

@Entity
@Getter
@Setter(PRIVATE)
@AllArgsConstructor(access = PACKAGE)
@NoArgsConstructor(access = PACKAGE)
public class MovieData {
    @Id
    @GeneratedValue(strategy = UUID)
    private UUID id;
    @Version
    private Long version;
    private String title;
    @Column(name = "releasedOn")
    private LocalDate released;
}
