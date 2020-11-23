package main;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jonathan Kipper on 8/1/2019.
 */
public class MyTableModel extends AbstractTableModel
{
    private List<PersonDataObj> personDataObjs;
    private String[] columnHeaderValues;

    public MyTableModel(List<PersonDataObj> theList)
    {
        this.personDataObjs = theList;
    }

    public MyTableModel(List<PersonDataObj> theList, String[] columnHeaderValues)
    {
        this.personDataObjs = theList;
        this.columnHeaderValues = columnHeaderValues;
    }

    @Override
    public int getRowCount()
    {
        return personDataObjs.size();
    }

    @Override
    public int getColumnCount()
    {
        return 17;
    }

    @Override
    public String getColumnName(int col)
    {
        if (columnHeaderValues != null)
        {
            return columnHeaderValues[col];
        }
        else
        {
            return null;
        }
    }

    public String[] getColumnHeaderValues()
    {
        return this.columnHeaderValues;
    }

    public void setColumnHeaderValues(String[] myVals)
    {
        this.columnHeaderValues = myVals;
    }

    public void add(PersonDataObj dataObj)
    {
        int size = personDataObjs.size();
        personDataObjs.add(dataObj);
        fireTableRowsInserted(size, size);
    }

    public void remove(PersonDataObj dataObj)
    {
        if (personDataObjs.contains(dataObj))
        {
            int index = personDataObjs.indexOf(dataObj);
            personDataObjs.remove(dataObj);
            fireTableRowsDeleted(index, index);
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex)
    {
        PersonDataObj dataObj = personDataObjs.get(rowIndex);
        switch (columnIndex)
        {
            case 0:
                return dataObj.getFirstName();
            case 1:
                return dataObj.getLastName();
            case 2:
                return dataObj.getSex();
            case 3:
                return dataObj.getAge();
            case 4:
                return dataObj.getAddress();
            case 5:
                return dataObj.getCity();
            case 6:
                return dataObj.getState();
            case 7:
                return dataObj.getZip();
            case 8:
                return dataObj.getPrimaryPhone();
            case 9:
                return dataObj.getSecondaryPhone();
            case 10:
                return dataObj.getReasonForNeed();
            case 11:
                return dataObj.getPersonOfColor();
            case 12:
                return dataObj.getDateScreened();
            case 13:
                return dataObj.getDateInterviewed();
            case 14:
                return dataObj.getScreenerName();
            case 15:
                return dataObj.getInterviewerName();
            case 16:
                return dataObj.getComments();
        }
        return "";
    }
}