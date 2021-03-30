class Solution {
    class Pair{
        int ele;
        int freq;
        Pair(int ele,int freq)
        {
            this.ele=ele;
            this.freq=freq;
        }
        
    }
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> h=new HashMap<>();
        for(int i=0;i<nums.length;i++)
        {
            h.put(nums[i],h.getOrDefault(nums[i],0)+1);
        }
        PriorityQueue<Pair> pq=new PriorityQueue<Pair>((o1,o2)->o2.freq-o1.freq);
        for(int ele:h.keySet())
        {
            pq.add(new Pair(ele,h.get(ele)));
        }
        int arr[]=new int[k];
        int i=0;
        while(k>0)
        {
            arr[i++]=pq.poll().ele;
            k--;
        }
        return arr;
        
    }
}