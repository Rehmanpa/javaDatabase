package main;

import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Basically this is just for testing purposes only, it loads in a .data file with the PersonDataObj's and displays them to the console (not completely up to date yet)
 */
public class ExternalDataViewer
{
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException
    {
        dataWriter();
        dataViewer();
    }

    public static void dataWriter() throws FileNotFoundException, IOException, ClassNotFoundException
    {
        JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        jfc.setDialogTitle("Data File Writer");
        jfc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        jfc.setAcceptAllFileFilterUsed(false);

        if (jfc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
        {
            PersonDataObj myObjectMemeDank = new PersonDataObj("Additional Skywalker", "dank", "wow", "stuff", "memes", "i", "hate", "this", "so",
                    "much", "right", "now", "it's", "wow", "awful", "i'm", "kms");
            PersonDataObj testStuff = new PersonDataObj("Darth Vader", "dank", "wow", "stuff", "memes", "i", "hate", "this", "so",
                    "much", "right", "now", "it's", "wow", "awful", "i'm", "kms");
            PersonDataObj you = new PersonDataObj("The Emperor", "dank", "wow", "stuff", "memes", "i", "hate", "this", "so",
                    "much", "right", "now", "it's", "wow", "awful", "i'm", "kms");
            PersonDataObj eck = new PersonDataObj("Han Solo", "dank", "wow", "stuff", "memes", "i", "hate", "this", "so",
                    "much", "right", "now", "it's", "wow", "awful", "i'm", "kms");
            PersonDataObj why = new PersonDataObj("Obama", "dank", "wow", "stuff", "memes", "i", "hate", "this", "so",
                    "much", "right", "now", "it's", "wow", "awful", "i'm", "kms");
            PersonDataObj dipShit = new PersonDataObj("Someone Else", "dank", "wow", "stuff", "memes", "i", "hate", "this", "so",
                    "much", "right", "now", "it's", "wow", "awful", "i'm", "kms");

            ArrayList<PersonDataObj> viewFile = new ArrayList<>();

            viewFile.add(myObjectMemeDank);
            viewFile.add(testStuff);
            viewFile.add(you);
            viewFile.add(eck);
            viewFile.add(why);
            viewFile.add(dipShit);

            String tmpPath = "C:\\Users\\Jonathan.CNP\\Desktop\\Project Testing Shit\\Database.data";
            WriteFile.writeCertainRecordToFile(viewFile, tmpPath);

            ReadFile.readCertainFile(jfc.getSelectedFile().getAbsolutePath(), viewFile);
        }
    }

    public static void dataViewer() throws FileNotFoundException, IOException, ClassNotFoundException
    {
        JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        jfc.setDialogTitle("Data File Viewer");
        jfc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        jfc.setAcceptAllFileFilterUsed(false);

        if (jfc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
        {
            ArrayList<PersonDataObj> viewFile = new ArrayList<>();
            ReadFile.readCertainFile(jfc.getSelectedFile().getAbsolutePath(), viewFile);
        }
    }
}