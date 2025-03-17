// Q1 --> https://www.geeksforgeeks.org/problems/k-th-element-of-two-sorted-array1317/1

class Q1 {
    public int kthElement(int a[], int b[], int k) {
        int size1 = a.length;
        int size2 = b.length;
        
        if(size1>size2)return kthElement(b,a,k);

        int start = Math.max(0,k-size2);
        int end = Math.min(k,size1);
        
        while(start<=end){
            int mid1 = (start+end)>>1; 
            int mid2 = k-mid1;
     
            int l1 = Integer.MIN_VALUE,l2=Integer.MIN_VALUE;

            int r1 = Integer.MAX_VALUE,r2=Integer.MAX_VALUE;
       
            if(mid1<size1)r1 = a[mid1];
            if(mid2<size2)r2 = b[mid2];
            if(mid1-1>=0)l1 = a[mid1-1];
            if(mid2-1>=0)l2 = b[mid2-1];
            
            if(l1<=r2 && l2<=r1){
                return Math.max(l1,l2);
            }
            else if(l1>r2){
                end=mid1-1;
            }else start=mid1+1;
            
        }
        return 0;
    }
}

// TC --> 0(logN)
// SC --> 0(1)

// Q2 --> https://leetcode.com/problems/search-a-2d-matrix/

class Q2 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int start = 0; 
        int end = m * n - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            int mid_val = matrix[mid / n][mid % n];

            if (mid_val == target)
                return true;
            else if (mid_val < target)
                start = mid + 1;
            else
                end = mid - 1;
        }
        return false;
    }
}

// TC --> 0(logmn)
// SC --> 0(1)

// Q3 --> https://leetcode.com/problems/search-a-2d-matrix-ii/

class Q3 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length < 1 || matrix[0].length <1) {
            return false;
        }
        int col = matrix[0].length-1;
        int row = 0;
        while(col >= 0 && row <= matrix.length-1) {
            if(target == matrix[row][col]) {
                return true;
            } else if(target < matrix[row][col]) {
                col--;
            } else if(target > matrix[row][col]) {
                row++;
            }
        }
        return false;
    }
}

// TC --> 0(m+n)
// SC --> 0(1)