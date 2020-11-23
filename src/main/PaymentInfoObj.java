package main;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Contains the following information: Amount of $ owed, how much they've gathered, what can they contribute
 * what other agencies have donated (and perhaps amounts?) (use a map?)
 * DATE FORMAT: "MM/dd/yyyy"
 *
 * @author Jonathan Kipper
 * @version 7/31/2019
 */
public class PaymentInfoObj implements Comparable<PaymentInfoObj>
{
    //fields
    private Double totalOwed;
    private Double totalGathered;
    private Double maxContribution;
    private Date date;

    //DATE FORMAT: "MM/dd/yyyy"

    public PaymentInfoObj()
    {
        this.totalOwed = null;
        this.totalGathered = null;
        this.maxContribution = null;
        this.date = null;
    }

    public PaymentInfoObj(Double totalOwed, Double totalGathered, Double maxContribution, String date)
    {
        //makes sure parameters are not null!
        if (totalOwed == null)
        {
            throw new NullPointerException("(PaymentInfoObj): totalOwed is null!");
        }

        if (totalGathered == null)
        {
            throw new NullPointerException("(PaymentInfoObj): totalGathered is null!");
        }

        if (maxContribution == null)
        {
            throw new NullPointerException("(PaymentInfoObj): maxContribution is null!");
        }

        if (date == null)
        {
            throw new NullPointerException("(PaymentInfoObj): date is null!");
        }
        else if (date.isEmpty())
        {
            throw new IllegalArgumentException("(PaymentInfoObj): date string is empty!");
        }
        else if (!DateClass.isValidDate(date)) //makes sure the date is in the correct format
        {
            throw new IllegalArgumentException("(PaymentInfoObj): the date string is an invalid format!");
        }

        //prevents negatives
        totalOwed = Math.abs(totalOwed);
        totalGathered = Math.abs(totalGathered);
        maxContribution = Math.abs(maxContribution);

        this.totalOwed = totalOwed;
        this.totalGathered = totalGathered;
        this.maxContribution = maxContribution;

        //deals with the date
        try
        {
            DateFormat format = new SimpleDateFormat(GlobalVariables.MAIN_DATE_FORMAT);
            this.date = format.parse(date);
        } catch (ParseException e)
        {
            e.printStackTrace();
        }
    }


    //Getters and Setters

    public Double getTotalOwed()
    {
        return totalOwed;
    }

    public Double getTotalGathered()
    {
        return totalGathered;
    }

    public Double getMaxContribution()
    {
        return maxContribution;
    }

    public Date getDate()
    {
        return date;
    }

    public void setTotalOwed(Double totalOwed)
    {
        this.totalOwed = totalOwed;
    }

    public void setTotalGathered(Double totalGathered)
    {
        this.totalGathered = totalGathered;
    }

    public void setMaxContribution(Double maxContribution)
    {
        this.maxContribution = maxContribution;
    }

    public void setDate(String date)
    {
        if (!DateClass.isValidDate(date)) //makes sure the date is in the correct format
        {
            throw new IllegalArgumentException("(PaymentInfoObj from the setter): the date string is an invalid format!");
        }

        try
        {
            DateFormat format = new SimpleDateFormat(GlobalVariables.MAIN_DATE_FORMAT);
            this.date = format.parse(date);
        }
        catch (ParseException e)
        {
            e.printStackTrace();
        }
    }

    /*
       How to tell if PaymentInfoObjects are equivalent or not (sorting):

       Deals with the ordering of objects in a TreeMap/TreeSet

       prioritizes by DATE, then by what they owe, and then by what what they have already gathered
     */
    @Override
    public int compareTo(PaymentInfoObj o)
    {
        DateFormat format = new SimpleDateFormat("MM/dd/yyyy");
        Date date1 = new Date();
        Date date2 = new Date();

        try
        {
            date1 = format.parse(getDate().toString());
            date2 = format.parse(o.getDate().toString());
        } catch (ParseException e)
        {
            e.printStackTrace();
        }

        if (date1.compareTo(date2) < 0)
        {
            return -1;
        }
        else if (date1.compareTo(date2) > 0)
        {
            return 1;
        }

        //deals with the comparison of the dates
        return Integer.compare(date1.compareTo(date2), 0);
    }
}