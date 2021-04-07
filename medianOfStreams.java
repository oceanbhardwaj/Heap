class Solution {
    public double[] medianSlidingWindow(int[] nums, int k) {
        int n=nums.length;
      double arr[]=new double[n-k+1];
        for(int i=0;i<=n-k;i++)
        {
            ArrayList<Integer> a=new ArrayList<>();
            for(int j=0;j<k;j++)
            {
                a.add(nums[i+j]);
                
            }
            Collections.sort(a);
            int s=a.size();
            if(a.size()%2==1)
                arr[i]=(double)a.get(s/2);
            else
            {
                int s1=s/2;
                arr[i]=(double)(((double)a.get(s1)+(double)a.get(s1-1))/2);
            }
        }
        return arr;
    }
}