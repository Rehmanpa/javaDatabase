package main;

import javax.swing.*;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 * Created by Jonathan Kipper on 7/29/2019.
 */
public class WriteFile
{
    /**
     * all this does is write the arraylist with all the objects to the file, clearing the original (to update the database information)
     */
    public static void writeRecords()
    {
        try
        {
            //MIGHT HAVE TO ADD ,TRUE TO THE OPTION IN CASE THE FILE NEEDS TO BE APPENDED
            FileOutputStream fileOut = new FileOutputStream(GlobalVariables.DATABASE_FILEPATH);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(GlobalVariables.THE_LIST_OF_RECORDS);
            objectOut.close();
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public static void writeCertainRecordToFile(ArrayList<PersonDataObj> myPersonDataObject, String filePath)
    {
        try
        {
            //MIGHT HAVE TO ADD ,TRUE TO THE OPTION IN CASE THE FILE NEEDS TO BE APPENDED
            FileOutputStream fileOut = new FileOutputStream(filePath);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(myPersonDataObject);
            objectOut.close();
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}