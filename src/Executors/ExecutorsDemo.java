package Executors;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;

public class ExecutorsDemo {
    public static void main(String[] args) {
        var executor = Executors.newFixedThreadPool(2);
//        try {
//            executor.submit(() -> {
//                System.out.println(Thread.currentThread().getName());
//            });
//        } finally {
//            executor.shutdown();
//        }

        try{
            var future = executor.submit(()->{
                LongTask.simulate();
                return 1;
            });
            System.out.println("Execution Continues to other tasks");
            try {
                var result = future.get();
                System.out.println(result);
            } catch (InterruptedException | ExecutionException e) {
                throw new RuntimeException(e);
            }
        }finally {
            executor.shutdown();
        }
    }
}
