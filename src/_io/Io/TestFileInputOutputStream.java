package _io.Io;

import org.junit.Test;

import java.io.*;

/**
 * @description:
 * @author: youyinnn
 * @date: 2017/3/7
 */
public class TestFileInputOutputStream {

    @Test
    public void testFileInputStream() {
        File file = new File("D:\\Users\\大黄\\workspace\\Learning_zoom\\123.txt");
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(file);
            int b ;
            while ( (b= fileInputStream.read()) != -1){
                System.out.print((char)b);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }    @Test
    public void testFileInputStream2() {
        File file = new File("D:\\Users\\大黄\\workspace\\Learning_zoom\\123.txt");
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(file);
            byte[] buffer = new byte[1024]; //读到的数据放入的数组
            int len ; //每次读入到byte数组中的字节的长度
            while ( (len = fileInputStream.read(buffer)) != -1){
                String str = new String(buffer,0,len);
                System.out.println(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void testOutputStream(){
        //创建一个file对象 表明要写入的位置 输出的物理文件可以不存在 不存在就会新创建一个 存在则将源文件覆盖
        File file = new File("456.txt");
        FileOutputStream fileOutputStream = null;
        try{
            fileOutputStream = new FileOutputStream(file);
            fileOutputStream.write("[hello world 456.txt]".getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void testInputOutputStream(){
        File file1 = new File("123.txt");
        File file2 = new File("789.txt");

        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        try {
            fileInputStream = new FileInputStream(file1);
            fileOutputStream = new FileOutputStream(file2);

            byte[] buffer = new byte[1024];
            int len;
            while ((len = fileInputStream.read(buffer)) != -1){
                fileOutputStream.write(buffer,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if (fileInputStream != null){
                    fileInputStream.close();
                }
                if (fileOutputStream != null){
                    fileOutputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
