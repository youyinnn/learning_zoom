package _time;

import org.junit.Test;

import java.time.LocalTime;
import java.time.temporal.ChronoField;

/**
 * @description:
 * @author: youyinnn
 * @date: 2017/3/17
 */
public class testLocalTime {

    @Test
    public void testTime(){

        LocalTime start = LocalTime.now();
        //try {
        //    Thread.sleep(1000);
        //} catch (InterruptedException e) {
        //    Thread.interrupted();
        //}
        LocalTime end = LocalTime.now();
        System.out.println(start);
        //System.out.println(end);

        System.out.println("nano of second:"+start.getLong(ChronoField.NANO_OF_SECOND));
        System.out.println("nano of day:"+start.getLong(ChronoField.NANO_OF_DAY));
        System.out.println("micro of second:"+start.getLong(ChronoField.MICRO_OF_SECOND));
        System.out.println("micro of day:"+start.getLong(ChronoField.MICRO_OF_DAY));
        System.out.println("milli of second:"+start.getLong(ChronoField.MILLI_OF_SECOND));
        System.out.println("milli of day:"+start.getLong(ChronoField.MILLI_OF_DAY));
        System.out.println("second of min:"+start.getLong(ChronoField.SECOND_OF_MINUTE));
        System.out.println("second of day:"+start.getLong(ChronoField.SECOND_OF_DAY));
        System.out.println("hour of day:"+start.getLong(ChronoField.HOUR_OF_DAY));
        System.out.println("minute of hour:"+start.getLong(ChronoField.MINUTE_OF_HOUR));


    }
}
