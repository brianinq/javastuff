package Executors.CompletableFutures;

import Executors.LongTask;

import java.util.concurrent.CompletableFuture;

public class GetEmailFromIdandPlaylistFromEmail {
    public static void main(String[] args) {
        //id -> mail
        var futureEmail = CompletableFuture.supplyAsync(()->{
            //db query
            return "example@mail.com";
        });

        //email - > playlist
        var playlist = futureEmail.thenCompose(email->{
            return CompletableFuture.supplyAsync(()->{
                return email+"'s Playlist";
            });
        });
        playlist.thenAccept(System.out::println);


        // better implementation
        getUserEmailAsync("trickster")
                .thenCompose(GetEmailFromIdandPlaylistFromEmail::getPlaylistAsync)
                .thenAccept(System.out::println);

        //sleep so that we can see results above
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
    public static CompletableFuture<String> getUserEmailAsync( String name){
        return CompletableFuture.supplyAsync(()->{
            LongTask.simulate();
            return name+"@gmail.com";
        });
    }

    public static CompletableFuture<String> getPlaylistAsync(String email){
        return CompletableFuture.supplyAsync(()->{
           return email+"'s Complete Playlist......";
        });
    }

}
