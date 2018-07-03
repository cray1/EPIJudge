package epi;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;
public class IsStringPermutableToPalindrome {
  @EpiTest(testDataFile = "is_string_permutable_to_palindrome.tsv")

  public static boolean canFormPalindrome(String s) {
    
    Map<Character, Integer> paired = new HashMap<Character, Integer>();
    Boolean has_middle_value = false;
    
    for(Character c : s.toCharArray()) {
    	int count = paired.getOrDefault(c, 0);
    	count++;
    	paired.put(c, count);
    }
    for(Integer num : paired.values()) {
    	System.out.println("num "+ num);
    	if(num % 2 != 0) {
    		System.out.println("has_middle_value");
    		if(has_middle_value) {
    			
    			return false;
    		}
    		else
    			has_middle_value = true;
    	}
    }
    if(s.length() % 2 == 0) {
    	return !has_middle_value;
    }
    else {
    	return has_middle_value;
    }
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "IsStringPermutableToPalindrome.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
