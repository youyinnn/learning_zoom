package _innerClass;

/**
 * @description:
 * @author: youyinnn
 * @date: 2017/3/4
 */
public class InnerClassTest2 {
    public static void main(String[] args) {
        Person a = new Person("Mary");

        Person b = new Person("Dracula"){
            int age = 10;

            @Override
            public String toString() {
                return "SPerson{name=\'"+getName()+"\',age=\'"+age+"\'}";
            }
        };
        System.out.println(a);
        System.out.println(b);
    }
}

class Person{
    private String name ;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }
}
