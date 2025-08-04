/**
 * this class represent a date object
 * @author yohaie elmakis
 * @version 21/11/2022
 */
public class Date
{
    // instance variables
    private int _day;// Number between 1 - 31
    private int _month;// Number between 1 - 12
    private int _year;//  4 digit number
    //------------------limits of date parts------------------//
    private final int MAX_YEAR = 9999; // max year which is the default year if a not valid year is given
    private final int MIN_YEAR = 1000;//min year
    private final int MAX_MONTH = 12;//max month which is the months amount in a year
    private final int MIN_MONTH = 1;// min month
    private final int MAX_DAY = 31;//max day which is the most days which a month can have which is 31 
    private final int MIN_DAY = 1;// min days
    private final int MAX_DAYS_SHORT_MONTH = 30;//the days amount in short months
    //------------------default------------------//
    private final int DEF_YEAR = 2000;// year to reset to whem not vaild year is inputed
    //------------------finals for date checking and months represention------------------//
    private final int TWO_INT_DAY = 10;//a final to check if its a day in the month which is less than 10
    private final int FEBRUARY_LEAP_MAX = 29;//the days in fabruary when its a leap year
    private final int FEBRUARY_REGULAR_MAX = 28;// the days in february when its not a leap year
    private final int FEBRUARY = 2; // february
    private final int APRIL = 4;//april
    private final int JUNE =6;//june
    private final int SEPTEMBER = 9;//september
    private final int NOVEMBER = 11;//november
    private final int CENTURY = 100;// a century has 100 years in it
    private final int LEAP_YEAR_CENTURY = 400;// a century which is leap has no remnant when divided by 400
    private final int LEAP_YEAR_NOT_CENTURY = 4;// a leap year which isnt a century has no remnant when devided by 4
    /**
     * a method that use a formula to calculate the amount of days from the begining of the christian counting
     * @param day which is the day in the date
     * @param month which is the month of the date
     * @param year which is the year of the date
     * @return the amount of days past since the start of the christian counting
     */
    private int calculateDate( int day, int month, int year)// calculate the day number since the begining of the christian counting of years
    {
        if(month < 3)
        {
            year--;
            month = month + MAX_MONTH;
        }
        return 365 * year + year/4 - year/100 + year/400 + ((month+1) * 306)/10 + (day - 62);
    }//end of calculateDate

    /**
     * Method that check if the inserted year is vaild 
     * the method checks if its a leap year which month and if its february 
     * it check if 29th can be inserted else the date will be the first of march
     * the method checks if the day number is a valid for the month 
     * the method checks if the month is not more than the month amount in a year and not less than 1
     * the method checks that the year is between the given minimum year and maximum year
     *
     *

     *@param day of the date as integer
     * @param month of the date as integer
     * @param year of the date as integer
     * @return truth if the date is valid otherwise false
     */

    private boolean checker(int day, int month, int year)
    {
        boolean check = true;
        // Checking if the year is leap year
        if(year >= MIN_YEAR && year <= MAX_YEAR && ((year % CENTURY == 0)? year % LEAP_YEAR_CENTURY == 0 : year % LEAP_YEAR_NOT_CENTURY == 0))
        {
            if( month >= MIN_MONTH && month <= MAX_MONTH)
            {
                if(month == FEBRUARY)
                {
                    if (day >= MIN_DAY && day <= FEBRUARY_LEAP_MAX)
                    {
                        return check;
                    }
                    else
                    {
                        check = false;
                    }
                }
                else if(month ==  APRIL || month == JUNE || month == SEPTEMBER || month == NOVEMBER)
                {
                    if(day >= MIN_DAY && day <= MAX_DAYS_SHORT_MONTH)
                    {
                        return check;
                    }
                    else
                    {
                        check = false;
                    }
                }
                else
                {
                    if(day >= MIN_DAY && day <= MAX_DAY)
                    {
                        return check;
                    }
                    else
                    {
                        check = false;
                    }
                }
            }
            else
            {
                check = false;
            }
        }
        // Checking the date
        else if(month >= MIN_MONTH && month <= MAX_MONTH && year >= MIN_YEAR && year <= MAX_YEAR)
        {
            if (month == FEBRUARY)
            {
                if(day >= MIN_DAY && day <= FEBRUARY_REGULAR_MAX)
                {
                    return check;
                }
                else
                {
                    check = false;
                }
            }
            else if(month ==  APRIL || month == JUNE || month == SEPTEMBER || month == NOVEMBER)
            {
                if(day >= MIN_DAY && day <= MAX_DAYS_SHORT_MONTH)
                {
                    return check;
                }
                else
                {
                    check = false;
                }
            }
            else
            {
                if(day >= MIN_DAY && day <= MAX_DAY)
                {
                    return check;
                }
                else
                {
                    check = false;
                }
            }
            return check;
        }
        check = false;
        return(check);

    }// end of isDateValid method
    /**
     * this constructor make a date from day, month and a year 
     * the constuctor use the checker method to check if the given parameters are valid if they do he makes a date otherwise reset it to default date
     * the default date is 01/01/2000
     * @param day which is an integer which is not less than 1 and not above 31 as the numbers of days in a month
     * @param month which is an integer between 1 to 12 which are the minimum and maximum months in a year
     * @param year which is an integer between 1000 to 9999 which are the minimum and maximum years 
     */
    public Date(int day, int month, int year)
    {
        if (checker(day,month,year)){
            this._day = day;
            this._month = month;
            this._year = year;
        }
        else {
            this._day = MIN_DAY;
            this._month = MIN_DAY;
            this._year = DEF_YEAR;
        }
    }//end of constructor date
    /**
     * copy constructor 
     * @param Date other which is the date to be copied
     */
    public Date(Date other){    
        this._day = other._day;
        this._month = other._month;
        this._year = other._year;

    }//end of copy constructor

    /**
     * gets the day of the date
     *
     * @return the day 
     */
    public int getDay()
    {
        return (_day);
    }//end of getDay

    /**
     * gets the month of the date
     *
     * @return the month 
     */
    public int getMonth()
    {
        return (_month);
    }//end of getMonth

    /**
     * gets the year of the date
     *
     * @return the year 
     */
    public int getYear()
    {
        return (_year);
    }//end of getYear

    /**
     * sets the day of the date if not vallid doesnt change anything
     * @param dayToSet which is the day to set in the date can be between 1-31 or less depends on the month
     */
    public void setDay(int dayToSet)
    {
        if(checker(dayToSet,_month,_year)){
            _day = dayToSet;
        }
    }//end of setDay

    /**
     * sets the month of the date if not vallid doesnt change anything
     * @param monthToSet which is the month to set in the date can be between 1-12 
     */
    public void setMonth(int monthToSet)
    {
        if (checker(_day,monthToSet,_year)){
            _month = monthToSet;
        }
    }//end of setMonth

    /**
     * * sets the year of the date if not vallid doesnt change anything
     * @param yearToSet which is the year to set in the date can be between 1000 to 9999 
     */
    public void setYear(int yearToSet)
    {
        if (checker(_day,_month,yearToSet)){
            _year = yearToSet;
        }
    }//end of setYear

    /**
     * a method that says if the given date is equal or not to the other date
     * @param Date other
     * @return truth if the dates are equals otherwise false
     */
    public boolean equals(Date other){
        return (other._day == this._day && other._month == this._month && other._year == this._year);
    }//end of equals

    /**
     * a method that says if the given date is before the other date
     * @param Date other
     * @return truth if the given date is before the other date otherwise false
     */
    public boolean before(Date other){
        return (this._day < other._day && this._month == other._month && this._year == other._year) || (this._month < other._month && this._year == other._year) || (this._year < other._year);
    }//end of before

    /**
     * a method the checks if the other date is before the given date
     * @param Date other
     * @return truth if the given date is after the other date otherwise false
     */
    public boolean after(Date other){ 
        return other.before(this);
    }//end of after
    /**
     * a method that checks the days difference between 2 dates
     * @param Date other
     * @return the difference between 2 dates in days as a not negetive integer
     */
    public int difference(Date other)
    {
        int difference = Math.abs((calculateDate(this._day,this._month,this._year) - calculateDate(other._day,other._month,other._year)));
        return difference;
    }//end of difference
    /**
     * a method that makes a string of the date and adds 0 if the days or month are one number
     * @return a string of the date in a syntax of day/month/year 
     * when days and months are 2 digits number and year is 4 digits number
     */
    public String toString(){
        String d = new String();
        String m = new String();
        if (_day < TWO_INT_DAY){
            d = "0" + this._day;
        }
        else
        {
            d = "" + this._day;
        }
        if (_month < TWO_INT_DAY){
            m = "0" + this._month;
        }
        else 
        {
            m = ""+this._month;
        }
        return (d + "/" + m + "/" + _year);
    }//end of toString
    /**
     * a method that return the date of tomorrow after checking if adding a day
     * to the date is valid otherwise checks with the month plus one and minimum day
     * otherwise minimum day an minimum month and year plus one
     * @return the date of tomorrow
     */
    public Date tomorrow()
    {
        int dayOfTomorrow = this._day;
        int monthOfTomorrow = this._month;
        int yearOfTomorrow = this._year;
        if(checker(this._day+1, this._month, this._year))
        {
            Date tomorrow = new Date(dayOfTomorrow + 1 , monthOfTomorrow, yearOfTomorrow);
            return tomorrow;
        }
        if(checker(MIN_DAY, this._month + 1, this._year)){
            Date tomorrow = new Date(MIN_DAY,monthOfTomorrow + 1,yearOfTomorrow);
            return tomorrow;
        }

        Date tomorrow = new Date (MIN_DAY, MIN_MONTH, yearOfTomorrow + 1);
        return tomorrow;

    }
}//end of class
