package Concurency;

import java.util.ArrayList;
import java.util.List;

public class GetPrecessInfo {
    public static void main(String[] args) {
        System.out.println(Thread.activeCount());
        System.out.println(Runtime.getRuntime().totalMemory());
        System.out.println(Runtime.getRuntime().availableProcessors());


        //AtomicClasses (AtomicInteger)
        //AdderClasses (longAdder)
        //synchronizedCollections
        //concurrentCollections (concurrentHashMaps)



        //Thread thread = new Thread(new Downloader());
        //Thread thread = new Thread(() -> System.out.println("Started thread"));
        //thread.start();
        //try {
        //    Thread.sleep(1000);
        //} catch (InterruptedException e) {
        //    throw new RuntimeException(e);
        //}
        //thread.interrupt();
        List<Thread> threads = new ArrayList<>();
        List<Downloader> tasks = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            var task = new Downloader();
            tasks.add(task);
            var thread = new Thread(task);
            thread.start();
            threads.add(thread);
        }

        for (var thread: threads){
            try{
                thread.join();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
       var totalBytes = tasks.stream().map(t->t.getStatus().getTotalBytes()).reduce(0, Integer::sum);
        System.out.println(totalBytes);
    }
}
