// Q1 --> https://leetcode.com/problems/valid-anagram/

import java.util.*;
class Q1 {
    public boolean isAnagram(String s, String t) {
        char[] s_array = s.toCharArray();
        char[] t_array = t.toCharArray();

        Arrays.sort(s_array);
        Arrays.sort(t_array);

        if(s.length() != t.length()) return false;

        int count = 0;
        for(int i=0; i<s.length(); i++){
            if(s_array[i] == t_array[i]) count++;
        }

        if(count == s.length()) return true;
        return false;
    }
}

// TC --> 0(nlogn)
// SC --> 0(n)
// Approach --> Converted both strings into arrays, sorted them and check whether equal or not

// Q2 --> https://leetcode.com/problems/longest-common-prefix/description/

class Q2 {
    public String longestCommonPrefix(String[] strs) {
       Arrays.sort(strs);
        String s1 = strs[0];
        String s2 = strs[strs.length-1];
        int idx = 0;
        while(idx < s1.length() && idx < s2.length()){
            if(s1.charAt(idx) == s2.charAt(idx)){
                idx++;
            } else {
                break;
            }
        }
        return s1.substring(0, idx); 
    }
}

// TC --> 0(nlogn)
// SC --> 0(1)