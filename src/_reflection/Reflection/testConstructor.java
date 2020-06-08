package _reflection.Reflection;

import org.junit.Test;

import java.lang.reflect.Constructor;

/**
 * @description:
 * @author: youyinnn
 * @date: 2017/3/22
 */
public class testConstructor {

    Class clazz = Person.class;

    //返回运行时类的所有构造器
    @Test
    public void test(){
        Constructor[] constructors = clazz.getDeclaredConstructors();
        for (Constructor constructor : constructors) {
            System.out.println(constructor);
        }
    }

    //调用指定的构造器
    @Test
    public void test2() throws Exception {
        Constructor c1 = clazz.getDeclaredConstructor(String.class, int.class);
        c1.setAccessible(true);
        Object o = c1.newInstance("张三",20);
        System.out.println(o);
    }
}
