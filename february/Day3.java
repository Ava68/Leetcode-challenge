https://leetcode.com/problems/zigzag-conversion/submissions/890566503/

zig-zag conversion

class Solution {
    public String convert(String s, int numRows) {
       if(numRows == 1)
            return s;
        String res = "";

        for(int i =0; i<numRows; i++)
        {
           int  increment = 2 * (numRows - 1);
            for(int j = i; j<s.length(); j= j+increment)
            {
                res += s.charAt(j);
                if(i >0 && i<numRows-1 && j+increment - 2 * i < s.length())
                {
                    res += s.charAt(j+increment - 2 * i);
                }
            }
        }

        return res;
    }
}
