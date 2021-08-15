package oleksii.filonov.interview.tasks.screening;

/**
 * Insert key value,
 * evict entities after expiration time proactively, don't wait when entity will be accessed to check for expiration
 */
public class CacheWithTTL {


    public static void main(String[] args) {
        System.currentTimeMillis();

        new Thread(() -> {
            System.out.println("Bla");
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "Cache Clean Up Thread").start();
    }

}
