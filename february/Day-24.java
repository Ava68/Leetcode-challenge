/* Intution is in 2 steps
step 1-> multuply all odd number by 2
step 2 -> pop max ele from heap diff = Math.min(diff,max-min)
and add  pQueue.add(max/2); do this untill every even element is exhausted from the queue.

*/

https://leetcode.com/problems/minimize-deviation-in-array/description/

class Solution {
    public int minimumDeviation(int[] nums) {
        PriorityQueue<Integer> pQueue
            = new PriorityQueue<Integer>(
                Collections.reverseOrder());
        int min = Integer.MAX_VALUE;
        int diff = Integer.MAX_VALUE;

        for(int n:nums)
        {
            if(n % 2 != 0)
                n = n * 2;
            min = Math.min(min,n);
            pQueue.add(n);
        }
        while(pQueue.peek() %2 == 0)
        {
            int max = pQueue.remove();
            diff = Math.min(diff,max-min);
            min = Math.min(min,max/2);
            pQueue.add(max/2);
        }
        return Math.min(diff,pQueue.peek() - min);
    }
}
