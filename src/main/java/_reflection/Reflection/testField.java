package _reflection.Reflection;

import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * @description:
 * @author: youyinnn
 * @date: 2017/3/22
 */
public class testField {

    Class clazz = Person.class;

    //获取字段
    @Test
    public void test1(){
        //这个方法只能获取到类和其继承类中的public的字段
        Field[] fields = clazz.getFields();

        for (Field field : fields) {
            field.setAccessible(true);
            System.out.println(field);
        }

        System.out.println("-------------------------");
        //获取运行时类自身定义的所有的字段
        Field[] fields1 = clazz.getDeclaredFields();

        for (Field field : fields1) {
            System.out.println(field.getName());
        }
    }

    //权限修饰符 变量类型 变量名 字段类型
    @Test
    public void test2(){
        //获取运行时类自身定义的所有的字段
        Field[] fields1 = clazz.getDeclaredFields();
        for (Field field : fields1) {
            System.out.println("--------------------");
            System.out.println("字段名:"+field.getName());
            System.out.println("字段所属类的全类名:"+field.getDeclaringClass());
            System.out.println("字段类型:"+field.getGenericType());
            System.out.println("字段权限:"+Modifier.toString(field.getModifiers()));
        }
    }

    //调用运行时类中指定的属性
    @Test
    public void test3() throws Exception {
        //公有字段可以直接用getField获取
        Person person = new Person();
        Field name = clazz.getField("name");
        name.set(person,"Jack");
        System.out.println(person);

        //对应私有字段 必须getDeclaredField 然后 setAccessible 才能访问
        Field age = clazz.getDeclaredField("age");
        age.setAccessible(true);
        age.set(person,20);
        System.out.println(person);

        //保护字段 必须getDeclaredField 然后就可以访问
        Field id = clazz.getDeclaredField("id");
        //但是为了保险起见 还是加上权限访问的设置
        age.setAccessible(true);
        id.set(person,20152222);
        System.out.println(person);
    }

}
