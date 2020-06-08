package _string;

import org.junit.Test;

/**
 * @description:
 * @author: youyinnn
 * @date: 2017/3/16
 */
public class testStringBuffer {

    @Test
    public void testStringBuffer(){

        String b = "";
        System.out.println(b.length());

        char[] c = new char[0];
        System.out.println(c.length);

        StringBuffer s = new StringBuffer();
        s.append("abc");
        System.out.println(s);
    }
}
