package _enum;

/**
 * @description:
 * @author: youyinnn
 * @date: 2017/3/2
 */
public class TestEnum {

    public static void main(String[] args) {
        Size s = Enum.valueOf(Size.class,"SMALL");
        System.out.println(s);
    }
}
