// Q1 --> https://leetcode.com/problems/push-dominoes/description/?envType=problem-list-v2&envId=string

class Q1 {
    public String pushDominoes(String dominoes) {
        
        StringBuilder sb = new StringBuilder(dominoes);
        
        int n = sb.length();
        
        
        //mark true for all the unpushed block, after pushing a bloch in right direction
        char prev = '.';
        boolean[] forward = new boolean[n];
        for(int i = 0; i < n; i++){
            char c = dominoes.charAt(i);
            if(c == '.'){
                if(prev == 'R') forward[i] = true; 
            }else{
                prev = c;
            }
        }
        
        //mark true for all the unpushed block, after pushing a block in left direction
        prev = '.';
        boolean[] backward  = new boolean[n];
        for(int i = n - 1; i >= 0; i--){
            char c = dominoes.charAt(i);
            if(c == '.'){
                if(prev == 'L') backward[i] = true; 
            }else{
                prev = c;
            }
        }
        
        int i = 0;
        while(i < n){
            if(backward[i] && !forward[i]){
                //fall block as there is force in left direction
                sb.setCharAt(i++, 'L');
                
            }else if(!backward[i] && forward[i]){
                //fall block as there is force in right direction
                sb.setCharAt(i++, 'R');
                
            }else if(backward[i] && forward[i]){
                //fall block as there is force in both  direction
                int j = (i + 1);
                while(j < n && backward[j] && forward[j]){
                    j++;
                }
                pushDominoesInBetween(sb, i, j - 1);
                i = j;
            }else{
                i++;
            }
            
        }
        
        return sb.toString();
    }
    
    
    private void pushDominoesInBetween(StringBuilder sb, int l, int r){
        while(l < r){
            sb.setCharAt(l++, 'R');
            sb.setCharAt(r--, 'L');
        }
        
    }
}

// TC --> 0(N)
// SC --> 0(1)

// Q2 --> https://leetcode.com/problems/partition-labels/description/?envType=problem-list-v2&envId=string

class Q2 {
    public List<Integer> partitionLabels(String s) {
        Map<Character, Integer> map = new HashMap<>();
        // filling impact of character's
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            map.put(ch, i);
        }
        // making of result
        List<Integer> res = new ArrayList<>();
        int prev = -1;
        int max = 0;
        
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            max = Math.max(max, map.get(ch));
            if(max == i){
                // partition time
                res.add(max - prev);
                prev = max;
            }
        }
        return res;
    }
}

// TC --> 0(N)
// SC --> 0(N)