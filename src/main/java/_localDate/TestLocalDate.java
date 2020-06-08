package _localDate;

import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.util.Date;

/**
 * @description: 这是8才有的新的对日期操作的类
 * @author: youyinnn
 * @date: 2017/2/28
 */
public class TestLocalDate{

    public static void main(String[] args) {
        //LocalDate time = LocalDate.of(2015,11,18);
        //
        //System.out.println(time);
        //System.out.println(time.getYear());
        //System.out.println(time.getMonthValue());
        //System.out.println(time.getDayOfMonth());
        ////在time日期上加上1000天 实际是在原time的基础上创建了一个的对象
        //System.out.println(time.plusDays(1000));
        //System.out.println(time);
        //
        ////在time2上加了1000天 实际是修改了对象time2
        //GregorianCalendar time2 = new GregorianCalendar(2015,11,18);
        //time2.add(Calendar.DAY_OF_MONTH,1000);
        //System.out.println(time2.get(Calendar.YEAR));
        //System.out.println(time2.get(Calendar.MONTH));
        //System.out.println(time2.get(Calendar.DAY_OF_MONTH));

        LocalDate time3 = LocalDate.now();
        //System.out.println(time3);

        long aLong = time3.getLong(ChronoField.DAY_OF_YEAR );

        Date date = new Date(aLong);

        System.out.println(date);
    }
}
