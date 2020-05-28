package Test.ATemp;

import java.util.HashMap;
import java.util.Map;

public class LeetCode {


    public static int lengthOfLongestSubstring(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int end = 0, start = 0; end < n; end++) {
            char alpha = s.charAt(end);
            if (map.containsKey(alpha)) {
                //start=Math.max(myHash.get(tempChar)+1,start);
                start = map.get(alpha) + 1;
            }
            ans = Math.max(ans, end - start + 1);
            map.put(s.charAt(end), end);
        }
        return ans;
    }


    public static void main(String[] args) {
        String s = "abba";

        lengthOfLongestSubstring(s);
    }
}