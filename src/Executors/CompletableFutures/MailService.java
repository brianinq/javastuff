package Executors.CompletableFutures;

import Executors.LongTask;

import java.util.concurrent.CompletableFuture;

public class MailService {
    public void send(){
        LongTask.simulate();
        System.out.println("Mail sent!");
    }

    // converting an existing synchronous method to async
    public CompletableFuture<Void> sendAsync(){
        return CompletableFuture.runAsync(()->{
            send();
        });
    }
}
