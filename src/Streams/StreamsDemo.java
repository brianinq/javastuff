package Streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class StreamsDemo {
    public static void main(String[] args) {
        List<Movie> movieList = List.of(
                new Movie("a", Genre.DRAMA, 15),
                new Movie("b", Genre.ACTION, 32),
                new Movie("c", Genre.ACTION, 90),
                new Movie("d", Genre.COMEDY, 9)
        );
        var bestMovies = movieList.stream()
                .filter(movie -> movie.getLikes()>10)
                .count();
        System.out.println(bestMovies);

        int[] numbers = {1,2,3,4,5,6,7,8};
        Arrays.stream(numbers).forEach(System.out::println);

        /* we can generate an infinite number of streams using the below lazy evaluation
           ie a value will only be generated when we call the stream
         */
        var stream = Stream.generate(Math::random);
        //will run infinitely
        //stream.forEach(System.out::println);

        //runs 4 times
        stream.limit(4).forEach(System.out::println);

        //10 numbers using stream
        Stream.iterate(1, n->n+1)
                .limit(10)
                .forEach(System.out::println);


        //mapping over items
        movieList
            .stream()
            .map(Movie::getTitle)
            .forEach(System.out::println);

        //flatMap
        var streamer = Stream.of(List.of(1,2,3), List.of(4,5,6,7));
        streamer
                .flatMap(List::stream)
                .peek(System.out::println);

        // slicing
        //eg for pagination of a movielist of 100 titles to get the 3rd page of 10page size
        int currentPage = 1;
        int pageSize = 20;
        movieList.stream().skip((currentPage - 1) * pageSize)
                .limit(pageSize)
                .forEach(m-> System.out.println(m.getTitle()));

        //  streamer.takeWhile() gets until predicate becomes false


        //sorting
        movieList
                .stream()
                .sorted(Comparator.comparingInt(Movie::getLikes))
                //.sorted((a, b)->a.getLikes() - b.getLikes())
                .forEach(movie -> System.out.println(movie.getTitle()));
    }
}

