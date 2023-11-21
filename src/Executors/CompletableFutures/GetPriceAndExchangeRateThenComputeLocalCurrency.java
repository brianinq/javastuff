package Executors.CompletableFutures;

import java.util.concurrent.CompletableFuture;

public class GetPriceAndExchangeRateThenComputeLocalCurrency {
    public static void main(String[] args) {
        CompletableFuture<Integer> getPrice = CompletableFuture
                .supplyAsync(()->"100USD")
                .thenApply(s -> {
                    var price = s.replace("USD", "");
                    return  Integer.parseInt(price);
                });
        CompletableFuture<Double> getExchangeRate = CompletableFuture.supplyAsync(()->153.67);

        getPrice
            .thenCombine(getExchangeRate, (price, exchange)->{
                return price*exchange;
            })
            .thenAccept(System.out::println);

    }
}
