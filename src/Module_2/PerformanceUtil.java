package Module_2;

public class PerformanceUtil {

    public static long measure(Runnable task) {
        long start = System.nanoTime();
        task.run();
        long end = System.nanoTime();
        return end - start;
    }
}