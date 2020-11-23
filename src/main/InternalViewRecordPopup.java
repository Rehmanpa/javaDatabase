package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Created by Jonathan Kipper on 8/1/2019.
 */
public class InternalViewRecordPopup extends JFrame
{
    private JButton printRecordButton;
    private JButton editRecordButton;
    private JButton saveEditsButton;
    private JButton cancelEditButton;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
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
    private JTextField textField17;
    private JLabel recordNumberLabel;
    private JPanel panel1;
    private JLabel recordNumberLabel1;
    private JButton nextRecordButton;
    private JButton previousRecordButton;
    private int currentRecord;

    public InternalViewRecordPopup(String title, int windowWidth, int windowHeight, int recordNumber) throws HeadlessException
    {
        super(title);

        this.currentRecord = recordNumber;

        setContentPane(panel1);
        setSize(windowWidth, windowHeight);
        setLocationRelativeTo(null);
        pack();
        viewerOpen(currentRecord);
        setVisible(true);

        
        editRecordButton.addActionListener(new ActionListener()
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
                    setFieldsEnabled();
                    previousRecordButton.setEnabled(false);
                    nextRecordButton.setEnabled(false);
                }
            }
        });

        saveEditsButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                boolean enterData = true;
                String[] theStrings = {"", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""};
                int n = JOptionPane.showConfirmDialog(null, "Are all fields to the best of your ability filled in?", "Confirm Record Entry", JOptionPane.YES_NO_OPTION);

                if (n == 0)
                {
                    //checks first name
                    theStrings[0] = textField1.getText();
                    System.out.println("IT THINKS THAT THE FIRST NAME IS: " + theStrings[0]);
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
                        System.out.println("IT THINKS THAT THE LAST NAME IS: " + theStrings[1]);
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
                        theStrings[2] = textField3.getText();
                        System.out.println("IT THINKS THAT THE SEX IS: " + theStrings[2]);
                        if (theStrings[2].isEmpty() || theStrings[2].chars().allMatch(Character::isSpaceChar) || theStrings[2].chars().allMatch(Character::isDigit))
                        {
                            int theNameCheck = JOptionPane.showConfirmDialog(null, "Sex invalid, continue?", "Check last name", JOptionPane.YES_NO_OPTION);
                            if (theNameCheck != 0)
                            {
                                enterData = false;
                            }
                            else if (theStrings[2].equalsIgnoreCase("male") || theStrings[2].equalsIgnoreCase("man") || theStrings[2].equalsIgnoreCase("boy"))
                            {
                                theStrings[2] = "Male";
                            }
                            else if (theStrings[2].equalsIgnoreCase("female") || theStrings[2].equalsIgnoreCase("woman") || theStrings[2].equalsIgnoreCase("girl"))
                            {
                                theStrings[2] = "Female";
                            }
                        }
                    }

                    if (enterData)
                    {
                        theStrings[3] = textField4.getText();
                        System.out.println("IT THINKS THAT THE AGE IS: " + theStrings[3]);
                        if (!isNumeric(theStrings[3]) || theStrings[3].isEmpty() || theStrings[3].chars().allMatch((Character::isSpaceChar)))
                        {
                            int addressCheck = JOptionPane.showConfirmDialog(null, "Age invalid, continue?", "Confirm age", JOptionPane.YES_NO_OPTION);
                            if (addressCheck != 0)
                            {
                                enterData=false;
                            }
                        }
                    }

                    if (enterData)
                    {
                        theStrings[4] = textField5.getText();
                        System.out.println("IT THINKS THAT THE ADDRESS NUMBER IS: " + theStrings[4]);
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
                        theStrings[5] = textField6.getText();
                        System.out.println("IT THINKS THAT THE CITY IS: " + theStrings[5]);
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
                        theStrings[6] = textField7.getText();
                        System.out.println("IT THINKS THAT THE STATE IS: " + theStrings[6]);
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
                        theStrings[7] = textField8.getText();
                        System.out.println("IT THINKS THAT THE ZIP IS: " + theStrings[7]);
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
                        theStrings[8] = textField9.getText();

                        System.out.println("IT THINKS THAT THE PHONE NUMBER IS: " + theStrings[8]);

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
                        theStrings[9] = textField10.getText();
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
                        theStrings[10] = textField11.getText();
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
                        theStrings[11] = textField12.getText();
                        if (theStrings[11].isEmpty() || theStrings[11].chars().allMatch(Character::isSpaceChar) || theStrings[11].chars().allMatch(Character::isDigit))
                        {
                            int check = JOptionPane.showConfirmDialog(null, "Reason for need is blank or invalid, continue?", "Confirm reason for need", JOptionPane.YES_NO_OPTION);
                            if (check != 0)
                            {
                                enterData=false;
                            }
                        }
                        else if (theStrings[11].equalsIgnoreCase("yes") || theStrings[11].equalsIgnoreCase("ya") || theStrings[11].equalsIgnoreCase("yea") || theStrings[11].equalsIgnoreCase("yeah") || theStrings[11].equalsIgnoreCase("y"))
                        {
                            theStrings[11] = "Yes";
                        }
                        else if (theStrings[11].equalsIgnoreCase("no") || theStrings[11].equalsIgnoreCase("naw") || theStrings[11].equalsIgnoreCase("nope") || theStrings[11].equalsIgnoreCase("n") || theStrings[11].equalsIgnoreCase("nop"))
                        {
                            theStrings[11] = "No";
                        }
                    }

                    if (enterData)
                    {
                        theStrings[12] = textField13.getText();
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
                        theStrings[13] = textField14.getText();
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
                        theStrings[14] = textField15.getText();
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
                        theStrings[15] = textField16.getText();
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
                        theStrings[16] = textField17.getText();
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
                        PersonDataObj tmpMeme = new PersonDataObj(theStrings[0], theStrings[1],theStrings[2],theStrings[3],theStrings[4],theStrings[5],theStrings[6],theStrings[7],
                                theStrings[8],theStrings[9],theStrings[10],theStrings[11],theStrings[12],theStrings[13],theStrings[14],theStrings[15],theStrings[16]);
                        GlobalVariables.THE_LIST_OF_RECORDS.remove(currentRecord);
                        GlobalVariables.THE_LIST_OF_RECORDS.add(currentRecord, tmpMeme);
                        WriteFile.writeRecords();
                        JOptionPane.showMessageDialog(null,"Record Written Successfully");
                        viewerOpen(currentRecord);
                        editRecordButton.setEnabled(true);
                        previousRecordButton.setEnabled(true);
                        nextRecordButton.setEnabled(true);
                    }
                }
            }
        });

        cancelEditButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                int n = JOptionPane.showConfirmDialog(null, "Cancel Record Edit?", "Cancel?", JOptionPane.YES_NO_OPTION);
                if (n == 0)
                {
                    viewerOpen(currentRecord);
                    editRecordButton.setEnabled(true);
                    previousRecordButton.setEnabled(true);
                    nextRecordButton.setEnabled(true);
                }
            }
        });

        previousRecordButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                int tmp = currentRecord-1;
                if (tmp < 0)
                {
                    previousRecordButton.setEnabled(false);
                    JOptionPane.showMessageDialog(null, "No Previous Records");
                }
                else
                {
                    viewerOpen(tmp);
                    currentRecord=tmp;
                    previousRecordButton.setEnabled(true);
                    nextRecordButton.setEnabled(true);
                }
            }
        });

        nextRecordButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                int tmp = currentRecord + 1;
                if (tmp < GlobalVariables.THE_LIST_OF_RECORDS.size())
                {
                    viewerOpen(tmp);
                    currentRecord=tmp;
                    nextRecordButton.setEnabled(true);
                    previousRecordButton.setEnabled(true);
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "No additional Records");
                    nextRecordButton.setEnabled(false);
                }
            }
        });

        printRecordButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                String col[] = new String[]{"First Name", "Last Name", "Sex", "Age", "Address", "City", "State", "Zip",
                        "Phone", "2nd Phone", "Reason", "Color", "Screened", "Interviewed", "Screener Name",
                        "Interviewer Name", "Comments"};
                ExportToExcel.printSingleRecordToExcel(col, recordNumber);
            }
        });
        
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    //runs when the viewer opens, sets the default values
    private void viewerOpen(int numToUse)
    {
        cancelEditButton.setEnabled(false);
        saveEditsButton.setEnabled(false);
        recordNumberLabel1.setText("Record "+String.valueOf(numToUse+1) + " of "+String.valueOf(GlobalVariables.THE_LIST_OF_RECORDS.size()));
        textField1.setText(GlobalVariables.THE_LIST_OF_RECORDS.get(numToUse).getFirstName());
        textField2.setText(GlobalVariables.THE_LIST_OF_RECORDS.get(numToUse).getLastName());
        textField3.setText(GlobalVariables.THE_LIST_OF_RECORDS.get(numToUse).getSex());
        textField4.setText(GlobalVariables.THE_LIST_OF_RECORDS.get(numToUse).getAge());
        textField5.setText(GlobalVariables.THE_LIST_OF_RECORDS.get(numToUse).getAddress());
        textField6.setText(GlobalVariables.THE_LIST_OF_RECORDS.get(numToUse).getCity());
        textField7.setText(GlobalVariables.THE_LIST_OF_RECORDS.get(numToUse).getState());
        textField8.setText(GlobalVariables.THE_LIST_OF_RECORDS.get(numToUse).getZip());
        textField9.setText(GlobalVariables.THE_LIST_OF_RECORDS.get(numToUse).getPrimaryPhone());
        textField10.setText(GlobalVariables.THE_LIST_OF_RECORDS.get(numToUse).getSecondaryPhone());
        textField11.setText(GlobalVariables.THE_LIST_OF_RECORDS.get(numToUse).getReasonForNeed());
        textField12.setText(GlobalVariables.THE_LIST_OF_RECORDS.get(numToUse).getPersonOfColor());
        textField13.setText(GlobalVariables.THE_LIST_OF_RECORDS.get(numToUse).getDateScreened());
        textField14.setText(GlobalVariables.THE_LIST_OF_RECORDS.get(numToUse).getDateInterviewed());
        textField15.setText(GlobalVariables.THE_LIST_OF_RECORDS.get(numToUse).getScreenerName());
        textField16.setText(GlobalVariables.THE_LIST_OF_RECORDS.get(numToUse).getInterviewerName());
        textField17.setText(GlobalVariables.THE_LIST_OF_RECORDS.get(numToUse).getComments());
        textField1.setEnabled(false);
        textField2.setEnabled(false);
        textField3.setEnabled(false);
        textField4.setEnabled(false);
        textField5.setEnabled(false);
        textField6.setEnabled(false);
        textField7.setEnabled(false);
        textField8.setEnabled(false);
        textField9.setEnabled(false);
        textField10.setEnabled(false);
        textField11.setEnabled(false);
        textField12.setEnabled(false);
        textField13.setEnabled(false);
        textField14.setEnabled(false);
        textField15.setEnabled(false);
        textField16.setEnabled(false);
        textField17.setEnabled(false);
    }

    private void setFieldsEnabled()
    {
        editRecordButton.setEnabled(false);
        cancelEditButton.setEnabled(true);
        saveEditsButton.setEnabled(true);
        textField1.setEnabled(true);
        textField2.setEnabled(true);
        textField3.setEnabled(true);
        textField4.setEnabled(true);
        textField5.setEnabled(true);
        textField6.setEnabled(true);
        textField7.setEnabled(true);
        textField8.setEnabled(true);
        textField9.setEnabled(true);
        textField10.setEnabled(true);
        textField11.setEnabled(true);
        textField12.setEnabled(true);
        textField13.setEnabled(true);
        textField14.setEnabled(true);
        textField15.setEnabled(true);
        textField16.setEnabled(true);
        textField17.setEnabled(true);
    }

    //checks to see if a string is numberic
    private static boolean isNumeric(String strNum)
    {
        return strNum.chars().allMatch(Character::isDigit);
    }

        private void createUIComponents()
        {
            // TODO: place custom component creation code here
        }
}