import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
//        Task One
//        CompletableFuture<Void> helloWorldFuture = CompletableFuture.runAsync(() ->{
//            try {
//                Thread.sleep(2000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//
//            System.out.println("Hello world!");
//        });
//
//        helloWorldFuture.join();

        // Task Two
        CompletableFuture<Void> helloFuture = CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
               e.printStackTrace();
            }

            System.out.println("Hello ");
        });

        CompletableFuture<Void> worldFuture = CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("world!");
        });

        helloFuture.join();
        worldFuture.join();
    }
}
