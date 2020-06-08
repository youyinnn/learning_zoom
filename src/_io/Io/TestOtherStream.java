package _io.Io;

import org.junit.Test;

import java.io.*;

/**
 * @description:
 * @author: youyinnn
 * @date: 2017/3/9
 */
public class TestOtherStream {

    /**
     * 数据流 DataOutputStream DataInputStream
     */
    @Test
    public void testData(){
        DataOutputStream dataOutputStream = null;
        DataInputStream dataInputStream = null;
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("data.txt");
            dataOutputStream = new DataOutputStream(fileOutputStream);

            dataOutputStream.writeUTF("[DataOutputStream test!（中文测试）]");
            dataOutputStream.writeBoolean(true);
            dataOutputStream.writeInt(45454644);

            FileInputStream fileInputStream = new FileInputStream("data.txt");
            dataInputStream = new DataInputStream(fileInputStream);

            System.out.println(dataInputStream.readUTF());
            System.out.println(dataInputStream.readBoolean());
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (dataOutputStream != null){
                try {
                    dataOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     *  打印流：PrintStream PrintWriter
     */
    @Test
    public void printStreamWriter(){

    }

    /**
     * 标准的输入输出流
     * 标准的输出流：System.out     PrintStream
     * 标准的输出流：System.in     InputStream
     */
    @Test
    public void testSystemIn(){
        BufferedReader bufferedReader = null;
        try {
            InputStream inputStream = System.in;
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            bufferedReader = new BufferedReader(inputStreamReader);
            String str = null ;
            while ((str = bufferedReader.readLine()) != null){
                System.out.println(str.toUpperCase());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if (bufferedReader != null)
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 转换流：解码、编码
     */
    @Test
    public void testOtherStream(){
        //1、解码
        //2、获取要读取的目标文件
        File file = new File("555.txt");
        FileInputStream fileInputStream;
        InputStreamReader inputStreamReader;
        BufferedReader bufferedReader = null;
        File file1 = new File("666.txt");
        FileOutputStream fileOutputStream;
        OutputStreamWriter outputStreamWriter;
        BufferedWriter bufferedWriter = null;
        try {
            //3、创建字节流
            fileInputStream = new FileInputStream(file);
            //4、创建转换流 将 字节流 转换为 字符流
            inputStreamReader = new InputStreamReader(fileInputStream,"UTF-8");
            //5、使用缓冲流 将 输出字符流
            bufferedReader = new BufferedReader(inputStreamReader);
            String str ;

            //6、创建要输出的文件
            fileOutputStream = new FileOutputStream(file1);
            //7、把字符流转换为字节流（因为str是字符）
            outputStreamWriter = new OutputStreamWriter(fileOutputStream,"UTF-8");
            //8、使用缓冲流 输出文件
            bufferedWriter = new BufferedWriter(outputStreamWriter);
            while ((str = bufferedReader.readLine()) != null){
                System.out.println(str);

                bufferedWriter.write(str);
                bufferedWriter.newLine();
                bufferedWriter.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if (bufferedReader != null) bufferedReader.close();
                if (bufferedWriter != null) bufferedWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
