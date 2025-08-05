
/**
 * the discription and the algorithim analaysics-
 * 
 * Discriptions-
 * *general discription*
 * the mergeableHeap program is devided into 2 clases one that operates the nodes and other that execute the methods
 * the first class which called node gets the values and data to make nodes which in the end will represent an mergeableHeap
 * the second class which is called mergeableHeap operates method which applies on the heaps creates heaps and make changes on them like merging,adding values,extracting values, print and etc
 *
 * algorithim analaysics  complexity and rightness discription-
 * *constructor analaysics*
 * function MergeableHeap(issorted):
    head←null
    this.issorted←issorted
    complexity: O(1)
   
 * *makeHeap analaysics* 
 * function makeHeap(isSorted):
    return new MergeableHeap(isSorted)
 * complexity: O(1)
 
     
 * *insert analaysics*
 * function insert(data):
    newNode←new Node(data)
    if isSorted:
        if head is null or head.data > data:
            newNode.next←head
            head←newNode
        else:
            current←head
            while current.next is not null and current.next.data <= data:
                current←current.next
            newNode.next←current.next
            current.next←newNode
    else:
        newNode.next←head
        head←newNode
    
        
    rightness description:
    if the heap is sorted the algorithm look up for the right place to insert the value otherwise 
    if the heap isnt sorted the value will just be added in the start of the heap
    complexity: if the heap is sorted O(n) otherwise O(1)
    
    
    *minimum analaysics*
    function minimum:
    if head is null:
        throw NoSuchElementException("Heap is empty")
    if isSorted:
        return head.data
    else:
        min←head.data
        current←head.next
        while current is not null:
            if current.data < min:
                min←current.data
            current←current.next
        return min
    rightness description:
    if the heap is sorted the smallest value is in the head otherwise we will need to pass all over the heap to find the minimum
    loop invariant:At each iteration of the loop, the variable min holds the minimum value encountered so far among the elements traversed. 
    complexity:
    if the heap is sorted O(1) otherwise O(n)
    
    *minExtract analaysics*
    function minExtract:
    if head is null:
        throw NoSuchElementException("Heap is empty")
    if isSorted:
        min←head.data
        head←head.next
        return min
    else:
        current←head
        prev←null
        minNode←head
        minPrev←null
        min←head.data

        while current is not null:
            if current.data < min:
                min←current.data
                minPrev←prev
                minNode←current
            prev←current
            current←current.next

        if minPrev is null:
            head←head.next
        else:
            minPrev.next←minNode.next

        return min
rightness description:
If the heap is sorted, the smallest value resides at the head. Otherwise, it necessitates traversing the entire heap to locate the minimum value.
loop invariant: During each iteration of the loop, the variable min stores the minimum value found in the current portion of the heap being traversed. Additionally, minNode points to the node containing the minimum value encountered thus far, and minPrev points to the node preceding minNode.
complexity:
if the heap is sorted O(1)
if the heap isnt sorted O(n)

*union analaysics*

function union(h1, h2):
    if h1.isSorted != h2.isSorted:
        throw IllegalArgumentException("Both heaps must be either sorted or unsorted")

    newHeap←new MergeableHeap(h1.isSorted)
    if h1.head is null:
        return h2
    if h2.head is null:
        return h1

    if h1.isSorted:
        dummy←new Node(-1)
        current←dummy
        l1←h1.head
        l2←h2.head

        while l1 is not null and l2 is not null:
            if l1.data <= l2.data:
                current.next ← l1
                l1←l1.next
            else:
                current.next←l2
                l2←l2.next
            current←current.next

        current.next←if l1 is not null then l1 else l2
        newHeap.head←dummy.next
    else:
        current←h1.head
        while current.next is not null:
            current←current.next
        current.next←h2.head
        newHeap.head←h1.head

    return newHeap
rightness description:
When both heaps are sorted, the algorithm merges them while maintaining the sorted order. However, if the heaps are not sorted, it simply connects them without any further rearrangement.
loop invariant:Throughout the loop execution, the algorithm correctly merges the elements from both heaps while preserving the sorted order if the heaps are sorted. In the case of unsorted heaps, the algorithm successfully connects them without modifying their original order.
complexity:
if they are sorted O(n+m) otherwise if they are not sorted its O(1)
    

 * printList analysis-
 * 
 *
 * function printList:
 *    current←head
 *    while current is not null:
 *        print current.data
 *        current←current.next
 *    prints the elements of the linked list starting from the head until the end of the list.
 *    
 * Rightness Description:
 * The printList method traverses the linked list starting from the head node and prints the data of each node until it reaches the end of the list. It ensures that all elements of the list are printed in the correct order.
 * 
 * Loop Invariant:
 * At each iteration of the loop, the variable `current` points to the node whose data is to be printed next. As long as `current` is not null, the loop continues to print the data of each node in the linked list.
 * 
 * Complexity:
 * The complexity of the printList method is O(n), where n is the number of elements in the linked list. This is because it iterates through each node in the list exactly once to print its data.
 * 
    
 *
 */

