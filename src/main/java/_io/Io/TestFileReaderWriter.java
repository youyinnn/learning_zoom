package _io.Io;

import org.junit.Test;

import java.io.*;

/**
 * @description:
 * @author: youyinnn
 * @date: 2017/3/7
 */
public class TestFileReaderWriter {

    @Test
    public void testFileReader(){
        File file = new File("111.txt");
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(file);
            char[] buffer = new char[24];
            int len;
            while ((len = fileReader.read(buffer)) != -1){
                String str = new String(buffer,0,len);
                System.out.println(str);
            }
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if (fileReader != null){
                    fileReader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void testFileReaderWriter(){
        File file1 = new File("111.txt");
        File file2 = new File("222.txt");

        FileReader fileReader = null;
        FileWriter fileWriter = null;
        try {
            fileReader = new FileReader(file1);
            fileWriter = new FileWriter(file2);
            char[] buffer = new char[1024];
            int len;
            while ((len = fileReader.read(buffer)) != -1){
                fileWriter.write(buffer,0,len);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (fileReader != null){
                try {
                    fileReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fileWriter != null){
                try {
                    fileWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
