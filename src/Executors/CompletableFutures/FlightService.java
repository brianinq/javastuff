package Executors.CompletableFutures;

import Executors.LongTask;

import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;

public class FlightService {
    public CompletableFuture<Quote> getQuote(String site){
        return CompletableFuture.supplyAsync(()->{
            System.out.println("Getting quote from "+ site);
            var random = new Random();
            LongTask.simulate( 1000* random.nextInt(10));
            var price = 100 + random.nextInt(10);
            return new Quote( price, site);
        });
    }

    public Stream<CompletableFuture<Quote>> getQuotes(String[] sites){
        var sitesList = List.of(sites);
        return  sitesList.stream().map(this::getQuote);
    }
}
