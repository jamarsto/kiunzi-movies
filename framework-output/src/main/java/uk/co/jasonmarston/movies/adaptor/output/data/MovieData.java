package uk.co.jasonmarston.movies.adaptor.output.data;

import java.time.LocalDate;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Version;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uk.co.jasonmarston.movies.entity.Movie;

@Entity
@Getter
@Setter(AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Builder
public class MovieData {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
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
