package todo.service;

import java.util.concurrent.atomic.AtomicLong;

public class IdGenerationService {
    private static AtomicLong currentId = new AtomicLong(0);

    public static long generateId(){
        return currentId.incrementAndGet();
    }
}
