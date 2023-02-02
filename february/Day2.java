class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        
        
        for(int i =0; i<words.length-1; i++)
        {
            String curr1  = words[i];
            String curr2 = words[i+1];

            if(verify(curr1,curr2,order) == false)
                return false;

        }

        return true;
    }

    public boolean verify(String curr1,String curr2,String order)
    {
        int i =0; 
        int j =0;
       

        while(i<curr1.length() && j<curr2.length())
        {
            if( curr1.charAt(i) == curr2.charAt(j))
            {
                i++;
                j++;
                continue;
            }
             if(check(curr1,curr2,order,i,j) == false)
                {
                    return false;
                }
            else
                return true;
            
               
        }

         if(curr1.length() > curr2.length())
           return false;

        return true;
    }

    public boolean check(String curr1,String curr2,String order,int i,int j)
    {
        

        for(int k =0; k<order.length(); k++)
        {
            if(curr1.charAt(i) == order.charAt(k))
            {
                
                return true;
            }

            else if(curr2.charAt(j) == order.charAt(k))
            return false;

        }

        return true;
    }
}
