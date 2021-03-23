package ro.java.ctrln;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeAPIFormat {
    public static void main(String[] args) {

        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println("Data curenta este: " + localDateTime);

        LocalDate localDate = LocalDate.now();
        System.out.println("Local date este: " + localDateTime);

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MMM-yyyy H:m:ss");
        DateTimeFormatter localDateFormatter = DateTimeFormatter.ofPattern("dd-MMM-yyyy");

        System.out.println(localDateTime.format(dateTimeFormatter));
        System.out.println(localDate.format(localDateFormatter));

        String localDateTimeString = "10-Dec-2020 16:42:27";
        String localDateString = "20-Dec-2020";

        System.out.println("localDateTimeString este: " + LocalDateTime.parse(localDateTimeString, dateTimeFormatter));
        System.out.println("localDateString este: " + LocalDate.parse(localDateString,localDateFormatter));
    }
}
