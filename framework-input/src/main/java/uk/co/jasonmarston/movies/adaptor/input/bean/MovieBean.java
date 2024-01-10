package uk.co.jasonmarston.movies.adaptor.input.bean;

import java.util.Date;
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
public class MovieBean {
    private UUID id;
    private Long version;
    private String title;
    private Date release;

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
