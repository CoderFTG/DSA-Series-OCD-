// Q1 --> https://leetcode.com/problems/isomorphic-strings/description/

class Q1 {
    public boolean isIsomorphic(String s, String t) {
        int map1[] = new int[200];
        int map2[] = new int[200];

        if(s.length()!=t.length())
            return false;

        for(int i=0;i<s.length();i++)
        {
            if(map1[s.charAt(i)]!=map2[t.charAt(i)])
                return false;
            map1[s.charAt(i)]=i+1;
            map2[t.charAt(i)]=i+1;
        }
        return true;
    }
}

// TC --> 0(N)
// SC --> 0(1)

// Q2 --> https://leetcode.com/problems/remove-outermost-parentheses/description/

class Q2 {
    public String removeOuterParentheses(String s) {
        StringBuilder ans = new StringBuilder();
        char[] a = s.toCharArray();
        int n = a.length;
        int count = 0;
        for (int i = 1; i < n; i++) {
            if (a[i] == '(') {
                count++;
                ans.append('(');
            } else {
                if (count == 0) {
                    i++;
                } else {
                    ans.append(')');
                    count--;
                }
            }
        }
        return ans.toString();
    }
}

// TC --> 0(N)
// SC --> 0(N)