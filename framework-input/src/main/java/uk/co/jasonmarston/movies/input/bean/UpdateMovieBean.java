package uk.co.jasonmarston.movies.input.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import uk.co.jasonmarston.movies.domain.entity.Movie;

import java.time.LocalDate;
import java.util.UUID;

import static lombok.AccessLevel.PUBLIC;

@Data
@Builder
@AllArgsConstructor(access = PUBLIC)
@NoArgsConstructor(access = PUBLIC)
public class UpdateMovieBean {
    private UUID id;
    private Long version;
    private String title;
    private LocalDate release;

    public static Movie buildMovieFrom(final UpdateMovieBean movieData) {
        return Movie
            .builder()
            .id(movieData.getId())
            .version(movieData.getVersion())
            .title(movieData.getTitle())
            .release(movieData.getRelease())
            .build();
    }
}
