package uk.co.jasonmarston.movies.adaptor.input.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import uk.co.jasonmarston.movies.entity.Movie;

import java.time.LocalDate;

import static lombok.AccessLevel.PUBLIC;

@Data
@Builder
@AllArgsConstructor(access = PUBLIC)
@NoArgsConstructor(access = PUBLIC)
public class CreateMovieBean {
    private String title;
    private LocalDate release;

    public static Movie buildMovieFrom(final CreateMovieBean movieData) {
        return Movie
            .builder()
            .title(movieData.getTitle())
            .release(movieData.getRelease())
            .build();
    }
}
