public class Main {
    public static void main(String[] args) {
        // Creating a sorted mergeable heap
        MergeableHeap sortedHeap = new MergeableHeap(true);
        
        // Inserting elements into the sorted heap
        sortedHeap.insert(5);
        sortedHeap.insert(2);
        sortedHeap.insert(8);
        sortedHeap.insert(3);
        
        // Printing the minimum element in the sorted heap
        System.out.println("Minimum (sorted): " + sortedHeap.minimum());
        
        // Extracting the minimum element from the sorted heap
        int minExtracted = sortedHeap.minExtract();
        System.out.println("Min-Extract (sorted): " + minExtracted);
        
        // Printing the sorted heap after minExtract
        System.out.print("Sorted Heap after Min-Extract: ");
        sortedHeap.printList();
        System.out.println();
        
        // Creating an unsorted mergeable heap
        MergeableHeap unsortedHeap = new MergeableHeap(false);
        
        // Inserting elements into the unsorted heap
        unsortedHeap.insert(10);
        unsortedHeap.insert(6);
        unsortedHeap.insert(12);
        unsortedHeap.insert(4);
        
        // Printing the minimum element in the unsorted heap
        System.out.println("Minimum (unsorted): " + unsortedHeap.minimum());
        
        // Extracting the minimum element from the unsorted heap
        int minExtractedUnsorted = unsortedHeap.minExtract();
        System.out.println("Min-Extract (unsorted): " + minExtractedUnsorted);
        
        // Printing the unsorted heap after minExtract
        System.out.print("Unsorted Heap after Min-Extract: ");
        unsortedHeap.printList();
        System.out.println();
        
        // Creating two sorted heaps for union operation
        MergeableHeap sortedHeap1 = new MergeableHeap(true);
        sortedHeap1.insert(1);
        sortedHeap1.insert(3);
        sortedHeap1.insert(5);
        
        MergeableHeap sortedHeap2 = new MergeableHeap(true);
        sortedHeap2.insert(2);
        sortedHeap2.insert(4);
        sortedHeap2.insert(6);
        
        // Performing union of two sorted heaps
        MergeableHeap unionSorted = MergeableHeap.union(sortedHeap1, sortedHeap2);
        
        // Printing the sorted heap after union operation
        System.out.print("Union of sorted heaps: ");
        unionSorted.printList();
        System.out.println();
        
        // Creating two unsorted heaps for union operation
        MergeableHeap unsortedHeap1 = new MergeableHeap(false);
        unsortedHeap1.insert(7);
        unsortedHeap1.insert(4);
        
        MergeableHeap unsortedHeap2 = new MergeableHeap(false);
        unsortedHeap2.insert(10);
        unsortedHeap2.insert(9);
        
        // Performing union of two unsorted heaps
        MergeableHeap unionUnsorted = MergeableHeap.union(unsortedHeap1, unsortedHeap2);
        
        // Printing the unsorted heap after union operation
        System.out.print("Union of unsorted heaps: ");
        unionUnsorted.printList();
        System.out.println();
    }
}
