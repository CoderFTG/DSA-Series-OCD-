// Q1 --> https://www.naukri.com/code360/problems/ceiling-in-a-sorted-array_1825401

class Q1 {
    public static int[] getFloorAndCeil(int[] arr, int n, int x) {
       int l=0,r=arr.length-1;
        
        while(l<=r){
            int m=(l+r)/2;
            if(arr[m]==x)return new int[]{x,x};
            else if(arr[m]<x)l=m+1;
            else r=m-1;
        }
        int a=0,b=0;
        if(l>arr.length-1 || l<0)a=-1;
        else a=arr[l];
        if(r>arr.length-1 || r<0)b=-1;
        else b=arr[r];
        
        
        return new int[]{b,a};
    }
}

// TC --> 0(logN)
// SC --> 0(N)

// Q2 --> https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/description/

class Q2 {
    public int findMin(int[] nums) {
        int start = 0;
        int end = nums.length-1;

        while(start<end){
            int mid = start +(end - start)/2;

            if(nums[mid] <= nums[end]) end = mid;
            else start = mid + 1;
        }

        return nums[start];
    }
}

// TC --> 0(logN)
// SC --> 0(1)

// Q3 --> https://leetcode.com/problems/search-in-rotated-sorted-array/description/

class Solution {
    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] >= nums[start]) {
                if (nums[start] <= target && target <= nums[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                if (nums[mid] <= target && target <= nums[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return -1;        
    }
}

// TC --> 0(logN)
// SC --> 0(1)