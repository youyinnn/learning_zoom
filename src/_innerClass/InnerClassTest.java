package _innerClass;

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
public class InnerClassTest{
    public static void main(String[] args) {
        TalkingClock clock = new TalkingClock();
        clock.start(3000,true);

        JOptionPane.showMessageDialog(null,"Quit !");
        System.exit(0);
    }
}

class TalkingClock {

    //public void start(int interval, boolean beep){
    //    //局部内部类
    //    class TimePrinter implements ActionListener{
    //        @Override
    //        public void actionPerformed(ActionEvent e) {
    //            System.out.println("Time is :"+new Date());
    //            if (beep) Toolkit.getDefaultToolkit().beep();
    //        }
    //    }
    //    ActionListener listener = new TimePrinter();
    //    Timer t = new Timer(interval,listener);
    //    t.start();
    //}

    public void start(int interval, boolean beep){
        //anonymous inner class
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Time is :"+new Date());
                if (beep) Toolkit.getDefaultToolkit().beep();
            }
        };
        Timer t = new Timer(interval,listener);
        t.start();
    }

    //public class TimePrinter implements ActionListener{
    //    @Override
    //    public void actionPerformed(ActionEvent e) {
    //        System.out.println("Time is :"+new Date());
    //        if (beep) Toolkit.getDefaultToolkit().beep();
    //        //实际的外围类引用语法
    //        //if (TalkingClock.this.beep) Toolkit.getDefaultToolkit().beep();
    //    }
    //}
}
