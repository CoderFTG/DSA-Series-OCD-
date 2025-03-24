// Q1 --> https://bit.ly/3CfQfYi

class Q1 {
    static long calcCount(String s , int k ){
        int i = 0;
        int j = 0 ;
        int n = s.length() ; 
        int[] charFreq = new int[26] ; 
        int dist_count = 0 ;
        long ans = 0 ;
        while(j<n){
            charFreq[s.charAt(j)-'a']++;
            if(charFreq[s.charAt(j)-'a']==1){ 
                dist_count++;
            }

            while(dist_count>k){
                charFreq[s.charAt(i)-'a']--;
                if(charFreq[s.charAt(i)-'a']==0){
                    dist_count--;
                }
                i++;
            }
            j++;
            ans+=(j-i+1) ; 
        }
        return ans ;
    }
    long substrCount (String S, int K) {
        return calcCount(S,K) - calcCount(S,K-1) ; 
    } 
}

// TC --> 0(N)
// SC --> 0(1)

// Q2 --> https://leetcode.com/problems/longest-palindromic-substring/

class Q2 {
    int maxLen = 0;
    int lo = 0;
    public String longestPalindrome(String s) {
        char[] input = s.toCharArray();
        if(s.length() < 2) {
            return s;
        }
        
        for(int i = 0; i<input.length; i++) {
            expandPalindrome(input, i, i);
            expandPalindrome(input, i, i+1);
        }
        return s.substring(lo, lo+maxLen);
    }
    
    public void expandPalindrome(char[] s, int j, int k) {
        while(j >= 0 && k < s.length && s[j] == s[k]) {
            j--;
            k++;
        }
        if(maxLen < k - j - 1) {
            maxLen = k - j - 1;
            lo = j+1;
        }
    }
}

// TC --> 0(N^2)
// SC --> 0(1)