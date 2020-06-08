package mythread;

/**
 * @description:
 * @author: youyinnn
 * @date: 2017/9/20
 */
public class ThreadLocalPropContainer {

    private static ThreadLocal<String>              threadString                    = new ThreadLocal<>();

    private static ThreadLocal<Integer>             threadInteger                   = new ThreadLocal<>();

    public static void setThreadString(String string) {
        threadString.set(string);
    }

    public static String getThreadString(){
        return threadString.get();
    }

    public static void setThreadInteger(Integer integer) {
        threadInteger.set(integer);
    }

    public static Integer getThreadInteger(){
        return threadInteger.get();
    }

}
