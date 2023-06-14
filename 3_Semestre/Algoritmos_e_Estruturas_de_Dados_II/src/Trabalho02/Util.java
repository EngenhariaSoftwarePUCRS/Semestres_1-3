package Trabalho02;

public class Util {
    public static String convertLongToTime(long time) {
        long nanoseconds = time % 1000000;
        long milliseconds = time / 1000000;
        long seconds = (time / 1000000000) % 60;

        return String.format("%02d:%02d.%03d", seconds, milliseconds, nanoseconds);
    }

    public static void clear(String text) {
        String clear = "";
        for (int i = 0; i < text.length(); i++)
            clear += " ";
        System.out.println("\r" + clear);
    }
}
