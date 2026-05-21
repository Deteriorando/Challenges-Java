package dete.Classes.Net;

import java.util.concurrent.atomic.AtomicInteger;

public class ID {
    private static final AtomicInteger count = new AtomicInteger(0);

    public static int GenerateID(){
        return count.getAndIncrement();
    }

    public static AtomicInteger getID() {
        return count;
    }
}
