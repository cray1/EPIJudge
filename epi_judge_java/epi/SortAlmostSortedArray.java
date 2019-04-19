package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
public class SortAlmostSortedArray {

  public static List<Integer>
  sortApproximatelySortedData(Iterator<Integer> sequence, int k) {
    List<Integer> sorted = new LinkedList<Integer>();
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    
    // go through iterator k times, filling priorityQueue
    for(int i=0; i<k; i++) {
    	if(sequence.hasNext()) {
    		pq.add(sequence.next());
    	}
    	else {
    		break;
    	}
    }
    
    // our PQ never gets bigger than k, add through rest of numbers
    while(sequence.hasNext()) {
    	int nextInt = sequence.next();
    	sorted.add(pq.poll());
    	pq.add(nextInt);
    }
    
    // dump remaining numbers from pq
    while(!pq.isEmpty()) {
    	sorted.add(pq.poll());
    }
    return sorted;
    
  }
  @EpiTest(testDataFile = "sort_almost_sorted_array.tsv")
  public static List<Integer>
  sortApproximatelySortedDataWrapper(List<Integer> sequence, int k) {
    return sortApproximatelySortedData(sequence.iterator(), k);
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "SortAlmostSortedArray.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
