// Q1 --> https://www.geeksforgeeks.org/problems/square-root/0?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=square-root
class Q1 {
    int floorSqrt(int n) {
    if (n == 0 || n == 1)
    return n;

    int start = 1;
    int end = n;
    int ans = 0;

    while (start <= end) {
        int mid = (start + end) / 2;

        if (mid * mid == n)
            return mid;

        if (mid * mid < n) {
            start = mid + 1;
            ans = mid;
        }
        else
            end = mid - 1;
    }
    return ans;
    }
}

// TC --> 0(logN)
// SC --> 0(1)

// Q2 --> https://leetcode.com/problems/koko-eating-bananas/description/

class Q2 {
    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;
        long total = 0;
        for (int p : piles) 
            total += p;
        
        int start = (int) ((total - 1) / h) + 1;
        int end = (int) ((total - n) / (h - n + 1)) + 1;
        
        while (start < end) {
            int mid = start + (end - start) / 2;
            int time = 0;
            for (int p : piles) {
                time += (p - 1) / mid + 1;
            }
            if (time > h) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return start;
    }
}

// TC --> 0(NlogM)
// SC --> 0(1)


// Q3 --> https://leetcode.com/problems/find-the-smallest-divisor-given-a-threshold/description/

class Q3 {
    public int smallestDivisor(int[] nums, int threshold) {
        int start = 1;
        int end = 1000000;
        while (start < end) {
            int m = (start + end) / 2, sum = 0;
            for (int i : nums)
                sum += (i + m - 1) / m;
            if (sum > threshold)
                start = m + 1;
            else
                end = m;
        }
        return start;
    }
}

// TC --> 0(NlogM)
// SC --> 0(1)