package main;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Jonathan Kipper on 7/30/2019.
 */
public class DateClass
{
    public static String getDate()
    {
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        Date dateObj = new Date();
        return dateFormat.format(dateObj);
    }

    public static String getSimpleDate()
    {
        DateFormat dateFormat = new SimpleDateFormat(GlobalVariables.MAIN_DATE_FORMAT); //"MM/dd/yyyy"
        Date dateObj = new Date();
        return dateFormat.format(dateObj);
    }

    //the date format for the backup file name
    public static String getBackupDate()
    {
        DateFormat dateFormat = new SimpleDateFormat("MM_dd_yyyy HH_mm_ss");
        Date dateObj = new Date();
        return dateFormat.format(dateObj);
    }

    /**
     * Checks to see if the date matches along the format "MM/dd/yyyy"
     * @param input an input string which is the date to check
     * @return True means the date is in the right format, false means it's not in the right format.
     */
    public static boolean isValidDate(String input)
    {
        String regex = "^(1[0-2]|0[1-9])/(3[01]|[12][0-9]|0[1-9])/[0-9]{4}$";
        Pattern pattern = Pattern.compile(regex);

        Matcher matcher = pattern.matcher(input);

        return matcher.matches();
    }
}