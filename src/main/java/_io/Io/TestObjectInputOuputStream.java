package _io.Io;

import org.junit.Test;

import java.io.*;
import java.util.ArrayList;

/**
 * @description:
 * @author: youyinnn
 * @date: 2017/3/9
 */
public class TestObjectInputOuputStream {

    /**
     * 对象的反序列化
     */
    @Test
    public void testObjectInputStream(){
        ObjectInputStream objectInputStream = null;
        try {
            FileInputStream fileInputStream = new FileInputStream("person.txt");
            objectInputStream = new ObjectInputStream(fileInputStream);

            Person person = (Person) objectInputStream.readObject();
            System.out.println(person);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (objectInputStream != null){
                try {
                    objectInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 对象的序列化过程：将内存中的对象通过ObjectOutputStream转换为二进制流 存储在硬盘中
     */
    @Test
    public void testObjectOutputStream(){
        Person person = new Person("汤姆",20);
        Person person1 = new Person("杰瑞",22);

        ArrayList<Person> people = new ArrayList<>();

        people.add(person);
        people.add(person1);

        ObjectOutputStream objectOutputStream = null;

        try {
            objectOutputStream = new ObjectOutputStream(new FileOutputStream("person.txt"));
            for (Person p : people){
                objectOutputStream.writeObject(p);
                objectOutputStream.flush();
            }
        }catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (objectOutputStream != null)
            {
                try {
                    objectOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

/**
 * 实现可序列化的类:1、需要实现接口：Serializable
 *                  2、类的属性也需要实现：Serializable
 *                  3、需要提供一个版本号：private static final long serialVersionUID
 */
class Person implements Serializable{

    private static final long serialVersionUID = 55555555555555L;

    private String name;
    private int age;

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

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

    }

    public Person(String name, int age) {

        this.name = name;
        this.age = age;
    }
}
