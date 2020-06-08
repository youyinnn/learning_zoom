package _java8.fi;

import _java8.FiHelper;
import _java8.Person;
import org.junit.Test;

import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * Consumer<T> 消费型接口
 *  void accept(T t);
 *
 * Supplier<T> 供给型接口
 *  T get();
 *
 * Function<T, R> 函数型接口
 *  R apply(T t);
 *
 * Predicate<T> 预测型接口
 *  boolean test(T t);
 *
 * @author youyinnn
 */
public class FiTest {

    @Test
    public void testConsumer(){
        Person p1 = new Person("abc", 12);
        Person p2 = new Person("uiop", 13);

        Consumer<Person> gn = (person) -> System.out.println("Name is : " + person.getName());
        Consumer<Person> ga = (person) -> System.out.println("Age is : " + person.getAge());
        Consumer<Person> gnAndga = gn.andThen(ga);

        FiHelper.accept(p1, gn);
        FiHelper.accept(p2, ga);
        FiHelper.accept(p1, gnAndga);

        gn.accept(p1);
    }

    @Test
    public void testSupplier(){
        Person person = FiHelper.get(Person::new);
        person.setName("asdsa");
        System.out.println(person);
    }

    @Test
    public void testFunction(){
        Person pp = new Person();
        Function<Person, Person> function = (ps) -> {
            System.out.println("nothing change~");
            return ps;
        };
        function = function.compose((ps) -> {
            System.out.println("before");
            ps.setName("xixi");
            return ps;
        });
        function = function.andThen((ps) -> {
            System.out.println("after");
            ps.setAge(15);
           return ps;
        });
        System.out.println(function.apply(pp));

        Person person = new Person();
        System.out.println(FiHelper.<Person, Person>apply(person, (p) -> {
            p.setName("haha");
            p.setAge(15);
            return p;
        }));

        int[] si = {1, 2, 3};
        Function<int[], String[]> f = (ar) -> {
            String[] ss = new String[ar.length];
            for (int i = 0; i < ar.length ; i++) {
                ss[i] = ar[i] + "";
            }
            return ss;
        };
        System.out.println(Arrays.toString(f.apply(si)));
    }

    @Test
    public void testPredicate(){
        Person person = new Person("a", 16);
        System.out.println(FiHelper.test(person, (p) -> p.getAge() > 16));
    }
}
