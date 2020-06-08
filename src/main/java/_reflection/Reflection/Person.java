package _reflection.Reflection;

/**
 * @description:
 * @author: youyinnn
 * @date: 2017/3/19
 */
@MyAnnotation("haha")
public class Person extends Creature<String> implements Comparable,MyInterface {
    public String name;
    private int age;
    int id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Person() {
        System.out.println("123");
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    private Person(int age) {
        this.age = age;
    }

    @MyAnnotation("show")
    public void show(){
        System.out.println("Im a person!");
    }

    public void display(String nation) throws Exception{
        System.out.println("My country : "+nation);
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }

    public class Bird{

        String bi ;
        public Bird() {
            this.bi = "bird";
        }
    }

    private int a(String s,int i){
        System.out.println("private method a:"+s);
        return i*10;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", id=" + id +
                '}';
    }
}
