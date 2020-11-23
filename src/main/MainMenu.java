package main;

import com.google.common.collect.*;
import org.apache.commons.collections4.MultiSet;
import org.apache.commons.collections4.multiset.HashMultiSet;
import org.apache.commons.io.FilenameUtils;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileSystemView;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Map;
import java.util.Set;

/**
 * Created by Jonathan Kipper on 7/23/2019.
 */
public class MainMenu extends JFrame
{
    private JTabbedPane tabbedPane1;
    private JButton exitButton;
    private JButton signInButton;
    private JButton signOutButton;
    private JButton cancelButton;
    private JButton saveButton1;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField4;
    private JTextField textField5;
    private JTextField textField6;
    private JTextField textField7;
    private JTextField textField8;
    private JTextField textField9;
    private JTextField textField10;
    private JTextField textField11;
    private JTextField textField12;
    private JTextField textField13;
    private JTextField textField14;
    private JTextField textField15;
    private JTextField textField16;
    private JRadioButton maleRadioButton;
    private JRadioButton femaleRadioButton;
    private JTable table1;
    private JSpinner spinner1;
    private JButton viewRecordButton;
    private JButton deleteRecordButton;
    private JButton printRecordButton;
    private JLabel signedInAsLabel;
    private JLabel zipCodeLabel;
    private JLabel primaryPhoneLabel;
    private JLabel secondaryPhoneLabel;
    private JLabel reasonForNeedLabel;
    private JLabel personOfColorLabel;
    private JLabel dateScreenedLabel;
    private JLabel dateInterviewedLabel;
    private JLabel screenerNameLabel;
    private JLabel interviewerNameLabel;
    private JLabel commentsLabel;
    private JLabel firstNameLabel;
    private JLabel lastNameLabel;
    private JLabel genderLabel;
    private JLabel addressLabel;
    private JLabel cityLabel;
    private JLabel stateLabel;
    private JPanel ViewDatabase;
    private JScrollPane scrollPane1;
    private JRadioButton yesColorRadioButton;
    private JRadioButton noColorRadioButton;
    private JButton generateExcelFileButton;
    private JButton printSelectRangeButton;
    private JCheckBox singleParentCheckBox;
    private JCheckBox veteranCheckBox;
    private JCheckBox disabledCheckBox;
    private JCheckBox employedCheckBox;
    private JTextField textField3;
    private JSpinner spinner2;
    private JSpinner spinner3;
    private JPanel newClientPanel;
    private MyTableModel model;
    private final String[] col = new String[]{"First Name", "Last Name", "Sex", "Age", "Address", "City", "State", "Zip", "Phone", "2nd Phone", "Reason",
            "Color", "Screened", "Interviewed", "Screener Name", "Interviewer Name", "Comments"};

    public MainMenu(String title, int width, int height) throws HeadlessException
    {
        super(title);

        //first page stuff
        signedInAsLabel.setText("Signed in as: "+GlobalVariables.USER_SIGNED_IN+"       Job Title: " + GlobalVariables.USER_JOB_ROLE);
        signOutButton.setEnabled(false);
        signInButton.setEnabled(true);
        exitButton.setEnabled(true);

        //second page stuff
        Integer defaultAge = 20;
        spinner1.setValue(defaultAge);

        //for the scrollbar shit i guess idek
        tabbedPane1.setAutoscrolls(true);
        setContentPane(tabbedPane1);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();

        table1.repaint();
        repaint();

        //frame setting shit
        repaint();
        setSize(width, height);
        setLocationRelativeTo(null);
        setVisible(true);

        //THESE ARE ALL OF THE ACTION EVENT LISTENERS (A LOT OF CODE)
        
        //THE FIRST SCREEN'S ACTION LISTENERS:
        //main screen sign in button 
        signInButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                if (!signOutButton.isEnabled())
                {
                    String username = JOptionPane.showInputDialog(null, "What is your name?", "Sign in",JOptionPane.PLAIN_MESSAGE);
                    Object[] choices = {"Screener", "Interviewer"};
                    int n = JOptionPane.showOptionDialog(null, "What is your job?", "Please enter your job", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, choices, choices[0]);

                    if (n == 0)
                    {
                        GlobalVariables.USER_JOB_ROLE = "Screener";
                        signedInAsLabel.setText("Signed in as " + username + "          Job: Screener");
                        JOptionPane.showMessageDialog(null,"Signed in as " + username + " with job Screener");
                    }
                    else
                    {
                        GlobalVariables.USER_JOB_ROLE = "Interviewer";
                        signedInAsLabel.setText("Signed in as " + username + "          Job: Interviewer");
                        JOptionPane.showMessageDialog(null,"Signed in as " + username + " with job Interviewer");
                    }

                    GlobalVariables.USER_SIGNED_IN = username;
                    signInButton.setEnabled(false);
                    signOutButton.setEnabled(true);

                    //prefills in interviewer/screener name and date
                    if (GlobalVariables.USER_JOB_ROLE.equalsIgnoreCase("Screener"))
                    {
                        textField14.setText(GlobalVariables.USER_SIGNED_IN);
                        textField12.setText(DateClass.getSimpleDate());
                    }
                    else if (GlobalVariables.USER_JOB_ROLE.equalsIgnoreCase("Interviewer"))
                    {
                        textField15.setText(GlobalVariables.USER_SIGNED_IN);
                        textField13.setText(DateClass.getSimpleDate());
                    }
                }
            }
        });
        //main screen signout button
        signOutButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                if (!signInButton.isEnabled())
                {
                    int n = JOptionPane.showConfirmDialog(null, "Are you sure you want to sign out?","Sign out", JOptionPane.WARNING_MESSAGE);
                    if (n == 0)
                    {
                        GlobalVariables.USER_SIGNED_IN = "";
                        GlobalVariables.USER_JOB_ROLE = "";
                        signedInAsLabel.setText("Signed in as: "+GlobalVariables.USER_SIGNED_IN+"       Job Title: " + GlobalVariables.USER_JOB_ROLE);
                        JOptionPane.showMessageDialog(null, "You have now signed out. Have a nice day!");
                        signInButton.setEnabled(true);
                        signOutButton.setEnabled(false);
                    }
                }
            }
        });
        //main screen exit button 
        exitButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                int n = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit the program?", "Exit program", JOptionPane.WARNING_MESSAGE);
                if (n == 0)
                {
                    if (!GlobalVariables.USER_JOB_ROLE.equalsIgnoreCase(""))
                    {
                        GlobalVariables.USER_JOB_ROLE = "";
                        GlobalVariables.USER_SIGNED_IN = "";
                    }
                    System.exit(0);
                }
            }
        });


        /*-------------------------------------------------------------------------------------------------*
         *-------------------------------------------------------------------------------------------------*
         *------------------------------THE SECOND SCREEN'S ACTION LISTENERS:------------------------------*
         *-------------------------------------------------------------------------------------------------*
         *-------------------------------------------------------------------------------------------------*/

        //just ensures everything is fresh to begin with
        quickResetNewClientPage();

        //Male radio button on New Client Page
        maleRadioButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                if (maleRadioButton.isSelected())
                {
                    femaleRadioButton.setSelected(false);
                    maleRadioButton.setEnabled(false);
                    femaleRadioButton.setEnabled(true);
                }
            }
        });

        //Female radio button on New Client Page
        femaleRadioButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                if (femaleRadioButton.isSelected())
                {
                    maleRadioButton.setSelected(false);
                    femaleRadioButton.setEnabled(false);
                    maleRadioButton.setEnabled(true);
                }
            }
        });

        yesColorRadioButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                if (yesColorRadioButton.isSelected())
                {
                    noColorRadioButton.setEnabled(true);
                    noColorRadioButton.setSelected(false);
                    yesColorRadioButton.setEnabled(false);
                }
            }
        });

        noColorRadioButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                if (noColorRadioButton.isSelected())
                {
                    yesColorRadioButton.setSelected(false);
                    noColorRadioButton.setEnabled(false);
                    yesColorRadioButton.setEnabled(true);
                }
            }
        });
        
        cancelButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                int n = JOptionPane.showConfirmDialog(null, "Are you sure you wish to cancel your data entry?", "Confirm Cancellation", JOptionPane.WARNING_MESSAGE);
                if (n == 0)
                {
                    quickResetNewClientPage();
                }
            }
        });

        //confirms the input of the clients information into the computer before record is created and added
        saveButton1.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                if (GlobalVariables.USER_SIGNED_IN.isEmpty())
                {
                    JOptionPane.showMessageDialog(null, "Must be signed in to enter data", "Please sign in", JOptionPane.WARNING_MESSAGE);
                }
                else
                {
                    boolean enterData = true;
                    String[] theStrings = {"", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""};
                    int n = JOptionPane.showConfirmDialog(null, "Are all fields to the best of your ability filled in?", "Confirm Record Entry", JOptionPane.YES_NO_OPTION);

                    if (n == 0)
                    {
                        //checks first name
                        theStrings[0] = textField1.getText();
                        if (theStrings[0].isEmpty() || theStrings[0].chars().allMatch(Character::isSpaceChar) || theStrings[0].chars().allMatch(Character::isDigit))
                        {
                            int theNameCheck = JOptionPane.showConfirmDialog(null, "First name blank or invalid, continue?", "Check first name", JOptionPane.YES_NO_OPTION);
                            if (theNameCheck != 0)
                            {
                                enterData = false;
                            }
                        }

                        //checks last name
                        if (enterData)
                        {
                            theStrings[1] = textField2.getText();
                            if (theStrings[1].isEmpty() || theStrings[1].chars().allMatch(Character::isSpaceChar) || theStrings[1].chars().allMatch(Character::isDigit))
                            {
                                int theNameCheck = JOptionPane.showConfirmDialog(null, "Last name blank or invalid, continue?", "Check last name", JOptionPane.YES_NO_OPTION);
                                if (theNameCheck != 0)
                                {
                                    enterData = false;
                                }
                            }
                        }

                        if (enterData)
                        {
                            if (maleRadioButton.isEnabled())
                            {
                                theStrings[2] = "Female";
                            }
                            else
                            {
                                theStrings[2] = "Male";
                            }
                        }

                        if (enterData)
                        {
                            theStrings[3] = spinner1.getValue().toString();
                            if (Integer.parseInt(theStrings[3]) < 18)
                            {
                                int ageCheck = JOptionPane.showConfirmDialog(null, "Age is under 18, continue?", "Confirm age", JOptionPane.YES_NO_OPTION);
                                if (ageCheck != 0)
                                {
                                    enterData=false;
                                }
                            }
                            else if (Integer.parseInt(theStrings[3]) > 75)
                            {
                                int ageCheck = JOptionPane.showConfirmDialog(null, "Age is over 75, continue?", "Confirm age", JOptionPane.YES_NO_OPTION);
                                if (ageCheck != 0)
                                {
                                    enterData=false;
                                }
                            }
                        }

                        if (enterData)
                        {
                            theStrings[4] = textField4.getText();
                            if (theStrings[4].isEmpty() || theStrings[4].chars().allMatch(Character::isSpaceChar) || theStrings[4].chars().allMatch(Character::isDigit))
                            {
                                int addressCheck = JOptionPane.showConfirmDialog(null, "Address is blank or invalid, continue?", "Confirm address", JOptionPane.YES_NO_OPTION);
                                if (addressCheck != 0)
                                {
                                    enterData=false;
                                }
                            }
                        }

                        if (enterData)
                        {
                            theStrings[5] = textField5.getText();
                            if (theStrings[5].isEmpty() || theStrings[5].chars().allMatch(Character::isSpaceChar) || theStrings[5].chars().allMatch(Character::isDigit))
                            {
                                int cityCheck = JOptionPane.showConfirmDialog(null, "City is blank or invalid, continue?", "Confirm city", JOptionPane.YES_NO_OPTION);
                                if (cityCheck != 0)
                                {
                                    enterData=false;
                                }
                            }
                        }

                        if (enterData)
                        {
                            theStrings[6] = textField6.getText();
                            if (theStrings[6].isEmpty() || theStrings[6].chars().allMatch(Character::isSpaceChar) || theStrings[6].chars().allMatch(Character::isDigit))
                            {
                                int check = JOptionPane.showConfirmDialog(null, "State is blank or invalid, continue?", "Confirm State", JOptionPane.YES_NO_OPTION);
                                if (check != 0)
                                {
                                    enterData=false;
                                }
                            }
                        }

                        if (enterData)
                        {
                            theStrings[7] = textField7.getText();
                            if (!isNumeric(theStrings[7]) || theStrings[7].isEmpty() || theStrings[7].chars().allMatch(Character::isSpaceChar))
                            {
                                int zipCheck = JOptionPane.showConfirmDialog(null, "Zip code is blank or invalid, continue?", "Confirm zip", JOptionPane.YES_NO_OPTION);
                                if (zipCheck != 0)
                                {
                                    enterData=false;
                                }
                            }
                        }

                        if (enterData)
                        {
                            theStrings[8] = textField8.getText();

                            if (theStrings[8].isEmpty())
                            {
                                int check = JOptionPane.showConfirmDialog(null, "Primary Phone is empty, continue?", "Error with Primary Phone #", JOptionPane.YES_NO_OPTION);
                                if (check != 0)
                                {
                                    enterData=false;
                                }
                            }
                            else if (!isNumeric(theStrings[8]))
                            {
                                JOptionPane.showMessageDialog(null, "Primary Phone # must be completely numeric! \n(no '(', '-', ')' for instance", "Error with Primary Phone #", JOptionPane.WARNING_MESSAGE);
                                enterData=false;
                            }
                            else if (theStrings[8].length() != 10)
                            {
                                JOptionPane.showMessageDialog(null, "The primary phone number is not 10 digits long!", "Error with primary phone number", JOptionPane.WARNING_MESSAGE);
                                enterData=false;
                            }
                        }

                        if (enterData)
                        {
                            theStrings[9] = textField9.getText();
                            if (theStrings[9].isEmpty())
                            {
                                int check = JOptionPane.showConfirmDialog(null, "Secondary Phone is empty, continue?", "Error with Primary Phone #", JOptionPane.YES_NO_OPTION);
                                if (check != 0)
                                {
                                    enterData=false;

                                }
                            }
                            else if (!isNumeric(theStrings[9]))
                            {
                                JOptionPane.showMessageDialog(null, "Secondary Phone # must be completely numeric! \n(no '(', '-', ')' for instance", "Error with Primary Phone #", JOptionPane.WARNING_MESSAGE);
                                enterData=false;
                            }
                            else if (theStrings[9].length() != 10)
                            {
                                JOptionPane.showMessageDialog(null, "The Secondary phone number is not 10 digits long!", "Error with primary phone number", JOptionPane.WARNING_MESSAGE);
                                enterData=false;
                            }
                        }

                        if (enterData)
                        {
                            theStrings[10] = textField10.getText();
                            if (theStrings[10].isEmpty() || theStrings[10].chars().allMatch(Character::isSpaceChar) || theStrings[10].chars().allMatch(Character::isDigit))
                            {
                                int check = JOptionPane.showConfirmDialog(null, "Reason for need is blank or invalid, continue?", "Confirm reason for need", JOptionPane.YES_NO_OPTION);
                                if (check != 0)
                                {
                                    enterData=false;
                                }
                            }
                        }

                        if (enterData)
                        {
                            if (noColorRadioButton.isEnabled())
                            {
                                theStrings[11] = "Yes";
                            }
                            else
                            {
                                theStrings[11] = "No";
                            }
                        }

                        if (enterData)
                        {
                            theStrings[12] = textField12.getText();
                            if (theStrings[12].isEmpty() || theStrings[12].chars().allMatch(Character::isSpaceChar) || theStrings[12].chars().allMatch(Character::isDigit))
                            {
                                int check = JOptionPane.showConfirmDialog(null, "Screen Date is blank or invalid, continue?", "Confirm Screen Date", JOptionPane.YES_NO_OPTION);
                                if (check != 0)
                                {
                                    enterData=false;
                                }
                            }
                        }

                        if (enterData)
                        {
                            theStrings[13] = textField13.getText();
                            if (theStrings[13].isEmpty() || theStrings[13].chars().allMatch(Character::isSpaceChar) || theStrings[13].chars().allMatch(Character::isDigit))
                            {
                                int check = JOptionPane.showConfirmDialog(null, "Date interviewed is blank or invalid, continue?", "Confirm Date Interviewed", JOptionPane.YES_NO_OPTION);
                                if (check != 0)
                                {
                                    enterData=false;
                                }
                            }
                        }

                        if (enterData)
                        {
                            theStrings[14] = textField14.getText();
                            if (theStrings[14].isEmpty() || theStrings[14].chars().allMatch(Character::isSpaceChar) || theStrings[14].chars().allMatch(Character::isDigit))
                            {
                                int check = JOptionPane.showConfirmDialog(null, "Screener Name is blank or invalid, continue?", "Confirm Screener Name", JOptionPane.YES_NO_OPTION);
                                if (check != 0)
                                {
                                    enterData=false;
                                }
                            }
                        }

                        if (enterData)
                        {
                            theStrings[15] = textField15.getText();
                            if (theStrings[15].isEmpty() || theStrings[15].chars().allMatch(Character::isSpaceChar) || theStrings[15].chars().allMatch(Character::isDigit))
                            {
                                int check = JOptionPane.showConfirmDialog(null, "Interviewer name is blank, continue?", "Confirm interviewer name", JOptionPane.YES_NO_OPTION);
                                if (check != 0)
                                {
                                    enterData=false;
                                }
                            }
                        }

                        if (enterData)
                        {
                            theStrings[16] = textField16.getText();
                            if (theStrings[16].isEmpty() || theStrings[16].chars().allMatch(Character::isSpaceChar) || theStrings[16].chars().allMatch(Character::isDigit))
                            {
                                int check = JOptionPane.showConfirmDialog(null, "Comments blank or invalid, continue?", "Confirm Comments", JOptionPane.YES_NO_OPTION);
                                if (check != 0)
                                {
                                    enterData=false;
                                }
                            }
                        }

                        System.out.println("status of this: " + enterData);

                        if (enterData)
                        {
                            PersonDataObj myDataObject = new PersonDataObj(theStrings[0], theStrings[1],theStrings[2],theStrings[3],theStrings[4],theStrings[5],theStrings[6],theStrings[7],
                                    theStrings[8],theStrings[9],theStrings[10],theStrings[11],theStrings[12],theStrings[13],theStrings[14],theStrings[15],theStrings[16]);
                            GlobalVariables.THE_LIST_OF_RECORDS.add(myDataObject);
                            model.fireTableRowsInserted(GlobalVariables.THE_LIST_OF_RECORDS.size()-1, GlobalVariables.THE_LIST_OF_RECORDS.size()-1);
                            WriteFile.writeRecords();
                            quickResetNewClientPage();
                            JOptionPane.showMessageDialog(null,"Record Written Successfully");
                        }
                    }
                }
            }
        });

        //action listeners for the View database tab
        viewRecordButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                int currentRecordSelection = table1.getSelectedRow();
                PersonDataObj tmp = GlobalVariables.THE_LIST_OF_RECORDS.get(currentRecordSelection);
                new InternalViewRecordPopup("Record Viewer", 400, 800, currentRecordSelection);
            }
        });

        printRecordButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                ExportToExcel.printSingleRecordToExcel(col, table1.getSelectedRow());
            }
        });

        printSelectRangeButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                String lowerBound = JOptionPane.showInputDialog(null, "Select the lower value of of record range to print to excel file");
                int lowerBoundNumber = Integer.parseInt(lowerBound);

                String upperBound = JOptionPane.showInputDialog(null, "Select the upper value of of record range to print to excel file");
                int upperBoundNumber = Integer.parseInt(upperBound);
                boolean runExport = true;

                if (lowerBoundNumber < 0)
                {
                    JOptionPane.showMessageDialog(null, "First Number can't be less than zero!");
                    runExport=false;
                }

                if (upperBoundNumber > GlobalVariables.THE_LIST_OF_RECORDS.size() - 1)
                {
                    JOptionPane.showMessageDialog(null, "Second number has to be smaller than the highest record value!");
                    runExport=false;
                }

                if (runExport)
                {
                    ExportToExcel.printExcelRange(col, lowerBoundNumber, upperBoundNumber);
                }
            }
        });

        deleteRecordButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                if (GlobalVariables.USER_SIGNED_IN.isEmpty())
                {
                    JOptionPane.showMessageDialog(null, "Must be signed in to enter data", "Please sign in", JOptionPane.WARNING_MESSAGE);
                }
                else
                {
                    int row = table1.getSelectedRow();
                    int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete the record?","Delete?", JOptionPane.YES_NO_OPTION);
                    if (confirm == 0)
                    {
                        GlobalVariables.THE_LIST_OF_RECORDS.remove(row);
                        model.fireTableRowsDeleted(row, row);
                        WriteFile.writeRecords();

                        System.out.println("\n\n\n\n");
                        for (PersonDataObj a : GlobalVariables.THE_LIST_OF_RECORDS)
                        {
                            System.out.println(a);
                        }
                    }
                }
            }
        });

        generateExcelFileButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                ExportToExcel.exportDataToExcel(col);
            }
        });
    }

    //checks to see if a string is numberic
    private static boolean isNumeric(String strNum)
    {
        return strNum.chars().allMatch(Character::isDigit);
    }

    //this handy method resets the new client tab
    private void quickResetNewClientPage()
    {
        textField1.setEnabled(true);
        textField2.setEnabled(true);
        textField4.setEnabled(true);
        textField5.setEnabled(true);
        textField6.setEnabled(true);
        textField7.setEnabled(true);
        textField8.setEnabled(true);
        textField9.setEnabled(true);
        textField10.setEnabled(true);
        textField12.setEnabled(true);
        textField13.setEnabled(true);
        textField14.setEnabled(true);
        textField15.setEnabled(true);
        textField16.setEnabled(true);
        spinner1.setEnabled(true);

        textField1.setText("");
        textField2.setText("");
        textField4.setText("");
        textField5.setText("");
        textField6.setText("");
        textField7.setText("");
        textField8.setText("");
        textField9.setText("");
        textField10.setText("");
        textField12.setText("");
        textField13.setText("");
        textField14.setText("");
        textField15.setText("");
        textField16.setText("");

        //jspinner reset
        Integer defaultAge = 20;
        spinner1.setValue(defaultAge);

        maleRadioButton.setSelected(true);
        maleRadioButton.setEnabled(false);
        femaleRadioButton.setSelected(false);
        femaleRadioButton.setEnabled(true);
        noColorRadioButton.setEnabled(false);
        noColorRadioButton.setSelected(true);
        yesColorRadioButton.setEnabled(true);
        yesColorRadioButton.setSelected(false);
    }

    //the main method for the entire program
    public static void main(String[] args) throws IOException, FileNotFoundException, ClassNotFoundException
    {
//        Multiset<String> mySet = HashMultiset.create(); // will delete later, only added for syntax practice purposes of guava
//        Multimap<String, Integer> myMap = TreeMultimap.create();

        //Multimap<String, Map<String, Double>> otherDonations = HashMultimap.create();
//        Multimap<String, Double> otherDonations = ArrayListMultimap.create();
//
//        otherDonations.put("KMart", 200.50);
//        otherDonations.put("KMart", 200.50);
//        otherDonations.put("hello", 34.5);
//        otherDonations.put("KMart", 200.10);
//
//        System.out.println(otherDonations);


        firstRunDialog();
    }

    //provides file browser for the first startup or if there is no set path (or if it gets messed up)
    private static void firstRunDialog() throws FileNotFoundException, IOException, ClassNotFoundException
    {
        JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());

        int returnValue = jfc.showOpenDialog(null);

        if (returnValue == JFileChooser.APPROVE_OPTION)
        {
            GlobalVariables.DATABASE_FILE = jfc.getSelectedFile();
            GlobalVariables.DATABASE_FILEPATH = jfc.getSelectedFile().getAbsolutePath();
            //GlobalVariables.INITIAL_BACKUP_FILEPATH = jfc.getSelectedFile().getParent() + "\\"+DateClass.getBackupDate()+"  - Backup.txt";
            InitialBackup.writeInitialBackup();
            ReadFile.readFile();
            new MainMenu("Database program", 1000, 800);
        }
        else
        {
            firstRunQuestionDialog();
        }
    }

    //IF the user starts the program for the first time and there has been no generated files to go with it and they want
    //to generate the files, they must use this to do so
    private static void firstRunQuestionDialog() throws IOException, ClassNotFoundException
    {
        Object[] options = {"Yes, new file", "No, keep looking", "Exit Program"};
        int n = JOptionPane.showOptionDialog(null, "Datafile not found, create new one?", "Generate New DataBase File?", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[2]);
        if (n == 0)
        {
            generateEmptyFiles();
        }
        else if (n == 1)
        {
            firstRunDialog();
        }
        else
        {
            System.exit(0);
        }
    }

    //generates the initial files
    private static void generateEmptyFiles() throws IOException, FileNotFoundException, ClassNotFoundException
    {
        JOptionPane.showMessageDialog(null, "Please nagivate to the directory you would like to create the file.");
        JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        jfc.setDialogTitle("Select Directory To Generate Files");
        jfc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        jfc.setAcceptAllFileFilterUsed(false);

        if (jfc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
        {
            String directoryPath = jfc.getSelectedFile().getAbsolutePath();
            try
            {
                File dataBaseData = new File(directoryPath + "\\Database.data");
                File dataBaseOptions = new File(directoryPath + "\\Log.txt");
                PrintWriter myWriter = new PrintWriter(dataBaseOptions);
                PrintWriter secondWriter = new PrintWriter(dataBaseData);
                secondWriter.print("");
                myWriter.println(DateClass.getDate()+ ": Database.data created at file path: "+directoryPath+"\\Database.data");
                myWriter.close();
                secondWriter.close();
            } catch (IOException e)
            {
                e.printStackTrace();
            }
            JOptionPane.showMessageDialog(null,"Files created! You can now load up the program");

            firstRunDialog();
        }
        else
        {
            firstRunDialog();
        }
    }

    private void createUIComponents()
    {
        // TODO: place custom component creation code here
        model = new MyTableModel(GlobalVariables.THE_LIST_OF_RECORDS, col);

        table1 = new JTable(model);

        System.out.println("IS THIS VISIBLE? : " + table1.isVisible());
        JTableHeader header = table1.getTableHeader();
        header.setBackground(Color.yellow);
    }
}