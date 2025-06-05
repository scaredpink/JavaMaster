package i.love.wsq;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) {
        String timeStr = "1749051501470";

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        String dateTime = dateTimeFormatter.format();
        System.out.println(dateTime);

        System.out.println();
    }

}
