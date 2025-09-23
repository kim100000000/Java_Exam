package com.seongtae;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Application4 {

    public static void main(String[] args) {

        List<Movie> movies = Arrays.asList(
                new Movie("인셉션", "액션", 8.8, 148),
                new Movie("다크 나이트", "액션", 9.0, 152),
                new Movie("인터스텔라", "SF", 8.6, 169),
                new Movie("대부", "드라마", 9.2, 175),
                new Movie("쇼생크 탈출", "드라마", 9.3, 142)
        );

        // 1) 액션 장르 & 평점 8 이상 영화 제목 리스트
        List<String> highRatedActionMovies = movies.stream()
                .filter(m -> "액션".equals(m.getGenre()) && m.getRating() >= 8.0)
                .map(Movie::getTitle)
                .collect(Collectors.toList());

        // 2) 모든 영화 평균 상영시간
        double averageDuration = movies.stream()
                .mapToInt(Movie::getDuration)
                .average()
                .orElse(0.0);

        // 3) 장르별 최고 평점 영화 제목 맵
        Map<String, String> topRatedMoviesByGenre = movies.stream()
                .collect(Collectors.groupingBy(
                        Movie::getGenre,
                        Collectors.collectingAndThen(
                                Collectors.maxBy(Comparator.comparingDouble(Movie::getRating)),
                                opt -> opt.map(Movie::getTitle).orElse("")
                        )
                ));

        System.out.println(highRatedActionMovies);   // 예: [인셉션, 다크 나이트]
        System.out.println(averageDuration);         // 예: 157.2
        System.out.println(topRatedMoviesByGenre);   // 예: {액션=다크 나이트, SF=인터스텔라, 드라마=쇼생크 탈출}
    }
}
