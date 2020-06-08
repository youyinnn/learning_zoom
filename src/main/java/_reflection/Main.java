package _reflection;

import java.lang.reflect.Field;
import java.util.Vector;

/**
 * @description:
 * @author: youyinnn
 * @date: 2017/3/21
 */
public class Main {

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {

        Field field = ClassLoader.class.getDeclaredField("classes");

        field.setAccessible(true);

        Vector<Class> classes = (Vector<Class>) field.get(ClassLoader.getSystemClassLoader());

        Person p = new Person();

        Class cc = Person.class;

        for (Class aClass : classes) {
            System.out.println(aClass.getName());
        }

    }
}
