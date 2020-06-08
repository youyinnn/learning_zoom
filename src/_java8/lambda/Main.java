package _java8.lambda;

import _java8.Person;
import org.junit.Test;

import java.util.Comparator;
import java.util.function.Consumer;

/**
 * Lambda表达式:
 * 要点1:
 *  语法必须要函数式接口的支持, 函数式接口即接口中只有一个抽象方法.一般需要@FunctionalInterface注解修饰类.
 *
 * 要点2:
 *  函数式写法格式, 分左右两边:
 *      (param1, param2, ...) -> {statement1;statement2;...;};
 *      左边-参数列表-方法要传递的参数:
 *          (1) 根据泛型可以省略参数列表的类型
 *          (2) 没有参数或者有两个以上参数时必须写`()`, 只有一个参数时可以省略`()`
 *      右边-语句块-表达式要执行的语句:
 *          (1) 如果只有一条语句, 则可以省略`{}`, 多条语句必须要`{}`
 *          (2) 如果有返回值, 且只有一条语句, 则可以`return`, 多条语句必须加return
 *
 * @author youyinnn
 */
public class Main{

    /**
     * 语法格式一: 无参 无返回值
     * 常用场景: 替代匿名内部类;
     *  () -> System.out.println("xixi");
     */
    @Test
    public void test1(){
        Runnable run = new Runnable() {
            @Override
            public void run() {
                System.out.println("xixi1");
            }
        };
        run.run();

        Runnable run2 = () -> System.out.println("xixi2");
        run2.run();
    }

    /**
     * 语法二: 一个参数 无返回值
     * Tips: 一个参数的话 小括号可以省略不写了 甚至可以配合方法引用(如代码中)
     *
     *         Consumer<String> consumer = x -> System.out.println(x);
     *         Consumer<String> consumer = (x) -> System.out.println(x);
     *
     * 常用场景: 和Consumer接口配合
     */
    @Test
    public void test2(){
        Consumer<String> consumer = System.out::println;
        consumer.accept("haha");
    }

    /**
     * 语法三: 两个参数, 有返回值
     * Tips1:
     *  返回值类型在接口方法上已经定义, 参数列表类型已经被泛型规定好了也可以省略,如:
     *          int compare(T o1, T o2);
     *
     * Tips2:
     *  如果实现的方法体中有一条语句, 那么return和大括号可以省略不写
     *
     * Tips3:
     *  如果实现的方法体中有多条语句, 那么必须要大括号和return
     *
     * Tips4:
     *  Comparator接口中已经写好了常用的自然顺序比较或者逆序比较的默认方法可以直接用默认方法引用
     */
    @Test
    public void test3(){
        //Comparator<Integer> comparator = Comparator.reverseOrder();
        Comparator<Integer> comparator = (x, y) -> y.compareTo(x);

        Comparator<Integer> comparator1 = (x, y) -> {
            System.out.println(x + y);
            return y.compareTo(x);
        };
    }

    /**
     * Lambda表达式的高级用法:
     *  (1) 连续泛型指定参数和返回值的类型
     *  (2) 静态方法指定泛型调用
     *  (3) 传递函数式接口
     */
    public static <T, R> R invokeGet(T t1, T t2, MyFunction<T, R> mf) {
        return mf.get(t1, t2);
    }

    @Test
    public void test4(){
        Person p1 = new Person("abc", 12);
        Person p2 = new Person("uiop", 13);
        Integer integer =
                Main.invokeGet(p1, p2, (ax, bx) -> ax.getName().length() + bx.getName().length());
        String s =
                Main.invokeGet(p1, p2, (ax, bx) -> ax.getAge() + " : " + bx.getAge());

        System.out.println(integer);
        System.out.println(s);
    }
}