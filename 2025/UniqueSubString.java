/**
Here's the problem that the provided Java code likely solves:

* Problem:

* Given a string S consisting of lowercase English letters, find the number of substrings you can create such that each substring contains only unique characters.
*
  
*  Example:

* Input: S = "abcabda"
* Output: 3
* The substrings are: "abc", "abd", "a".
  
  ***/

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class UniqueSubString {
    public List<String> solution(String S) {
        List<String> substrings = new ArrayList<>();
        Set<Character> visited = new HashSet<>();
        StringBuilder currentSubstring = new StringBuilder();

        for (char c : S.toCharArray()) {
            if (!visited.contains(c)) {
                visited.add(c);
                currentSubstring.append(c);
            } else {
                substrings.add(currentSubstring.toString());
                visited.clear();
                visited.add(c);
                currentSubstring = new StringBuilder();
                currentSubstring.append(c);
            }
        }

        substrings.add(currentSubstring.toString()); // Add the last substring
        return substrings;
    }

   public static void main(String[] args) {
        String input = "abcabda";
        List<String> result = solution(input);
        System.out.println(result); // Output: [abc, abd, a]
    }
}
