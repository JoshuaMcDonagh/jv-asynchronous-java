import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        CompletableFuture<Void> helloWorldFuture = CompletableFuture.runAsync(() ->{
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Hello world!");
        });

        helloWorldFuture.join();
    }
}
