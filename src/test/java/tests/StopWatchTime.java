package tests;

import org.apache.commons.lang.time.StopWatch;
import org.testng.Reporter;

public class StopWatchTime extends StopWatch {

    static StopWatch stopWatch = new StopWatch();

    public static void timeTaken() {
        long x = stopWatch.getTime();
        String numberAsString = Long.toString(x);

        System.out.println("Execution time for this method: " + numberAsString + "milliseconds \n");

        Reporter.log("time taken to execute this method : " + numberAsString + "milliseconds \n");
    }

    public static void start(String nmsLoginMapMethod) {

        stopWatch.start();

        Reporter.log(nmsLoginMapMethod+ ";\n");
    }
    public static void stop(String nmsLoginMapMethod) {

        stopWatch.stop();

        Reporter.log(nmsLoginMapMethod+ ";\n");
    }

    public static void reset(String nmsLoginMapMethod) {
        stopWatch.reset();

        Reporter.log(nmsLoginMapMethod + ";\n");
    }


}
