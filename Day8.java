// Q1 --> https://leetcode.com/problems/move-zeroes/description/

import java.util.*;
class Day8Q1 {
        public int[] moveZeroes(int[] nums) {
            int j = -1;
            int n = nums.length;
            for(int i = 0; i<n; i++) {
                if(nums[i] == 0) {
                    j = i;
                    break;
                }
            }
            if(j == -1) return nums;
    
            for(int i = j+1; i<n; i++) {
                if(nums[i] != 0 ) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                    j++;
                }
            }
            return nums;
        }
}

// Time Complexity  -->  0(n)
// Space Complexity -->  0(1)

// Approach --> Create a new reverse function and use it to rotate the array and obtain the desired outcome

//-----------------------------------------------------------------------------------------------------------------//

// Q2 --> https://leetcode.com/problems/rotate-array/description/

class Day8Q2 {
        public void reverse(int[] arr, int start, int end) {
            while(start <= end) {
                int temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;
                start++;
                end--;
            }
        }
        public void rotate(int[] nums, int k) {
            int n = nums.length;
            k = k%n;
            reverse(nums,0,n-1);
            reverse(nums,0,k-1);
            reverse(nums,k,n-1);
            System.out.println(Arrays.toString(nums));
        }
}

//Time Complexity  --> 0(n)
//Space Complexity --> 0(1)

//Approach --> Using the two pointer approach and swapping the non-zero and zero numbers to transfer the zeroes to the end
