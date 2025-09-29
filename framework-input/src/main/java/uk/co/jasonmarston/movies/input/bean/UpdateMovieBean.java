package uk.co.jasonmarston.movies.input.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

import static lombok.AccessLevel.PUBLIC;

@Data
@AllArgsConstructor(access = PUBLIC)
@NoArgsConstructor(access = PUBLIC)
public class UpdateMovieBean {
    private UUID id;
    private Long version;
    private String title;
    private LocalDate release;
}
