// Q1 --> https://leetcode.com/problems/pascals-triangle/description/

import java.util.ArrayList;
import java.util.List;

class Q1 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        if (numRows == 0) {
            return result;
        }

        List<Integer> firstRow = new ArrayList<>();
        firstRow.add(1);
        result.add(firstRow);

        for (int i = 1; i < numRows; i++) {
            List<Integer> prevRow = result.get(i - 1);
            List<Integer> currentRow = new ArrayList<>();
            currentRow.add(1);

            for (int j = 1; j < i; j++) {
                currentRow.add(prevRow.get(j - 1) + prevRow.get(j));
            }

            currentRow.add(1);
            result.add(currentRow);
        }

        return result;
    }
}

// TC --> 0(N^2)
// SC --> 0(N^2)
// Approach --> Using the binomial coefficient formula C(n,k) to form the pascal's triangle

// ------------------------------------------------------------------------------------------- //

// Q2 --> https://leetcode.com/problems/rotate-image/description/

class Q2 {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for(int i = 0; i<n; i++) {
            for(int j = 0; j<i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        for(int i = 0; i<n; i++) {
            int j = 0;
            int k = n-1;
            while(j<k) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][k];
                matrix[i][k] = temp;
                j++;
                k--;
            }
        }
    }
}

// TC --> 0(N^2)
// SC --> 0(1)
// Approach --> First taking the transpose of the matrix and then reversing each row of the matrix.

// ------------------------------------------------------------------------------------------- //

// Q3 --> https://leetcode.com/problems/spiral-matrix/description/

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int top = 0, bottom = matrix.length - 1;
        int left = 0, right = matrix[0].length - 1;
        List<Integer> list = new ArrayList<>();

        while(top <= bottom && left <= right) {
            //left to right
            for(int i = left; i<=right; i++) 
                list.add(matrix[top][i]);
            
            top++;

            // top to bottom 
            for(int i = top; i<=bottom; i++) 
                list.add(matrix[i][right]);

            right--;

            //right to left
            if(top <= bottom) {
                for(int i = right; i>=left; i--) 
                    list.add(matrix[bottom][i]);
                bottom--;
            }

            //bottom to top
            if(left <= right) {
                for(int i = bottom; i >=top; i--) 
                    list.add(matrix[i][left]);
                left++;
            }
        }
        return list;
    }
}

// TC --> 0(N^2)
// SC --> 0(1)
