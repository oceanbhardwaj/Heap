class Solution {
    class Pair{
        int x;
        int y;
        int sum;
        Pair(int x,int y,int sum)
        {
            this.x=x;
            this.y=y;
            this.sum=sum;
        }
    }
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> res=new ArrayList<>();
        PriorityQueue<Pair> pq=new PriorityQueue<>((o1,o2)->o1.sum-o2.sum);
        for(int i=0;i<nums1.length;i++)
        {
            for(int j=0;j<nums2.length;j++)
            {
                pq.add(new Pair(nums1[i],nums2[j],nums1[i]+nums2[j]));
            }
        }
        while(!pq.isEmpty() && k>0)
        { Pair p=pq.poll();
            res.add(new ArrayList(Arrays.asList(p.x,p.y)));
         k--;
        }
        return res;
        
    }
}
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
o(klogk) time
class Solution {
    class Pair{
        int x;
        int y;
        int sum;
        int index;
        Pair(int x,int y,int sum,int index)
        {
            this.x=x;
            this.y=y;
            this.sum=sum;
            this.index=index;
        }
    }
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> res=new ArrayList<>();
        if(nums1.length==0 | nums2.length==0)
            return res;
        PriorityQueue<Pair> pq=new PriorityQueue<>((o1,o2)->o1.sum-o2.sum);
        for(int i=0;i<nums1.length && i<k;i++)
        {
            pq.add(new Pair(nums1[i],nums2[0],nums1[i]+nums2[0],0));
        }
       while(!pq.isEmpty() && k>0)
       {
           Pair p=pq.poll();
           int X=p.x;
           int Y=p.y;
           int SUM=p.sum;
           int INDEX=p.index;
           res.add(new ArrayList(Arrays.asList(X,Y)));
           k--;
           if(INDEX+1<nums2.length)
               pq.add(new Pair(X,nums2[INDEX+1],X+nums2[INDEX+1],INDEX+1));
       }
        
        
        
        
        
        
        return res;
        
    }
}
