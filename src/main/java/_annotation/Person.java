package _annotation;

/**
 * @description:
 * @author: youyinnn
 * @date: 2017/2/28
 */
@MyAnnotation(value = "456")
public class Person {

    String name;
    int age;

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public Person() {
    }

    @MyAnnotation(value = "456")
    public Person(String name, int age) {

        this.name = name;
        this.age = age;
    }
}
