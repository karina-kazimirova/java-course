import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Sve on 07.06.2017.
 */
public class Dates {

    public static void main (String[] args) {

        Date date = new Date();
        SimpleDateFormat sf = new SimpleDateFormat();

        sf.applyPattern("MMM dе, hh:mm aaa");
        String dateString = sf.format(date);

        System.out.println(dateString);
    }


}
