package algorithm.study.util;

import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

public class LapUtil {
    //private static StopWatch stopWatch = new StopWatch();
    private static volatile long executeIndex = 0L;

    public static void check(String message, Runnable r) {
        StopWatch stopWatch = new StopWatch();
        //stopWatch.reset();
        stopWatch.start();
        r.run();
        System.out.println(message);
        System.out.println("elapsed time : " + stopWatch.getTime(TimeUnit.MILLISECONDS));
    }

    public static void check(Runnable r) {
        check("executing method " + executeIndex++, r);
    }


}
