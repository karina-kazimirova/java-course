package ConvertDate;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Sve on 10.06.2017.
 */
public class ConvertDate {

    public static void main (String[] args) {

        String dateString = "2017-06-05 20:25";

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");

        Date date = null;
        try {
            date = formatter.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(formatter.format(date));


    }
}
