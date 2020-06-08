package _reference;

/**
 * @author youyinnn
 * Date 3/2/2019
 */
public class TestOne {

    public static void main(String[] args) {
        Dog aDog = new Dog("Max");
        Dog oldDog = aDog;

        // we pass the object to foo
        foo(aDog);
        // aDog variable is still pointing to the "Max" dog when foo(...) returns
        // true
        System.out.println("1 " + aDog.getName().equals("Max"));
        // false
        System.out.println("2 " + aDog.getName().equals("Fifi"));
        // true
        System.out.println("3 " + (aDog == oldDog));;
    }

    public static void foo(Dog d) {
        // true
        System.out.println("4 " + d.getName().equals("Max"));
        // change d inside of foo() to point to a new Dog instance "Fifi"
        d = new Dog("Fifi");
        // true
        System.out.println("5 " + d.getName().equals("Fifi"));
    }

}
