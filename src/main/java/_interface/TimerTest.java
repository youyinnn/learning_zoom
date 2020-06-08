package _interface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

/**
 * @description:
 * @author: youyinnn
 * @date: 2017/3/3
 */
public class TimerTest {

    public static void main(String[] args) {
        ActionListener listener = new TimePrinter();

        //构造一个定时器 每个
        Timer timer = new Timer(3000,listener);
        timer.start();
        JOptionPane.showMessageDialog(null,"Quit ?");
        System.exit(0);
    }
}

class TimePrinter implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Time is :"+new Date());
        //获得默认的工具箱 包含有关GUI的环境信息 beep()发出一声铃响
        Toolkit.getDefaultToolkit().beep();
    }
}
