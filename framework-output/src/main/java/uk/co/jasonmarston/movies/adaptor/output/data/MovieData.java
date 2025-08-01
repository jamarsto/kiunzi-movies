package uk.co.jasonmarston.movies.adaptor.output.data;

import jakarta.persistence.*;
import lombok.*;
import uk.co.jasonmarston.movies.entity.Movie;

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
@Builder
public class MovieData {
    @Id
    @GeneratedValue(strategy = UUID)
    private UUID id;
    @Version
    private Long version;
    private String title;
    @Column(name = "releasedOn")
    private LocalDate released;

    public static MovieData buildMovieDataFrom(final Movie movie) {
        return MovieData
            .builder()
            .id(movie.getId())
            .version(movie.getVersion())
            .title(movie.getTitle())
            .released(movie.getRelease())
            .build();
    }

    public static Movie buildMovieFrom(final MovieData movieData) {
        return Movie
            .builder()
            .id(movieData.getId())
            .version(movieData.getVersion())
            .title(movieData.getTitle())
            .release(movieData.getReleased())
            .build();
    }

    public MovieData from(final MovieData movieData) {
        this.setId(movieData.getId());
        this.setTitle(movieData.getTitle());
        this.setReleased(movieData.getReleased());
        return this;
    }
}
