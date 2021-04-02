class KthLargest {
 PriorityQueue<Integer> pq;
    int k;
    public KthLargest(int k, int[] nums) {
        pq=new PriorityQueue<>();
       this.k=k;
        for(int i=0;i<nums.length;i++)
        {
            pq.add(nums[i]);
            
        }
       
        
    }
    
    public int add(int val) {
        pq.add(val);
        while(pq.size()>k)
            pq.poll();
        return pq.peek();
    }
}
