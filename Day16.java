// Q1 --> https://leetcode.com/problems/find-a-peak-element-ii/description/

class Q1 {
    public int[] findPeakGrid(int[][] mat) {
        int start = 0;
        int end = mat[0].length-1;
        while(start<=end)
        {
            int mid = (start+end)/2;
            int max = mat[0][mid];
            int idx = 0;
            for(int i=1;i<mat.length;i++)
            {
                if(max < mat[i][mid])
                {
                    idx = i;
                    max = mat[i][mid];
                }
            }
            int left= (mid-1>=0) ? mat[idx][mid-1]:-1;
            int right= (mid+1<mat[0].length) ? mat[idx][mid+1]:-1;
            if(max > left && max > right) return new int[]{idx, mid};
            else if(max > left) start = mid+1;
            else end = mid-1;
        }
        return new int[]{-1, -1};
    }
}

// TC --> 0(NlogM)
// SC --> 0(1)

// Q2 --> https://www.geeksforgeeks.org/problems/median-in-a-row-wise-sorted-matrix1527/1

class Q2 {
    int median(int mat[][]) {
        int n = mat.length;
        int m = mat[0].length;
   
        List<Integer> lst = new ArrayList<>();
        for(int i =0;i<n;i++){
            for(int j =0;j<m;j++){
                lst.add(mat[i][j]);
            }
        }
        Collections.sort(lst);
        return lst.get((m*n)/2);
    }
}

// TC --> 0(N^2)
// SC --> 0(N)