package uk.co.jasonmarston.movies.adaptor.input.bean;

import java.util.Date;

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
public class CreateMovieBean {
	private String title;
	private Date release;

	public static CreateMovieBean buildCreateMovieBeanFrom(final Movie movie) {
		return CreateMovieBean
			.builder()
			.title(movie.getTitle())
			.release(movie.getRelease())
			.build();
	}

	public static Movie buildMovieFrom(final CreateMovieBean movieData) {
		return Movie
			.builder()
			.title(movieData.getTitle())
			.release(movieData.getRelease())
			.build();
	}
}
