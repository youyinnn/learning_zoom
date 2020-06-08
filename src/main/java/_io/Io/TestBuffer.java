package _io.Io;

import org.junit.Test;

import java.io.*;

/**
 * @description:
 * @author: youyinnn
 * @date: 2017/3/8
 */
public class TestBuffer {

    @Test
    public void testBufferedReader(){
        File file = new File("111.txt");
        File file2 = new File("333.txt");
        FileReader fileReader;
        FileWriter fileWriter;
        BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;
        try {
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            fileWriter = new FileWriter(file2);
            bufferedWriter = new BufferedWriter(fileWriter);
            String str;
            while ((str = bufferedReader.readLine()) != null){
                System.out.println(str+"");
                bufferedWriter.write(str);
                bufferedWriter.newLine();
                bufferedWriter.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (bufferedWriter != null){
                try {
                    bufferedWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bufferedReader != null){
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 使用缓冲流来实现非文本文件的复制
     */
    @Test
    public void testBufferInputOutputStream(){
        //1、提供读入写出的文件
        File file1 = new File("picture.png");
        File file2 = new File("picture2.png");

        //2、先创建相应的节点流
        FileInputStream fileInputStream;
        FileOutputStream fileOutputStream;
        BufferedInputStream bufferedInputStream = null;
        BufferedOutputStream bufferedOutputStream = null;

        try {
            fileInputStream = new FileInputStream(file1);
            fileOutputStream = new FileOutputStream(file2);

            //3、将创建的节点流对象作为参数传给缓冲流的构造器中
            bufferedInputStream = new BufferedInputStream(fileInputStream);
            bufferedOutputStream = new BufferedOutputStream(fileOutputStream);

            //4、复制
            byte[] buffer = new byte[1024];
            int len;
            while ((len = bufferedInputStream.read(buffer)) != -1){
                bufferedOutputStream.write(buffer,0,len);
                bufferedOutputStream.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            //5、关闭流
            if (bufferedOutputStream != null){
                try {
                    bufferedOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bufferedInputStream != null){
                try {
                    bufferedInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
