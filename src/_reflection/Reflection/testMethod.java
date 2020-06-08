package _reflection.Reflection;

import org.junit.Test;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

/**
 * @description:
 * @author: youyinnn
 * @date: 2017/3/22
 */
public class testMethod {

    Class clazz = Person.class;

    @Test
    public void test1(){
        //获取运行时类和其父类中声明的所有的public方法
        Method[] m1 = clazz.getMethods();
        for (Method method : m1) {
            System.out.println("--------------");
            System.out.println(method);
        }

        //获取运行时类本身所有的方法
        Method[] m2 = clazz.getDeclaredMethods();
        for (Method method : m2) {
            System.out.println("++++++++++++++");
            System.out.println(method);
        }
    }

    //获取自身方法的 注解 权限 返回值类型 方法名 形参表 throws的异常
    @Test
    public void test2(){
        //获取运行时类本身所有的方法
        Method[] m2 = clazz.getDeclaredMethods();
        for (Method method : m2) {
            System.out.println("---------------");
            System.out.println("方法全名:"+method);
            System.out.println("异常类型:"+ Arrays.toString(method.getGenericExceptionTypes()));
            System.out.println("参数:"+Arrays.toString(method.getParameters()));
            System.out.println("方法名:"+method.getName());
            System.out.println("返回值类型:"+method.getGenericReturnType());
            System.out.println("权限:"+ Modifier.toString(method.getModifiers()));
            System.out.println("注解:"+Arrays.toString(method.getDeclaredAnnotations()));
        }
    }

    @Test
    public void test3() throws Exception {
        Method show = clazz.getMethod("show");
        Person person = new Person("Mike",20);
        Object return_val = show.invoke(person);//方法中有打印
        System.out.println(return_val);//没有返回值

        System.out.println("----------------------");

        Method toString = clazz.getMethod("toString");
        Object return_val1 = toString.invoke(person);//方法中没有打印
        System.out.println(return_val1);//方法返回String

        System.out.println("----------------------");
        //基本数据类型也可以.class
        Method a = clazz.getDeclaredMethod("a",String.class,int.class);
        a.setAccessible(true);
        System.out.println(a);

        Object invoke = a.invoke(person,"AAA",2);
        System.out.println(invoke);
    }

}
