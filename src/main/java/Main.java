import java.sql.Time;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class Main {
    public static void main(String[] args) {
        // Task One
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
//        CompletableFuture<Void> helloFuture = CompletableFuture.runAsync(() -> {
//            try {
//                Thread.sleep(3000);
//            } catch (InterruptedException e) {
//               e.printStackTrace();
//            }
//
//            System.out.println("Hello ");
//        });
//
//        CompletableFuture<Void> worldFuture = CompletableFuture.runAsync(() -> {
//            try {
//                Thread.sleep(5000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//
//            System.out.println("world!");
//        });
//
//        helloFuture.join();
//        worldFuture.join();

        // Task Three
//        CompletableFuture<String> helloFuture = CompletableFuture.supplyAsync(() -> {
//            try {
//                Thread.sleep(3000);
//            } catch (InterruptedException e) {
//               e.printStackTrace();
//            }
//
//            return "Hello ";
//        });
//
//        CompletableFuture<String> worldFuture = CompletableFuture.supplyAsync(() -> {
//            try {
//                Thread.sleep(5000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//
//            return "world!";
//        });
//
//        CompletableFuture<String> helloWorldCombinedFuture = helloFuture.thenCombine(worldFuture, (f1, f2) -> f1 + f2);
//
//        System.out.println(helloWorldCombinedFuture.join());

        // Task Four
//        Random randomNumber = new Random();
//        int threadSleepTimeHello = randomNumber.nextInt(1000, 10000);
//        int threadSleepTimeWorld = randomNumber.nextInt(1000, 10000);
//
//        CompletableFuture<String> helloFuture = CompletableFuture.supplyAsync(() -> {
//
//            try {
//                Thread.sleep(threadSleepTimeHello);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//
//            return "Hello ";
//        });
//
//        CompletableFuture<String> worldFuture = CompletableFuture.supplyAsync(() -> {
//            try {
//                Thread.sleep(threadSleepTimeWorld);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//
//            return "world!";
//        });
//
//        CompletableFuture<String> helloWorldCombinedFuture = helloFuture.thenCombine(worldFuture, (f1, f2) -> f1 + f2);
//
//        try {
//            System.out.println(helloWorldCombinedFuture.get(10, TimeUnit.SECONDS));
//        } catch(InterruptedException | ExecutionException | TimeoutException e) {
//            System.out.println(
//                    "Threads did not return results in time.\n"
//                    +"Hello thread took: "
//                    +threadSleepTimeHello
//                    +"\nWorld thread took: "
//                    + threadSleepTimeWorld
//            );
//        }
//    }

        // Task Six (after the task update...)
        Random randomNumber = new Random();
        int threadSleepTimeHello = randomNumber.nextInt(1000, 10000);
        int threadSleepTimeWorld = randomNumber.nextInt(1000, 10000);

        CompletableFuture<String> helloFuture = CompletableFuture.supplyAsync(() -> {

            try {
                Thread.sleep(threadSleepTimeHello);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            return "Hello ";
        });

        CompletableFuture<String> worldFuture = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(threadSleepTimeWorld);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            return "world!";
        });

        CompletableFuture<Void> helloWorldCombinedFuture = helloFuture
                .thenCombine(worldFuture, (f1, f2) -> f1 + f2)
                .thenAccept(System.out::println);

        helloWorldCombinedFuture.join();
    }
}
