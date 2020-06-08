package _reflection.Reflection;

import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * @description:
 * @author: youyinnn
 * @date: 2017/3/22
 */
public class testOthers {

    Class clazz = Person.class;

    //获取共有内部类
    @Test
    public void test7(){
        Class[] classes = clazz.getClasses();
        for (Class aClass : classes) {
            System.out.println(aClass);
        }
    }

    @Test
    public void test6(){
        //只有声明为RUNTIME的注解才可以被获取
        Annotation[] annotations = clazz.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println(annotation);
        }
    }

    //获取所在的包
    @Test
    public void test5(){
        Package aPackage = clazz.getPackage();
        System.out.println(aPackage);
    }

    //获取实现的接口
    @Test
    public void test4(){
        Class[] interfaces = clazz.getInterfaces();
        for (Class anInterface : interfaces) {
            System.out.println(anInterface);
        }
    }

    //获取父类的泛型
    @Test
    public void test3(){
        Type type = clazz.getGenericSuperclass();
        ParameterizedType parameterizedType = (ParameterizedType) type;
        Type[] types = parameterizedType.getActualTypeArguments();
        System.out.println(((Class) types[0]).getName());
    }

    //获取带泛型的父类
    @Test
    public void test2(){
        Type type = clazz.getGenericSuperclass();
        System.out.println(type);
    }

    @Test
    public void test(){
        Class su_class = clazz.getSuperclass();
        System.out.println(su_class);
    }
}
