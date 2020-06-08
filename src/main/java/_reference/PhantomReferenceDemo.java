package _reference;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;

/**
 * @author youyinnn
 * Date 3/3/2019
 */
public class PhantomReferenceDemo {

    private static ReferenceQueue<Person> rq = new ReferenceQueue<>();

    static Person p;
    static Dog d;

    public static void main(String[] args){
        p = new Person("xixi");
        d = new Dog(p, rq, "haha");
        printRQ();
        p = null;
        System.gc();
        waitMoment(2000);
        printRQ();
        System.out.println(d);
    }

    static class Person {
        String name;
        Dog dog;

        public Person(String name) {
            this.name = name;
        }

        public void setDog(Dog dog) {
            this.dog = dog;
        }
    }

    static class Dog extends PhantomReference<Person> {
        String name;
        //Person person;

        public Dog(Person referent, ReferenceQueue<? super Person> q, String name) {
            super(referent, q);
            //this.person = referent;
            this.name = name;
        }

        @Override
        public void clear() {
            super.clear();
            System.out.println("clear dog");
            d = null;
        }
    }


    private static void waitMoment(long time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void printRQ() {
        int size = 0;
        Object obj;
        while ( ( obj = rq.poll() ) != null ) {
            System.out.println("reference: " + obj);
            ((Reference) obj).clear();
            size++;
        }
        System.out.println("size of rq： " + size);
    }
}
