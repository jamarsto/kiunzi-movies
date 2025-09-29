package uk.co.jasonmarston.movies.input.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

import static lombok.AccessLevel.PUBLIC;

@Data
@AllArgsConstructor(access = PUBLIC)
@NoArgsConstructor(access = PUBLIC)
public class CreateMovieBean {
    private String title;
    private LocalDate release;
}
