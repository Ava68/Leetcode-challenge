https://leetcode.com/problems/count-odd-numbers-in-an-interval-range/submissions/897016633/

count-odd-numbers-in-an-interval-range
class Solution {
    public int countOdds(int low, int high) {
        int c = 0;

       if(low %2 ==0)
        low = low +1;
       if(high % 2 == 0)
        high = high -1;
       
       return (high-low)/2 +1;
    }
}
