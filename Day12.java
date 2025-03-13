// Q1 --> https://leetcode.com/problems/binary-search/description/

class Q1 {
    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int mid = (start + end)  / 2;
            if (target < nums[mid]) {
                end = mid - 1;
            } else if (target > nums[mid]) {
                start = mid + 1;

            } else {
                return mid;
            }

        }
        return -1;
    }
}

// TC --> 0(logN)
// SC --> 0(1)
// Approach --> Consider a middle element and look for the target element with respect to the middle element. Binary Search Approach

// ---------------------------------------------------------------------------------------------------------//

// Q2 --> https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/description/

class Q2 {
    public int[] searchRange(int[] nums, int target) {
        int[] ans = {-1,-1};
        int left  = binarySearch(nums, target, true);
        int right = binarySearch(nums, target, false);
        ans[0] = left;
        ans[1] = right;
        return ans;
        }
        
    private int binarySearch(int[] nums, int target, boolean leftSearch) {
        int start = 0;
        int end = nums.length - 1;
        int index = -1;

        while (start <= end) {
            int mid = (start + end) / 2;
            if (target > nums[mid]) {
                start = mid + 1;
            } else if (target < nums[mid]) {
                end = mid - 1;
            } else {
                index = mid;
                if (leftSearch) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        } 
        return index;   
    }
}

// TC --> 0(logN)
// SC --> 0(1)
// Approach --> Created a new function that performs binary search to find the target value 
//and returns the index of either the leftmost or rightmost occurrence of the target value based on the leftSearch parameter.

// ---------------------------------------------------------------------------------------------------------//

// Q3 --> https://leetcode.com/problems/search-insert-position/description/

class Q3 {
    public int searchInsert(int[] nums, int target) {
        int start = 0;
        int end = nums.length-1;

        while (start <= end) {
            int mid = (start + end)/2;
            if (nums[mid] == target) return mid;
            else if (nums[mid] > target) end = mid-1;
            else start = mid+1;
        }

        return start;
    }
}

// TC --> 0(logN)
// SC --> 0(1)


