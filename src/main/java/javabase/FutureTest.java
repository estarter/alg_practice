package javabase;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.Function;

import org.junit.jupiter.api.Test;

public class FutureTest {

    private Function<String, String> sup = (id) -> {
        System.out.println("start " + id);
        try {
            Thread.sleep(new Random().nextInt(2000));
        } catch (InterruptedException e) {
            System.out.println("interrupt process " + id);
        }
        System.out.println("complete " + id);
        return id;
    };

    @Test
    void testCompletableFuture() throws ExecutionException, InterruptedException {
        CompletableFuture cf = CompletableFuture.anyOf(CompletableFuture.supplyAsync(() -> sup.apply("1")),
                CompletableFuture.supplyAsync(() -> sup.apply("2")),
                CompletableFuture.supplyAsync(() -> sup.apply("3")));
        System.out.println("cf = " + cf.get());

        CompletableFuture<Void> a1 = CompletableFuture.supplyAsync(() -> sup.apply("a1"))
                                                      .thenAccept((res) -> System.out.println("res = " + res));
        a1.get(); // it would cancel a1 without #get() call

    }

    @Test
    void testCompletableFuture2() throws ExecutionException, InterruptedException {
        CompletableFuture<String> a2 = CompletableFuture.supplyAsync(() -> sup.apply("a2"));
        a2.complete("a22");
        System.out.println("a2 = " + a2.get());
    }

    @Test
    void testCompletableFuture3() throws ExecutionException, InterruptedException {
        CompletableFuture<String> c = CompletableFuture.supplyAsync(() -> sup.apply("c1"));
        c.thenRunAsync(() -> sup.apply("c2")).get();
        System.out.println("a2 = " + c.get());
    }
}
