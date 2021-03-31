class Solution {
    public int nthUglyNumber(int n) {
        int count=0;
         
       int i=1;
        while(count!=n)
        {
            if(isUgly(i)==1)
            {
                count++;
                System.out.println(i);
            }
            
            System.out.println(count);
            if(count==n)
                return i;
            i++;
        }
        return 1;
    }
    public int isUgly(int n)
    {
        if(n==0)
            return 0;
        if(n==1)
            return 1;
        while(n%5==0 || n%2==0 || n%3==0 ||n==1)
        {
            if(n==1)
                return 1;
            if(n==0)
                return 0;
            if(n%5==0)
                n=n/5;
            else if(n%2==0)
                n=n/2;
            else if(n%3==0)
                n=n/3;
            else 
                return 0;
            
        }
        return 0;
    }
}
/////////////////////////////////////////////////////////
class Solution {
    public int nthUglyNumber(int n) {
        int dp[]=new int[n];
        dp[0]=1;//first ugly numbers
        int i2=0;
        int i3=0;
        int i5=0;
        int n2=0;
        int n3=0;
        int n5=0;
        int i=1;
        while(i<n)
        {
            n2=dp[i2]*2;
            n3=dp[i3]*3;
            n5=dp[i5]*5;
            int min=Math.min(n2,Math.min(n3,n5));
            if(min==n2)
                i2++;
             if(min==n3)
                i3++;
            if(min==n5)
                i5++;
            dp[i]=min;
            i++;
        }
        
        return dp[n-1];
        
    }
}