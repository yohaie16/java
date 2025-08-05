import java.util.NoSuchElementException;

class Node
/**
 * 
 * @param data-an int in the node
 * @param next-a pointer to the next node
 */
{
    int data;
    Node next;

    public Node(int data)
    /**
     * constructor for a node
     * @param data-an int in the node
     * @param next-a pointer to the next node
     */
    {
        this.data = data;
        this.next = null;
    }
}

public class MergeableHeap
/**
 * @param node made out of data and next 
 * @param isSorted a boolean parameter to provide if its sorted or not
 */
{
    private Node head;
    private boolean isSorted;

    public MergeableHeap(boolean isSorted)
    /**
     * a constructor of a mergeableheap can be sorted or not
     * @param node made out of data and next represent the head 
     * @param isSorted a boolean parameter to provide if its sorted(true) or not(false)
     */
    {
        this.head = null;
        this.isSorted = isSorted;
    }

    public static MergeableHeap makeHeap(boolean isSorted)
    /**
     * creates and return a mergeableHeap
     * @param isSorted boolean that represent if the heap is sorted or not
     * @return mergeableHeap
     */
    {
        return new MergeableHeap(isSorted);
    }

    public void insert(int data)
    /**
     * insert a new value into the heap
     * @param data an int value to be inserted to the heap
     */
    {
        Node newNode = new Node(data);
        if (isSorted) {
            if (head == null || head.data > data) {
                newNode.next = head;
                head = newNode;
            } else {
                Node current = head;
                while (current.next != null && current.next.data <= data) {
                    current = current.next;
                }
                newNode.next = current.next;
                current.next = newNode;
            }
        } else {
            newNode.next = head;
            head = newNode;
        }
    }

    public int minimum()
    /**
     * return the smallest value in the heap
     * @return min which is and integer and the minimum value in the heap
     * @return "Heap is empty" if the heap is empty
     */
    {
        if (head == null) {
            throw new NoSuchElementException("Heap is empty");
        }
        if (isSorted) {
            return head.data;
        } else {
            int min = head.data;
            Node current = head.next;
            while (current != null) {
                if (current.data < min) {
                    min = current.data;
                }
                current = current.next;
            }
            return min;
        }
    }

    public int minExtract() 
    /**
     * extract the minimum value out of the heap and returns it 
     * @return min which is the minimum value of the heap
     */
    {
        if (head == null) {
            throw new NoSuchElementException("Heap is empty");
        }
        if (isSorted) {
            int min = head.data;
            head = head.next;
            return min;
        } else {
            Node current = head, prev = null, minNode = head, minPrev = null;
            int min = head.data;

            while (current != null) {
                if (current.data < min) {
                    min = current.data;
                    minPrev = prev;
                    minNode = current;
                }
                prev = current;
                current = current.next;
            }

            if (minPrev == null) {
                head = head.next;
            } else {
                minPrev.next = minNode.next;
            }

            return min;
        }
    }

    public static MergeableHeap union(MergeableHeap h1, MergeableHeap h2) 
    /**
     * merge 2 heaps h1 and h2 into one mergeable heap
     * @param h1 is a mergeable heap
     * @param h2 is a mergeable heap
     * @return newHeap which is the new heap that built out of the other 2 heaps
     */
    {
        if (h1.isSorted != h2.isSorted) {
            throw new IllegalArgumentException("Both heaps must be either sorted or unsorted");
        }

        MergeableHeap newHeap = new MergeableHeap(h1.isSorted);
        if (h1.head == null) return h2;
        if (h2.head == null) return h1;

        if (h1.isSorted) {
            Node dummy = new Node(-1);  // Node עזר להקל על המיזוג
            Node current = dummy;
            Node l1 = h1.head, l2 = h2.head;

            while (l1 != null && l2 != null) {
                if (l1.data <= l2.data) {
                    current.next = l1;
                    l1 = l1.next;
                } else {
                    current.next = l2;
                    l2 = l2.next;
                }
                current = current.next;
            }

            current.next = (l1 != null) ? l1 : l2;
            newHeap.head = dummy.next;
        } else {
            newHeap.head = h1.head;
            Node current = h1.head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = h2.head;
        }

        return newHeap;
    }

    public void printList()
    /**
     * prints out the values of the heap
     */
    {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
}
