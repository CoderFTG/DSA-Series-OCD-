// Q1 --> https://leetcode.com/problems/two-sum/description/

class Q1 {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        int[] ans = new int[2];
        ans[0] = ans[1] = -1;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] + nums[j] == target) {
                    ans[0] = i;
                    ans[1] = j;
                    return ans;
                }
            }
        }
        return ans;
    }
}
// TC --> 0(N^2)
// SC --> 0(1)
// Approach --> Two pointer approach

// ------------------------------------------------------------------------------------------------------//

// Q2 --> https://leetcode.com/problems/sort-colors/description/

class Q2 {
    public void sortColors(int[] nums) {
        int count0 = 0;
        int count1 = 0;
        int count2 = 0;
        for(int i = 0; i<nums.length; i++) {
            if(nums[i] == 0) count0++;
            else if(nums[i] == 1) count1++;
            else count2++;
        }
        for(int i = 0; i<count0; i++) nums[i] = 0;
        for(int i = count0; i< count0 + count1; i++) nums[i] = 1;
        for(int i = count0 + count1; i<nums.length; i++) nums[i] = 2;
    }
}

// TC --> 0(N)
// SC --> 0(1)
// Approach --> Creating separate variables for count of 0,1,2 and then change the given array into the desired result

// ------------------------------------------------------------------------------------------------------//

// Q3 --> https://www.geeksforgeeks.org/problems/max-sum-in-sub-arrays0824/0

class Q3 {
    public int pairWithMaxSum(int arr[]) {
    int maxSum = 0;
    for(int i = 0; i<arr.length-1; i++) {
        int sum = 0;
        sum = arr[i] + arr[i+1];
        if( sum > maxSum) maxSum = sum;
            }
    return maxSum;

    }
}

// TC --> 0(N)
// SC --> 0(1)
// Approach --> Iterate through the whole array to find maximum consecutive sum

