package training.GameStuff;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class DodgeCounter {
    private AtomicInteger a = new AtomicInteger(0);

    AtomicBoolean outsideFlag = new AtomicBoolean(false);

    public synchronized void increment() {
        a.getAndIncrement();
        System.out.println(a);
    }
    public synchronized int get(){
        return a.get();
    }
}
