package _string;

import org.junit.Test;

/**
 * @description:
 * @author: youyinnn
 * @date: 2017/3/15
 */
public class testString {

    @Test
    public void testUsefulMethod(){
        String s1 = "12";
        String s2 = "1";
        String s3 = s2 + "1";
        System.out.println(s1 == s3);
    }

    public static void main(String[] args) {

        String a = "aaa";
        String b = "aaa";
        String c = new String("aaa");
        String d = "aaa"+"bbb";
        String e = "bbb";
        String f = a+e;
        String h = f.intern();
        String i = "aaabbb";

        System.out.println((a == b));//t
        System.out.println((a == c));//f
        System.out.println(a.equals(c));//t

        System.out.println((d == f));//
        System.out.println(d.equals(f));
        System.out.println((h == d));
        System.out.println((d == i));


    }
}
