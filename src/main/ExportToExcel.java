package main;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;

import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Jonathan Kipper on 8/2/2019.
 */
public class ExportToExcel
{
    public static void exportDataToExcel(String[] columnNames)
    {
        try
        {
            Workbook wb = new HSSFWorkbook();
            CreationHelper createHelper = wb.getCreationHelper();
            Sheet sheet = wb.createSheet("New Sheet");
            Row row = null;
            Cell cell = null;

            //makes the column headers in the excel spread sheet
            row = sheet.createRow(0);
            int z = 0;
            for (String a : columnNames)
            {
                cell = row.createCell(z);
                cell.setCellValue(a);
                z++;
            }

            for (int i = 0; i < GlobalVariables.THE_LIST_OF_RECORDS.size(); i++)
            {
                row = sheet.createRow((i+1));
                for (int j = 0; j < 18; j++)
                {
                    cell = row.createCell(j);
                    if (j == 0)
                    {
                        cell.setCellValue(GlobalVariables.THE_LIST_OF_RECORDS.get(i).getFirstName());
                    }
                    else if (j == 1)
                    {
                        cell.setCellValue(GlobalVariables.THE_LIST_OF_RECORDS.get(i).getLastName());
                    }
                    else if (j == 2)
                    {
                        cell.setCellValue(GlobalVariables.THE_LIST_OF_RECORDS.get(i).getSex());
                    }
                    else if (j == 3)
                    {
                        cell.setCellValue(GlobalVariables.THE_LIST_OF_RECORDS.get(i).getAge());
                    }
                    else if (j == 4)
                    {
                        cell.setCellValue(GlobalVariables.THE_LIST_OF_RECORDS.get(i).getAddress());
                    }
                    else if (j == 5)
                    {
                        cell.setCellValue(GlobalVariables.THE_LIST_OF_RECORDS.get(i).getCity());
                    }
                    else if (j == 6)
                    {
                        cell.setCellValue(GlobalVariables.THE_LIST_OF_RECORDS.get(i).getState());
                    }
                    else if (j == 7)
                    {
                        cell.setCellValue(GlobalVariables.THE_LIST_OF_RECORDS.get(i).getZip());
                    }
                    else if (j == 8)
                    {
                        cell.setCellValue(GlobalVariables.THE_LIST_OF_RECORDS.get(i).getPrimaryPhone());
                    }
                    else if (j == 9)
                    {
                        cell.setCellValue(GlobalVariables.THE_LIST_OF_RECORDS.get(i).getSecondaryPhone());
                    }
                    else if (j == 10)
                    {
                        cell.setCellValue(GlobalVariables.THE_LIST_OF_RECORDS.get(i).getReasonForNeed());
                    }
                    else if (j == 11)
                    {
                        cell.setCellValue(GlobalVariables.THE_LIST_OF_RECORDS.get(i).getPersonOfColor());
                    }
                    else if (j == 12)
                    {
                        cell.setCellValue(GlobalVariables.THE_LIST_OF_RECORDS.get(i).getDateScreened());
                    }
                    else if (j == 13)
                    {
                        cell.setCellValue(GlobalVariables.THE_LIST_OF_RECORDS.get(i).getDateInterviewed());
                    }
                    else if (j == 14)
                    {
                        cell.setCellValue(GlobalVariables.THE_LIST_OF_RECORDS.get(i).getScreenerName());
                    }
                    else if (j == 15)
                    {
                        cell.setCellValue(GlobalVariables.THE_LIST_OF_RECORDS.get(i).getInterviewerName());
                    }
                    else if (j == 16)
                    {
                        cell.setCellValue(GlobalVariables.THE_LIST_OF_RECORDS.get(i).getComments());
                    }
                }
            }
            JOptionPane.showMessageDialog(null, "Please select to where you would like to save the excel file");
            JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
            jfc.setDialogTitle("Select directory to save spreadsheet");
            jfc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            jfc.setAcceptAllFileFilterUsed(false);

            if (jfc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
            {
                String directoryPath = jfc.getSelectedFile().getAbsolutePath();
                String fileName = JOptionPane.showInputDialog(null, "What would you like to name the file?");
                FileOutputStream out = new FileOutputStream(directoryPath+"\\"+fileName+".xls");
                wb.write(out);
                out.close();
                JOptionPane.showMessageDialog(null, "File sucessfully written!");
            }
        } catch (IOException e)
        {
            Logger.getLogger(ExportToExcel.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public static void printSingleRecordToExcel(String[] columnNames, int recordValue)
    {
        try
        {
            Workbook wb = new HSSFWorkbook();
            CreationHelper createHelper = wb.getCreationHelper();
            Sheet sheet = wb.createSheet("New Sheet");
            Row row = null;
            Cell cell = null;

            //makes the column headers in the excel spread sheet
            row = sheet.createRow(0);
            int z = 0;
            for (String a : columnNames)
            {
                cell = row.createCell(z);
                cell.setCellValue(a);
                z++;
            }

            for (int i = 0; i < 1; i++)
            {
                row = sheet.createRow((i+1));
                for (int j = 0; j < 18; j++)
                {
                    cell = row.createCell(j);
                    if (j == 0)
                    {
                        cell.setCellValue(GlobalVariables.THE_LIST_OF_RECORDS.get(recordValue).getFirstName());
                    }
                    else if (j == 1)
                    {
                        cell.setCellValue(GlobalVariables.THE_LIST_OF_RECORDS.get(recordValue).getLastName());
                    }
                    else if (j == 2)
                    {
                        cell.setCellValue(GlobalVariables.THE_LIST_OF_RECORDS.get(recordValue).getSex());
                    }
                    else if (j == 3)
                    {
                        cell.setCellValue(GlobalVariables.THE_LIST_OF_RECORDS.get(recordValue).getAge());
                    }
                    else if (j == 4)
                    {
                        cell.setCellValue(GlobalVariables.THE_LIST_OF_RECORDS.get(recordValue).getAddress());
                    }
                    else if (j == 5)
                    {
                        cell.setCellValue(GlobalVariables.THE_LIST_OF_RECORDS.get(recordValue).getCity());
                    }
                    else if (j == 6)
                    {
                        cell.setCellValue(GlobalVariables.THE_LIST_OF_RECORDS.get(recordValue).getState());
                    }
                    else if (j == 7)
                    {
                        cell.setCellValue(GlobalVariables.THE_LIST_OF_RECORDS.get(recordValue).getZip());
                    }
                    else if (j == 8)
                    {
                        cell.setCellValue(GlobalVariables.THE_LIST_OF_RECORDS.get(recordValue).getPrimaryPhone());
                    }
                    else if (j == 9)
                    {
                        cell.setCellValue(GlobalVariables.THE_LIST_OF_RECORDS.get(recordValue).getSecondaryPhone());
                    }
                    else if (j == 10)
                    {
                        cell.setCellValue(GlobalVariables.THE_LIST_OF_RECORDS.get(recordValue).getReasonForNeed());
                    }
                    else if (j == 11)
                    {
                        cell.setCellValue(GlobalVariables.THE_LIST_OF_RECORDS.get(recordValue).getPersonOfColor());
                    }
                    else if (j == 12)
                    {
                        cell.setCellValue(GlobalVariables.THE_LIST_OF_RECORDS.get(recordValue).getDateScreened());
                    }
                    else if (j == 13)
                    {
                        cell.setCellValue(GlobalVariables.THE_LIST_OF_RECORDS.get(recordValue).getDateInterviewed());
                    }
                    else if (j == 14)
                    {
                        cell.setCellValue(GlobalVariables.THE_LIST_OF_RECORDS.get(recordValue).getScreenerName());
                    }
                    else if (j == 15)
                    {
                        cell.setCellValue(GlobalVariables.THE_LIST_OF_RECORDS.get(recordValue).getInterviewerName());
                    }
                    else if (j == 16)
                    {
                        cell.setCellValue(GlobalVariables.THE_LIST_OF_RECORDS.get(recordValue).getComments());
                    }
                }
            }

            JOptionPane.showMessageDialog(null, "Please select to where you would like to save the excel file");
            JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
            jfc.setDialogTitle("Select directory to save spreadsheet");
            jfc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            jfc.setAcceptAllFileFilterUsed(false);

            if (jfc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
            {
                String directoryPath = jfc.getSelectedFile().getAbsolutePath();
                String fileName = JOptionPane.showInputDialog(null, "What would you like to name the file?");
                FileOutputStream out = new FileOutputStream(directoryPath+"\\"+fileName+".xls");
                wb.write(out);
                out.close();
                JOptionPane.showMessageDialog(null, "File sucessfully written!");
            }
        } catch (IOException e)
        {
            Logger.getLogger(ExportToExcel.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public static void printExcelRange(String[] columnNames, int lowerValue, int upperValue)
    {
        try
        {
            Workbook wb = new HSSFWorkbook();
            CreationHelper createHelper = wb.getCreationHelper();
            Sheet sheet = wb.createSheet("New Sheet");
            Row row = null;
            Cell cell = null;

            //makes the column headers in the excel spread sheet
            row = sheet.createRow(0);
            int z = 0;
            for (String a : columnNames)
            {
                cell = row.createCell(z);
                cell.setCellValue(a);
                z++;
            }

            for (int i = lowerValue; i < upperValue; i++)
            {
                row = sheet.createRow((i+1));
                for (int j = 0; j < 18; j++)
                {
                    cell = row.createCell(j);
                    if (j == 0)
                    {
                        cell.setCellValue(GlobalVariables.THE_LIST_OF_RECORDS.get(i).getFirstName());
                    }
                    else if (j == 1)
                    {
                        cell.setCellValue(GlobalVariables.THE_LIST_OF_RECORDS.get(i).getLastName());
                    }
                    else if (j == 2)
                    {
                        cell.setCellValue(GlobalVariables.THE_LIST_OF_RECORDS.get(i).getSex());
                    }
                    else if (j == 3)
                    {
                        cell.setCellValue(GlobalVariables.THE_LIST_OF_RECORDS.get(i).getAge());
                    }
                    else if (j == 4)
                    {
                        cell.setCellValue(GlobalVariables.THE_LIST_OF_RECORDS.get(i).getAddress());
                    }
                    else if (j == 5)
                    {
                        cell.setCellValue(GlobalVariables.THE_LIST_OF_RECORDS.get(i).getCity());
                    }
                    else if (j == 6)
                    {
                        cell.setCellValue(GlobalVariables.THE_LIST_OF_RECORDS.get(i).getState());
                    }
                    else if (j == 7)
                    {
                        cell.setCellValue(GlobalVariables.THE_LIST_OF_RECORDS.get(i).getZip());
                    }
                    else if (j == 8)
                    {
                        cell.setCellValue(GlobalVariables.THE_LIST_OF_RECORDS.get(i).getPrimaryPhone());
                    }
                    else if (j == 9)
                    {
                        cell.setCellValue(GlobalVariables.THE_LIST_OF_RECORDS.get(i).getSecondaryPhone());
                    }
                    else if (j == 10)
                    {
                        cell.setCellValue(GlobalVariables.THE_LIST_OF_RECORDS.get(i).getReasonForNeed());
                    }
                    else if (j == 11)
                    {
                        cell.setCellValue(GlobalVariables.THE_LIST_OF_RECORDS.get(i).getPersonOfColor());
                    }
                    else if (j == 12)
                    {
                        cell.setCellValue(GlobalVariables.THE_LIST_OF_RECORDS.get(i).getDateScreened());
                    }
                    else if (j == 13)
                    {
                        cell.setCellValue(GlobalVariables.THE_LIST_OF_RECORDS.get(i).getDateInterviewed());
                    }
                    else if (j == 14)
                    {
                        cell.setCellValue(GlobalVariables.THE_LIST_OF_RECORDS.get(i).getScreenerName());
                    }
                    else if (j == 15)
                    {
                        cell.setCellValue(GlobalVariables.THE_LIST_OF_RECORDS.get(i).getInterviewerName());
                    }
                    else if (j == 16)
                    {
                        cell.setCellValue(GlobalVariables.THE_LIST_OF_RECORDS.get(i).getComments());
                    }
                }
            }

            JOptionPane.showMessageDialog(null, "Please select to where you would like to save the excel file");
            JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
            jfc.setDialogTitle("Select directory to save spreadsheet");
            jfc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            jfc.setAcceptAllFileFilterUsed(false);

            if (jfc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
            {
                String directoryPath = jfc.getSelectedFile().getAbsolutePath();
                String fileName = JOptionPane.showInputDialog(null, "What would you like to name the file?");
                FileOutputStream out = new FileOutputStream(directoryPath+"\\"+fileName+".xls");
                wb.write(out);
                out.close();
                JOptionPane.showMessageDialog(null, "File sucessfully written!");
            }
        } catch (IOException e)
        {
            Logger.getLogger(ExportToExcel.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}