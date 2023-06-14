package Trabalho02.src;

public class Util {
    public static String convertLongToTime(long time) {
        long nanoseconds = time % 1000000;
        long milliseconds = time / 1000000;
        long seconds = (time / 1000000000) % 60;

        return String.format("%02d:%02d.%03d", seconds, milliseconds, nanoseconds);
    }
}
