package uk.co.jasonmarston.movies.adaptor.input.bean;

import java.time.LocalDate;
import java.util.UUID;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import uk.co.jasonmarston.movies.entity.Movie;

@Data
@Builder
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
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
