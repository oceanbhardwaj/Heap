class Solution {
    class Pair
    {
        String ele;
        int freq;
        Pair(String ele,int freq)
        {
            this.ele=ele;
            this.freq=freq;
        }
    }
    public List<String> topKFrequent(String[] words, int k) {
        //method 1 --usinh priority queue
        HashMap<String,Integer> h=new HashMap<>();
        for(int i=0;i<words.length;i++)
        {
            h.put(words[i],h.getOrDefault(words[i],0)+1);
        }
        Comparator co=new Comparator<Pair>()
        {
            public int compare(Pair o1,Pair o2)
            {
                if(o1.freq==o2.freq)
                    return o1.ele.compareTo(o2.ele);
                return o2.freq-o1.freq;
            }
            
        };
        PriorityQueue<Pair> pq=new PriorityQueue<>(co);
            
            
     
        for(String s:h.keySet())
        {
            pq.add(new Pair(s,h.get(s)));
        }
        List<String> res=new ArrayList<>();
        while(k>0)
        {
            res.add(pq.poll().ele);
            k--;
        }
        
        return res;
        
    }
}
/////////////////////////////////////////////////////////////bucket sort///////////////////////////////////////
class Solution {
    class Pair
    {
        String ele;
        int freq;
        Pair(String ele,int freq)
        {
            this.ele=ele;
            this.freq=freq;
        }
    }
    public List<String> topKFrequent(String[] words, int k) {
        //method 1 --using bucket sort
        HashMap<String,Integer> h=new HashMap<>();
        for(int i=0;i<words.length;i++)
        {
            h.put(words[i],h.getOrDefault(words[i],0)+1);
        }
        int n=words.length;
        ArrayList<String> a[]=new ArrayList[n+1];
        for(int i=0;i<=n;i++)
        {
            a[i]=new ArrayList<>();
            
        }
        for(String s:h.keySet())
        {
        int f=h.get(s);
            a[f].add(s);
        }
        List<String> res=new ArrayList<>();
        int count=0;
        for(int i=n;i>=0;i--)
        {
            Collections.sort(a[i]);
            for(int j=0;j<a[i].size();j++)
            {
                int index=i;
                String ss=a[i].get(j);
                res.add(ss);
                count++;
                if(count==k)
                    return res;
            }
        }
      
        return res;
    }
}