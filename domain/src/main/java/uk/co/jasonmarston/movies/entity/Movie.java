package uk.co.jasonmarston.movies.entity;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Data
@Builder
public class Movie {
    private UUID id;
    private Long version;
    private String title;
    private LocalDate release;
}
