// Q1 --> https://leetcode.com/problems/maximum-nesting-depth-of-the-parentheses/description/

class Q1 {
    public int maxDepth(String s) {
        int count = 0;
        int max = 0;
        for (int i=0;i<s.length();i++) {
            if (s.charAt(i) == '(') {
                count++;
                if (max < count)
                    max = count;
            } else if (s.charAt(i) == ')') {
                count--;
            }
        }
        return max;
    }
}

// TC --> 0(N)
// SC --> 0(1)
// Approach --> use count to track depth of parentheses if char is '(' count is increased 
//and if char is ')' count is decreased. count is stored in max if count>max.

// Q2 --> https://leetcode.com/problems/roman-to-integer/description/

class Q2 {

    static int romanValue(char c){
        if(c == 'I'){
            return 1;
        }
        else if(c == 'V'){
            return 5;
        }
        else if(c == 'X'){
            return 10;
        }
        else if(c == 'L'){
            return 50;
        }
        else if(c == 'C'){
            return 100;
        }
        else if(c == 'D'){
            return 500;
        }
        else if(c == 'M'){
            return 1000;
        }
        return -1;
    }

    public int romanToInt(String s) {
        int num = 0;
        for(int i = 0; i < s.length(); i++){
            int currNum = romanValue(s.charAt(i));
            if(i+1 < s.length()){
                if(currNum >= romanValue(s.charAt(i+1))){
                    num += currNum;
                }
                else{
                    num += (romanValue(s.charAt(i+1))-currNum);
                    i++;
                }
            }
            else{
                return num += currNum;
            }
        }
        return num;
    }
}

// TC --> 0(N)
// SC --> 0(1)