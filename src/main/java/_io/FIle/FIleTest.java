package _io.FIle;

import java.io.File;

/**
 * @description:
 * @author: youyinnn
 * @date: 2017/3/6
 */
public class FIleTest {

    public static void main(String[] args) {
        //文件
        File file1 = new File("D:/Users/大黄/workspace/Learning_zoom/io/123.txt");
        //文件夹
        File file2 = new File("D:\\Users\\大黄\\workspace\\Learning_zoom\\io");

        System.out.println(file1.getName());
        System.out.println(file1.getPath());
        System.out.println(file1.getAbsoluteFile());
        System.out.println(file1.getAbsolutePath());
        System.out.println(file1.getParent());


        System.out.println("------------------------");
        System.out.println(file2.getName());
        System.out.println(file2.getPath());
        System.out.println(file2.getAbsoluteFile());
        System.out.println(file2.getAbsolutePath());
        System.out.println(file2.getParent());

        //重命名file1.renameTo(file2) 要求file1必须存在 file2必须不存在
        //System.out.println(file1.renameTo(new File("456.txt")));


    }
}
