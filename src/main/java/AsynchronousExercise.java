import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class AsynchronousExercise {

    private static BigInteger calculateFactorial(BigInteger num) {
        BigInteger result = BigInteger.ONE;
        for (BigInteger i = BigInteger.ONE; i.compareTo(num) <= 0; i = i.add(BigInteger.ONE)) {
            result = result.multiply(i);
        }
        return result;
    }

    public static void main(String[] args) {
        String data = "85671 34262 92143 50984 24515 68356 77247 12348 56789 98760";
        String[] dataStringArray = data.split(" ");

        List<BigInteger> dataIntegerArray = Arrays.stream(dataStringArray)
                .map(BigInteger::new)
                .toList();

        String stringToPrint = "mary had a little lamb, its fleece was white as snow";
        String[] stringToPrintArray = stringToPrint.split(" ");

//        for (String word : stringToPrintArray) {
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                System.out.println("Process interrupted");
//            }
//            System.out.println(word);

        CompletableFuture<List<BigInteger>> dataIntegerListFuture = CompletableFuture.supplyAsync(
                () -> dataIntegerArray);

        CompletableFuture<Void> factorialConversionFuture = dataIntegerListFuture
                .thenApply(value -> {
                    return value.stream()
                            .map(AsynchronousExercise::calculateFactorial)
                            .toList();
                })
                .thenAccept(value -> {
                    for (BigInteger number : value) {
                        System.out.println(number);
                    }
                });

        CompletableFuture<String[]> stringToPrintArrayFuture = CompletableFuture.supplyAsync(
                () -> stringToPrintArray);

        CompletableFuture<Void> stringPrinter = stringToPrintArrayFuture
                .thenAccept(value -> {
                    for (String word : value) {
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            System.out.println("Process interrupted");
                            ;
                        }
                        System.out.println(word);
                    }
                });
    }
}
