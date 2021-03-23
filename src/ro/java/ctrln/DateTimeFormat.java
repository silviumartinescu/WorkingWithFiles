package ro.java.ctrln;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateTimeFormat {

    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();

        Date date = calendar.getTime();

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd H:m:ss");

        System.out.println(simpleDateFormat.format(date));

        String someDateString = "2021-04-15 23:34:25";

        try {
            Date someDate = (simpleDateFormat.parse(someDateString));
            System.out.println(someDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
