package epi;
import java.util.HashSet;
import java.util.Set;

import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;
public class IsStringPermutableToPalindrome {
  @EpiTest(testDataFile = "is_string_permutable_to_palindrome.tsv")

  public static boolean canFormPalindrome(String s) {
    
    Set<Character> paired = new HashSet<Character>();
    for(Character c : s.toCharArray()) {
    	if(paired.contains(c)) {
    		paired.remove(c);
    	}
    	else {
			paired.add(c);
		}
    }
    
    return paired.size() <=1;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "IsStringPermutableToPalindrome.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
