// Q1 --> https://leetcode.com/problems/sort-characters-by-frequency/description/

class Q1 {
    public String frequencySort(String s) {
        StringBuilder sb = new StringBuilder();
        int[] freq = new int[128];
        for(char c : s.toCharArray())
        {
            freq[c-'0']++;
        }

        for(int k = 0; k < s.length(); k++)
        {
            int max = 0;
            int ind = 0;
            for(int j = 0; j < freq.length; j++)
            {
                if(freq[j] != 0 && freq[j] > max)
                {
                    max = freq[j];
                    ind = j;
                }
            }
            for(int i = 0; i < max; i++)
            {
                sb.append((char)('0'+ind));
            }
            freq[ind] = 0;
            k += --max;
        }
        return sb.toString();
    }
}

// TC --> 0(N^2)
// SC --> 0(1)

// Q2 --> https://leetcode.com/problems/string-to-integer-atoi/description/

class Q2 {
    public int myAtoi(String s) {
     int INT_MAX = 2147483647, INT_MIN = -2147483648;
        int i = 0, n = s.length(), sign = 1, result = 0;
    
        while (i < n && s.charAt(i) == ' '){
            i++;
        }
        if (i < n && s.charAt(i) == '-' ){
            sign=-1;
            i++;
        }
        if (i < n && s.charAt(i) == '+') {
            if (i < n && i!=0 && s.charAt(i-1)=='-'){
                return 0;
            }
            sign=1;
            i++;
        }
        while (i < n && Character.isDigit(s.charAt(i))) {
            int digit = s.charAt(i) - '0';
            if (result >(INT_MAX - digit)/10) {
                if (sign == 1){
                    return INT_MAX;
                }
                else{
                    return INT_MIN;
                }
            }
            result = result * 10 + digit;
            i++;
        }
        return sign * result;   
    }
}

// TC --> 0(N)
// SC --> 0(1)