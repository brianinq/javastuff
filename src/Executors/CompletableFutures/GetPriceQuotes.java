package Executors.CompletableFutures;

import Executors.LongTask;

import java.time.Duration;
import java.time.LocalTime;
import java.util.concurrent.CompletableFuture;

public class GetPriceQuotes {
    public static void main(String[] args) {
        var start = LocalTime.now();
        var service = new FlightService();
        service.getQuote("Site0").thenAccept(System.out::println);
        var futures = service
            .getQuotes(new String[]{"site1", "site2", "site3"})
            .map(s->s.thenAccept(System.out::println))
                .toList();

        CompletableFuture
                .allOf(futures.toArray(new CompletableFuture[0]))
                .thenRun(()->{
                    System.out.println("retrieved all quotes in " +Duration.between(start, LocalTime.now()).toMillis()+ "ms");
                });

        try {
            Thread.sleep(10_000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
