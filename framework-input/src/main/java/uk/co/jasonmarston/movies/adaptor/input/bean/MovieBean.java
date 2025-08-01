package uk.co.jasonmarston.movies.adaptor.input.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import uk.co.jasonmarston.movies.entity.Movie;

import java.time.LocalDate;
import java.util.UUID;

import static lombok.AccessLevel.PUBLIC;

@Data
@Builder
@AllArgsConstructor(access = PUBLIC)
@NoArgsConstructor(access = PUBLIC)
public class MovieBean {
    private UUID id;
    private Long version;
    private String title;
    private LocalDate release;

    public static MovieBean buildMovieBeanFrom(final Movie movie) {
        return MovieBean
            .builder()
            .id(movie.getId())
            .version(movie.getVersion())
            .title(movie.getTitle())
            .release(movie.getRelease())
            .build();
    }
}
