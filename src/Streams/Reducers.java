package Streams;

import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Reducers {
    public static void main(String[] args) {
        List<Movie> movieList = List.of(
                new Movie("a", Genre.COMEDY, 15),
                new Movie("b", Genre.ACTION, 32),
                new Movie("c", Genre.DRAMA, 90),
                new Movie("d", Genre.COMEDY, 9)
        );
        var res = movieList.stream().anyMatch(movie -> movie.getLikes() > 20);
        System.out.println(res);

        var resx = movieList.stream().allMatch(movie -> movie.getLikes() > 20);
        System.out.println(resx);
        //noneMatch, findFirst,

        var first = movieList.stream().findFirst().get();
        var any = movieList.stream().findAny().get();
        var max = movieList.stream().max(Comparator.comparing(Movie::getLikes)).get();
        System.out.println(max.getTitle());


        var totalLikes = movieList
                .stream()
                .map(Movie::getLikes)
                .reduce(Integer::sum);
                //.reduce(0,Integer::sum);
                //.reduce((a, b)-> a+b);
        System.out.println(totalLikes.get());
        System.out.println(totalLikes.orElse(0));


        ///COLLECTORS

        var filteredMovies = movieList
                .stream()
                .filter(m->m.getLikes()>30)
                .collect(Collectors.toList());

        var moviesMap = movieList
                .stream()
                .filter(m->m.getLikes()>30)
                .collect(Collectors.toMap(Movie::getTitle, Movie::getLikes));
                //.collect(Collectors.toMap(movie -> movie.getTitle(), movie -> movie.getLikes()));
        System.out.println(moviesMap);

        var moviesSummary= movieList
                .stream()
                .map(Function.identity())
                .collect(Collectors.summarizingInt(Movie::getLikes));

        System.out.println(moviesSummary);


        //grouping
        var moviesGrouped= movieList
                .stream()
//                .collect(Collectors.groupingBy(Movie::getGenre));
                .collect(Collectors.groupingBy(Movie::getGenre, Collectors.toSet())); //rets {genre=[mv1, mv2]}
                //.collect(Collectors.groupingBy(Movie::getGenre, Collectors.counting)); returns {genre:2}

        System.out.println(moviesGrouped);

        // primitive streams
        IntStream.range(1, 5).forEach(System.out::println);
        IntStream.rangeClosed(1, 5).forEach(System.out::println); //includes 5
    }
}
