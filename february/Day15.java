https://leetcode.com/problems/add-to-array-form-of-integer/submissions/898440871/

class Solution {
    public List<Integer> addToArrayForm(int[] num, int k) {
      List<Integer>ans = new ArrayList<Integer>();

      int i =num.length-1;
      
      int sum =k;
      while(i >=0)
       {
        
            sum += num[i];
            ans.add(0,sum % 10);
            sum = sum /10;
            i--;
       }
       while(sum > 0)
       {
           ans.add(0,sum%10);
           sum = sum / 10;
       }
        
       return ans;
    }
}
