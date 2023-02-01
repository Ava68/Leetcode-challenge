https://leetcode.com/problems/greatest-common-divisor-of-strings/submissions/889274030/

1071. Greatest Common Divisor of Strings

class Solution {
    public String gcdOfStrings(String str1, String str2) {
         if(!(str1 + str2).equals(str2 + str1))
            return "";

        int gcd  = gcdLen(str1.length(),str2.length());

        return str1.substring(0, gcd);

    }
    public static int gcdLen(int x, int y)
    {
        if(y == 0)
            return x;
        return gcdLen(y,x%y);
    }
}


