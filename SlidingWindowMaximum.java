class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n=nums.length;
        int arr[]=new int[n-k+1];
        for(int i=0;i<=n-k;i++)
        {
            int max=Integer.MIN_VALUE;
            for(int j=0;j<k;j++)
            {
                max=Math.max(nums[i+j],max);
            }
            arr[i]=max;
        }
        return arr;
    }
}
/////////////////////////////////////////////////////
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n=nums.length;
        int arr[]=new int[n-k+1];
       
       Deque<Integer> pq=new LinkedList<>();
        for(int i=0;i<k;i++)
        {
           while(!pq.isEmpty() && nums[pq.peekLast()]<=nums[i])
               pq.removeLast();
            pq.addLast(i);
                
                
        }
       
        for(int i=k;i<n;i++)
        {
            int d=pq.peek();
            arr[i-k]=nums[d];
            while(!pq.isEmpty() && pq.peekFirst()<=i-k)
                pq.removeFirst();
            while(!pq.isEmpty() && nums[pq.peekLast()]<=nums[i])
               pq.removeLast();
            pq.addLast(i);
           
            
        }
        arr[n-k]=nums[pq.peek()];
        return arr;
    }
}