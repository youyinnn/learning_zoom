package _java8;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * @author youyinnn
 */
public class FiHelper {

    public static <T> void accept(T t, Consumer<T> consumer) {
        consumer.accept(t);
    }

    public static <T> T get(Supplier<T> supplier) {
        return supplier.get();
    }

    public static <T, R> R apply(T t,Function<T, R> function) { return function.apply(t);}

    public static <T> boolean test(T t, Predicate<T> predicate) {
        return predicate.test(t);
    }
}
