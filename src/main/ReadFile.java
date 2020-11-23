package main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

/**
 * Created by Jonathan Kipper on 7/29/2019. Contains the readFile method, opens the database file and sets the_list_of_records arraylist
 * equal to all of the values inside of the file.
 */
public class ReadFile
{
    //reads the file
    public static void readFile() throws IOException, FileNotFoundException, ClassNotFoundException
    {
        System.out.println("THE FILE PATH IS (ReadFile.Java Class output):" + GlobalVariables.DATABASE_FILEPATH);
        FileInputStream fileIn = new FileInputStream(GlobalVariables.DATABASE_FILEPATH);
        System.out.println(fileIn.available());

        if (fileIn.available() > 0)
        {
            try
            {
                ObjectInputStream objIn = new ObjectInputStream(fileIn);
                GlobalVariables.THE_LIST_OF_RECORDS.clear();

                while (fileIn.available() > 0)
                {
                    GlobalVariables.THE_LIST_OF_RECORDS = (ArrayList<PersonDataObj>) objIn.readObject();
                }

                for (PersonDataObj meme : GlobalVariables.THE_LIST_OF_RECORDS)
                {
                    System.out.println(meme);
                }
            }
            finally
            {
                fileIn.close();
            }
        }
    }

    //loads up very specific file and reads it out.
   public static void readCertainFile(String filePath, ArrayList<PersonDataObj> myObjArray) throws FileNotFoundException, IOException, ClassNotFoundException
   {
       FileInputStream fileIn = new FileInputStream(filePath);
       try
       {
           ObjectInputStream objIn = new ObjectInputStream(fileIn);
           while (fileIn.available() > 0)
           {
               myObjArray = (ArrayList<PersonDataObj>) objIn.readObject();
           }

           for (PersonDataObj a : myObjArray)
           {
               System.out.println(a);
           }
       }
       finally
       {
           fileIn.close();
       }
   }
}