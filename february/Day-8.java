https://leetcode.com/problems/jump-game-ii/description/
jump game -2 greedy
class Solution {
    public int jump(int[] nums) {
        int res = 0;
        int left=0,right =0;
        
        while(right < nums.length-1)
        {
            int farthest=0;
            for(int i =left; i<=right; i++)
                farthest = Math.max(farthest,i+nums[i]);
            
            left = right +1;
            right = farthest;
            res = res +1;
        }
return res;
    }
}
