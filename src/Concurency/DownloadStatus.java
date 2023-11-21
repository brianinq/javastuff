package Concurency;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DownloadStatus {
    private int totalBytes;
    private final Lock lock = new ReentrantLock();

    public int getTotalBytes() {
        return totalBytes;
    }

    public void incrementTotalBytes() {
        this.totalBytes++;
    }

    // using locks to prevent race conditions
    public void incrementTotalBytesLocked() {
        lock.lock();
        try{
            this.totalBytes++;
        }finally {
            lock.unlock();
        }
    }
}
