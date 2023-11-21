package Executors.CompletableFutures;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class CompletableFuturesDemo {
    public static void main(String[] args) {
        //runs a task in async
        var future = CompletableFuture.runAsync(()->{
            System.out.println("a");
        });
        future.orTimeout(3, TimeUnit.SECONDS);
        //future.thenRun(()-> System.out.println("do something after it's done"));



        var futureInt = CompletableFuture.supplyAsync(()->1);
        futureInt.completeOnTimeout(0, 3, TimeUnit.SECONDS);
        try {
            var rescuedRes = futureInt.exceptionally(e->0).get(); // default value incase of an excepption

            var res = futureInt.get();
            System.out.println(res);
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }

        var service = new MailService();
        service.sendAsync();
        System.out.println("Hello World");
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
