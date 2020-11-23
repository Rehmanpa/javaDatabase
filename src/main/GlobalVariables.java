package main;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jonathan Kipper on 7/30/2019.
 */
public class GlobalVariables
{
    //lists used for data reading and writing
    public static List<PersonDataObj> INITIAL_RECORDS_BACKUP_LIST = new ArrayList<>();
    public static List<PersonDataObj> THE_LIST_OF_RECORDS = new ArrayList<>();
    public static File DATABASE_FILE = null;
    public static String USER_SIGNED_IN = "";
    public static String USER_JOB_ROLE = "";
    public static String DATABASE_FILEPATH = "";
    public static String INITIAL_BACKUP_FILEPATH = "";
    public static final String MAIN_DATE_FORMAT = "MM/dd/yyyy";
}