//Given a dictionary of words and a string made up of those words (no spaces), #
//return the original sentence in a list. If there is more than one possible reconstruction, 
//return any of them. If there is no possible reconstruction, then return null.
//For example, given the set of words 'quick', 'brown', 'the', 'fox', and the string 
//"thequickbrownfox", you should return ['the', 'quick', 'brown', 'fox'].
//Given the set of words 'bed', 'bath', 'bedbath', 'and', 'beyond', and the string "bedbathandbeyond", 
//return either ['bed', 'bath', 'and', 'beyond] or ['bedbath', 'and', 'beyond'].

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Day3 {
    
    public static void main(String[] args) {
        String[] words = {"quick", "brown", "the", "fox"}; //set up the words
        String s = "thequickbrownfox"; //set up the string
        System.out.println(Arrays.toString(reconstruct(words, s).toArray()));

        String[] words2 = {"bed", "bath", "bedbath", "and", "beyond"}; //set up the words
        String s2 = "bedbathandbeyond"; //set up the string
        System.out.println(Arrays.toString(reconstruct(words2, s2).toArray()));
    }
    
    public static List<String> reconstruct(String[] words, String s) {
        Map<String, Boolean> map = new HashMap<>();
        for(String word : words) {
            map.put(word, true);
        }
        return reconstructHelper(map, s);
    }
    
    public static List<String> reconstructHelper(Map<String, Boolean> map, String s) {
        List<String> result = new ArrayList<>();
        if(s.length() == 0) {
            return result;
        }
        for(int i = 1; i <= s.length(); i++) {
            String prefix = s.substring(0, i);
            if(map.containsKey(prefix) && map.get(prefix)) {
                map.put(prefix, false);
                List<String> suffix = reconstructHelper(map, s.substring(i));
                if(suffix != null) {
                    result.add(prefix);
                    result.addAll(suffix);
                    return result;
                }
                map.put(prefix, true);
            }
        }
        return null;
    }
}