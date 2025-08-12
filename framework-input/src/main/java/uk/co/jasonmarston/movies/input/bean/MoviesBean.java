package uk.co.jasonmarston.movies.input.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

import static lombok.AccessLevel.PUBLIC;

@Data
@Builder
@AllArgsConstructor(access = PUBLIC)
@NoArgsConstructor(access = PUBLIC)
public class MoviesBean {
    private List<MovieBean> movies;
}
