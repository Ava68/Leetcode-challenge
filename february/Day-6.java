https://leetcode.com/problems/shuffle-the-array/description/

Shuffle the array

class Solution {
    public int[] shuffle(int[] nums, int n) {
        int i =0;
        int j =n;
        int temp [] = new int[2*n];
        int k =0;
        while(i<n && j <2 * n)
        {
            temp[k++] = nums[i++];
            temp[k++] = nums[j++];
        } 

        return temp;
    }
}
