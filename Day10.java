// Q1 --> https://leetcode.com/problems/rearrange-array-elements-by-sign/

class Q1 {
    public int[] rearrangeArray(int[] nums) {
        int[] ans = new int[nums.length];
        int positive = 0;
        int negative = 1;

        for(int i = 0; i<nums.length; i++) {
            if(nums[i] > 0) {
                ans[positive] = nums[i];
                positive += 2;
            }
            else {
                ans[negative] = nums[i];
                negative += 2;
            }
        }
        return ans;
    }
}

// TC --> 0(N)
// SC --> 0(N)
// Approach --> Created a new array and position variables to store positive and negative integers as per the question

// -------------------------------------------------------------------------------------------------- //

// Q2 --> https://leetcode.com/problems/next-permutation/description/

class Q2 {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int i = n - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) i--;
        if (i >= 0) {
            int j = n - 1;
            while (nums[j] <= nums[i]) j--;
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
        reverse(nums, i + 1, nums.length - 1);
    }

    private void reverse(int[] nums, int left, int right) {
        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }
}

// TC --> 0(N)
// SC --> 0(1)

// -------------------------------------------------------------------------------------------------- //

// Q3 --> https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/

class Q3 {
    public int maxProfit(int[] prices) {
        int min = prices[0];
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < min) {
                min = prices[i];
            } else if (prices[i] - min > profit) {
                profit = prices[i] - min;
            }
        }
        return profit;
    }
}

// TC --> 0(N)
// SC --> 0(1)
// Approach --> First finding the minimum value of the prices and then maximising the profit