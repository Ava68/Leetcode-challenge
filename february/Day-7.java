https://leetcode.com/problems/fruit-into-baskets/description/

fruits in the basket

class Solution {
    public int totalFruit(int[] fruits) {
        int typecount = 0;
        int count = 0;
        int max = Integer.MIN_VALUE;
        int right =0;
        int left =0;
       HashMap<Integer,Integer>map = new HashMap<Integer,Integer>();

        while(right<fruits.length)
        {

        map.put(fruits[right], map.getOrDefault(fruits[right], 0) + 1);

            if(map.size() > 2)
            {
                map.put(fruits[left], map.get(fruits[left]) - 1);
                if (map.get(fruits[left]) == 0)
                    map.remove(fruits[left]);
                left++;
            }
          right++;
        }
return right - left;
    }

    
}
