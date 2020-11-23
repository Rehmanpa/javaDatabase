package main;

import java.io.Serializable;

/**
 * Created by Jonathan Kipper on 7/29/2019.
 */
public class PersonDataObj implements Serializable, Comparable<PersonDataObj>
{
    private static final long serialVersionUID = 1L;
    private String firstName;
    private String lastName;
    private String age;
    private String sex;
    private String address;
    private String city;
    private String state;
    private String zip;
    private String primaryPhone;
    private String secondaryPhone;
    private String reasonForNeed;
    private String personOfColor;
    private String dateScreened;
    private String dateInterviewed;
    private String screenerName;
    private String interviewerName;
    private String comments;

    //default constructor
    public PersonDataObj()
    {
        this.firstName = null;
        this.lastName = null;
        this.age = null;
        this.sex = null;
        this.address = null;
        this.city = null;
        this.zip = null;
        this.state=null;
        this.primaryPhone = null;
        this.secondaryPhone = null;
        this.reasonForNeed = null;
        this.personOfColor = null;
        this.dateScreened = null;
        this.dateInterviewed = null;
        this.screenerName = null;
        this.interviewerName = null;
        this.comments = null;
    }

    //main constructor
    public PersonDataObj(String firstName, String lastName, String sex, String age, String address, String city, String zip, String state, String primaryPhone, String secondaryPhone,
                         String reasonForNeed, String personOfColor, String dateScreened, String dateInterviewed, String screenerName, String interviewerName, String comments)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.sex = sex;
        this.address = address;
        this.city = city;
        this.zip = zip;
        this.state = state;
        this.primaryPhone = primaryPhone;
        this.secondaryPhone = secondaryPhone;
        this.reasonForNeed = reasonForNeed;
        this.personOfColor = personOfColor;
        this.dateScreened = dateScreened;
        this.dateInterviewed = dateInterviewed;
        this.screenerName = screenerName;
        this.interviewerName = interviewerName;
        this.comments = comments;
    }

    @Override
    public String toString()
    {
        return "PersonDataObj{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zip='" + zip + '\'' +
                ", primaryPhone='" + primaryPhone + '\'' +
                ", secondaryPhone='" + secondaryPhone + '\'' +
                ", reasonForNeed='" + reasonForNeed + '\'' +
                ", personOfColor=" + personOfColor +
                ", dateScreened='" + dateScreened + '\'' +
                ", dateInterviewed='" + dateInterviewed + '\'' +
                ", screenerName='" + screenerName + '\'' +
                ", interviewerName='" + interviewerName + '\'' +
                ", comments='" + comments + '\'' +
                '}';
    }

    //THESE ARE THE GETTERS AND SETTERS

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public String getAge()
    {
        return age;
    }

    public void setAge(String age)
    {
        this.age = age;
    }

    public String getSex()
    {
        return sex;
    }

    public void setSex(String sex)
    {
        this.sex = sex;
    }

    public String getAddress()
    {
        return address;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    public String getCity()
    {
        return city;
    }

    public void setCity(String city)
    {
        this.city = city;
    }

    public String getZip()
    {
        return zip;
    }

    public void setZip(String zip)
    {
        this.zip = zip;
    }

    public String getState()
    {
        return state;
    }

    public void setState(String state)
    {
        this.state = state;
    }

    public String getPrimaryPhone()
    {
        return primaryPhone;
    }

    public void setPrimaryPhone(String primaryPhone)
    {
        this.primaryPhone = primaryPhone;
    }

    public String getSecondaryPhone()
    {
        return secondaryPhone;
    }

    public void setSecondaryPhone(String secondaryPhone)
    {
        this.secondaryPhone = secondaryPhone;
    }

    public String getReasonForNeed()
    {
        return reasonForNeed;
    }

    public void setReasonForNeed(String reasonForNeed)
    {
        this.reasonForNeed = reasonForNeed;
    }

    public String getPersonOfColor()
    {
        return personOfColor;
    }

    public void setPersonOfColor(String personOfColor)
    {
        this.personOfColor = personOfColor;
    }

    public String getDateScreened()
    {
        return dateScreened;
    }

    public void setDateScreened(String dateScreened)
    {
        this.dateScreened = dateScreened;
    }

    public String getDateInterviewed()
    {
        return dateInterviewed;
    }

    public void setDateInterviewed(String dateInterviewed)
    {
        this.dateInterviewed = dateInterviewed;
    }

    public String getScreenerName()
    {
        return screenerName;
    }

    public void setScreenerName(String screenerName)
    {
        this.screenerName = screenerName;
    }

    public String getInterviewerName()
    {
        return interviewerName;
    }

    public void setInterviewerName(String interviewerName)
    {
        this.interviewerName = interviewerName;
    }

    public String getComments()
    {
        return comments;
    }

    public void setComments(String comments)
    {
        this.comments = comments;
    }

    @Override
    public int compareTo(PersonDataObj o)
    {
        return 0;
    }
}