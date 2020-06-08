package DesignPattern;

/**
 * @author youyinnn
 */
public class SingletonTest {

}

/**
 * 使用静态对象进行预加载来保证线程安全的
 * 一般我们称这样的单例为饿汉式单例 不管三七二十一 一旦加载这个类就创建对象
 * 一般是在第一次引用这个类的时候就加载这个类
 */
class Singleton{
    private Singleton(){}
    private static final Singleton INSTANCE = new Singleton();
    public static Singleton getInstance() {
        return INSTANCE;
    }
}
