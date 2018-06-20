package algorithm.study.util;

import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

public class LapUtil {
    //private static StopWatch stopWatch = new StopWatch();

    public static void check(Runnable r) {
        StopWatch stopWatch = new StopWatch();
        //stopWatch.reset();
        stopWatch.start();
        r.run();
        System.out.println("elapsed time : " + stopWatch.getTime(TimeUnit.MILLISECONDS));
    }


}
