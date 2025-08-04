
/**
 * This class represents a Car object 
 * @author yohaie elmakis
 * @version 21/11/2022
 */
public class Car
{
    private int _id; // the id of a car represented by an integer
    private char _type; // the type of a car represented by a char
    private String _brand;// the brand of the car represented by a string
    private boolean _isManual;// represent if the car is manual or not by truth for manual or false for not manual which is auto
    private final int DEFAULT_ID = 9999999;// a final that represent the default id of a car 
    private final int MAX_ID = 9999999;// a final that represent the max id
    private final int MIN_ID = 1000000;// a final that represent the min id 
    private final char DEFAULT_TYPE = 'A'; // represent the default type when a not valid type is written 
    private final String MANUAL = "manual";// a final that represent the string manual
    private final String AUTO = "auto";// a final that represent the string auto
    /**
     * Constructor for objects of class Car
     * creates a car object id should be a 7 digit number
     * otherwise set it to 9999999
     * type should be 'A' or 'B' or 'C' or 'D' 
     * otherwise set it to 'A'
     * @param id of a car which is a 7 numbers length number
     * @param type of a car which is represented by a char between A,B,C or D 
     * @param brand of a car which is represented by a string
     * @param isManual which is from type boolean and return true for a manual car and fulse for an auto car
     */
    public Car(int id, char type, String brand, boolean isManual)
    {
        if (id >= MIN_ID && id <= MAX_ID )
        {
            this._id = id;
        }
        else
        {
            this._id = DEFAULT_ID;
        }
        if (type == 'A' || type == 'B' || type == 'C' || type == 'D'){
            this._type = type;
        }
        else
        {
            this._type = DEFAULT_TYPE;
        }
        this._brand = brand;
        this._isManual = isManual; 
    }//end of constructor car

    /** 
     * copy constructor
     * @param other which is the car to be copied
     */
    public Car(Car other){
        this._id = other._id;
        this._type = other._type;
        this._brand = other._brand;
        this._isManual = other._isManual;
    }//end of copy constructor

    /**
     * gets the id of the car
     * @return the cars's id
     */
    public int getId()
    {
        return (_id);
    }//end of get id

    /**
     * gets the type of the car
     * @return the car's type
     */
    public char getType()
    {
        return (_type);
    }//end of get type

    /**
     * gets the brand of the car
     * @return the car brand
     */
    public String getBrand()
    {
        return (_brand);
    }//end of get brand

    /**
     * gets if the car is manual(truth) or auto(false)
     * @return truth or false 
     */
    public boolean isManual()
    {
        return (_isManual);
    }//end of isManual

    /**
     * sets the id of the car if it is valid
     * @param id which is the id to be set 
     */
    public void setId(int id)
    {
        if (id >= MIN_ID && id <= MAX_ID)
        {
            _id = id;
        }
    }//end of setId

    /**
     * sets the type of a car if its valid
     * @param type which is between 'A','B','C' or 'D'
     */
    public void setType(char type)
    {
        if (type == DEFAULT_TYPE || type == 'B' || type == 'C' || type == 'D')
        {
            _type = type;
        }
    }//end of setType

    /**
     * sets the brand of a car
     * @param brand which is a string
     */
    public void setBrand(String brand)
    {
        _brand = brand;
    }//end of setBrand

    /**
     * sets if the car is manual or auto
     * @param manual which is a boolean type truth or false
     */
    public void setIsManual(boolean isManual)
    {
        _isManual = isManual;
    }//end of setIsManual

    /**
     * this method checks if the car is auto or manual and returns a string of its id,type,brand and gear
     * Returns a String that represents this car
     * @return String that represents this car in the following format: id:1234567 type:B brand:Toyota gear:manual (or auto)
     * @overrides toString in class java.lang.Object
     */
    public String toString()
    {
        if(this._isManual)
        {
            return ("id:" + _id + " " +  "type:" + _type + " " + "brand:"+ _brand + " " + "gear:" + MANUAL);
        }
        else
        {
            return ("id:" + _id + " " +  "type:" + _type + " " + "brand:"+ _brand + " " +  "gear:" + AUTO);
        }
    }//end of toString

    /**
     * this method checks if two cars are the same cars
     * 2 cars are the same if their brand,gear and type are the same
     * @param car other which is other from type car 
     * @return if two cars are equals truth else false
     */
    public boolean equals (Car other)
    {
        return (this._brand.equals(other._brand) && this._isManual == other._isManual && this._type == other._type);
    }//end of equals

    /**
     * the method better checks if a car is better than other car
     * other car is better if its type is higher than other car but if they are the same type the car which is auto is better if the other is manual
     * @param Car other
     * @return true if car is better than other otherwise false
     */
    public boolean better (Car other)
    {
        if (this._type > other._type){
            return true;
        }
        else if (this._type == other._type){
            if (this._isManual == false && other._isManual == true){
                return true;
            }
        }
        return false;
    }//end of better
    /**
     * the method worse checks if the car is worse than other car 
     * other car is worse if it has a lower type than the car if the types are the same a manual car is worse than auto car
     * the method uses the better method in the opposite direction
     * @param Car other
     * @return true if car is worse otherwise false
     */
    public boolean worse(Car other)
    {
        return (other.better(this));
    }//end of worse
}
//end of class
