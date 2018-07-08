package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;
public class SortedListsMerge {
  @EpiTest(testDataFile = "sorted_lists_merge.tsv")
  //@include
  public static ListNode<Integer> mergeTwoSortedLists(ListNode<Integer> L1,
                                                      ListNode<Integer> L2) {
    ListNode<Integer> dummyhead = new ListNode<Integer>(0, null);
    ListNode<Integer> current = dummyhead;
    
    while(L1 != null && L2 != null) { 
    	if(L2.data >= L1.data) {
    		current.next = L1;
    		L1 = L1.next;
    	}
    	else if(L2.data < L1.data) {
    		current.next = L2;
    		L2 = L2.next;
    	}
		current = current.next;
    } 
    
    current.next = L1 != null? L1 : L2;
     
    return dummyhead.next;
  }
  

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "SortedListsMerge.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
