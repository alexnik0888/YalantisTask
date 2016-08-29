package alexnik0888.yalantistask.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import alexnik0888.yalantistask.model.Task;

/**
 * Created by Alex on 12.08.2016.
 */
public class DateHelper {
    private static final String FULL_DATE_FORMAT = "d MMMM yyyy";
    private static final String SHORT_DATE_FORMAT = "MMM dd, yyyy";
    private static SimpleDateFormat mShortDateFormatter = new SimpleDateFormat(SHORT_DATE_FORMAT, new Locale("uk", "UA"));
    private static SimpleDateFormat mFULLDateFormatter = new SimpleDateFormat(FULL_DATE_FORMAT, new Locale("uk", "UA"));

    private static final String DAYS = " днів";


    public static String getStringDataFromMillis(long millis) {
        Date date = new Date(millis*1000);
        return mShortDateFormatter.format(date);
    }

    public static String getFullAddress(Task task){
        return task.getUser().getAddress().getCity().getName()+", "+
                task.getUser().getAddress().getStreet().getStreetType().getShortName()+
                task.getUser().getAddress().getStreet().getName()+", "+
                task.getUser().getAddress().getFlat();
    }

    public static String getDaysToDeadLine(long deadlineDate) {
        if (deadlineDate == 0){
            return "";
        }else {
            long difference = deadlineDate*1000 - System.currentTimeMillis();
            long days = difference/(24*60*60*1000);
            return String.valueOf(days)+DAYS;
        }
    }

    public static String getFullDataFromMillis(long millis) {
        if (millis == 0){
            return "";
        }else {
            Date date = new Date(millis * 1000);
            return mFULLDateFormatter.format(date);
        }
    }

}
