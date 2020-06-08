package _operators;

import org.junit.Test;

/**
 * @author youyinnn
 */
public class Main {

    public static void main(String[] args) {
        int i = 2;
        i += i -= i *= i;
        System.out.println(i);
    }

    @Test
    public void test(){
        int i = 6;
        i = -i;
        System.out.println(i);
        i = +i;
        System.out.println(i);
    }

    @Test
    public void testShift(){
        int a = 8;
        int b = 7;
        int c = -1;
        System.out.println(a >> 1);
        System.out.println(a >> 2);
        System.out.println(b << 1);
        System.out.println(b << 2);
        System.out.println(c >> 1);
        System.out.println(c >>> 1);
        System.out.println(c >>> 2);

        System.out.println(-9 >>> 4);
    }

    @Test
    public void testUse(){
        System.out.println(3 & 1);
        System.out.println(2 & 1);

        System.out.println(~8 + 1);

        int a = 999;
        int b = 888;
        a ^= b;
        b ^= a;
        a ^= b;
        System.out.println(a);
        System.out.println(b);
    }

    @Test
    public void testBitMask(){
        // Mask: 0000 1111 0000 -> 0x0F0 -> 240
        int mask = 0x0F0;
        // Record: 0111 0011 1111 -> 0x73F -> 1855
        int record = 0x73F;
        int status;
        // check
        status = record & mask;
        System.out.println(status);
        // clear
        status = record & ~mask;
        System.out.println(status);
        // set
        status = record & ~mask | 0x060;
        System.out.println(status);
    }
}
