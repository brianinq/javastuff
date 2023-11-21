package Concurency;

public class Downloader implements Runnable{
    private final DownloadStatus status =new DownloadStatus();


    @Override
    public void run() {
        System.out.println("Started thread");
        for (int i = 0; i < 10_000; i++) {
            if (Thread.currentThread().isInterrupted()) return;
            status.incrementTotalBytes();
        }
        System.out.println("Download Complete "+ Thread.currentThread().getName());
    }

    public DownloadStatus getStatus() {
        return status;
    }

}
