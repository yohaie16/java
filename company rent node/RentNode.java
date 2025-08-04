
/**
 * the class represnt a node of a rent and a linked list of connected nodes
 *
 * @author yohaie elmakies
 * @version 27.01.23
 */
public class RentNode
{
    private  Rent _rent;
    private  RentNode _next;
    /**
     * a constructor of a RentNode which recieves a rent and makes his next null
     * @param Rent r
     */
    public RentNode(Rent r)
    {
        _rent = r;
        _next = null;
    }

    /**
     * a constructor that recieves a rent and a node and make a node which is connected to another node and contain a rent which represents a linked list
     * @param Rent r
     * @param RentNode next
     */
    public RentNode(Rent r, RentNode next)
    {
        _rent = r;
        _next = next;
    }

    /**
     * a copy constructor that recieve a RentNode other and copy it into a different node 
     * it wont make a new node but an exact pointers 
     * @param RentNode other
     */
    public RentNode(RentNode other)
    {
        this._rent = other._rent;
        this._next=other._next;
    }

    /**
     * the method returns the Rent of the Node
     * @returns Rent _rent
     */
    public Rent getRent()

    {
        return(new Rent (_rent));
    }

    /**
     * the method gets the _next of a node 
     * @returns RentNode _next
     */
    public RentNode getNext()
    {
        return(_next);
    }

    /**
     * the method set the rent of node
     * @param Rent r
     */
    public void setRent(Rent r)
    {
        _rent = new Rent (r);
    }

    /**
     * the methods set the next RentNode of a Node
     * @param RentNode next
     */
    public void setNext(RentNode next)
    {
        _next = next;
    }

}
