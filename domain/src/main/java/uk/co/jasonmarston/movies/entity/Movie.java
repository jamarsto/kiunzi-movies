package uk.co.jasonmarston.movies.entity;

import java.util.Date;
import java.util.UUID;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Movie {
	private UUID id;
	private Long version;
	private String title;
	private Date release;
}
