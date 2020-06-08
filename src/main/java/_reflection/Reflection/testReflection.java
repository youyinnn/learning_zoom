package _reflection.Reflection;

import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @description:
 * @author: youyinnn
 * @date: 2017/3/19
 */
public class testReflection {

    @Test
    public void test4() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        String className = "_reflection.Reflection.Person";

        Class clazz = Class.forName(className);

        Object object = clazz.newInstance();

        System.out.println(object);
    }

    @Test
    public void test3() throws ClassNotFoundException {

        //1.通过运行时类获取class
        Class<Person> personClass = Person.class;
        System.out.println(personClass);

        Class<String> stringClass = String.class;
        System.out.println(stringClass);

        //2.通过运行时类对象获取class
        Person person = new Person();
        System.out.println(person.getClass().getName());

        //3.通过Class的静态方法获取
        String className = "_reflection.Reflection.Person";
        Class personClass1 = Class.forName(className);
        System.out.println(personClass1);


    }

    @Test
    public void test2(){
        Person p = new Person();

        //通过运行时类的对象 调用getClass方法返回其运行时类
        Class clazz = p.getClass();
        System.out.println(clazz);
    }

    @Test
    public void test1() throws Exception {
        Class clazz = Person.class;

        //1.创建clazz对应的运行时类的Person类的对象
        Person p = (Person) clazz.newInstance();
        System.out.println(p);

        //2.通过反射调用运行时的指定的属性
        Field f1 = clazz.getField("name");
        f1.set(p,"Jack");

        Field f2 = clazz.getDeclaredField("age");
        f2.setAccessible(true);
        f2.set(p,15);
        System.out.println(p);

        //3.通过反射调用运行时的指定的方法
        Method m1 =  clazz.getMethod("show");
        m1.invoke(p);

        Method m2 = clazz.getMethod("display",String.class);
        m2.invoke(p,"China");
    }
}
