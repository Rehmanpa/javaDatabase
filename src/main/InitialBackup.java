package main;

import java.io.*;
import java.util.ArrayList;

/**
 * Created by Jonathan Kipper on 7/30/2019.
 */
public class InitialBackup
{
    //this creates an initial backup every time the program is loaded and saves it to a (current date/time)+backup.txt in the same file
    //directory as the main database file.
    public static void writeInitialBackup() throws IOException, ClassNotFoundException, FileNotFoundException
    {
        FileInputStream fileIn = new FileInputStream(GlobalVariables.DATABASE_FILEPATH);

        String myFilePath = GlobalVariables.DATABASE_FILEPATH;
        myFilePath = myFilePath.replace("Database.data", "Backups Folder");
        GlobalVariables.INITIAL_BACKUP_FILEPATH = myFilePath + "\\"+DateClass.getBackupDate()+"  - Backup.txt";
        //GlobalVariables.INITIAL_BACKUP_FILEPATH = myFilePath;
        File f = new File(myFilePath);

        boolean bool = f.mkdir();
        /*if (bool)
        {
            System.out.println("created successfully");
        }
        else
        {
            System.out.println("Failed");
        }*/

        System.out.println("The file path is (InitialBackup.java class output): " + GlobalVariables.DATABASE_FILEPATH);

        if (fileIn.available() > 0)
        {
            try
            {
                ObjectInputStream objIn = new ObjectInputStream(fileIn);

                while (fileIn.available() > 0)
                {
                    GlobalVariables.INITIAL_RECORDS_BACKUP_LIST = (ArrayList<PersonDataObj>) objIn.readObject();
                }

                System.out.println("new size is: " + GlobalVariables.INITIAL_RECORDS_BACKUP_LIST.size());

                for (PersonDataObj a : GlobalVariables.INITIAL_RECORDS_BACKUP_LIST)
                {
                    System.out.println(a);
                }
            }
            finally
            {
                fileIn.close();
            }

            try
            {
                FileOutputStream fileOut = new FileOutputStream(GlobalVariables.INITIAL_BACKUP_FILEPATH);
                ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
                objectOut.writeObject(GlobalVariables.INITIAL_RECORDS_BACKUP_LIST);
                objectOut.close();
                fileOut.close();
                System.out.println("The backup was written successfully!" + DateClass.getDate());
            } catch (Exception e)
            {
                e.printStackTrace();
            }
        }
    }
}