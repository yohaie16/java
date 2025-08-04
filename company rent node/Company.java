/**
 * Maman 14
 * a class that represent a rent company linked list
 * @author- yohaie elmakise
 * 26.01.23
 */
public class Company {
    private RentNode _head; // the head of the linked list

    private boolean IsEmpty()
    {
        return (_head==null);
    }

    /**
     * the empty constructor of a company assign the head to be null.
     */
    public Company()
    {
        _head = null;
    }

    /**
     * addRent is a method that creates a RentNode out of a rent object parameters
     * which are name car pickdate and a return date after it makes a 
     * rentNode out of it and adding it to the linked list if its empty 
     * the node will be the head of it if the adding succeded will retrn true else will return false the node wont be added if there is an exact one already
     * in the list
     * @param name  String
     * @param car  Car
     * @param pick  Date
     * @param ret  Date
     * @return true  if the adding succeded
     * @return false  if the adding isnt possible 
     */
    public boolean addRent(String name, Car car, Date pick, Date ret)
    {
        Rent nr =new Rent(name,car,pick,ret);
        RentNode nnr = new RentNode(nr);
        RentNode curr=_head;
        if(IsEmpty()){
            _head = nnr;
            return true;
        }

        if (curr.getRent().equals(nr))
            return false;

        if (IsBefore(nnr, curr)) {
            nnr.setNext(curr);
            _head = nnr;
            return true;
        }

        while(curr.getNext()!=null){
            if(curr.getRent().getPickDate().equals(nr.getPickDate()) && curr.getRent().getReturnDate().after(nr.getReturnDate()))
            {
                AddRent(curr,nnr);
            }
            else if (curr.getRent().getPickDate().equals(nr.getPickDate()) && curr.getRent().getReturnDate().before(nr.getReturnDate()))
            {
                AddRent(nnr,curr);
            }
            
            if (curr.getRent().equals(nr))
                return false;

            if(IsBefore(nnr,curr)) {
                AddRent(curr,nnr);
                return true;
            }
            curr=curr.getNext();
        }
        curr.setNext(nnr);
        return true;
    }

    private void AddRent(RentNode curr, RentNode nnr)
    {
        nnr.setNext(curr.getNext());
        curr.setNext(nnr);
    }

    private boolean IsBefore(RentNode nnr, RentNode curr){
        Date pickDateBefore = nnr.getRent().getPickDate();
        Date pickDateAfter = curr.getRent().getPickDate();
        if (pickDateBefore.before(pickDateAfter))
            return true;
        if (pickDateBefore.after(pickDateAfter))
            return false;

        int daysBefore = nnr.getRent().howManyDays();
        int daysAfter = curr.getRent().howManyDays();

        return  daysBefore > daysAfter;
    }

    
    /**
     * the method recieve a date and remove the first node that has the rent which his return date is the recieved date if succeed return true else false
     * if the list is empty will return false
     * @param ret  Date
     * @return true if succeded
     * @return false if the date isnt part of the linked list or the list is empty and the removal isnt possible
     */
    public boolean removeRent(Date ret)
    
    {
        if(_head == null)
            return false;
        else {
            RentNode rn = _head;
            if(_head.getRent().getReturnDate().equals(ret)){
                _head=_head.getNext();
                rn.setNext(null);
                return true;
            }
            else{
                while(rn.getNext()!=null){
                    if(rn.getNext().getRent().getReturnDate().equals(ret)){
                        RentNode delete = rn.getNext();
                        rn.setNext(delete.getNext());
                        delete.setNext(null);
                        return true;
                    }
                    rn = rn.getNext();
                }
                return false;
            }
        }
    }

    /**
     * the method returns the number of rents that a linked list has in it
     * @returns count int the number of rents
     */
    public int getNumOfRents()
    
    {
        int count =0;

        RentNode curr = _head;
        while(curr != null){
            count++;
            curr = curr.getNext();
        }
        return count;
    }

    
    /**
     * the method returns the sum of prices of all rents in a linked list
     * @ returns prices int the sum of all rents int linked list
     */
    public int getSumOfPrices()
    
    {
        int prices = 0;

        RentNode curr = _head;
        while (curr != null) {
            prices += curr.getRent().getPrice();
            curr = curr.getNext();
        }
        return prices;
    }

    /**
     * the method returns the sum of days of all the rents in the linked list
     * @returns int days which is the sum of all days
     */
    public int getSumOfDays()
    
    {
        int days = 0;

        RentNode curr = _head;
        while (curr != null) {
            days += curr.getRent().howManyDays();
            curr = curr.getNext();
        }
        return days;
    }

    /**
     * the method returns the average amount of days per rent in a linked list if the list is empty 0 will be returned
     * @returns double which is the average days of a rent in the linked list will return 0 if the list is empty
     */
    public double averageRent()
    
    {
        if(_head==null)
            return 0;

        return (double)getSumOfDays()/getNumOfRents();
    }

    /**
     * the method returns the last car in the linked list if the list is empty will return null
     * @returns Car which is the last car rented on the linked list
     */
    public Car lastCarRent()
    
    {
        if(_head == null)
            return null;

        RentNode curr = _head;
        Rent lastRent = curr.getRent();

        while(curr != null){
            if(curr.getRent().getReturnDate().after(lastRent.getReturnDate())){
                lastRent = curr.getRent();
            }
            curr = curr.getNext();
        }
        return new Car(lastRent.getCar());
    }

    /**
     * the method returns the logest rent on the linked list if the list id empty will return null
     * @returns Rent  rentLongest which is the longest rent on the list
     */
    public Rent longestRent()
    
    {
        if(_head==null)
            return null;

        RentNode curr = _head;
        Rent rentLongest = curr.getRent();
        int longest = curr.getRent().howManyDays();

        while (curr != null){
            if(curr.getRent().howManyDays() > longest){
                longest =  curr.getRent().howManyDays();
                rentLongest = curr.getRent();
            }
            curr = curr.getNext();
        }
        return new Rent(rentLongest);
    }

    /**
     * the method returns the most common rate of cars in the list if 2 rates have the same amount in the list the method will returns the highest
     * rate from both ( D is higher than C that higher than B that higher than A) if the list is empty will return N
     * @returns char the most common one if list is empty returns N
     */
    public char mostCommonRate()
    
    {
        RentNode curr = _head;
        if(curr == null)
            return 'N';

        int numA =0, numB =0, numC =0, numD =0;

        while(curr!=null){
            if(curr.getRent().getCar().getType()=='A')
                numA++;
            else if(curr.getRent().getCar().getType()=='B')
                numB++;
            else if(curr.getRent().getCar().getType()=='C')
                numC++;
            else
                numD++;
            curr = curr.getNext();
        }

        int Mostcommon = Math.max(Math.max(numD, numC),Math.max(numB, numA));
        if(Mostcommon == numD)
            return 'D';
        if(Mostcommon == numC)
            return 'C';
        if(Mostcommon == numB)
            return 'B';
        else
            return 'A';
    }

    /**
     * the method recieve an other company and returns a boolean variable true or false which true if the other company is include in the company the method
     * is working on which is only if every rent in other is in the method company in the same way not have to be sticked one to other like
     * in the other linked list when the other is empty the method returns true else false
     * @returns true if the company included in the company that turned the method on the variable else returns false.
     * @param other  Company
     */
    public boolean includes(Company other)
    
    {

        RentNode otherNode = other._head;
        if(otherNode == null)
            return true;

        RentNode curr = _head;
        if(curr==null)
            return false;

        while(otherNode != null){
            if(curr == null)
                return false;
            if(otherNode.getRent().equals(curr.getRent())){
                otherNode = otherNode.getNext();
                curr = curr.getNext();
            }
            else
                curr = curr.getNext();
        }
        return true;
    }

    /**
     * the method recieves a company other and merge it into the method company if there is a dupplicate it wont add it 
     * 
     * @param other Company
     */
    public void merge(Company other)
    

    {
        RentNode otherNode = other._head;
        while(otherNode != null){
            addRent(otherNode.getRent().getName(), otherNode.getRent().getCar(), otherNode.getRent().getPickDate(), otherNode.getRent()
                .getReturnDate());
            otherNode = otherNode.getNext();
        }
    }

    /**
     * the method returns a string that represent the linked list.
     * @returns String  s 
     */
    public String toString()
    
    {
        if(_head == null)
            return "The company has "+ getNumOfRents() +" rents.";

        String s = "The company has "+ getNumOfRents() +" rents:\n";
        RentNode curr = _head;
        while (curr !=null){
            s+= curr.getRent().toString()+"\n";
            curr = curr.getNext();
        }
        return s;
    }

}
