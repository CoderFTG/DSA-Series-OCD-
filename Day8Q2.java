import java.util.*;
public class Day8Q2 {
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

// Time Complexity  -->  0(n)
// Space Complexity -->  0(1)

// Approach --> Create a new reverse function and use it to rotate the array and obtain the desired outcome
