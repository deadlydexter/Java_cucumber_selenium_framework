package dataProvider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

public class LogFile {
    private static final Logger Log = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass().getSimpleName());

//    private static final Logger Log = LoggerFactory.getLogger(LogFile.class);

    public static void startTestCase(String sTestCaseName) {

        Log.info("-------------------------------------------");
        Log.info(sTestCaseName);
        Log.info("-------------------------------------------");
    }

    public static void endTestCase(String sTestCaseName) {


        Log.info(sTestCaseName);
        Log.info("-------------------------------------------");
    }

    public static void info(String message) {
        Log.info(message);
    }

    public static void error(String message) {
        Log.error(message);
    }

    public static void error(String message, Exception e) {
        Log.error(message, e);
    }

    public static void fatal(String message) {

    }

    public static void debug(String message) {
        Log.debug(message);
    }
}
