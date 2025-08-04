
/**
 * class rent use objects from class Car and class Date to describe a rent of a car in time periods, names of the renter, the car type, and car upgrades.
 * the program can determine which car is better and with this intel request the gap the renter needs to pay extra
 * the rogram calculate the days amount of rent 
 * the program eventually return a string of the name of the renter the dates period the amount he paid which car type and how many days he rented the car
 * @author yohaie elmakis
 * @version 14/11/22
 */
public class Rent
{
    private String _name;  /*making istance variables of the whole class which some of them are part of the Car or Date class*/
    private Car _car;
    private Date _pickDate;
    private Date _returnDate;
    private final int A_PRICE = 100; /* making a final instance variable of the diffrent prices of different car types*/
    private final int B_PRICE = 150;
    private final int C_PRICE = 180;
    private final int D_PRICE = 240;
    private final int DAYS_IN_WEEK =7; /* a final instance of the days amount in one week*/
    private final int A_AFTER_DISCOUNT = 90; /* a final instances of the price of each car types after the discount*/
    private final int B_AFTER_DISCOUNT = 135;/* which the renters get for every full week they rent a car from any type but not for part of a week*/ 
    private final int C_AFTER_DISCOUNT = 162;
    private final int D_AFTER_DISCOUNT = 216;
    /**
     * Constructor for objects of class Rent
     * if the return date is beofre the pickup date the return date will be a day after the pickup date
     * @param name of the renter
     * @param car of the renter
     * @param date of pick the car of type Date
     * @param date of return the car of type Date
     */
    public Rent(String name, Car car, Date pick,Date ret)
    {
        _name = name;
        _car = new Car(car);
        _pickDate = new Date(pick);
        if ((ret.before(pick)) || (ret.equals(pick)))
        {
            _returnDate = pick.tomorrow();

        }
        else
        {
            _returnDate = new Date(ret);  
        }    
    }//end of Rent constructor
    /**
     * copy constructor 
     * @param Rent other which is the Rent to be copied
     */
    public Rent (Rent other)
    {    
        this._name = other._name;
        this._car = new Car (other._car);
        this._pickDate = new Date(other._pickDate);
        this._returnDate = new Date(other._returnDate);
    }// end of copy constructor Rent
    /**
     * gets the name 
     * @return string of the name
     */
    public String getName()
    {
        return (_name);
    }// end of getName
    /**
     * gets the Car  
     * @return a Car object _car 
     */
    public Car getCar(){
        return new Car (_car);
    }// end of getCar

    /**
     * method which return the date of the renter picking up the car
     * @return the date of pickup which is _pickup
     */
    public Date getPickDate(){
        return new Date(_pickDate);
    }//end of getPickDate
    /**
     * method which return the date of the renter returning the car
     * @return the date of returning the car which is _returnDate 
     */
    public Date getReturnDate(){
        return new Date(_returnDate);
    }//end of getReturnDate
    /** 
     * method which set the name of the renter
     *@param name which is a string
     *
     */
    public void setName(String name)
    {
        _name = name;
    }//end of setName
    /**
     * method which set the car of the renter
     *@param Car car the rented car
     */
    public void setCar(Car car)
    {
        _car = new Car (car);
    }

    /**
     * method which set the date of picking up the car of the renter
     * the date must be at least one day before return date otherwise
     * it doesnt change
     * @param pickDate which is from type Date 
     */
    public void setPickDate(Date pickDate)
    {
        if (pickDate.before(this._returnDate))
        {
            _pickDate = new Date (pickDate);
        }
    }//end setPickDate
    /**
     * method which set the date of returning the car of the renter
     * the date must be at least one day after the pick date otherwise 
     * it doesnt change
     * @param returnDate which is from type Date
     */
    public void setReturnDate(Date returnDate)
    {
        if(returnDate.after(this._pickDate))
        {
            _returnDate = new Date(returnDate);
        }
    }//end of setReturnDate
    /**
     * method which return true if one rent equals other one rents are equals only if the names , pickDates, returnDate and cars are the same
     * @param other from type Rent
     * @return true if the cars are equals otherwise false 
     */
    public boolean equals(Rent other) 
    {
        if (this._name == other._name && this._pickDate.equals(other._pickDate) && this._returnDate.equals(other._returnDate) && this._car.equals(other._car))
        {
            return true;
        }
        return false;
    }//end of equals
    /**
     * method which calculate the days past from the pickDate until the returnDate
     * @return numbers of days from the beginning of the rent to the returnDate
     */
    public int howManyDays()
    {
        return this._pickDate.difference(_returnDate);
    }//end of howManyDays
    /**
     * method which get the price of the deal which is calculated by days amount car type and if there is a discount for renting for more than a week
     * @return the rent total price
     */
    public int getPrice()
    {
        int rentDays = this.howManyDays(); // the amount of days of renting
        int weeksWithDiscount = rentDays / DAYS_IN_WEEK;// the amount of full weeks of renting without the leftovers days
        int daysWithoutDiscount = rentDays % DAYS_IN_WEEK; // the days which are left from the unfinished week
        if (_car.getType() == 'A'){
            return ((DAYS_IN_WEEK * weeksWithDiscount*A_AFTER_DISCOUNT) + (daysWithoutDiscount*A_PRICE));
        }
        else if (_car.getType() == 'B'){
            return ((DAYS_IN_WEEK * weeksWithDiscount*B_AFTER_DISCOUNT) + (daysWithoutDiscount *B_PRICE));

        }
        else if (_car.getType() == 'C'){
            return ((DAYS_IN_WEEK * weeksWithDiscount*C_AFTER_DISCOUNT) + (daysWithoutDiscount *C_PRICE));    
        }
        else{
            return ((DAYS_IN_WEEK * weeksWithDiscount*D_AFTER_DISCOUNT) + (daysWithoutDiscount *D_PRICE));
        }

    }//end of getPrice
    /**
     * try to upgrade the car to a new car if it is better
     * the method will return the price gap between 2 cars after upgrading
     * from one to other otherwise dont upgrade
     * @param newCar which is the car to upgrade to
     * @return the upgrade costs
     */
    public int upgrade (Car newCar)                                
    {
        if(newCar.better(this._car))
        {
            int priceCarBeforeUpgrade= getPrice();
            _car = new Car(newCar);
            int price_increase = getPrice() - priceCarBeforeUpgrade;
            return price_increase;
        }
        return 0;
    }//end of upgrade
    /**
     * a method that checks if there is a double registration of the same name 
     * and car in dates that are going one through
     * other if there is it colides them into one so the pickDate will be the 
     * earlier one and the returnDate will be the later one otherwise return null
     * @param other from type of Rent
     * @return the unified rent or null 
     */
    public Rent overlap (Rent other) 
    {
        if (this._name.equals(other._name) && this._car.equals(other._car))
        {
            if((_pickDate.equals(other._pickDate) && (_returnDate.equals(other._returnDate)) || ((other._pickDate.before(_pickDate) && other._returnDate.after(_returnDate)) || (other._pickDate.equals(_pickDate) && other._returnDate.after(_returnDate)) || other._pickDate.before(_pickDate) && other._returnDate.equals(_returnDate)))){
                return (other);
            }
            else if(_pickDate.after(other._returnDate) || _returnDate.before(other._pickDate)){
                return null;
            }
            else if(((_pickDate.before(other._pickDate) && _returnDate.after(other._returnDate)) || (_pickDate.equals(other._pickDate) && _returnDate.after(other._returnDate)) || _pickDate.before(other._pickDate) && _returnDate.equals(other._returnDate))){
                return (this);
            }
            else if(_pickDate.before(other._pickDate) &&(_returnDate.equals(other._pickDate) || (_returnDate.after(other._pickDate) && _returnDate.before(other._returnDate))))
            {
                return (new Rent(_name , _car, this._pickDate, other._returnDate));
            }
            else 
            {
                return (new Rent(_name,_car,other._pickDate,this._returnDate));
            }
        }
        return null;
    }//end of overlap
    /**
     * method which return a string of the rent which includes the name,pick and return Dates, car type, days amount and price. 
     * @return String that represents this rent in the following format: Name:Rama From:30/10/2022 To:12/11/2022 Type:B Days:13 Price:1845 
     * @Overrides toString in class java.lang.Object
     */
    public String toString()
    {
        return ("Name:" + _name + " From:" + _pickDate + " To:" + _returnDate + " Type:" + _car.getType() + " Days:" + howManyDays() + " Price:" + getPrice());
    }//end of toString
}// end of class

